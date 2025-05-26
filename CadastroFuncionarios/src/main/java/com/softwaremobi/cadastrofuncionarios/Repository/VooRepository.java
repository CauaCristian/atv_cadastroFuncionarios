package com.softwaremobi.cadastrofuncionarios.Repository;


import com.softwaremobi.cadastrofuncionarios.Enum.StatusVooEnum;
import com.softwaremobi.cadastrofuncionarios.Model.VooModel;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VooRepository extends MongoRepository<VooModel,String> {
    List<VooModel> findByStatusVoo(@NotNull StatusVooEnum statusVoo);
}
