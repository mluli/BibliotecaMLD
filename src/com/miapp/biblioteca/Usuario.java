package com.miapp.biblioteca;

import java.util.ArrayList;

public class Usuario {
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private String nombre;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;

    public ArrayList<Libro> getLibrosPrestados() {
        return librosPrestados;
    }

    public void setLibrosPrestados(ArrayList<Libro> librosPrestados) {
        this.librosPrestados = librosPrestados;
    }

    private ArrayList <Libro> librosPrestados;

    public Usuario(String nombre,String id) {
        this.nombre = nombre;
        this.id = id;
        this.librosPrestados = new ArrayList<>();
    }

    public Usuario(){

    }

    @Override
    public String toString() {
        return "Usuario [Nombre="+nombre+", id="+id+"]";
    }



}
