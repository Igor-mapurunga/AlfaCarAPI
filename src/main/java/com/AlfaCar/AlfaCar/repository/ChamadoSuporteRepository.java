package com.AlfaCar.AlfaCar.repository;

import com.AlfaCar.AlfaCar.model.entidades.ChamadoSuporte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChamadoSuporteRepository extends JpaRepository<ChamadoSuporte, Long> {

    List<ChamadoSuporte> findByUsuarioId(Long usuarioId);

    // 📌 Buscar todos os chamados por status
    List<ChamadoSuporte> findByStatusSuporte(String statusSuporte);
}
