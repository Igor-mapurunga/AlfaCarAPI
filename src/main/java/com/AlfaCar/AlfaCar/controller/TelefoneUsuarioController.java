//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.AlfaCar.AlfaCar.controller;

import com.AlfaCar.AlfaCar.model.entidades.TelefoneUsuario;
import com.AlfaCar.AlfaCar.model.entidades.Usuario;
import com.AlfaCar.AlfaCar.service.interfaces.TelefoneUsuarioService;
import com.AlfaCar.AlfaCar.service.interfaces.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/telefones"})
public class TelefoneUsuarioController {
    private final TelefoneUsuarioService telefoneUsuarioService;
    private final UserService usuarioService;

    public TelefoneUsuarioController(TelefoneUsuarioService telefoneUsuarioService, UserService usuarioService) {
        this.telefoneUsuarioService = telefoneUsuarioService;
        this.usuarioService = usuarioService;
    }

    @PostMapping({"/usuario/{usuarioId}"})
    public ResponseEntity<TelefoneUsuario> cadastrarTelefone(@PathVariable Long usuarioId, @RequestBody TelefoneUsuario telefoneUsuario) {
        Optional<Usuario> usuario = this.usuarioService.buscarUsuarioPorId(usuarioId);
        if (usuario.isPresent()) {
            telefoneUsuario.setUsuario((Usuario)usuario.get());
            TelefoneUsuario novoTelefone = this.telefoneUsuarioService.cadastrarTelefone(telefoneUsuario);
            return ResponseEntity.ok(novoTelefone);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<TelefoneUsuario>> listarTelefones() {
        return ResponseEntity.ok(this.telefoneUsuarioService.listarTelefones());
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<TelefoneUsuario> buscarTelefonePorId(@PathVariable Long id) {
        return (ResponseEntity)this.telefoneUsuarioService.buscarTelefonePorId(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping({"/usuario/{usuarioId}"})
    public ResponseEntity<Optional<TelefoneUsuario>> buscarTelefonesPorUsuarioId(@PathVariable Long usuarioId) {
        Optional<TelefoneUsuario> telefones = this.telefoneUsuarioService.buscarTelefonesPorUsuarioId(usuarioId);
        return !telefones.isEmpty() ? ResponseEntity.ok(telefones) : ResponseEntity.notFound().build();
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deletarTelefone(@PathVariable Long id) {
        this.telefoneUsuarioService.deletarTelefone(id);
        return ResponseEntity.noContent().build();
    }
}
