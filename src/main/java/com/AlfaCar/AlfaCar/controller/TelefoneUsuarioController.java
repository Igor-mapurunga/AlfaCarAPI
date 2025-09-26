package com.AlfaCar.AlfaCar.controller;

import com.AlfaCar.AlfaCar.model.entidades.TelefoneUsuario;
import com.AlfaCar.AlfaCar.model.entidades.Usuario;
import com.AlfaCar.AlfaCar.service.interfaces.TelefoneUsuarioService;
import com.AlfaCar.AlfaCar.service.interfaces.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/telefones")
public class TelefoneUsuarioController {

    private final TelefoneUsuarioService telefoneUsuarioService;
    private final UserService usuarioService;

    public TelefoneUsuarioController(TelefoneUsuarioService telefoneUsuarioService, UserService usuarioService) {
        this.telefoneUsuarioService = telefoneUsuarioService;
        this.usuarioService = usuarioService;
    }

    @PostMapping("/usuario/{usuarioId}")
    public ResponseEntity<TelefoneUsuario> cadastrarTelefone(
            @PathVariable Long usuarioId,
            @RequestBody TelefoneUsuario telefoneUsuario) {

        Optional<Usuario> usuario = usuarioService.buscarUsuarioPorId(usuarioId);
        if (usuario.isPresent()) {
            telefoneUsuario.setUsuario(usuario.get());
            TelefoneUsuario novoTelefone = telefoneUsuarioService.cadastrarTelefone(telefoneUsuario);
            return ResponseEntity.ok(novoTelefone);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<TelefoneUsuario>> listarTelefones() {
        return ResponseEntity.ok(telefoneUsuarioService.listarTelefones());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelefoneUsuario> buscarTelefonePorId(@PathVariable Long id) {
        return telefoneUsuarioService.buscarTelefonePorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<Optional<TelefoneUsuario>> buscarTelefonesPorUsuarioId(@PathVariable Long usuarioId) {
        Optional<TelefoneUsuario> telefones = telefoneUsuarioService.buscarTelefonesPorUsuarioId(usuarioId);
        if (!telefones.isEmpty()) {
            return ResponseEntity.ok(telefones);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTelefone(@PathVariable Long id) {
        telefoneUsuarioService.deletarTelefone(id);
        return ResponseEntity.noContent().build();
    }
}
