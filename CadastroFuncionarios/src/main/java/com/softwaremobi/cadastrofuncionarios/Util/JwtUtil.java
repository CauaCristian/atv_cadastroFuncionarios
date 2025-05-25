package com.softwaremobi.cadastrofuncionarios.Util;

import com.softwaremobi.cadastrofuncionarios.Model.Funcionario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    private final String SECRET = "segredo";
    private final long EXPIRATION = 120000;

    public String generateToken(Funcionario f) {
        return Jwts.builder()
                .setSubject(f.getEmail())
                .claim("id", f.getId())
                .claim("nome", f.getNome())
                .claim("cargo", f.getCargo())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    public Claims validateToken(String token) throws Exception {
        return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
    }
}
