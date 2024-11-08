package com.example.FilmLit.Entidades;

import jakarta.persistence.*;

@Entity
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perfil")
    private int idPerfil;  // Este es el ID único para la tabla Perfil, diferente del id_usuario en Usuario

    @Column(name = "foto_perfil")
    private String fotoPerfil;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "seguidores")
    private int seguidores;

    @Column(name = "siguiendo")
    private int siguiendo;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Perfil() {
    }

    public Perfil(String fotoPerfil, String descripcion, int siguiendo, int seguidores, Usuario usuario) {
        this.fotoPerfil = fotoPerfil;
        this.descripcion = descripcion;
        this.siguiendo = siguiendo;
        this.seguidores = seguidores;
        this.usuario = usuario;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public int getSiguiendo() {
        return siguiendo;
    }

    public void setSiguiendo(int siguiendo) {
        this.siguiendo = siguiendo;
    }

    public int getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(int seguidores) {
        this.seguidores = seguidores;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Perfil{" +
                "idPerfil=" + idPerfil +
                ", fotoPerfil='" + fotoPerfil + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", seguidores=" + seguidores +
                ", siguiendo=" + siguiendo +
                ", usuario=" + usuario +
                '}';
    }
}
