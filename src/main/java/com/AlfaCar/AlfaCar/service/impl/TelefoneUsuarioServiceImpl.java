package com.AlfaCar.AlfaCar.service.impl;

import com.AlfaCar.AlfaCar.model.entidades.TelefoneUsuario;
import com.AlfaCar.AlfaCar.model.entidades.Usuario;
import com.AlfaCar.AlfaCar.repository.TelefoneUsuarioRepository;
import com.AlfaCar.AlfaCar.repository.UserRepository;
import com.AlfaCar.AlfaCar.service.interfaces.TelefoneUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelefoneUsuarioServiceImpl implements TelefoneUsuarioService {

    private final TelefoneUsuarioRepository telefoneUsuarioRepository;
    private final UserRepository usuarioRepository;

    @Autowired
    public TelefoneUsuarioServiceImpl(TelefoneUsuarioRepository telefoneUsuarioRepository, UserRepository usuarioRepository) {
        this.telefoneUsuarioRepository = telefoneUsuarioRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public TelefoneUsuario cadastrarTelefone(TelefoneUsuario telefoneUsuario) {
        if (telefoneUsuario.getUsuario() == null || telefoneUsuario.getUsuario().getId() == null) {
            throw new IllegalArgumentException("Usuário não pode ser nulo ao cadastrar um telefone.");
        }
        Usuario usuario = usuarioRepository.findById(telefoneUsuario.getUsuario().getId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + telefoneUsuario.getUsuario().getId()));

        telefoneUsuario.setUsuario(usuario);

        return telefoneUsuarioRepository.save(telefoneUsuario);
    }

    @Override
    public List<TelefoneUsuario> listarTelefones() {
        return telefoneUsuarioRepository.findAll();
    }

    @Override
    public Optional<TelefoneUsuario> buscarTelefonePorId(Long id) {
        return telefoneUsuarioRepository.findById(id);
    }

    @Override
    public Optional<TelefoneUsuario> buscarTelefonesPorUsuarioId(Long usuarioId) {
        return telefoneUsuarioRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public void deletarTelefone(Long id) {
        telefoneUsuarioRepository.deleteById(id);
    }
}
