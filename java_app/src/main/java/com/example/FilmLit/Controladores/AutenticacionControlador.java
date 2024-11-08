package com.example.FilmLit.Controladores;

import com.example.FilmLit.Entidades.Usuario;
import com.example.FilmLit.Servicios.ServicioAutenticacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AutenticacionControlador {

    @Autowired
    private ServicioAutenticacion autenticacionServicio;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String contraseña) {
        Optional<Usuario> usuario = autenticacionServicio.autenticarUsuario(email, contraseña);
        if (usuario.isPresent()) {
            return ResponseEntity.ok("Inicio de sesión exitoso. Bienvenido " + usuario.get().getNombreUsuario());
        } else {
            return ResponseEntity.status(401).body("Credenciales incorrectas");
        }
    }
}
