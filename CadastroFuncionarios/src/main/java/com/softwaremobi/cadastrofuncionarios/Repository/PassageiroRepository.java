package com.softwaremobi.cadastrofuncionarios.Repository;

import com.softwaremobi.cadastrofuncionarios.Enum.StatusCheckinEnum;
import com.softwaremobi.cadastrofuncionarios.Model.PassageiroModel;
import com.softwaremobi.cadastrofuncionarios.Model.VooModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PassageiroRepository extends MongoRepository<PassageiroModel,String> {
   List<PassageiroModel> findByVooId(@NotNull VooModel vooId);

    List<PassageiroModel> findByStatusCheckin(@NotBlank StatusCheckinEnum statusCheckin);
}
