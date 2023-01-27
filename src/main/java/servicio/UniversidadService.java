/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servicio;

import java.util.List;
import modelo.Universidad;

/**
 *
 * @author Mauricio Ortiz
 */
public interface UniversidadService {

    public Universidad UniversidadCodigo(int codigo);

    public void crear(Universidad universidad);

    public void modificar(Universidad universidad, int codigo);

    public void eliminar(int codigo);

    public List<Universidad> listar();
    
    public List<Universidad> recuperarArchivo(String ruta) ;
    
    public void almacenarArchivo(Universidad universidad, String ruta) ;

}
