/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Asignatura;
import modelo.Carrera;
import static servicio.CarreraServiceImpl.carreraList;

/**
 *
 * @author David
 */
public class AsignaturaServiceImpl implements AsignaturaService {

    public static List<Asignatura> asiganturaList =new ArrayList<>();

    public AsignaturaServiceImpl() {
        
    }

    @Override
    public void crear(Asignatura asignatura) {
        this.asiganturaList.add(asignatura);
         this.almacenarArchivo(asignatura, "C:/Netbeans1/asignatura.dat");
        
        
    }

    @Override
    public List<Asignatura> listar() {
        return this.asiganturaList;
    }

    @Override
    public void modificar(Asignatura asignatura, int codigo) {
        var indice = -1;
        for (var asignaturas : this.asiganturaList) {
            indice++;
            if (codigo == asignaturas.getCodigo()) {
                System.out.print("chi");
                this.asiganturaList.set(indice, asignatura);

            }

        }
        this.Actualizar();
    }

    @Override
    public void eliminar(int codigo) {
        var indice = -1;
        
        for (var asignatura : this.asiganturaList) {
            indice++;
            if (codigo == asignatura.getCodigo()) {
                this.asiganturaList.remove(indice);

            }

        }
        this.Actualizar();
    }

    @Override
    public List<Asignatura> recuperarArchivo(String ruta) {
        List<Asignatura> asiganturaList= new ArrayList<Asignatura>();
        
        
        ObjectInputStream entrada =null;
        try{
            var fis=new FileInputStream(new File(ruta));
            while(fis.available()>0){
            entrada = new ObjectInputStream(fis);
            Asignatura asignatura = (Asignatura) entrada.readObject();
            asiganturaList.add(asignatura);
            
            
            }
            entrada.close();
 
        }catch(Exception ex){
            try {
                entrada.close();
            } catch (IOException ex1) {
                Logger.getLogger(CarreraServiceImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
      
    return  asiganturaList;
  
    }

    @Override
    public void almacenarArchivo(Asignatura asigantura, String ruta) {
        ObjectOutputStream salida=null;
        
        try {
            salida = new ObjectOutputStream(new FileOutputStream(ruta, true));
            salida.writeObject(asigantura);
            salida.close();
        
        } catch (Exception ex) {
            
            Logger.getLogger(AsignaturaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void Actualizar() {
        var Borrarfile = new File("C:/Netbeans1/asignatura.dat");
        Borrarfile.delete();

        for (var i = 0; i < asiganturaList.size(); i++) {
            this.almacenarArchivo(asiganturaList.get(i), "C:/Netbeans1/asignatura.dat");

        }

    }

   public  void setAsignaturaList(List<Asignatura> asignaturalist) {
        AsignaturaServiceImpl.asiganturaList=asignaturalist;
        System.out.print("chi2");
    }

}
