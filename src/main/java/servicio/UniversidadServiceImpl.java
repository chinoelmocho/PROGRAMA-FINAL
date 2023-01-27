/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Universidad;

/**
 *
 * @author Mauricio Ortiz
 */
public class UniversidadServiceImpl implements UniversidadService {

    private static List<Universidad> universidadList = new ArrayList<>();

    @Override
    public void crear(Universidad universidad) {

        this.universidadList.add(universidad);
        this.almacenarArchivo(universidad, "C:/Netbeans1/universidad.dat");
    }

    @Override
    public List<Universidad> listar() {
        return this.universidadList;
    }

    @Override
    public Universidad UniversidadCodigo(int codigo) {
        Universidad retorno = null;
        for (var universidad : this.universidadList) {
            if (codigo == universidad.getCodigo()) {
                retorno = universidad;
                break;

            }
        }
        return retorno;
    }

    @Override
    public void modificar(Universidad universidad, int codigo) {

        var indice = -1;
        for (var universidades : this.universidadList) {
            indice++;
            if (codigo == universidades.getCodigo()) {
                this.universidadList.set(indice, universidad);

            }

        }
        this.Actualizar();
    }

    @Override
    public void eliminar(int codigo) {
        var indice = -1;
        for (var universidades : this.universidadList) {
            indice++;
            if (codigo == universidades.getCodigo()) {
                this.universidadList.remove(indice);

            }

        }
        this.Actualizar();
    }

    @Override
    public List<Universidad> recuperarArchivo(String ruta) {
     var universidadlist = new ArrayList<Universidad>();
        DataInputStream entrada = null;
        try {
            entrada = new DataInputStream(new FileInputStream(ruta));
            while (true) {
              
                var Nombre = entrada.readUTF();
                var Director = entrada.readUTF();
                var year = entrada.readInt();
                var mes = entrada.readInt();
                var dia= entrada.readInt();
                var numEstudiantes = entrada.readInt();
                var costomatricula = entrada.readDouble();
                var Codigo=entrada.readInt();
     
                var universidad = new Universidad(Nombre, Director, LocalDate.of(year,mes,dia),numEstudiantes,costomatricula,Codigo);
                universidadlist.add(universidad);
            }
        } catch (IOException e) {
            try {
                entrada.close();
            } catch (IOException ex) {
                Logger.getLogger(UniversidadServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return universidadlist;    
    
    }

    @Override
    public void almacenarArchivo(Universidad universidad, String ruta) {
     DataOutputStream salida = null;

        try {
            salida = new DataOutputStream(new FileOutputStream(ruta, true));
            salida.writeUTF(universidad.getNombre());
            salida.writeUTF(universidad.getDirector());
            salida.writeInt(universidad.getYearFundacion().getDayOfYear());
            salida.writeInt(universidad.getYearFundacion().getMonthValue());
            salida.writeInt(universidad.getYearFundacion().getDayOfMonth());
            salida.writeInt(universidad.getNumEstudiantes());
            salida.writeDouble(universidad.getCostoMatricula());
            salida.writeInt(universidad.getCodigo() );
           

        } catch (IOException ex) {
            Logger.getLogger(UniversidadServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
    
    
    }
      public   void setUniversidadList(List<Universidad> universidadList) {
        UniversidadServiceImpl.universidadList= universidadList;
    }
      public void Actualizar() {
          var Borrarfile= new File("C:/Netbeans1/universidad.dat");
        Borrarfile.delete();
        
        
        for(var i=0;i<universidadList.size();i++){
        this.almacenarArchivo(universidadList.get(i),"C:/Netbeans1/universidad.dat");
        }
     /*ficheroEntrada =new File("clientes.dat");
ficheroSalida = new File("temporal.dat");
try(FileInputStream flujoEntrada = new FileInputStream(ficheroEntrada);
    FileOutputStream flujoSalida = new FileOutputStream (ficheroSalida))
{
    lector = new ObjectInputStream (flujoEntrada);
    escritor = new ObjectOutputStream(flujoSalida); 
    Cliente cliente;
    while(true)
    { 
        cliente = (Cliente)lector.readObject();
        if(!borrarNif.equals(cliente.dni))
        {
            escritor.writeObject(cliente);
        }   
    }
}
catch (FileNotFoundException fnfe)
{
    System.out.println("Fichero no encontrado");
}
catch (IOException ioe)
{
    //ioe.printStackTrace();
}
ficheroEntrada.delete();
ficheroSalida.renameTo(ficheroEntrada);*/
    
    }


}
