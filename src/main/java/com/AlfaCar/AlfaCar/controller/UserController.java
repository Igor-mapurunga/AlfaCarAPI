//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.AlfaCar.AlfaCar.controller;

import com.AlfaCar.AlfaCar.model.entidades.Usuario;
import com.AlfaCar.AlfaCar.service.interfaces.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/usuarios"})
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return ResponseEntity.ok(this.userService.listarUsuarios());
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable Long id) {
        Optional<Usuario> usuarioOpt = this.userService.buscarUsuarioPorId(id);
        return (ResponseEntity)usuarioOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
        Usuario novoUsuario = this.userService.cadastrarUsuario(usuario);
        return ResponseEntity.ok(novoUsuario);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {
        Optional<Usuario> usuarioOpt = this.userService.buscarUsuarioPorId(id);
        if (usuarioOpt.isPresent()) {
            Usuario usuarioExistente = (Usuario)usuarioOpt.get();
            usuarioExistente.setNome(usuarioAtualizado.getNome());
            usuarioExistente.setEmail(usuarioAtualizado.getEmail());
            usuarioExistente.setCpf(usuarioAtualizado.getCpf());
            usuarioExistente.setTipo(usuarioAtualizado.getTipo());
            usuarioExistente.setSenha(usuarioAtualizado.getSenha());
            usuarioExistente.setDataNascimento(usuarioAtualizado.getDataNascimento());
            Usuario usuarioSalvo = this.userService.cadastrarUsuario(usuarioExistente);
            return ResponseEntity.ok(usuarioSalvo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        Optional<Usuario> usuarioOpt = this.userService.buscarUsuarioPorId(id);
        if (usuarioOpt.isPresent()) {
            this.userService.deletarUsuario(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
