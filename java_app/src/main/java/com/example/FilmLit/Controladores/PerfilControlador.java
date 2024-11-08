package com.example.FilmLit.Controladores;

import com.example.FilmLit.Entidades.Perfil;
import com.example.FilmLit.Servicios.PerfilServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/perfil")
public class PerfilControlador {

    @Autowired
    private PerfilServicio perfilServicio;

    @GetMapping("/{id}")
    public ResponseEntity<Perfil> obtenerPerfil(@PathVariable int id) {
        Optional<Perfil> perfil = perfilServicio.obtenerPerfil(id);
        return perfil.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Perfil> actualizarPerfil(@PathVariable int id, @RequestBody Perfil perfil) {
        try {
            Perfil perfilActualizado = perfilServicio.actualizarPerfil(id, perfil);
            return ResponseEntity.ok(perfilActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPerfil(@PathVariable int id) {
        perfilServicio.eliminarPerfil(id);
        return ResponseEntity.noContent().build();
    }
}
