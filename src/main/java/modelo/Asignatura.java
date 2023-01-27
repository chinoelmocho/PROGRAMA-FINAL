/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author David
 */
public class Asignatura implements Serializable{

    private String nombre;
    private String docente;
    private int numHoras;
    private int horasSemanales;
    private double costoHoras;
    private int cuposDisponibles;
    private Carrera Carrera;
    private String modalidad;
    private int codigo;

    public Asignatura(String nombre, String docente, int numHoras, int horasSemanales, double costoHoras, int cuposDisponibles, Carrera Carrera, String modalidad, int codigo) {
        this.nombre = nombre;
        this.docente = docente;
        this.numHoras = numHoras;
        this.horasSemanales = horasSemanales;
        this.costoHoras = costoHoras;
        this.cuposDisponibles = cuposDisponibles;
        this.Carrera = Carrera;
        this.modalidad = modalidad;
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public int getNumHoras() {
        return numHoras;
    }

    public void setNumHoras(int numHoras) {
        this.numHoras = numHoras;
    }

    public int getHorasSemanales() {
        return horasSemanales;
    }

    public void setHorasSemanales(int horasSemanales) {
        this.horasSemanales = horasSemanales;
    }

    public double getCostoHoras() {
        return costoHoras;
    }

    public void setCostoHoras(double costoHoras) {
        this.costoHoras = costoHoras;
    }

    public int getCuposDisponibles() {
        return cuposDisponibles;
    }

    public void setCuposDisponibles(int cuposDisponibles) {
        this.cuposDisponibles = cuposDisponibles;
    }

    public Carrera getCarrera() {
        return Carrera;
    }

    public void setCarrera(Carrera Carrera) {
        this.Carrera = Carrera;
    }

    public double costoAsignatura() {
        return this.costoHoras * this.numHoras;

    }

    public String periodoDuracion() {
        var months = (this.numHoras / this.horasSemanales);

        return "Tiene una duracion= " + months + " meses";

    }

    @Override
    public String toString() {
        return "Asignatura{" + "nombre=" + nombre + ", docente=" + docente + ", numHoras=" + numHoras + ", horasSemanales=" + horasSemanales + ", costoHoras=" + costoHoras + ", cuposDisponibles=" + cuposDisponibles + ", con un costo total de=" + this.costoAsignatura() + this.periodoDuracion() + ", de modalidad=" + this.modalidad + "\n, Carrera=" + Carrera.getNombre() + ", Codigo=" + this.codigo + '}';
    }

}
