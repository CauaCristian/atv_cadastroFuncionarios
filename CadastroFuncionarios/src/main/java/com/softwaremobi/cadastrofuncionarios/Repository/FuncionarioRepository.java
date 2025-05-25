package com.softwaremobi.cadastrofuncionarios.Repository;

import com.softwaremobi.cadastrofuncionarios.Model.Funcionario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FuncionarioRepository extends MongoRepository<Funcionario, String> {
    Optional<Funcionario> findByEmail(String email);
}
