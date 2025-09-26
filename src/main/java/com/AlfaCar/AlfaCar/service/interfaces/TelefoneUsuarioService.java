package com.AlfaCar.AlfaCar.service.interfaces;

import com.AlfaCar.AlfaCar.model.entidades.TelefoneUsuario;

import java.util.List;
import java.util.Optional;

public interface TelefoneUsuarioService {
    TelefoneUsuario cadastrarTelefone(TelefoneUsuario telefoneUsuario);
    List<TelefoneUsuario> listarTelefones();
    Optional<TelefoneUsuario> buscarTelefonePorId(Long id);
    Optional<TelefoneUsuario> buscarTelefonesPorUsuarioId(Long usuarioId);
    void deletarTelefone(Long id);
}
