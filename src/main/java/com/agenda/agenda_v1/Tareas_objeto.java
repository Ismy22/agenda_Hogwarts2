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
public class Tareas_objeto {
    
    public int id_tarea;
    public String id_profesor;
    public String id_estudiante;
    public String id_curso;
    public String nombre_tarea;    
    public Date descripcion_tarea;
    public String tipo_tarea;
    public String rubrica;
    public String fecha_inicio;
    public String fecha_fin;
    public String entregado;
    public String archivo;
    public String corregido;
    


    public Tareas_objeto(int id_tarea, String id_profesor, String id_estudiante, String id_curso, String nombre_tarea, Date descripcion_tarea, String tipo_tarea, String rubrica, String fecha_inicio, String fecha_fin, String entregado, String archivo, String corregido) {
        this.id_tarea = id_tarea;
        this.id_profesor = id_profesor;
        this.id_estudiante = id_estudiante;
        this.id_curso = id_curso;
        this.nombre_tarea = nombre_tarea;
        this.descripcion_tarea = descripcion_tarea;
        this.tipo_tarea = tipo_tarea;
        this.rubrica = rubrica;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.entregado = entregado;
        this.archivo = archivo;
        this.corregido = corregido;

    }

    public int getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(int id_tarea) {
        this.id_tarea = id_tarea;
    }

    public String getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(String id_profesor) {
        this.id_profesor = id_profesor;
    }

    public String getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(String id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public String getId_curso() {
        return id_curso;
    }

    public void setId_curso(String id_curso) {
        this.id_curso = id_curso;
    }

    public String getNombre_tarea() {
        return nombre_tarea;
    }

    public void setNombre_tarea(String nombre_tarea) {
        this.nombre_tarea = nombre_tarea;
    }

    public Date getDescripcion_tarea() {
        return descripcion_tarea;
    }

    public void setDescripcion_tarea(Date descripcion_tarea) {
        this.descripcion_tarea = descripcion_tarea;
    }

    public String getTipo_tarea() {
        return tipo_tarea;
    }

    public void setTipo_tarea(String tipo_tarea) {
        this.tipo_tarea = tipo_tarea;
    }

    public String getRubrica() {
        return rubrica;
    }

    public void setRubrica(String rubrica) {
        this.rubrica = rubrica;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getEntregado() {
        return entregado;
    }

    public void setEntregado(String entregado) {
        this.entregado = entregado;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public String getCorregido() {
        return corregido;
    }

    public void setCorregido(String corregido) {
        this.corregido = corregido;
    }
    

}