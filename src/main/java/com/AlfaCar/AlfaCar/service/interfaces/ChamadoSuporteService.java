//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.AlfaCar.AlfaCar.service.interfaces;

import com.AlfaCar.AlfaCar.model.entidades.ChamadoSuporte;
import com.AlfaCar.AlfaCar.model.enums.StatusSuporte;
import java.util.List;
import java.util.Optional;

public interface ChamadoSuporteService {
    ChamadoSuporte criarChamado(ChamadoSuporte chamadoSuporte, Long usuarioId);

    List<ChamadoSuporte> buscarChamados();

    Optional<ChamadoSuporte> buscarChamadoPorId(Long id);

    List<ChamadoSuporte> buscarChamadosPorUsuario(Long usuarioId);

    List<ChamadoSuporte> buscarChamadosPorStatus(StatusSuporte statusSuporte);

    ChamadoSuporte atualizarChamado(Long id, ChamadoSuporte chamadoAtualizado);

    void deletarChamado(Long id);
}
