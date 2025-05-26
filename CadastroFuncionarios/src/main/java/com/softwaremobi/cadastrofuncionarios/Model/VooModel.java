package com.softwaremobi.cadastrofuncionarios.Model;

import com.softwaremobi.cadastrofuncionarios.Enum.StatusVooEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "voos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class VooModel {
    @Id
    private String id;
    @NotNull
    private int numeroVoo;
    @NotBlank
    private String origem;
    @NotBlank
    private String destino;
    @NotBlank
    private String dataHoraPartida;
    @NotNull
    @DBRef
    @Indexed(unique = true)
    private PortaoModel portaoId;
    @NotNull
    private StatusVooEnum statusVoo;
}
