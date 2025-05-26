package com.softwaremobi.cadastrofuncionarios.Controller;

import com.softwaremobi.cadastrofuncionarios.Model.PortaoModel;
import com.softwaremobi.cadastrofuncionarios.Service.PortaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/portao")
public class PortaoController {
    @Autowired
    private PortaoService portaoService;

    @GetMapping(value = "/getAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PortaoModel> getAllPortao() {
        return portaoService.getAllPortoes();
    }
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PortaoModel createPortao(@RequestBody PortaoModel portao) {
        return portaoService.createPortao(portao);
    }
    @PutMapping(value = "/updateStatus/{id}/{status}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PortaoModel updatePortao(@PathVariable Boolean status, @PathVariable String id) {
        return portaoService.updateStatusPortao(status,id);
    }
    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deletePortao(@PathVariable String id) {
        portaoService.deletePortao(id);
    }
}
