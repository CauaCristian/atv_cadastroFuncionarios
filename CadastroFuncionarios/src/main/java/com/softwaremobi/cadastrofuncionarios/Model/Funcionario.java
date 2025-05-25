package com.softwaremobi.cadastrofuncionarios.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("funcionarios")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Funcionario {
    @Id
    private String id;
    private String nome;
    private String email;
    private String senha;
    private String cargo;
}
