package com.AlfaCar.AlfaCar.service.impl;

import com.AlfaCar.AlfaCar.model.entidades.EnderecoLocadora;
import com.AlfaCar.AlfaCar.model.entidades.Locadora;
import com.AlfaCar.AlfaCar.repository.EnderecoLocadoraRepository;
import com.AlfaCar.AlfaCar.repository.LocadoraRepository;
import com.AlfaCar.AlfaCar.service.interfaces.EnderecoLocadoraService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoLocadoraServiceImpl implements EnderecoLocadoraService {

    private final EnderecoLocadoraRepository enderecoLocadoraRepository;
    private final LocadoraRepository locadoraRepository;

    public EnderecoLocadoraServiceImpl(EnderecoLocadoraRepository enderecoLocadoraRepository,
                                       LocadoraRepository locadoraRepository) {
        this.enderecoLocadoraRepository = enderecoLocadoraRepository;
        this.locadoraRepository = locadoraRepository;
    }

    @Override
    public EnderecoLocadora cadastrarEndereco(Long idLocadora, EnderecoLocadora enderecoLocadora) {
        // 📌 Verifica se a Locadora existe antes de cadastrar o endereço
        Locadora locadora = locadoraRepository.findById(idLocadora)
                .orElseThrow(() -> new IllegalArgumentException("Locadora com ID " + idLocadora + " não encontrada."));

        // Associa o endereço à locadora existente
        enderecoLocadora.setLocadora(locadora);

        // Salva o endereço e retorna
        return enderecoLocadoraRepository.save(enderecoLocadora);
    }

    @Override
    public List<EnderecoLocadora> listarEnderecos() {
        return enderecoLocadoraRepository.findAll();
    }

    @Override
    public Optional<EnderecoLocadora> buscarEnderecoPorId(Long id) {
        return enderecoLocadoraRepository.findById(id);
    }

    @Override
    public Optional<EnderecoLocadora> buscarEnderecoPorLocadoraId(Long locadoraId) {
        return enderecoLocadoraRepository.findAll().stream()
                .filter(endereco -> endereco.getLocadora().getId().equals(locadoraId))
                .findFirst();
    }

    @Override
    public EnderecoLocadora atualizarEndereco(Long idEndereco, EnderecoLocadora enderecoAtualizado) {
        return enderecoLocadoraRepository.findById(idEndereco).map(endereco -> {
            endereco.setLogradouro(enderecoAtualizado.getLogradouro());
            endereco.setNumero(enderecoAtualizado.getNumero());
            endereco.setBairro(enderecoAtualizado.getBairro());
            endereco.setCep(enderecoAtualizado.getCep());
            endereco.setCidade(enderecoAtualizado.getCidade());
            endereco.setUf(enderecoAtualizado.getUf());
            return enderecoLocadoraRepository.save(endereco);
        }).orElseThrow(() -> new IllegalArgumentException("Endereço com ID " + idEndereco + " não encontrado."));
    }

    @Override
    public void deletarEndereco(Long id) {
        if (!enderecoLocadoraRepository.existsById(id)) {
            throw new IllegalArgumentException("Endereço com ID " + id + " não encontrado.");
        }
        enderecoLocadoraRepository.deleteById(id);
    }
}
