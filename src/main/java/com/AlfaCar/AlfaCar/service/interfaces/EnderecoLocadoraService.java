//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.AlfaCar.AlfaCar.service.interfaces;

import com.AlfaCar.AlfaCar.model.entidades.EnderecoLocadora;
import java.util.List;
import java.util.Optional;

public interface EnderecoLocadoraService {
    EnderecoLocadora cadastrarEndereco(Long idLocadora, EnderecoLocadora enderecoLocadora);

    List<EnderecoLocadora> listarEnderecos();

    Optional<EnderecoLocadora> buscarEnderecoPorId(Long id);

    Optional<EnderecoLocadora> buscarEnderecoPorLocadoraId(Long locadoraId);

    EnderecoLocadora atualizarEndereco(Long idEndereco, EnderecoLocadora enderecoAtualizado);

    void deletarEndereco(Long id);
}
