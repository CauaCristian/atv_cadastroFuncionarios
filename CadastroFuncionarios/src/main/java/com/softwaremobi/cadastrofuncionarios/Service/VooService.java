package com.softwaremobi.cadastrofuncionarios.Service;

import com.softwaremobi.cadastrofuncionarios.Enum.StatusVooEnum;
import com.softwaremobi.cadastrofuncionarios.Model.PortaoModel;
import com.softwaremobi.cadastrofuncionarios.Model.VooModel;
import com.softwaremobi.cadastrofuncionarios.Repository.PortaoRepository;
import com.softwaremobi.cadastrofuncionarios.Repository.VooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VooService {
    @Autowired
    private VooRepository vooRepository;
    @Autowired
    private PortaoRepository portaoRepository;

    public List<VooModel> getAll() {
        return vooRepository.findAll();
    }
    public VooModel createVoo(VooModel voo) {
        PortaoModel portao = portaoRepository.findById(voo.getPortaoId().getId()).orElse(null);
        if(portao != null) {
            if (portao.isDisponivel()) {
                portao.setDisponivel(false);
                portaoRepository.save(portao);
                return vooRepository.save(voo);
            }
        }
        return null;
    }
    public VooModel updateStatusVoo(StatusVooEnum status, String id) {
        if(status.equals(StatusVooEnum.CONCLUIDO)){
            PortaoModel portao = portaoRepository.findById(vooRepository.findById(id).orElse(null).getPortaoId().getId()).orElse(null);
            if (portao != null) {
                portao.setDisponivel(true);
                portaoRepository.save(portao);
            }
        }
        VooModel voo = vooRepository.findById(id).orElse(null);
        if (voo != null) {
            voo.setStatusVoo(status);
            return vooRepository.save(voo);
        }
        return null;
    }
    public void deleteVoo(String id) {
        vooRepository.deleteById(id);
    }
}
