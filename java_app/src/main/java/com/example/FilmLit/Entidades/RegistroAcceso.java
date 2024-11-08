package com.example.FilmLit.Entidades;
import java.util.Date;
import jakarta.persistence.*;

@Entity
public class RegistroAcceso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro_acceso")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_sala")
    private Sala sala;

    @Column(name = "fecha")
    private Date fecha;

    public RegistroAcceso() {
    }

    public RegistroAcceso(int id, Usuario usuario, Sala sala, Date fecha) {
        this.id = id;
        this.usuario = usuario;
        this.sala = sala;
        this.fecha = fecha;
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

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "RegistroAcceso{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", sala=" + sala +
                ", fecha=" + fecha +
                '}';
    }
}
