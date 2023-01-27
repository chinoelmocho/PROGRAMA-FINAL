/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servicio;

import java.util.List;
import modelo.Asignatura;
import modelo.Carrera;

/**
 *
 * @author David
 */
public interface AsignaturaService {

    public void crear(Asignatura asignatura);

    public void modificar(Asignatura asignatura, int codigo);

    public void eliminar(int codigo);

    public List<Asignatura> listar();
    
    public List<Asignatura> recuperarArchivo(String ruta) ;
    
    public void almacenarArchivo(Asignatura asigantura, String ruta) ;
    
    
    
    
    
}
