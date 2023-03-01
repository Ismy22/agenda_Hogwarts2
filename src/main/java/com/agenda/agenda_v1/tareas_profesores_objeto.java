/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agenda.agenda_v1;

/**
 *
 * @author nuria
 */
public class tareas_profesores_objeto {
    private String id_tarea;
    private String nombre;
    private String apellidos;
    private String curso;
    private String nombre_tarea;
    private String tipo_tarea;
    private String fecha_fin;

    public tareas_profesores_objeto(String nombre, String apellidos, String curso, String nombre_tarea, String tipo_tarea, String fecha_fin) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.curso = curso;
        this.nombre_tarea = nombre_tarea;
        this.tipo_tarea = tipo_tarea;
        this.fecha_fin = fecha_fin;
    }

    public tareas_profesores_objeto(String id_tarea, String nombre, String apellidos, String curso, String nombre_tarea, String tipo_tarea, String fecha_fin) {
        this.id_tarea = id_tarea;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.curso = curso;
        this.nombre_tarea = nombre_tarea;
        this.tipo_tarea = tipo_tarea;
        this.fecha_fin = fecha_fin;
    }

    public String getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(String id_tarea) {
        this.id_tarea = id_tarea;
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

    public String getNombre_tarea() {
        return nombre_tarea;
    }

    public void setNombre_tarea(String nombre_tarea) {
        this.nombre_tarea = nombre_tarea;
    }

    public String getTipo_tarea() {
        return tipo_tarea;
    }

    public void setTipo_tarea(String tipo_tarea) {
        this.tipo_tarea = tipo_tarea;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
     
}
