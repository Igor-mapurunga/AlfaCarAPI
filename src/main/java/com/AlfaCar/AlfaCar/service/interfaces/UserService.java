package com.AlfaCar.AlfaCar.service.interfaces;

import com.AlfaCar.AlfaCar.model.entidades.Usuario;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Usuario cadastrarUsuario(Usuario usuario);
    List<Usuario> listarUsuarios();
    Optional<Usuario> buscarUsuarioPorId(Long id);
    void deletarUsuario(Long id);
}