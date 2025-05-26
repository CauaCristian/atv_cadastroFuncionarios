package com.softwaremobi.cadastrofuncionarios.Service;

import com.softwaremobi.cadastrofuncionarios.Enum.StatusVooEnum;
import com.softwaremobi.cadastrofuncionarios.Model.PassageiroModel;
import com.softwaremobi.cadastrofuncionarios.Model.PortaoModel;
import com.softwaremobi.cadastrofuncionarios.Model.VooModel;
import com.softwaremobi.cadastrofuncionarios.Repository.PassageiroRepository;
import com.softwaremobi.cadastrofuncionarios.Repository.PortaoRepository;
import com.softwaremobi.cadastrofuncionarios.Repository.VooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioService {
    @Autowired
    private VooRepository vooRepository;
    @Autowired
    private PassageiroRepository passageiroRepository;
    @Autowired
    private PortaoRepository portaoRepository;

    public List<VooModel> getVoosProgramados(StatusVooEnum statusVoo, String dataHoraPartida) {
        List<VooModel> voosProgramados = vooRepository.findByStatusVoo(statusVoo);
        List<VooModel> voosFiltrados = voosProgramados.stream()
                .filter(voo -> voo.getDataHoraPartida().equals(dataHoraPartida))
                .toList();
        return voosFiltrados;
    }
    public List<PassageiroModel> getPassageirosPorVoo(String vooId) {
        VooModel voo = vooRepository.findById(vooId).orElse(null);
        if (voo != null) {
            return passageiroRepository.findByVooId(voo);
        }
        return null;
    }
    public List<PassageiroModel> getStatusCheckInPassageiros() {
        return passageiroRepository.findAll();
    }
    public List<PortaoModel> getPortoesAtribuidos() {
        return portaoRepository.findByDisponivel(false);
    }
}
