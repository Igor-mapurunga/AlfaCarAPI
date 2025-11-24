//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.AlfaCar.AlfaCar.controller;

import com.AlfaCar.AlfaCar.model.entidades.Usuario;
import com.AlfaCar.AlfaCar.repository.UserRepository;
import com.AlfaCar.AlfaCar.security.JwtUtil;
import com.AlfaCar.AlfaCar.security.UserDetailsImpl;
import java.util.Map;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/auth"})
public class AuthController {
    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(AuthenticationManager authManager, JwtUtil jwtUtil, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.authManager = authManager;
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping({"/login"})
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        String email = (String)body.get("email");
        String senha = (String)body.get("senha");
        Authentication authentication = this.authManager.authenticate(new UsernamePasswordAuthenticationToken(email, senha));
        UserDetailsImpl userDetails = (UserDetailsImpl)authentication.getPrincipal();
        String token = this.jwtUtil.gerarToken(userDetails.getUsername());
        Optional<Usuario> usuarioOpt = this.userRepository.findByEmail(email);
        String nome = (String)usuarioOpt.map(Usuario::getNome).orElse("Usuário");
        return ResponseEntity.ok(Map.of("token", token, "nome", nome));
    }

    @PostMapping({"/register"})
    public ResponseEntity<?> register(@RequestBody Usuario usuario) {
        if (this.userRepository.findByEmail(usuario.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email já está em uso.");
        } else {
            usuario.setSenha(this.passwordEncoder.encode(usuario.getSenha()));
            Usuario salvo = (Usuario)this.userRepository.save(usuario);
            return ResponseEntity.ok(salvo);
        }
    }

    @GetMapping({"/me"})
    public ResponseEntity<?> getMe() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String email = authentication.getName();
            Optional<Usuario> usuarioOpt = this.userRepository.findByEmail(email);
            if (usuarioOpt.isPresent()) {
                Usuario usuario = (Usuario)usuarioOpt.get();
                return ResponseEntity.ok(Map.of("id", usuario.getId(), "nome", usuario.getNome(), "email", usuario.getEmail()));
            } else {
                return ResponseEntity.status(404).body("Usuário não encontrado");
            }
        } else {
            return ResponseEntity.status(401).body("Não autenticado");
        }
    }
}
