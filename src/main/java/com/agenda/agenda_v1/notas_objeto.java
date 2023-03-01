package com.agenda.agenda_v1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nuria
 */
public class notas_objeto {
    public String asignatura;
    public String tipo;
    public String nombre;
    public String nota;
    public String comentario;

    public notas_objeto(String asignatura, String tipo, String nombre, String nota, String comentario) {
        this.asignatura = asignatura;
        this.tipo = tipo;
        this.nombre = nombre;
        this.nota = nota;
        this.comentario = comentario;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    

   
    
}
