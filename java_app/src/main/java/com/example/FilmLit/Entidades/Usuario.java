package com.example.FilmLit.Entidades;
import java.util.Date;
import jakarta.persistence.*;

@Entity

public class Usuario {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_usuario")
        private int id;

        @Column(name = "nombre_usuario")
        private String nombreUsuario;

        @Column(name = "email")
        private String email;

        @Column(name = "contraseña")
        private String contraseña;

        @Column(name = "estado")
        private String estado;

        @Column(name = "tipo_usuario")
        private String tipoUsuario;

        @Column(name = "fecha_nacimiento")
        private Date fechaNacimiento;

        // Nuevo campo para indicar si el usuario ha realizado el pago (aplicable a premium y author)
        @Column(name = "es_pagado")
        private Boolean esPagado;

        // Constructor, getters y setters

        public Usuario() {}

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNombreUsuario() {
            return nombreUsuario;
        }

        public void setNombreUsuario(String nombreUsuario) {
            this.nombreUsuario = nombreUsuario;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getContraseña() {
            return contraseña;
        }

        public void setContraseña(String contraseña) {
            this.contraseña = contraseña;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public String getTipoUsuario() {
            return tipoUsuario;
        }

        public void setTipoUsuario(String tipoUsuario) {
            this.tipoUsuario = tipoUsuario;
        }

        public Date getFechaNacimiento() {
            return fechaNacimiento;
        }

        public void setFechaNacimiento(Date fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
        }

        public Boolean getEsPagado() {
            return esPagado;
        }

        public void setEsPagado(Boolean esPagado) {
            this.esPagado = esPagado;
        }
}
