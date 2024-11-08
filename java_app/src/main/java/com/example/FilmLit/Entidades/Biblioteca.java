package com.example.FilmLit.Entidades;

import jakarta.persistence.*;

@Entity
public class Biblioteca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_biblioteca")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(name = "numero_obras")
    private int numeroObras;

    @Column(name = "obras")
    private String obras;

    @Column(name = "nombre")
    private String nombre;

    public Biblioteca() {
    }

    public Biblioteca(int id, Usuario usuario, int numeroObras, String obras, String nombre) {
        this.id = id;
        this.usuario = usuario;
        this.numeroObras = numeroObras;
        this.obras = obras;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getNumeroObras() {
        return numeroObras;
    }

    public void setNumeroObras(int numeroObras) {
        this.numeroObras = numeroObras;
    }

    public String getObras() {
        return obras;
    }

    public void setObras(String obras) {
        this.obras = obras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", numeroObras=" + numeroObras +
                ", obras='" + obras + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
