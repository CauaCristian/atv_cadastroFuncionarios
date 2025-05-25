package com.softwaremobi.cadastrofuncionarios.Service;

import com.softwaremobi.cadastrofuncionarios.DTO.FuncionarioDTO;
import com.softwaremobi.cadastrofuncionarios.DTO.LoginDTO;
import com.softwaremobi.cadastrofuncionarios.DTO.ResponseDTO;
import com.softwaremobi.cadastrofuncionarios.Model.Funcionario;
import com.softwaremobi.cadastrofuncionarios.Repository.FuncionarioRepository;
import com.softwaremobi.cadastrofuncionarios.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private FuncionarioRepository repo;
    @Autowired private PasswordEncoder encoder;
    @Autowired private JwtUtil jwt;

    public ResponseDTO<Funcionario> register(FuncionarioDTO dto) {
        if (repo.findByEmail(dto.email).isPresent()) {
            return new ResponseDTO<>(true, "Email já registrado", null, null);
        }

        Funcionario f = new Funcionario();
        f.setNome(dto.nome);
        f.setEmail(dto.email);
        f.setSenha(encoder.encode(dto.senha));
        f.setCargo(dto.cargo.toUpperCase());

        repo.save(f);
        return new ResponseDTO<>(false, "Cadastrado com sucesso", f, jwt.generateToken(f));
    }

    public ResponseDTO<Funcionario> login(LoginDTO dto) {
        Optional<Funcionario> opt = repo.findByEmail(dto.email);
        if (opt.isEmpty() || !encoder.matches(dto.senha, opt.get().getSenha())) {
            return new ResponseDTO<>(true, "Credenciais inválidas", null, null);
        }

        Funcionario f = opt.get();
        return new ResponseDTO<>(false, "Login realizado", f, jwt.generateToken(f));
    }
}
