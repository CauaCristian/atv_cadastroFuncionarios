package com.softwaremobi.cadastrofuncionarios.Controller;

import com.softwaremobi.cadastrofuncionarios.DTO.FuncionarioDTO;
import com.softwaremobi.cadastrofuncionarios.DTO.LoginDTO;
import com.softwaremobi.cadastrofuncionarios.DTO.ResponseDTO;
import com.softwaremobi.cadastrofuncionarios.Model.Funcionario;
import com.softwaremobi.cadastrofuncionarios.Service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService service;

    @PostMapping("/register")
    public ResponseDTO<Funcionario> register(@RequestBody @Valid FuncionarioDTO dto) {
        return service.register(dto);
    }

    @PostMapping("/login")
    public ResponseDTO<Funcionario> login(@RequestBody LoginDTO dto) {
        return service.login(dto);
    }
}
