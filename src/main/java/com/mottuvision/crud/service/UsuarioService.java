package com.mottuvision.crud.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mottuvision.crud.model.Usuario;
import com.mottuvision.crud.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    
    public Optional<Usuario> autenticarUsuario(String usuario, String senha) {
        
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findByUsuario(usuario);
        if (usuarioEncontrado.isPresent() && usuarioEncontrado.get().getSenha().equals(senha)) {
            return usuarioEncontrado;
        }

        return Optional.empty();
    }
}
