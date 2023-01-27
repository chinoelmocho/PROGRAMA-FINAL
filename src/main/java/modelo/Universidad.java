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
public class Universidad implements Serializable {

    private String nombre;
    private String director;
    private LocalDate yearFundacion;
    private int numEstudiantes;
    private double costoMatricula;
    private int codigo;

    public Universidad(String nombre, String director, LocalDate yearFundacion, int numEstudiantes, double costoMatricula, int codigo) {
        this.nombre = nombre;
        this.director = director;
        this.yearFundacion = yearFundacion;
        this.numEstudiantes = numEstudiantes;
        this.costoMatricula = costoMatricula;
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public LocalDate getYearFundacion() {
        return yearFundacion;
    }

    public void setYearFundacion(LocalDate yearFundacion) {
        this.yearFundacion = yearFundacion;
    }

    public int getNumEstudiantes() {
        return numEstudiantes;
    }

    public void setNumEstudiantes(int numEstudiantes) {
        this.numEstudiantes = numEstudiantes;
    }

    public double getCostoMatricula() {
        return costoMatricula;
    }

    public void setCostoMatricula(double costoMatricula) {
        this.costoMatricula = costoMatricula;
    }

    @Override
    public String toString() {

        return "\nUniversidad{" + "nombre=" + nombre + ", Codigo=" + this.codigo + ", director=" + director + ", yearFundacion=" + yearFundacion + ", numEstudiantes="
                + numEstudiantes + ", costoMatricula=" + costoMatricula + ", años de Universidad=" + this.yearUniversidad() + ", Ingresos por Matriculas=" + this.ingresoporMatriculas() + '}';
    }

    public int yearUniversidad() {
        var years = LocalDate.now().getYear() - this.yearFundacion.getYear();
        if (this.yearFundacion.getMonthValue() < LocalDate.now().getMonthValue()) {
            years -= 1;
        }
        if (this.yearFundacion.getMonthValue() == LocalDate.now().getMonthValue()) {
            if (this.yearFundacion.getDayOfMonth() < LocalDate.now().getDayOfMonth()) {
                years -= 1;
            }

        }
        return years;
    }

    public double ingresoporMatriculas() {
        return this.costoMatricula * this.numEstudiantes;
    }

}
