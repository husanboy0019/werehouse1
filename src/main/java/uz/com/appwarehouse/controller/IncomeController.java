package uz.com.appwarehouse.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.com.appwarehouse.base.BaseURI;
import uz.com.appwarehouse.common.ResponseData;
import uz.com.appwarehouse.dto.income.IncomeCreateDTO;
import uz.com.appwarehouse.dto.income.IncomeDTO;
import uz.com.appwarehouse.service.IncomeService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(BaseURI.API + BaseURI.V1 + BaseURI.INCOME)
public class IncomeController {

    private final IncomeService service;

    @GetMapping(BaseURI.GET + BaseURI.ALL)
    public ResponseEntity<ResponseData<List<IncomeDTO>>> getAll() {
        return service.getAll();
    }

    @GetMapping(BaseURI.GET + "/{id}")
    public ResponseEntity<ResponseData<IncomeDTO>> get(@PathVariable(value = "id") Integer id) {
        return service.get(id);
    }

    @PostMapping(BaseURI.ADD)
    public ResponseEntity<ResponseData<IncomeDTO>> add(@Valid @RequestBody IncomeCreateDTO dto) {
        return service.add(dto);
    }

}
