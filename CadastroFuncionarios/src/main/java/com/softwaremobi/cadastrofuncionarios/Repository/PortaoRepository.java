package com.softwaremobi.cadastrofuncionarios.Repository;

import com.softwaremobi.cadastrofuncionarios.Model.PortaoModel;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PortaoRepository extends MongoRepository<PortaoModel, String> {
    List<PortaoModel> findByDisponivel(@NotNull boolean disponivel);
}
