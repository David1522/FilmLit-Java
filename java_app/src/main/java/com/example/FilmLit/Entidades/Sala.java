package com.example.FilmLit.Entidades;
import java.util.Date;
import jakarta.persistence.*;

@Entity
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sala")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "privado")
    private boolean privado;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Column(name = "contraseña")
    private String contraseña;

    public Sala() {
    }

    public Sala(int id, Usuario usuario, String nombre, boolean privado, Date fechaCreacion, String contraseña) {
        this.id = id;
        this.usuario = usuario;
        this.nombre = nombre;
        this.privado = privado;
        this.fechaCreacion = fechaCreacion;
        this.contraseña = contraseña;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isPrivado() {
        return privado;
    }

    public void setPrivado(boolean privado) {
        this.privado = privado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", nombre='" + nombre + '\'' +
                ", privado=" + privado +
                ", fechaCreacion=" + fechaCreacion +
                ", contraseña='" + contraseña + '\'' +
                '}';
    }
}
