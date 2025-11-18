//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.AlfaCar.AlfaCar.repository;

import com.AlfaCar.AlfaCar.model.entidades.Aluguel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
    List<Aluguel> findByClienteId(Long clienteId);

    List<Aluguel> findByVeiculoId(Long veiculoId);

    List<Aluguel> findByStatusAluguel(String statusAluguel);
}
