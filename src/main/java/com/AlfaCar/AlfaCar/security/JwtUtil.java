//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.AlfaCar.AlfaCar.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    private final String secret = "chave-secreta-muito-forte-para-jwt-nao-compartilhar";
    private final long expirationMillis = 86400000L;

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor("chave-secreta-muito-forte-para-jwt-nao-compartilhar".getBytes());
    }

    public String gerarToken(String email) {
        return Jwts.builder().setSubject(email).setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + 86400000L)).signWith(this.getSigningKey(), SignatureAlgorithm.HS256).compact();
    }

    public String getEmailDoToken(String token) {
        return ((Claims)Jwts.parserBuilder().setSigningKey(this.getSigningKey()).build().parseClaimsJws(token).getBody()).getSubject();
    }

    public boolean tokenValido(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(this.getSigningKey()).build().parseClaimsJws(token);
            return true;
        } catch (IllegalArgumentException | JwtException var3) {
            return false;
        }
    }
}
