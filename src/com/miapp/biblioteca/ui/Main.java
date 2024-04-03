package com.miapp.biblioteca.ui;

import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.Usuario;

import com.miapp.biblioteca.service.UsuarioServicio;
import com.miapp.biblioteca.service.LibroServicio;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Libro> biblioteca = new ArrayList<>();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        LibroServicio libroServicio = new LibroServicio(biblioteca);
        UsuarioServicio usuarioServicio = new UsuarioServicio(usuarios);
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("=== Biblioteca Virtual ===");
            System.out.println("1. Crear libro");
            System.out.println("2. Actualizar libro");
            System.out.println("3. Buscar libro por ISBN");
            System.out.println("4. Buscar libro por Título");
            System.out.println("5. Listar libros");
            System.out.println("6. Eliminar libros");
            System.out.println("7. Préstamos");
            System.out.println("8. Devoluciones");
            System.out.println("9. Salir");
            System.out.println("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();


            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el título: ");
                    String titulo = scanner.nextLine();
                    System.out.println("Ingrese el autor: ");
                    String autor = scanner.nextLine();
                    System.out.println("Ingrese el ISBN: ");
                    String ISBN = scanner.nextLine();
                    System.out.println("Ingrese el genero: ");
                    String genero = scanner.nextLine();
                    libroServicio.crearLibro(titulo, autor, ISBN, genero);
                    break;
                case 2:
                    System.out.println("Ingrese el ISBN del libro a actualizar: ");
                    String isbnActualizar = scanner.nextLine();
                    System.out.println("Ingrese el nuevo titulo: ");
                    String nuevoTitulo = scanner.nextLine();
                    System.out.println("Ingrese el nuevo autor: ");
                    String nuevoAutor = scanner.nextLine();
                    System.out.println("Ingrese el nuevo genero: ");
                    String nuevoGenero = scanner.nextLine();
                    libroServicio.actualizarLibro (isbnActualizar, nuevoTitulo, nuevoAutor, nuevoGenero);
                    break;
                case 3:
                    System.out.println("Ingrese el ISBN del libro a buscar: ");
                    String isbnBuscar = scanner.nextLine();
                    Libro libroISBN = libroServicio.buscarLibroPorISBN(isbnBuscar);
                    if (libroISBN != null) {
                        System.out.println("Libro encontrado: " + libroISBN.gettitulo());
                    } else {
                        System.out.println("Libro no encontrado");
                    }
                    break;
                case 4:
                    System.out.println("Ingrese el título a buscar: ");
                    String tituloBuscar = scanner.nextLine();
                    ArrayList<Libro> librosPorTitulo = libroServicio.buscarLibrosPorTitulo(tituloBuscar);
                    if (librosPorTitulo.isEmpty()) {
                        System.out.println("Libros encontrados: ");
                        for (Libro libro : librosPorTitulo) {
                            System.out.println(libro.gettitulo());
                        }
                    } else {
                        System.out.println("Ningún libro encontrado con ese título");
                    }
                    break;
                case 5:
                    ArrayList<Libro> listaLibros = libroServicio.obtenerTodosLosLibros();
                    for (Libro libro : listaLibros) {
                        System.out.println(libro.gettitulo() + " (" + libro.getISBN() + " )");
                    }
                    break;
                case 6:
                    System.out.println("Ingrese el ISBN del Libro a eliminar");
                    String isbnEliminar = scanner.nextLine();
                    libroServicio.eliminarLibro(isbnEliminar);
                    break;

                case 7:
                    System.out.println("Ingrese el número de identificación del usuario: ");
                    String idUsuario;
                            idUsuario = scanner.nextLine();
                    Usuario usuarioPrestamo = usuarioServicio.buscarUsuarioPorId(idUsuario);
                    if (usuarioPrestamo != null) {
                        System.out.println("Ingrese el ISBN del libro a prestar: ");
                        String isbnPrestamo = scanner.nextLine();
                        Libro libroPrestamo = libroServicio.buscarLibroPorISBN(isbnPrestamo);
                        if (libroPrestamo != null) {
                            if (libroServicio.verificarDisponibilidad(libroPrestamo)) {
                                usuarioServicio.prestarLibro(usuarioPrestamo, libroPrestamo);
                                System.out.println("Prestamo exitoso. Libro prestado a " + usuarioPrestamo.getNombre());

                            } else {
                                System.out.println("El libro no esta disponible para préstamo");
                            }
                        } else {
                            System.out.println("Libro no encontrado");
                        }
                    } else {
                        System.out.println("Usuario no encontrado");
                    }
                    break;
                case 8:
                    System.out.println("Ingrese el número de identificacion del usuario");
                    String idUsuario1 = scanner.nextLine();
                    Usuario usuarioDevolucion = usuarioServicio.buscarUsuarioPorId(idUsuario1);
                    if (usuarioDevolucion != null) {
                        System.out.println("Ingrese el ISBN del libro a devolver: ");
                        String isbnDevolucion = scanner.nextLine();
                        Libro libroDevolucion = libroServicio.buscarLibroPorISBN(isbnDevolucion);
                        if (libroDevolucion != null) {
                            usuarioServicio.devolverLibro(usuarioDevolucion, libroDevolucion);
                            System.out.println("Devolucion exitosa. Libro devuelto por " + usuarioDevolucion.getNombre());
                        } else {
                            System.out.println("Libro no encontrado");
                        }
                    } else {
                        System.out.println("Usuario no encontrado");
                    }
                    break;
                case 9:
                    System.out.println("Gracias por ver la biblioteca virtual.¡Hasta Luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo");
            }

        }
        while (opcion != 9);
    }
}