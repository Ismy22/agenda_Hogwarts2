/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agenda.agenda_v1;

/**
 *
 * @author ismae
 */
public class Alumnos_asistencia_objeto {
    public String nombre;
    public String apellidos;
    public String dni;
    public String estado;
    public String Fecha;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public Alumnos_asistencia_objeto(String nombre, String apellidos, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }

    public Alumnos_asistencia_objeto(String nombre, String apellidos, String dni, String estado) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.estado = estado;
    }

    public Alumnos_asistencia_objeto(String nombre, String apellidos, String dni, String estado, String Fecha) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.estado = estado;
        this.Fecha = Fecha;
    }
    

}