package com.AlfaCar.AlfaCar.service.impl;

import com.AlfaCar.AlfaCar.model.entidades.ChamadoSuporte;
import com.AlfaCar.AlfaCar.model.entidades.Usuario;
import com.AlfaCar.AlfaCar.model.enums.StatusSuporte;
import com.AlfaCar.AlfaCar.repository.ChamadoSuporteRepository;
import com.AlfaCar.AlfaCar.repository.UserRepository;
import com.AlfaCar.AlfaCar.service.interfaces.ChamadoSuporteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChamadoSuporteServiceImpl implements ChamadoSuporteService {

    private final ChamadoSuporteRepository chamadoSuporteRepository;
    private final UserRepository userRepository;

    public ChamadoSuporteServiceImpl(ChamadoSuporteRepository chamadoSuporteRepository, UserRepository userRepository) {
        this.chamadoSuporteRepository = chamadoSuporteRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ChamadoSuporte criarChamado(ChamadoSuporte chamadoSuporte, Long usuarioId) {
        Usuario usuario = userRepository.findById(usuarioId)
                .orElseThrow(() -> new IllegalArgumentException("Usuário com ID " + usuarioId + " não encontrado."));

        chamadoSuporte.setUsuario(usuario);
        chamadoSuporte.setStatusSuporte(StatusSuporte.ABERTO); // Status inicial padrão

        return chamadoSuporteRepository.save(chamadoSuporte);
    }

    @Override
    public List<ChamadoSuporte> buscarChamados() {
        return chamadoSuporteRepository.findAll();
    }

    @Override
    public Optional<ChamadoSuporte> buscarChamadoPorId(Long id) {
        return chamadoSuporteRepository.findById(id);
    }

    @Override
    public List<ChamadoSuporte> buscarChamadosPorUsuario(Long usuarioId) {
        return chamadoSuporteRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public List<ChamadoSuporte> buscarChamadosPorStatus(StatusSuporte statusSuporte) {
        return chamadoSuporteRepository.findByStatusSuporte(statusSuporte.name());
    }

    @Override
    public ChamadoSuporte atualizarChamado(Long id, ChamadoSuporte chamadoAtualizado) {
        return chamadoSuporteRepository.findById(id).map(chamado -> {
            chamado.setDescricaoSuporte(chamadoAtualizado.getDescricaoSuporte());
            chamado.setStatusSuporte(chamadoAtualizado.getStatusSuporte());
            return chamadoSuporteRepository.save(chamado);
        }).orElseThrow(() -> new IllegalArgumentException("Chamado com ID " + id + " não encontrado."));
    }

    @Override
    public void deletarChamado(Long id) {
        if (!chamadoSuporteRepository.existsById(id)) {
            throw new IllegalArgumentException("Chamado com ID " + id + " não encontrado.");
        }
        chamadoSuporteRepository.deleteById(id);
    }
}
