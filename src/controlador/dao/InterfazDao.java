/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador.dao;

import controlador.TDA.listas.LinkedList;

/**
 *
 * @author juanc
 */
public interface InterfazDao<T> {
    
    public Integer guardar(T obj) throws Exception;

    public void modificar(T obj) throws Exception;

    public LinkedList<T> listar();

    public T obtener(Integer id);
    
}
