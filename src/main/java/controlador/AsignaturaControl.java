/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.time.LocalDate;
import java.util.List;
import modelo.Asignatura;
import modelo.Carrera;

import servicio.AsignaturaServiceImpl;
import servicio.CarreraServiceImpl;

/**
 *
 * @author David
 */
public class AsignaturaControl {

    private AsignaturaServiceImpl asignaturaServiceImpl = new AsignaturaServiceImpl();
    private CarreraServiceImpl carreraServiceImpl = new CarreraServiceImpl();

    public AsignaturaControl() {
        this.asignaturaServiceImpl = new AsignaturaServiceImpl();
    }

    public void crear(String[] data) {
        try {
            var retorno = "No se puede crear la Asignatura:";
            var nombre = data[0];
            var docente = data[1];
            var numHoras = Integer.valueOf(data[2]).intValue();
            var horasSemanales = Integer.valueOf(data[3]).intValue();
            var costoHoras = Double.valueOf(data[4]).doubleValue();
            var cuposDisponibles = Integer.valueOf(data[5]).intValue();
            var carrera = this.carreraServiceImpl.CarreraCodigo(Integer.valueOf(data[6]));
            if( carrera== null){
        throw new NumberFormatException(" No existe carrera "); 
        }
            var modalidad = data[7];
            var codigo = Integer.valueOf(data[8]).intValue();

            if (numHoras < 0) {
                retorno += " El numero de Horas no son validos ";
            } else {
                if (horasSemanales <= 0 || horasSemanales > 24) {
                    retorno += " El numero de horas semanales es incorrecto ";
                } else {
                    if (costoHoras < 0) {
                        retorno += " El costo por horas no es valido";
                    } else {
                        if (cuposDisponibles < 0) {
                            retorno += " Los cupos disponibles no validos ";
                        } else {
                            if (carrera == null) {
                                retorno += " Universidad fuera del registro ";
                            } else {
                                var asignatura = new Asignatura(nombre, docente, numHoras, horasSemanales, costoHoras, cuposDisponibles, carrera, modalidad, codigo);
                                if (this.codigoActual(codigo)) {
                                    throw new RuntimeException(" Codigo Existente ");
                                } else {
                                    this.asignaturaServiceImpl.crear(asignatura);
                                    retorno = "Creado Satisfactoriamente ";
                                }
                            }

                        }

                    }

                }

            }
        } catch (NumberFormatException e1) {
            throw new RuntimeException("Error en los parametros");
        } catch (RuntimeException e1) {
            throw new RuntimeException("Codigo Existente");
        }

    }

    public boolean codigoActual(int codigo) {
        var retorno = false;
        System.out.print(this.asignaturaServiceImpl.listar());
        for (var asignatura : this.asignaturaServiceImpl.listar()) {
            if (asignatura.getCodigo() == codigo) {
                retorno = true;
              

            }
        }

        return retorno;
    }

    public void modificar(String[] data) {
        try {
            var retorno = "No se puede crear la Asignatura:";
            var nombre = data[0];
            var docente = data[1];
            var numHoras = Integer.valueOf(data[2]).intValue();
            var horasSemanales = Integer.valueOf(data[3]).intValue();
            var costoHoras = Double.valueOf(data[4]).doubleValue();
            var cuposDisponibles = Integer.valueOf(data[5]).intValue();
            var carrera = this.carreraServiceImpl.CarreraCodigo(Integer.valueOf(data[6]));
            var modalidad = data[7];
            var codigo = Integer.valueOf(data[8]).intValue();
            var modificar = Integer.valueOf(data[9]).intValue();

            if (numHoras < 0) {
                retorno += " El numero de Horas no son validos ";
            } else {
                if (horasSemanales <= 0 || horasSemanales > 24) {
                    retorno += " El numero de horas semanales es incorrecto ";
                } else {
                    if (costoHoras < 0) {
                        retorno += " El costo por horas no es valido";
                    } else {
                        if (cuposDisponibles < 0) {
                            retorno += " Los cupos disponibles no validos ";
                        } else {
                            if (carrera == null) {
                                retorno += " Universidad fuera del registro ";
                            } else {
                                var asignatura = new Asignatura(nombre, docente, numHoras, horasSemanales, costoHoras, cuposDisponibles, carrera, modalidad, codigo);
                                if (!this.codigoActual(modificar)) {
                                      System.out.print("chi");
                                    throw new RuntimeException(" Codigo No Existente ");
                                    

                                } else {
                                    this.asignaturaServiceImpl.modificar(asignatura, modificar);
                                    retorno = "Modificado Satisfactoriamente ";
                                }

                            }

                        }

                    }

                }

            }
        } catch (NumberFormatException e1) {
            throw new RuntimeException("Error en los parametros");
        } catch (RuntimeException e1) {
            throw new RuntimeException("Codigo No Existente");
        }

    }

    public void eliminar(String codigos) {
        var codigo = Integer.valueOf(codigos).intValue();
        try {
            if (!this.codigoActual(codigo)) {
                throw new RuntimeException(" Codigo No Existente ");

            } else {

                this.asignaturaServiceImpl.eliminar(codigo);
            }
        } catch (NumberFormatException e1) {
            throw new RuntimeException("Codigo no valido");
        }

    }

    public List<Asignatura> listar() {
        return this.asignaturaServiceImpl.listar();

    }
}
