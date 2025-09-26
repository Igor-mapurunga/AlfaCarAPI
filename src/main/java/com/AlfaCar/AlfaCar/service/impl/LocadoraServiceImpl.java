package com.AlfaCar.AlfaCar.service.impl;

import com.AlfaCar.AlfaCar.model.entidades.Locadora;
import com.AlfaCar.AlfaCar.model.entidades.Usuario;
import com.AlfaCar.AlfaCar.repository.LocadoraRepository;
import com.AlfaCar.AlfaCar.repository.UserRepository;
import com.AlfaCar.AlfaCar.service.interfaces.LocadoraService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocadoraServiceImpl implements LocadoraService {

    private final LocadoraRepository locadoraRepository;

    

    public LocadoraServiceImpl(LocadoraRepository locadoraRepository) {
        this.locadoraRepository = locadoraRepository;
    }


    @Override
    public Locadora cadastrarLocadora(Locadora locadora) {
        return locadoraRepository.save(locadora);
    }


    @Override
    public List<Locadora> listarLocadoras() {
        return locadoraRepository.findAll();
    }

    @Override
    public Optional<Locadora> buscarLocadoraPorId(Long id) {
        return locadoraRepository.findById(id);
    }

    @Override
    public void deletarLocadora(Long id) {
        locadoraRepository.deleteById(id);
    }
    @Override
    public Optional<Locadora> atualizarLocadora(Long id, Locadora locadoraAtualizada) {
        return locadoraRepository.findById(id).map(locadora -> {
            locadora.setNome(locadoraAtualizada.getNome()); // Atualiza o nome
            return locadoraRepository.save(locadora);
        });
    }
}
