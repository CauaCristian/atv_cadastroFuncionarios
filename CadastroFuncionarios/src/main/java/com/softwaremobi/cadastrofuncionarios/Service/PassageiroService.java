package com.softwaremobi.cadastrofuncionarios.Service;

import com.softwaremobi.cadastrofuncionarios.Enum.StatusCheckinEnum;
import com.softwaremobi.cadastrofuncionarios.Enum.StatusVooEnum;
import com.softwaremobi.cadastrofuncionarios.Model.PassageiroModel;
import com.softwaremobi.cadastrofuncionarios.Repository.PassageiroRepository;
import com.softwaremobi.cadastrofuncionarios.Repository.VooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassageiroService {
    @Autowired
    private PassageiroRepository passageiroRepository;
    @Autowired
    private VooRepository vooRepository;

    public List<PassageiroModel> getAllPassageiros() {
        return passageiroRepository.findAll();
    }
    public PassageiroModel createPassageiro(PassageiroModel passageiro) {
        return passageiroRepository.save(passageiro);
    }
    public PassageiroModel updateCheckInPassageiro(StatusCheckinEnum status, String id) {
        PassageiroModel passageiro = passageiroRepository.findById(id).orElse(null);
        if (passageiro != null) {
            if(passageiro.getVooId().getStatusVoo().equals(StatusVooEnum.EMBARQUE)){
                passageiro.setStatusCheckin(status);
                return passageiroRepository.save(passageiro);
            }
        }
        return null;
    }
    public void deletePassageiro(String id) {
        passageiroRepository.deleteById(id);
    }
}
