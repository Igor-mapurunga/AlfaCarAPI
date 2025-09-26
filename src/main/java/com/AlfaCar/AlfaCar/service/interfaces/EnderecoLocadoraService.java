package com.AlfaCar.AlfaCar.service.interfaces;

import com.AlfaCar.AlfaCar.model.entidades.EnderecoLocadora;
import java.util.List;
import java.util.Optional;

public interface EnderecoLocadoraService {

    // 📌 Criar um endereço associado a uma locadora existente
    EnderecoLocadora cadastrarEndereco(Long idLocadora, EnderecoLocadora enderecoLocadora);

    // 📌 Listar todos os endereços cadastrados
    List<EnderecoLocadora> listarEnderecos();

    // 📌 Buscar um endereço pelo ID
    Optional<EnderecoLocadora> buscarEnderecoPorId(Long id);

    // 📌 Buscar um endereço pelo ID da locadora associada
    Optional<EnderecoLocadora> buscarEnderecoPorLocadoraId(Long locadoraId);

    // 📌 Atualizar um endereço existente pelo ID
    EnderecoLocadora atualizarEndereco(Long idEndereco, EnderecoLocadora enderecoAtualizado);

    // 📌 Excluir um endereço pelo ID
    void deletarEndereco(Long id);
}
