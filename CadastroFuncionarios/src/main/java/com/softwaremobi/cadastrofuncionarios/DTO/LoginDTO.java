package com.softwaremobi.cadastrofuncionarios.DTO;
import jakarta.validation.constraints.Email;

public class LoginDTO {
    @Email
    public String email;

    public String senha;
}
