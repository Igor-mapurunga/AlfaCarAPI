package com.AlfaCar.AlfaCar.repository;

import com.AlfaCar.AlfaCar.model.entidades.EnderecoLocadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoLocadoraRepository extends JpaRepository<EnderecoLocadora, Long> {
}
