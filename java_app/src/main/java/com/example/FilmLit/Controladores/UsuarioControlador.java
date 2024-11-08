package com.example.FilmLit.Controladores;

import com.example.FilmLit.Entidades.Usuario;
import com.example.FilmLit.Servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {

        @Autowired
        private UsuarioServicio usuarioServicio;

        @PostMapping
        public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario){
            Usuario saveUsuario = usuarioServicio.agregar(usuario);
            return new ResponseEntity<>(saveUsuario, HttpStatus.CREATED);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Usuario> obtenerUsuario(@PathVariable int id){
            Usuario usuario = usuarioServicio.obtenerPorId(id);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Usuario> actualizarUsuario(@PathVariable int id, @RequestBody Usuario usuario){
            Usuario actualizado = usuarioServicio.actualizar(id, usuario);
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> eliminarUsuario(@PathVariable int id){
            usuarioServicio.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
}


