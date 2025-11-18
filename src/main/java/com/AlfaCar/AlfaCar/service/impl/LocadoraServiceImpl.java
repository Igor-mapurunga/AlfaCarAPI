//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.AlfaCar.AlfaCar.service.impl;

import com.AlfaCar.AlfaCar.model.entidades.Locadora;
import com.AlfaCar.AlfaCar.repository.LocadoraRepository;
import com.AlfaCar.AlfaCar.service.interfaces.LocadoraService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class LocadoraServiceImpl implements LocadoraService {
    private final LocadoraRepository locadoraRepository;

    public LocadoraServiceImpl(LocadoraRepository locadoraRepository) {
        this.locadoraRepository = locadoraRepository;
    }

    public Locadora cadastrarLocadora(Locadora locadora) {
        return (Locadora)this.locadoraRepository.save(locadora);
    }

    public List<Locadora> listarLocadoras() {
        return this.locadoraRepository.findAll();
    }

    public Optional<Locadora> buscarLocadoraPorId(Long id) {
        return this.locadoraRepository.findById(id);
    }

    public void deletarLocadora(Long id) {
        this.locadoraRepository.deleteById(id);
    }

    public Optional<Locadora> atualizarLocadora(Long id, Locadora locadoraAtualizada) {
        return this.locadoraRepository.findById(id).map((locadora) -> {
            locadora.setNome(locadoraAtualizada.getNome());
            return (Locadora)this.locadoraRepository.save(locadora);
        });
    }
}
