//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.AlfaCar.AlfaCar.service.impl;

import com.AlfaCar.AlfaCar.model.entidades.TelefoneUsuario;
import com.AlfaCar.AlfaCar.model.entidades.Usuario;
import com.AlfaCar.AlfaCar.repository.TelefoneUsuarioRepository;
import com.AlfaCar.AlfaCar.repository.UserRepository;
import com.AlfaCar.AlfaCar.service.interfaces.TelefoneUsuarioService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelefoneUsuarioServiceImpl implements TelefoneUsuarioService {
    private final TelefoneUsuarioRepository telefoneUsuarioRepository;
    private final UserRepository usuarioRepository;

    @Autowired
    public TelefoneUsuarioServiceImpl(TelefoneUsuarioRepository telefoneUsuarioRepository, UserRepository usuarioRepository) {
        this.telefoneUsuarioRepository = telefoneUsuarioRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public TelefoneUsuario cadastrarTelefone(TelefoneUsuario telefoneUsuario) {
        if (telefoneUsuario.getUsuario() != null && telefoneUsuario.getUsuario().getId() != null) {
            Usuario usuario = (Usuario)this.usuarioRepository.findById(telefoneUsuario.getUsuario().getId()).orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + telefoneUsuario.getUsuario().getId()));
            telefoneUsuario.setUsuario(usuario);
            return (TelefoneUsuario)this.telefoneUsuarioRepository.save(telefoneUsuario);
        } else {
            throw new IllegalArgumentException("Usuário não pode ser nulo ao cadastrar um telefone.");
        }
    }

    public List<TelefoneUsuario> listarTelefones() {
        return this.telefoneUsuarioRepository.findAll();
    }

    public Optional<TelefoneUsuario> buscarTelefonePorId(Long id) {
        return this.telefoneUsuarioRepository.findById(id);
    }

    public Optional<TelefoneUsuario> buscarTelefonesPorUsuarioId(Long usuarioId) {
        return this.telefoneUsuarioRepository.findByUsuarioId(usuarioId);
    }

    public void deletarTelefone(Long id) {
        this.telefoneUsuarioRepository.deleteById(id);
    }
}
