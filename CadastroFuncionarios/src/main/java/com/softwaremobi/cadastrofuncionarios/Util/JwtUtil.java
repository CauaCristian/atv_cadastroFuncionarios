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

    private final SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    private final long EXPIRATION = 2 * 60 * 1000; // 2 minutos

    public String generateToken(Funcionario f) {
        return Jwts.builder()
                .setSubject(f.getEmail())
                .claim("id", f.getId())
                .claim("nome", f.getNome())
                .claim("cargo", f.getCargo()) // Ex: ADMIN
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
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
