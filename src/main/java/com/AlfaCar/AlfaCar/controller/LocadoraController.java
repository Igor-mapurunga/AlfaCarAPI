//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.AlfaCar.AlfaCar.controller;

import com.AlfaCar.AlfaCar.model.entidades.Locadora;
import com.AlfaCar.AlfaCar.model.entidades.Usuario;
import com.AlfaCar.AlfaCar.service.impl.LocadoraServiceImpl;
import com.AlfaCar.AlfaCar.service.interfaces.UserService;
import java.util.List;
import java.util.Optional;
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
@RequestMapping({"/locadoras"})
public class LocadoraController {
    private final LocadoraServiceImpl locadoraService;
    private final UserService usuarioService;

    public LocadoraController(LocadoraServiceImpl locadoraService, UserService usuarioService) {
        this.locadoraService = locadoraService;
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Locadora> cadastrarLocadora(@RequestBody Locadora locadora) {
        Usuario usuarioLogado = this.usuarioService.obterUsuarioLogado();
        locadora.setUsuario(usuarioLogado);
        Locadora novaLocadora = this.locadoraService.cadastrarLocadora(locadora);
        return ResponseEntity.ok(novaLocadora);
    }

    @GetMapping
    public ResponseEntity<List<Locadora>> listarLocadoras() {
        return ResponseEntity.ok(this.locadoraService.listarLocadoras());
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Locadora> buscarLocadoraPorId(@PathVariable Long id) {
        Optional<Locadora> locadora = this.locadoraService.buscarLocadoraPorId(id);
        return (ResponseEntity)locadora.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deletarLocadora(@PathVariable Long id) {
        this.locadoraService.deletarLocadora(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<Locadora> atualizarLocadora(@PathVariable Long id, @RequestBody Locadora locadoraAtualizada) {
        return (ResponseEntity)this.locadoraService.atualizarLocadora(id, locadoraAtualizada).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
