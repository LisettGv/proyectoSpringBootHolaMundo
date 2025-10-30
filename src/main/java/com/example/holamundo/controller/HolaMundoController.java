//Definiendo un controlador REST de Spring
//Una clase que atiende solicitudes HTTP
package com.example.holamundo.controller;


//Importamos notaciones de Spring para usar en esta clase
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Indica a Spring que esta clase es un controller WEB
//Que maneja peticiones HTTP
@RestController
//Define un "prefijo" de ruta para todos los ENDPOINT
//Es decir ahora todos nuestros ENDPOINT pasara por aqui
@RequestMapping ("/api")

public class HolaMundoController{
    //Registra un ENDPOINT HTTP de tipo GET en la ruta /hola
    // Cuando un servidor reciba la peticion GET http://localhost:8080/hola
    // Ejecutara el metodo y lo que retorne sera enviado al cliente
    @GetMapping ("/Hola")
    //Metodo
    public String hola(){
        //Retronamos una cadena simple de texto
        return "Hola Mundo";
    }

    //Crear otro ENDPOINT para nuestra clase, mostrar nuestro nombre
    @GetMapping ("/minombre")
    //Metodo
    public String nombre(){
        return "Hola soy LisettGv";
    }

    //Creamos otro ENDPOINT para sumar dos numeros
    //La forma de ingresar los numeros sera GET /api/suma/{valor_uno}/{valor_dos}
    //Para esto necesitaremos el @PathVariable que indica los valores numericos ingresados
    @GetMapping ("/suma/{valor_uno}/{valor_dos}")
    //Metodo
    public String sumarComoTexto(@PathVariable("valor_uno") int valorUno,
                                 @PathVariable("valor_dos") int valorDos) {
        int resultado = valorUno + valorDos;
        return "Resultado: " + resultado;
    }
}