package com.softwaremobi.cadastrofuncionarios.Controller;


import com.softwaremobi.cadastrofuncionarios.Enum.StatusCheckinEnum;
import com.softwaremobi.cadastrofuncionarios.Model.PassageiroModel;
import com.softwaremobi.cadastrofuncionarios.Service.PassageiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passageiro")
public class PassageiroController {
    @Autowired
    private PassageiroService passageiroService;

    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PassageiroModel> getAllPassageiros() {
        return passageiroService.getAllPassageiros();
    }
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PassageiroModel createPassageiro(@RequestBody PassageiroModel passageiro) {
        return passageiroService.createPassageiro(passageiro);
    }
    @PutMapping(value = "/updateCheckIn/{id}/{status}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PassageiroModel updateCheckInPassageiro(@PathVariable StatusCheckinEnum status, @PathVariable String id) {
        return passageiroService.updateCheckInPassageiro(status,id);
    }
    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deletePassageiro(@PathVariable String id) {
        passageiroService.deletePassageiro(id);
    }
}
