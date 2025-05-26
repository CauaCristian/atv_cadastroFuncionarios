package com.softwaremobi.cadastrofuncionarios.Controller;

import com.softwaremobi.cadastrofuncionarios.Enum.StatusVooEnum;
import com.softwaremobi.cadastrofuncionarios.Model.VooModel;
import com.softwaremobi.cadastrofuncionarios.Service.VooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voo")
public class VooController {
    @Autowired
    private VooService vooService;

    @GetMapping(value = "/getAll", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<VooModel> getAll() {
        return vooService.getAll();
    }
    @PostMapping(value = "/create", consumes= MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
    public VooModel createVoo(@RequestBody VooModel voo) {
        return vooService.createVoo(voo);
    }
    @PutMapping(value = "/updateStatus/{id}/{status}", consumes= MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
    public VooModel updateVoo(@PathVariable StatusVooEnum status, @PathVariable String id) {
        return vooService.updateStatusVoo(status,id);
    }
    @DeleteMapping(value = "/delete/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public void deleteVoo(@PathVariable String id) {
        vooService.deleteVoo(id);
    }

}
