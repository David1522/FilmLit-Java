package com.example.FilmLit.Servicios;

import com.example.FilmLit.Entidades.Usuario;
import com.example.FilmLit.Entidades.Perfil;
import com.example.FilmLit.Repositorios.UsuarioRepositorio;
import com.example.FilmLit.Repositorios.PerfilRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private PerfilRepositorio perfilRepositorio;

    /**
     * Registra un nuevo usuario y crea automáticamente un perfil vacío vinculado a él.
     * @param usuario - datos del nuevo usuario
     * @return Usuario registrado
     */
    public Usuario agregar(Usuario usuario) {
        // Validación de pago para tipos de usuario premium y author
        if (!usuario.getTipoUsuario().equals("base") && !Boolean.TRUE.equals(usuario.getEsPagado())) {
            throw new IllegalArgumentException("Los usuarios premium y author deben pagar.");
        }

        // Guardar el usuario en la base de datos
        Usuario nuevoUsuario = usuarioRepositorio.save(usuario);

        // Crear un perfil vacío asociado al usuario recién registrado
        Perfil perfil = new Perfil();
        perfil.setUsuario(nuevoUsuario);
        perfil.setFotoPerfil("");  // Inicializa con valores predeterminados o vacíos
        perfil.setDescripcion("");
        perfil.setSiguiendo(0);
        perfil.setSeguidores(0);
        perfilRepositorio.save(perfil);

        return nuevoUsuario;
    }

    /**
     * Obtiene un usuario por su ID.
     * @param id - ID del usuario
     * @return Usuario encontrado
     */
    public Usuario obtenerPorId(int id) {
        return usuarioRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    /**
     * Actualiza la información de un usuario existente.
     * @param id - ID del usuario
     * @param usuarioActualizado - datos actualizados
     * @return Usuario actualizado
     */
    public Usuario actualizar(int id, Usuario usuarioActualizado) {
        Usuario usuarioExistente = obtenerPorId(id);

        // Validación de pago para tipos de usuario premium y author
        if (!usuarioActualizado.getTipoUsuario().equals("base") && !Boolean.TRUE.equals(usuarioActualizado.getEsPagado())) {
            throw new IllegalArgumentException("Los usuarios premium y author deben pagar.");
        }

        // Actualizar los campos permitidos
        usuarioExistente.setNombreUsuario(usuarioActualizado.getNombreUsuario());
        usuarioExistente.setTipoUsuario(usuarioActualizado.getTipoUsuario());
        usuarioExistente.setEsPagado(usuarioActualizado.getEsPagado());

        return usuarioRepositorio.save(usuarioExistente);
    }

    /**
     * Elimina un usuario por su ID.
     * @param id - ID del usuario a eliminar
     */
    public void eliminar(int id) {
        usuarioRepositorio.deleteById(id);
    }
}

