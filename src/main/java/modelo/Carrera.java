/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Mauricio Ortiz
 */
public class Carrera implements Serializable{

    private String nombre;
    private String direcorCarrera;
    private double costoCiclo;
    private int numCiclos;
    private LocalDate yearInaguracion;
    private Universidad universidad;
    private int codigo;

    public Carrera(String nombre, String direcorCarrera, double costoCiclo, int numCiclos, LocalDate yearInaguracion, Universidad universidad, int codigo) {
        this.nombre = nombre;
        this.direcorCarrera = direcorCarrera;
        this.costoCiclo = costoCiclo;
        this.numCiclos = numCiclos;
        this.yearInaguracion = yearInaguracion;
        this.universidad = universidad;
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirecorCarrera() {
        return direcorCarrera;
    }

    public void setDirecorCarrera(String direcorCarrera) {
        this.direcorCarrera = direcorCarrera;
    }

    public double getCostoCiclo() {
        return costoCiclo;
    }

    public void setCostoCiclo(double costoCiclo) {
        this.costoCiclo = costoCiclo;
    }

    public int getNumCiclos() {
        return numCiclos;
    }

    public void setNumCiclos(int numCiclos) {
        this.numCiclos = numCiclos;
    }

    public LocalDate getYearInaguracion() {
        return yearInaguracion;
    }

    public void setYearInaguracion(LocalDate yearInaguracion) {
        this.yearInaguracion = yearInaguracion;
    }

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }

    public double costoTotalCarrera() {
        return this.costoCiclo * this.numCiclos;
    }

    public int yearCarrera() {
        var years = LocalDate.now().getYear() - this.yearInaguracion.getYear();
        if (this.yearInaguracion.getMonthValue() < LocalDate.now().getMonthValue()) {
            years -= 1;
        }
        if (this.yearInaguracion.getMonthValue() == LocalDate.now().getMonthValue()) {
            if (this.yearInaguracion.getDayOfMonth() < LocalDate.now().getDayOfMonth()) {
                years -= 1;
            }

        }
        return years;
    }

    @Override
    public String toString() {
        return "Carrera{" + "nombre=" + nombre + ", direcorCarrera=" + direcorCarrera + ", costoCiclo=" + costoCiclo + ", numCiclos=" + numCiclos + ", yearInaguracion=" + yearInaguracion + ", Costo total=" + this.costoTotalCarrera() + ", año de la carrera=" + this.yearCarrera() + "\n, universidad=" + universidad.getNombre() + '}';
    }
}
