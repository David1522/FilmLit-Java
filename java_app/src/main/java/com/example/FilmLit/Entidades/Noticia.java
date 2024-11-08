package com.example.FilmLit.Entidades;
import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Noticia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_noticia")
    private int id;

    @Column(name = "titular")
    private String titular;

    @Column(name = "fuente")
    private String fuente;

    @Column(name = "tema")
    private String tema;

    @Column(name = "contenido")
    private String contenido;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "portada")
    private String portada;

    public Noticia() {
    }

    public Noticia(int id, String titular, String fuente, String tema, String contenido, Date fecha, String portada) {
        this.id = id;
        this.titular = titular;
        this.fuente = fuente;
        this.tema = tema;
        this.contenido = contenido;
        this.fecha = fecha;
        this.portada = portada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    @Override
    public String toString() {
        return "Noticia{" +
                "id=" + id +
                ", titular='" + titular + '\'' +
                ", fuente='" + fuente + '\'' +
                ", tema='" + tema + '\'' +
                ", contenido='" + contenido + '\'' +
                ", fecha=" + fecha +
                ", portada='" + portada + '\'' +
                '}';
    }
}
