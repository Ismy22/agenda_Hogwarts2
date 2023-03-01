/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agenda.agenda_v1;

import java.util.Date;

/**
 *
 * @author Ismael
 */
public class Alumnos_objeto {
    public String nombre;
    public String apellidos;
    public String curso;
    public String casa;
    public String dni;

    public Alumnos_objeto(String nombre, String apellidos, String curso, String casa, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.curso = curso;
        this.casa = casa;
        this.dni = dni;
    }
    public String estado;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    

    public Alumnos_objeto(String nombre, String apellidos, String curso, String casa) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.curso = curso;
        this.casa = casa;
    }

    public Alumnos_objeto(String nombre, String apellidos, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }
    

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

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getCasa() {
        return casa;
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }

    public String getEstado() {
        
        
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
}
