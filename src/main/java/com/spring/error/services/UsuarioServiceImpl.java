package com.spring.error.services;

import com.spring.error.models.domain.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private List<Usuario> lista;

    public UsuarioServiceImpl() {
        this.lista= new ArrayList<>();
        this.lista.add(new Usuario(1, "Andres", "Guzman"));
        this.lista.add(new Usuario(2, "John", "Doe"));
        this.lista.add(new Usuario(3, "Linus", "Torvalds"));
        this.lista.add(new Usuario(4, "Rasmus", "Lerdorf"));
        this.lista.add(new Usuario(5, "Erich", "Gamma"));
        this.lista.add(new Usuario(6, "Richard", "Helm"));
        this.lista.add(new Usuario(7, "Ralph", "Johnson"));
        this.lista.add(new Usuario(8, "John", "Vlissides"));
    }

    @Override
    public List<Usuario> listar() {
        return this.lista;
    }

    @Override
    public Usuario obtenerPorId(Integer id) {
        for (Usuario usuario : this.lista) {
            if (usuario.getId().equals(id)) {
                return usuario;

            }
        }
        return null;
    }

    @Override
    public Optional<Usuario> obtenerPorIdOptional(Integer id) { //Optional es una clase que permite manejar valores nulos
        Usuario usuario = this.obtenerPorId(id);
        return Optional.ofNullable(usuario);//ofNullable permite manejar valores nulos
    }
}
