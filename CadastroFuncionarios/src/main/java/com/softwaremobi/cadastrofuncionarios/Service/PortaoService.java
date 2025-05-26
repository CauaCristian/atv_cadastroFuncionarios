package com.softwaremobi.cadastrofuncionarios.Service;

import com.softwaremobi.cadastrofuncionarios.Model.PortaoModel;
import com.softwaremobi.cadastrofuncionarios.Repository.PortaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortaoService {
    @Autowired
    private PortaoRepository portaoRepository;

    public List<PortaoModel> getAllPortoes() {
        return portaoRepository.findAll();
    }
    public PortaoModel createPortao(PortaoModel portao) {
        return portaoRepository.save(portao);
    }
    public PortaoModel updateStatusPortao(Boolean status, String id) {
        PortaoModel portao = portaoRepository.findById(id).orElse(null);
        if (portao != null) {
            portao.setDisponivel(status);
            return portaoRepository.save(portao);
        }
        return null;
    }
    public void deletePortao(String id) {
        portaoRepository.deleteById(id);
    }
}
