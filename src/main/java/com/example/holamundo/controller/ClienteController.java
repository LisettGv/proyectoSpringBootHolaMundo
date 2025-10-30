package com.example.holamundo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.holamundo.model.Cliente;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Creamos dos nuevos controladores con sus respectivas rutas
@RestController
@RequestMapping("/api/clientes")

public class ClienteController {

    @GetMapping
    public List<Cliente> listarTodosLosClientes() {
        return listaClientes;
    }

    private List<Cliente> listaClientes = new ArrayList<>(Arrays.asList(
            new Cliente(1, "Ana González", "ana@gmail.com"),
            new Cliente(2, "Luis Martínez", "luis@gmail.com"),
            new Cliente(3, "Carla Fernández", "carla@gmail.com")
    ));

    @GetMapping("/saludo")
    public String saludoCliente() {
        return "Hola desde el controlador de clientes";
    }

    @GetMapping("/listar")
    public String listarClientes() {
        return "Aquí se listarán los clientes (ejemplo)";
    }

    //paso 2
    @GetMapping("/listar2")
    public List<Cliente> listarClientes2() {
        return listaClientes;
    }

    // Buscar cliente por ID
    @GetMapping("/{idCliente}")
    public ResponseEntity<?> buscarCliente(@PathVariable int idCliente) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getId() == idCliente) {
                return ResponseEntity.ok(cliente); // Cliente encontrado
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Cliente con ID " + idCliente + " no encontrado."); // Cliente no encontrado
    }

    // Agregar un cliente (POST)
    @PostMapping
    public ResponseEntity<?> agregarCliente(@RequestBody Cliente nuevoCliente) {
        listaClientes.add(nuevoCliente); // Se agrega el nuevo cliente a la lista
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Cliente agregado correctamente: " + nuevoCliente.getNombre());
    }
}
