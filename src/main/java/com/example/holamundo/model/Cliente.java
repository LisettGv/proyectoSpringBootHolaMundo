package com.example.holamundo.model;


public class Cliente {
    //Atributos, privados encapsulados
    private int id;
    private String nombre;
    private String correo;

    // Constructor vacío (necesario para deserialización JSON)
    public Cliente() {
    }

    // Constructor con parámetros
    public Cliente(int id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }


    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    // Setters (necesarios para que Spring pueda mapear JSON)
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}