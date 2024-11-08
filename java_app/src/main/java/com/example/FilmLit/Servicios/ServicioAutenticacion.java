package com.example.FilmLit.Servicios;
import com.example.FilmLit.Entidades.Usuario;
import com.example.FilmLit.Repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ServicioAutenticacion {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public Optional<Usuario> autenticarUsuario(String email, String contraseña) {
        Optional<Usuario> usuario = usuarioRepositorio.findByEmail(email);
        if (usuario.isPresent() && usuario.get().getContraseña().equals(contraseña)) {
            return usuario;
        }
        return Optional.empty();
    }
}
