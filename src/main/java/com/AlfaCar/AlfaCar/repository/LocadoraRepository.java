package com.AlfaCar.AlfaCar.repository;

import com.AlfaCar.AlfaCar.model.entidades.Locadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocadoraRepository extends JpaRepository<Locadora, Long> {


}
