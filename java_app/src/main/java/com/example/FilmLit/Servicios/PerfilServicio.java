package com.example.FilmLit.Servicios;

import com.example.FilmLit.Entidades.Perfil;
import com.example.FilmLit.Repositorios.PerfilRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PerfilServicio {

    @Autowired
    private PerfilRepositorio perfilRepositorio;

    public Optional<Perfil> obtenerPerfil(int idPerfil) {
        return perfilRepositorio.findById(idPerfil);
    }

    public Perfil actualizarPerfil(int idPerfil, Perfil perfilActualizado) {
        return perfilRepositorio.findById(idPerfil).map(perfil -> {
            perfil.setFotoPerfil(perfilActualizado.getFotoPerfil());
            perfil.setDescripcion(perfilActualizado.getDescripcion());
            perfil.setSiguiendo(perfilActualizado.getSiguiendo());
            perfil.setSeguidores(perfilActualizado.getSeguidores());
            return perfilRepositorio.save(perfil);
        }).orElseThrow(() -> new RuntimeException("Perfil no encontrado"));
    }

    public void eliminarPerfil(int idPerfil) {
        perfilRepositorio.deleteById(idPerfil);
    }
}
