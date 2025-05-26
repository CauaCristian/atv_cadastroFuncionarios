package com.softwaremobi.cadastrofuncionarios.Model;

import com.softwaremobi.cadastrofuncionarios.Enum.StatusCheckinEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "passageiros")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class PassageiroModel {
    @Id
    private String id;
    @NotBlank
    private String nome;
    @NotBlank
    @Indexed(unique = true)
    private String cpf;
    @NotNull
    @DBRef
    private VooModel vooId;
    @NotBlank
    private StatusCheckinEnum statusCheckin;
}
