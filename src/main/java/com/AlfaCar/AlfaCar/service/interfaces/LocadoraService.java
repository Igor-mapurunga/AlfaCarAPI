package com.AlfaCar.AlfaCar.service.interfaces;

import com.AlfaCar.AlfaCar.model.entidades.Locadora;

import java.util.List;
import java.util.Optional;

public interface LocadoraService {
    Locadora cadastrarLocadora(Locadora locadora);
    List<Locadora> listarLocadoras();
    Optional<Locadora> buscarLocadoraPorId(Long id);
    void deletarLocadora(Long id);
    Optional<Locadora> atualizarLocadora(Long id, Locadora locadoraAtualizada);
}
