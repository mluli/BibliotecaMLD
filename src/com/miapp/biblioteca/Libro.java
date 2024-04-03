package com.miapp.biblioteca;
import java.util.ArrayList;
public class Libro {

    private String titulo;
    private String autor;
    private String ISBN;
    private String genero;
    private boolean disponible;

    public Libro(String titulo, String autor, String ISBN, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.genero = genero;
        this.disponible = true;
    }


    public Libro() {

    }

    public String gettitulo() {
        return titulo;
    }

    public void settitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getautor() {
        return autor;
    }

    public void setautor(String autor) {
        this.autor = autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getgenero(String nuevoGenero) {
        return genero;
    }

    public void setgenero(String genero) {
        this.genero = genero;
    }

    public boolean isdisponible() {
        return disponible;
    }

    public void setdisponible(boolean disponible) {
        this.disponible = disponible;
    }
    @Override
    public String toString() {
        return "Libro [Titulo=" + titulo + ", autor=" + autor + ", ISBN=" + ISBN + ", genero=" + genero + ", disponible=" + disponible + "]";
    }

}
