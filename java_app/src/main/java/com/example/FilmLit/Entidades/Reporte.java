package com.example.FilmLit.Entidades;
import java.util.Date;
import jakarta.persistence.*;

@Entity
public class Reporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reporte")
    private int idReporte;

    @ManyToOne
    @JoinColumn(name = "id_comentario", nullable = true)
    private Comentario comentario;

    @ManyToOne
    @JoinColumn(name = "id_publicacion", nullable = true)
    private Publicacion publicacion;

    @ManyToOne
    @JoinColumn(name = "id_mensaje", nullable = true)
    private MensajeDirecto mensajeDirecto;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "fecha")
    private Date fecha;

    public Reporte() {
    }

    public Reporte(int idReporte, Comentario comentario, Publicacion publicacion, MensajeDirecto mensajeDirecto, String descripcion, Date fecha) {
        this.idReporte = idReporte;
        this.comentario = comentario;
        this.publicacion = publicacion;
        this.mensajeDirecto = mensajeDirecto;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    public MensajeDirecto getMensajeDirecto() {
        return mensajeDirecto;
    }

    public void setMensajeDirecto(MensajeDirecto mensajeDirecto) {
        this.mensajeDirecto = mensajeDirecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Reporte{" +
                "idReporte=" + idReporte +
                ", comentario=" + comentario +
                ", publicacion=" + publicacion +
                ", mensajeDirecto=" + mensajeDirecto +
                ", descripcion='" + descripcion + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}
