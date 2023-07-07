package com.spring.error.controllers;

import com.spring.error.errors.UsuarioNoEncontrado;
import com.spring.error.models.domain.Usuario;
import com.spring.error.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AppController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping({"/index", "/", ""})//mapea las rutas
    public String index() {
        // Integer valor = 100 / 0;//genera un error
        Integer valor = Integer.parseInt("10x");//genera un error
        return "index";//retorna la vista HTML
    }

    @GetMapping("/ver/{id}")
    public String ver(@PathVariable Integer id, Model model) {

        /*Usuario usuario = usuarioService.obtenerPorId(id);
        if (usuario == null) {
            throw new UsuarioNoEncontrado(id.toString());
        }*/

        Usuario usuario = usuarioService.obtenerPorIdOptional(id).orElseThrow(() -> new UsuarioNoEncontrado(id.toString()));//se ejecuta si no se encuentra el usuario
        model.addAttribute("usuario", usuario);

        model.addAttribute("titulo", "Detalle usuario: " + usuario.getNombre());
        return "ver";
    }

}
