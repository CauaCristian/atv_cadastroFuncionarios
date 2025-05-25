package com.softwaremobi.cadastrofuncionarios.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class FuncionarioDTO {
    @NotBlank
    public String nome;

    @Email
    @NotBlank
    public String email;

    @NotBlank
    public String senha;

    @NotBlank
    public String cargo;
}
