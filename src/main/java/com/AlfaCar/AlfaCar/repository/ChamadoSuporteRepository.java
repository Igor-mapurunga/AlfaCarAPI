//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.AlfaCar.AlfaCar.repository;

import com.AlfaCar.AlfaCar.model.entidades.ChamadoSuporte;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoSuporteRepository extends JpaRepository<ChamadoSuporte, Long> {
    List<ChamadoSuporte> findByUsuarioId(Long usuarioId);

    List<ChamadoSuporte> findByStatusSuporte(String statusSuporte);
}
