/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.time.LocalDate;
import java.util.List;
import modelo.Universidad;
import servicio.UniversidadServiceImpl;

/**
 *
 * @author Mauricio Ortiz
 */
public class UniversidadControl {

    private UniversidadServiceImpl universidadServiceImpl = new UniversidadServiceImpl();

    public void crear(String[] data) throws Exception {
        try {
            var retorno="No se pudo crear universidad";
            var nombre = data[0];
            var director = data[1];
            var year = Integer.valueOf(data[2]).intValue();
            var mes = Integer.valueOf(data[3]).intValue();
            var dia = Integer.valueOf(data[4]).intValue();
            var numEstudiantes = Integer.valueOf(data[5]).intValue();
            var costoMatricula = Double.valueOf(data[6]).doubleValue();
            var codigo = Integer.valueOf(data[7]).intValue();

            if (year > LocalDate.now().getYear()) {
                retorno+=" El año no es valido ";

            } else {
                if (mes < 1 || mes > 12) {
                    retorno+="  El mes no es valido  ";

                } else {
                    if (dia < 0 || dia > 31) {
                        retorno+=" El dia no es valido  ";

                    } else {
                        if (numEstudiantes < 0) {
                            retorno+=" El numero de estudientes no es valido  ";
                            

                        } else {
                            if (costoMatricula < 0) {
                                retorno+=" El costo de la matricula es incorrecto   ";

                            } else {
                                var universidad = new Universidad(nombre, director, LocalDate.of(year, mes, dia), numEstudiantes, costoMatricula, codigo);
                                if(this.codigoActual(codigo)){
                                throw new RuntimeException(" Codigo Existente ");
                                
                                }else{
                                this.universidadServiceImpl.crear(universidad);}

                            }

                        }

                    }

                }

            }
            
        
        }catch(NumberFormatException e1){
            throw new RuntimeException("Error en los parametros");
        }catch(RuntimeException e1){
            throw new RuntimeException("Codigo Existente");
        }

    }
    public boolean codigoActual(int codigo){
        var retorno = false;
        for(var universidad:this.universidadServiceImpl.listar()){
            if(universidad.getCodigo()==codigo){
                retorno=true;
            
            }
        }
        
        return retorno;
}
    

    public List<Universidad> listar() {
        return this.universidadServiceImpl.listar();
    }

    public void modificar(String[] data) {
        try {
        var retorno = "No se puede crear Universidad";

        var nombre = data[0];
        var director = data[1];
        var year = Integer.valueOf(data[2]).intValue();
        var mes = Integer.valueOf(data[3]).intValue();
        var dia = Integer.valueOf(data[4]).intValue();
        var numEstudiantes = Integer.valueOf(data[5]).intValue();
        var costoMatricula = Double.valueOf(data[6]).doubleValue();
        var codigo = Integer.valueOf(data[7]).intValue();
        var universidadModificada = Integer.valueOf(data[8]).intValue();

        if (year > LocalDate.now().getYear()) {
            retorno += " El año no es valido ";
        } else {
            if (mes < 1 || mes > 12) {
                retorno += " El mes no es valido ";
            } else {
                if (dia < 0 || dia > 31) {
                    retorno += " El dia no es valido ";
                } else {
                    if (numEstudiantes < 0) {
                        retorno += " El numero de estudientes no es valido ";
                    } else {
                        if (costoMatricula < 0) {
                            retorno += " El costo de la matricula es incorrecto ";
                        } else {
                            var universidad = new Universidad(nombre, director, LocalDate.of(year, mes, dia), numEstudiantes, costoMatricula, codigo);
                            if(!this.codigoActual(universidadModificada)){
                                throw new RuntimeException(" Codigo No Existente ");
                            }else{
                            this.universidadServiceImpl.modificar(universidad, universidadModificada);
                            retorno = "Universidad modificada Exitosamente ";}

                        }

                    }

                }

            }

        }}catch(NumberFormatException e1){
            throw new RuntimeException("Error en los parametros");
        }catch(RuntimeException e1){
            throw new RuntimeException("Codigo No Existe");
        }
        
        
        

    }

    public void eliminar(String codigos) {
        var codigo = Integer.valueOf(codigos).intValue();
        try{
            if(!this.codigoActual(codigo)){
                throw new RuntimeException(" Codigo No Existente ");
                
            }else{
            
            this.universidadServiceImpl.eliminar(codigo);
            }
        }catch(NumberFormatException e1){
            throw new RuntimeException("Codigo no valido");
        }
    }
}
