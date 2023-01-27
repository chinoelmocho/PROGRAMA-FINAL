/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servicio;

import java.util.List;
import modelo.Carrera;
import modelo.Universidad;

/**
 *
 * @author Mauricio Ortiz
 */
public interface CarreraService {

    public void crear(Carrera carrera);

    public void modificar(Carrera carrera, int codigo);

    public void eliminar(int codigo);

    public List<Carrera> listar();

    public Carrera CarreraCodigo(int codigo);
    
      public List<Carrera> recuperarArchivo(String ruta);

    public void almacenarArchivo(Carrera carrera, String ruta);
    

}
