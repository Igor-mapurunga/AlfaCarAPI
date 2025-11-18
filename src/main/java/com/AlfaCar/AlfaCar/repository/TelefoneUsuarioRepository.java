//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.AlfaCar.AlfaCar.repository;

import com.AlfaCar.AlfaCar.model.entidades.TelefoneUsuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneUsuarioRepository extends JpaRepository<TelefoneUsuario, Long> {
    Optional<TelefoneUsuario> findByUsuarioId(Long usuarioId);
}
