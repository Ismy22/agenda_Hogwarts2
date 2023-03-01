/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agenda.agenda_v1;

/**
 *
 * @author nuria
 */
public class tareas_alumnos_objeto {
    public int id_tarea;
    public String asignatura;
    public String tipo_tarea;
    public String nombre_tarea;
    public String fecha_fin;
    public String archivo;

    public tareas_alumnos_objeto(int id_tarea, String asignatura, String tipo_tarea, String nombre_tarea, String fecha_fin, String archivo) {
        this.id_tarea = id_tarea;
        this.asignatura = asignatura;
        this.tipo_tarea = tipo_tarea;
        this.nombre_tarea = nombre_tarea;
        this.fecha_fin = fecha_fin;
        this.archivo = archivo;
    }

    public int getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(int id_tarea) {
        this.id_tarea = id_tarea;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getTipo_tarea() {
        return tipo_tarea;
    }

    public void setTipo_tarea(String tipo_tarea) {
        this.tipo_tarea = tipo_tarea;
    }

    public String getNombre_tarea() {
        return nombre_tarea;
    }

    public void setNombre_tarea(String nombre_tarea) {
        this.nombre_tarea = nombre_tarea;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    
}
