package uz.com.appwarehouse.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.com.appwarehouse.base.BaseURI;
import uz.com.appwarehouse.common.ResponseData;
import uz.com.appwarehouse.dto.warehouse.WarehouseCreateDTO;
import uz.com.appwarehouse.dto.warehouse.WarehouseDTO;
import uz.com.appwarehouse.dto.warehouse.WarehouseUpdateDTO;
import uz.com.appwarehouse.service.WarehouseService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(BaseURI.API + BaseURI.V1 + BaseURI.WAREHOUSE)
public class WarehouseController {

    private final WarehouseService service;

    @GetMapping(BaseURI.GET + BaseURI.ALL)
    public ResponseEntity<ResponseData<List<WarehouseDTO>>> getAll() {
        return service.getAll();
    }

    @GetMapping(BaseURI.GET + "/{id}")
    public ResponseEntity<ResponseData<WarehouseDTO>> get(@PathVariable(value = "id") Integer id) {
        return service.get(id);
    }

    @PostMapping(BaseURI.ADD)
    public ResponseEntity<ResponseData<WarehouseDTO>> add(@Valid @RequestBody WarehouseCreateDTO dto) {
        return service.add(dto);
    }

    @PutMapping(BaseURI.EDIT)
    public ResponseEntity<ResponseData<WarehouseDTO>> edit(@Valid @RequestBody WarehouseUpdateDTO dto) {
        return service.edit(dto);
    }

    @DeleteMapping(BaseURI.DELETE + "/{id}")
    public ResponseEntity<ResponseData<Boolean>> delete(@PathVariable(value = "id") Integer id) {
        return service.delete(id);
    }

}
