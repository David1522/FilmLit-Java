package com.example.FilmLit.Servicios;

import com.example.FilmLit.Entidades.Publicacion;
import com.example.FilmLit.Repositorios.PublicacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicacionServicio {

    @Autowired
    private PublicacionRepositorio publicacionRepositorio;

    public List<Publicacion> obtenerTodas() {
        return publicacionRepositorio.findAll();
    }

    public Optional<Publicacion> obtenerPorId(int id) {
        return publicacionRepositorio.findById(id);
    }

    public Publicacion crearPublicacion(Publicacion publicacion) {
        return publicacionRepositorio.save(publicacion);
    }

    public Publicacion actualizarPublicacion(int id, Publicacion publicacionActualizada) {
        return publicacionRepositorio.findById(id).map(publicacion -> {
            publicacion.setMultimedia(publicacionActualizada.getMultimedia());
            publicacion.setDescripcion(publicacionActualizada.getDescripcion());
            publicacion.setFecha(publicacionActualizada.getFecha());
            publicacion.setLikes(publicacionActualizada.getLikes());
            return publicacionRepositorio.save(publicacion);
        }).orElseThrow(() -> new RuntimeException("Publicación no encontrada"));
    }

    public void eliminarPublicacion(int id) {
        publicacionRepositorio.deleteById(id);
    }
}
