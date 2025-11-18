//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.AlfaCar.AlfaCar.service.impl;

import com.AlfaCar.AlfaCar.model.entidades.EnderecoLocadora;
import com.AlfaCar.AlfaCar.model.entidades.Locadora;
import com.AlfaCar.AlfaCar.repository.EnderecoLocadoraRepository;
import com.AlfaCar.AlfaCar.repository.LocadoraRepository;
import com.AlfaCar.AlfaCar.service.interfaces.EnderecoLocadoraService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class EnderecoLocadoraServiceImpl implements EnderecoLocadoraService {
    private final EnderecoLocadoraRepository enderecoLocadoraRepository;
    private final LocadoraRepository locadoraRepository;

    public EnderecoLocadoraServiceImpl(EnderecoLocadoraRepository enderecoLocadoraRepository, LocadoraRepository locadoraRepository) {
        this.enderecoLocadoraRepository = enderecoLocadoraRepository;
        this.locadoraRepository = locadoraRepository;
    }

    public EnderecoLocadora cadastrarEndereco(Long idLocadora, EnderecoLocadora enderecoLocadora) {
        Locadora locadora = (Locadora)this.locadoraRepository.findById(idLocadora).orElseThrow(() -> new IllegalArgumentException("Locadora com ID " + idLocadora + " não encontrada."));
        enderecoLocadora.setLocadora(locadora);
        return (EnderecoLocadora)this.enderecoLocadoraRepository.save(enderecoLocadora);
    }

    public List<EnderecoLocadora> listarEnderecos() {
        return this.enderecoLocadoraRepository.findAll();
    }

    public Optional<EnderecoLocadora> buscarEnderecoPorId(Long id) {
        return this.enderecoLocadoraRepository.findById(id);
    }

    public Optional<EnderecoLocadora> buscarEnderecoPorLocadoraId(Long locadoraId) {
        return this.enderecoLocadoraRepository.findAll().stream().filter((endereco) -> endereco.getLocadora().getId().equals(locadoraId)).findFirst();
    }

    public EnderecoLocadora atualizarEndereco(Long idEndereco, EnderecoLocadora enderecoAtualizado) {
        return (EnderecoLocadora)this.enderecoLocadoraRepository.findById(idEndereco).map((endereco) -> {
            endereco.setLogradouro(enderecoAtualizado.getLogradouro());
            endereco.setNumero(enderecoAtualizado.getNumero());
            endereco.setBairro(enderecoAtualizado.getBairro());
            endereco.setCep(enderecoAtualizado.getCep());
            endereco.setCidade(enderecoAtualizado.getCidade());
            endereco.setUf(enderecoAtualizado.getUf());
            return (EnderecoLocadora)this.enderecoLocadoraRepository.save(endereco);
        }).orElseThrow(() -> new IllegalArgumentException("Endereço com ID " + idEndereco + " não encontrado."));
    }

    public void deletarEndereco(Long id) {
        if (!this.enderecoLocadoraRepository.existsById(id)) {
            throw new IllegalArgumentException("Endereço com ID " + id + " não encontrado.");
        } else {
            this.enderecoLocadoraRepository.deleteById(id);
        }
    }
}
