//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.AlfaCar.AlfaCar.service.impl;

import com.AlfaCar.AlfaCar.model.entidades.ChamadoSuporte;
import com.AlfaCar.AlfaCar.model.entidades.Usuario;
import com.AlfaCar.AlfaCar.model.enums.StatusSuporte;
import com.AlfaCar.AlfaCar.repository.ChamadoSuporteRepository;
import com.AlfaCar.AlfaCar.repository.UserRepository;
import com.AlfaCar.AlfaCar.service.interfaces.ChamadoSuporteService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ChamadoSuporteServiceImpl implements ChamadoSuporteService {
    private final ChamadoSuporteRepository chamadoSuporteRepository;
    private final UserRepository userRepository;

    public ChamadoSuporteServiceImpl(ChamadoSuporteRepository chamadoSuporteRepository, UserRepository userRepository) {
        this.chamadoSuporteRepository = chamadoSuporteRepository;
        this.userRepository = userRepository;
    }

    public ChamadoSuporte criarChamado(ChamadoSuporte chamadoSuporte, Long usuarioId) {
        Usuario usuario = (Usuario)this.userRepository.findById(usuarioId).orElseThrow(() -> new IllegalArgumentException("Usuário com ID " + usuarioId + " não encontrado."));
        chamadoSuporte.setUsuario(usuario);
        chamadoSuporte.setStatusSuporte(StatusSuporte.ABERTO);
        return (ChamadoSuporte)this.chamadoSuporteRepository.save(chamadoSuporte);
    }

    public List<ChamadoSuporte> buscarChamados() {
        return this.chamadoSuporteRepository.findAll();
    }

    public Optional<ChamadoSuporte> buscarChamadoPorId(Long id) {
        return this.chamadoSuporteRepository.findById(id);
    }

    public List<ChamadoSuporte> buscarChamadosPorUsuario(Long usuarioId) {
        return this.chamadoSuporteRepository.findByUsuarioId(usuarioId);
    }

    public List<ChamadoSuporte> buscarChamadosPorStatus(StatusSuporte statusSuporte) {
        return this.chamadoSuporteRepository.findByStatusSuporte(statusSuporte.name());
    }

    public ChamadoSuporte atualizarChamado(Long id, ChamadoSuporte chamadoAtualizado) {
        return (ChamadoSuporte)this.chamadoSuporteRepository.findById(id).map((chamado) -> {
            chamado.setDescricaoSuporte(chamadoAtualizado.getDescricaoSuporte());
            chamado.setStatusSuporte(chamadoAtualizado.getStatusSuporte());
            return (ChamadoSuporte)this.chamadoSuporteRepository.save(chamado);
        }).orElseThrow(() -> new IllegalArgumentException("Chamado com ID " + id + " não encontrado."));
    }

    public void deletarChamado(Long id) {
        if (!this.chamadoSuporteRepository.existsById(id)) {
            throw new IllegalArgumentException("Chamado com ID " + id + " não encontrado.");
        } else {
            this.chamadoSuporteRepository.deleteById(id);
        }
    }
}
