/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador.dao.Tarea;

import java.util.ArrayList;
import modelo.Tarea;

/**
 *
 * @author Jhostin
 */
public interface CRUD {
    ArrayList<Tarea> Listar_all();

    void Agregar_Archivo(Tarea vo);

    void Modificar_Archivo(Tarea vo);

    void Modificar_Archivo2(Tarea vo);

    void Eliminar_Archivo(Tarea vo);
}
