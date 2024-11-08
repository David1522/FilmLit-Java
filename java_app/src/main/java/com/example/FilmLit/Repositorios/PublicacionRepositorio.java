package com.example.FilmLit.Repositorios;

import com.example.FilmLit.Entidades.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicacionRepositorio extends JpaRepository<Publicacion, Integer> {
}
