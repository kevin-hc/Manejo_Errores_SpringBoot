package com.spring.error.controllers;


import com.spring.error.errors.UsuarioNoEncontrado;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice//se ejecuta antes de cualquier controlador-> se puede usar para manejar errores
class ErrorHandlerController {

    @ExceptionHandler(ArithmeticException.class)//se ejecuta cuando se genera un error de aritmetica
    public String aritmeticError(ArithmeticException ex, Model model) {
        model.addAttribute("error", "Error de aritmetica");
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("status", "500");
        model.addAttribute("timestamp",  new Date());
        return "error/generica";
    }

    @ExceptionHandler(NumberFormatException.class)//se ejecuta cuando se genera un error de formato de numero
    public String numberFormatError(NumberFormatException ex, Model model) {
        model.addAttribute("error", "Error de formato de numero");
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("status", "500");
        model.addAttribute("timestamp",  new Date());
        return "error/number-formato";
    }
    @ExceptionHandler(UsuarioNoEncontrado.class)//se ejecuta cuando se genera un error de formato de numero
    public String UsuarioNoEncontrado(UsuarioNoEncontrado ex, Model model) {
        model.addAttribute("error", "Error usuario no encontrado");
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("status", "500");
        model.addAttribute("timestamp", new Date());
        return "error/generica";
    }
}

