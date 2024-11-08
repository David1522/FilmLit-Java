package com.example.FilmLit.Repositorios;

import com.example.FilmLit.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmail(String email);
}

