package com.example.FilmLit.Entidades;
import java.util.Date;
import jakarta.persistence.*;

@Entity
public class MensajeDirecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mensaje")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_remitente")
    private Usuario remitente;

    @ManyToOne
    @JoinColumn(name = "id_receptor")
    private Usuario receptor;

    @Column(name = "contenido")
    private String contenido;

    @Column(name = "fecha")
    private Date fecha;

    public MensajeDirecto() {
    }

    public MensajeDirecto(int id, Usuario remitente, Usuario receptor, String contenido, Date fecha) {
        this.id = id;
        this.remitente = remitente;
        this.receptor = receptor;
        this.contenido = contenido;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getRemitente() {
        return remitente;
    }

    public void setRemitente(Usuario remitente) {
        this.remitente = remitente;
    }

    public Usuario getReceptor() {
        return receptor;
    }

    public void setReceptor(Usuario receptor) {
        this.receptor = receptor;
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

    @Override
    public String toString() {
        return "MensajeDirecto{" +
                "id=" + id +
                ", remitente=" + remitente +
                ", receptor=" + receptor +
                ", contenido='" + contenido + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}
