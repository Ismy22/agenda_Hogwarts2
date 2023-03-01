/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agenda.agenda_v1;

/**
 *
 * @author nuria
 */
public class mensajeria_objeto {
    public int id;
    public String nombre;
    public String apellidos;
    public String curso;
    public String fecha;
    public String leidos;

    public mensajeria_objeto(int id, String nombre, String apellidos, String fecha, String leidos) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha = fecha;
        this.leidos = leidos;
    }

    public mensajeria_objeto(int id, String nombre, String apellidos, String curso, String fecha, String leidos) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.curso = curso;
        this.fecha = fecha;
        this.leidos = leidos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLeidos() {
        return leidos;
    }

    public void setLeidos(String leidos) {
        this.leidos = leidos;
    }

    

    
}
