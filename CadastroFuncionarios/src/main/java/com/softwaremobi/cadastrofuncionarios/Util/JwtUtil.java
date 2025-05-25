package com.softwaremobi.cadastrofuncionarios.Util;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import com.softwaremobi.cadastrofuncionarios.Model.Funcionario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    // Gera uma chave HS256 segura (256 bits)
    private final SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // Validade do token: 2 minutos (em milissegundos)
    private final long EXPIRATION = 2 * 60 * 1000;

    public String generateToken(Funcionario f) {
        return Jwts.builder()
                .setSubject(f.getEmail())
                .claim("id", f.getId())
                .claim("nome", f.getNome())
                .claim("cargo", f.getCargo())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                // Assina com a SecretKey (já inclui o algoritmo)
                .signWith(key)
                .compact();
    }

    public Claims validateToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
