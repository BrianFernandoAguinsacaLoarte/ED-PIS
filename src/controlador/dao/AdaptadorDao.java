package controlador.dao;

import controlador.TDA.listas.LinkedList;
import modelo.CrearTarea;
import modelo.EntregaTarea;
//import com.mysql.cj.jdbc.Blob;
//import com.mysql.cj.jdbc.Blob;
import java.sql.Blob;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AdaptadorDao<T> implements InterfazDao<T> {

    private Conexion conetion;
    private Class clazz;

    public AdaptadorDao(Class clazz) {
        this.conetion = new Conexion();
        this.clazz = clazz;
    }

    @Override
    public Integer guardar(T obj) throws Exception {
        String query = queryInsert(obj);
        Integer idGenerado = -1;
        PreparedStatement statement = conetion.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        setParameters(statement, obtenerObjeto(obj));

        statement.executeUpdate();
        ResultSet generatedKeys = statement.getGeneratedKeys();
        if (generatedKeys.next()) {
            idGenerado = generatedKeys.getInt(1);
        }

        conetion.getConnection().close();
        conetion.setConnection(null);
        return idGenerado;
    }

    @Override
     public void modificar(T obj) throws Exception {
        String query = queryUpdate(obj);
        Statement st = conetion.getConnection().createStatement();
        st.executeUpdate(query);
        conetion.getConnection().close();
        conetion.setConnection(null);
    }
    
    
    public void modificarBlob(T obj) throws Exception {
        String query = queryUpdate(obj);
        PreparedStatement statement = conetion.getConnection().prepareStatement(query);

        setParameters(statement, obtenerObjeto(obj));

        statement.executeUpdate();
        conetion.getConnection().close();
        conetion.setConnection(null);
    }

    public boolean modificar2(CrearTarea crearTarea) {
        PreparedStatement consulta = null;
        Connection conexion = null;

        try {
            conexion = conetion.conectar();
            consulta = conexion.prepareStatement("UPDATE creartarea SET tema = ?, fechaCreacion = ?, fechaEntrega = ?, descripcion = ?, archivo = ?, extensionArchivo = ?, id_docenteMateria = ? WHERE id = ?;");
            consulta.setString(1, crearTarea.getTema());
            consulta.setDate(2, new java.sql.Date(crearTarea.getFechaCreacion().getTime()));
            consulta.setDate(3, new java.sql.Date(crearTarea.getFechaEntrega().getTime()));
            consulta.setString(4, crearTarea.getDescripcion());
            consulta.setBlob(5, crearTarea.getArchivo());
            consulta.setString(6, crearTarea.getExtensionArchivo());
            consulta.setInt(7, crearTarea.getId_docenteMateria());
            consulta.setInt(8, crearTarea.getId());
            consulta.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return false;
    }

    public boolean modificar3(EntregaTarea entregaTarea) {
        PreparedStatement consulta = null;
        Connection conexion = null;

        try {
            conexion = conetion.conectar();
            consulta = conexion.prepareStatement("UPDATE entregatarea SET nombreTarea = ?, estado = ?, fechaEntrega = ?, calificacion = ?, texto = ?, archivo = ?, extensionArchivo = ?, idCrearTarea = ?, idMatriculaCursoMateria = ? WHERE id = ?;");
            consulta.setString(1, entregaTarea.getNombreTarea());
            consulta.setString(2, entregaTarea.getEstado());
            consulta.setDate(3, new java.sql.Date(entregaTarea.getFechaEntrega().getTime()));
            consulta.setDouble(4, entregaTarea.getCalificacion());
            consulta.setString(5, entregaTarea.getTexto());
            consulta.setBlob(6, entregaTarea.getArchivo());
            consulta.setString(7, entregaTarea.getExtensionArchivo());
            consulta.setInt(8, entregaTarea.getIdCrearTarea());
            consulta.setInt(9, entregaTarea.getIdMatriculaCursoMateria());
            consulta.setInt(10, entregaTarea.getId());
            consulta.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return false;
    }

    public boolean modificar4(EntregaTarea entregaTarea) {
        PreparedStatement consulta = null;
        Connection conexion = null;

        try {
            conexion = conetion.conectar();
            consulta = conexion.prepareStatement("UPDATE entregatarea SET nombreTarea = ?, estado = ?, fechaEntrega = ?, calificacion = ?, texto = ?, archivo = ?, extensionArchivo = ?, idCrearTarea = ?, idMatriculaCursoMateria = ?, codigo = ? WHERE id = ?;");
            consulta.setString(1, entregaTarea.getNombreTarea());
            consulta.setString(2, entregaTarea.getEstado());
            consulta.setDate(3, new java.sql.Date(entregaTarea.getFechaEntrega().getTime()));
            consulta.setDouble(4, entregaTarea.getCalificacion());
            consulta.setString(5, entregaTarea.getTexto());
            consulta.setBlob(6, entregaTarea.getArchivo());
            consulta.setString(7, entregaTarea.getExtensionArchivo());
            consulta.setInt(8, entregaTarea.getIdCrearTarea());
            consulta.setInt(9, entregaTarea.getIdMatriculaCursoMateria());
            consulta.setString(10, entregaTarea.getCodigo());
            consulta.setInt(11, entregaTarea.getId());
            consulta.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return false;
    }

    @Override
    public LinkedList<T> listar() {
        LinkedList<T> lista = new LinkedList<>();
        try {
            Statement stmt = conetion.getConnection().createStatement();
            String query = "SELECT * FROM " + clazz.getSimpleName().toLowerCase();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                lista.add(llenarObjeto(rs));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lista;
    }

    @Override
    public T obtener(Integer id) {
        T data = null;
        try {
            Statement stmt = conetion.getConnection().createStatement();
            String query = "select * from " + clazz.getSimpleName().toLowerCase() + " where id = " + id;
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                data = llenarObjeto(rs);
            }
        } catch (Exception e) {
        }
        return data;
    }

    private T llenarObjeto(ResultSet rs) {
        T data = null;
        try {
            data = (T) clazz.getDeclaredConstructor().newInstance();
            for (Field f : clazz.getDeclaredFields()) {
                String atributo = f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
                fijarDatos(f, rs, data, atributo);
            }
            for (Field f : clazz.getSuperclass().getDeclaredFields()) {
                String atributo = f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
                fijarDatos(f, rs, data, atributo);
            }
        } catch (Exception e) {
            System.out.println("error " + e);
        }
        return data;
    }

    private void fijarDatos(Field f, ResultSet rs, T data, String atributo) {
        try {
            Method m = null;

            if (f.getType().getSimpleName().equalsIgnoreCase("String")) {
                m = clazz.getMethod("set" + atributo, String.class);
                m.invoke(data, rs.getString(atributo));
            }

            if (f.getType().getSimpleName().equalsIgnoreCase("Integer")) {
                m = clazz.getMethod("set" + atributo, Integer.class);
                m.invoke(data, rs.getInt(atributo));
            }

            if (f.getType().getSimpleName().equalsIgnoreCase("Double")) {
                m = clazz.getMethod("set" + atributo, Double.class);
                m.invoke(data, rs.getDouble(atributo));
            }

            if (f.getType().getSimpleName().equalsIgnoreCase("Boolean")) {
                m = clazz.getMethod("set" + atributo, Boolean.class);
                m.invoke(data, rs.getBoolean(atributo));
            }

            if (f.getType().getSimpleName().equalsIgnoreCase("Date")) {
                m = clazz.getMethod("set" + atributo, Date.class);
                m.invoke(data, rs.getDate(atributo));
            }

            if (f.getType().isEnum()) {
                m = clazz.getMethod("set" + atributo, (Class<Enum>) f.getType());
                m.invoke(data, Enum.valueOf((Class<Enum>) f.getType(), rs.getString(atributo)));
            }

            if (f.getType().getSimpleName().equalsIgnoreCase("Blob")) {
                m = clazz.getMethod("set" + atributo, java.sql.Blob.class);
                m.invoke(data, rs.getBlob(atributo));
            }

        } catch (Exception e) {
            System.out.println("chiqui error " + e);
        }
    }

    private HashMap<String, Object> obtenerObjeto(T obj) {
        HashMap<String, Object> mapa = new HashMap<>();
        try {
            for (Field f : clazz.getDeclaredFields()) {
                Method m = null;
                String atributo = f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
                m = clazz.getMethod("get" + atributo);
                Object aux = m.invoke(obj);
                if (aux != null) {
                    mapa.put(atributo.toLowerCase(), aux);
                }
            }

            for (Field f : clazz.getSuperclass().getDeclaredFields()) {
                Method m = null;
                String atributo = f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
                m = clazz.getMethod("get" + atributo);
                Object aux = m.invoke(obj);
                if (aux != null) {
                    mapa.put(atributo.toLowerCase(), aux);
                }
            }
        } catch (Exception e) {
            System.out.println("No se pudo tener dato");
        }
        return mapa;
    }

    private void setParameters(PreparedStatement statement, Map<String, Object> parameters) {
        try {
            int index = 1;
            for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                if (entry.getValue().getClass().getSimpleName().equalsIgnoreCase("Blob")) {
                    statement.setBlob(index, (Blob) entry.getValue());
                } else {
                    statement.setObject(index, entry.getValue());
                }
                index++;
            }
        } catch (Exception e) {
            System.out.println("Error setting parameters: " + e);
        }
    }

    private String queryInsert(T obj) {
        HashMap<String, Object> mapa = obtenerObjeto(obj);
        String query = "INSERT INTO " + clazz.getSimpleName().toLowerCase() + " (";
        for (Map.Entry<String, Object> entry : mapa.entrySet()) {
            query += entry.getKey() + ",";
        }
        query = query.substring(0, query.length() - 1);
        query += ") VALUES (";
        for (Map.Entry<String, Object> entry : mapa.entrySet()) {
            query += "?,";
        }
        query = query.substring(0, query.length() - 1);
        query += ")";
        return query;
    }

    private String queryUpdate(T obj) {
        HashMap<String, Object> mapa = obtenerObjeto(obj);
        String query = "UPDATE " + clazz.getSimpleName().toLowerCase() + " SET ";
        Integer id = 0;
        for (Map.Entry<String, Object> entry : mapa.entrySet()) {
            if (entry.getKey().toString().equalsIgnoreCase("id")) {
                id = (Integer) entry.getValue();
            } else {
                query += entry.getKey() + " = ?, ";
            }
        }

        query = query.substring(0, query.length() - 2);
        query += " WHERE id = " + id;
        return query;
    }
}
