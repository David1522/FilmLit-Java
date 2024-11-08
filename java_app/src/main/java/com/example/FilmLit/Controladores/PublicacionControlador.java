package com.example.FilmLit.Controladores;

import com.example.FilmLit.Entidades.Publicacion;
import com.example.FilmLit.Servicios.PublicacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publicaciones")
public class PublicacionControlador {

    @Autowired
    private PublicacionServicio publicacionServicio;

    @GetMapping
    public List<Publicacion> obtenerTodas() {
        return publicacionServicio.obtenerTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publicacion> obtenerPorId(@PathVariable int id) {
        return publicacionServicio.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Publicacion crearPublicacion(@RequestBody Publicacion publicacion) {
        return publicacionServicio.crearPublicacion(publicacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Publicacion> actualizarPublicacion(@PathVariable int id, @RequestBody Publicacion publicacion) {
        try {
            Publicacion actualizada = publicacionServicio.actualizarPublicacion(id, publicacion);
            return ResponseEntity.ok(actualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPublicacion(@PathVariable int id) {
        publicacionServicio.eliminarPublicacion(id);
        return ResponseEntity.noContent().build();
    }
}
