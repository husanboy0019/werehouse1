package uz.com.appwarehouse.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.com.appwarehouse.base.BaseURI;
import uz.com.appwarehouse.common.ResponseData;
import uz.com.appwarehouse.dto.outcome.OutcomeCreateDTO;
import uz.com.appwarehouse.dto.outcome.OutcomeDTO;
import uz.com.appwarehouse.service.OutcomeService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(BaseURI.API + BaseURI.V1 + BaseURI.OUTCOME)
public class OutcomeController {

    private final OutcomeService service;

    @GetMapping(BaseURI.GET + BaseURI.ALL)
    public ResponseEntity<ResponseData<List<OutcomeDTO>>> getAll() {
        return service.getAll();
    }

    @GetMapping(BaseURI.GET + "/{id}")
    public ResponseEntity<ResponseData<OutcomeDTO>> get(@PathVariable(value = "id") Integer id) {
        return service.get(id);
    }

    @PostMapping(BaseURI.ADD)
    public ResponseEntity<ResponseData<OutcomeDTO>> add(@Valid @RequestBody OutcomeCreateDTO dto) {
        return service.add(dto);
    }

}
