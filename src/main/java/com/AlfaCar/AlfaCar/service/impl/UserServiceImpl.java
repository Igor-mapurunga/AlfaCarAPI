//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.AlfaCar.AlfaCar.service.impl;

import com.AlfaCar.AlfaCar.model.entidades.Usuario;
import com.AlfaCar.AlfaCar.repository.UserRepository;
import com.AlfaCar.AlfaCar.service.interfaces.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
        return (Usuario)this.userRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return this.userRepository.findAll();
    }

    public Optional<Usuario> buscarUsuarioPorId(Long id) {
        return this.userRepository.findById(id);
    }

    public void deletarUsuario(Long id) {
        this.userRepository.deleteById(id);
    }

    public Usuario obterUsuarioLogado() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return (Usuario)this.userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuário logado não encontrado"));
    }
}
