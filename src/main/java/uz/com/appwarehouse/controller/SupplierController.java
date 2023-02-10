package uz.com.appwarehouse.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.com.appwarehouse.base.BaseURI;
import uz.com.appwarehouse.common.ResponseData;
import uz.com.appwarehouse.dto.supplier.SupplierCreateDTO;
import uz.com.appwarehouse.dto.supplier.SupplierDTO;
import uz.com.appwarehouse.dto.supplier.SupplierUpdateDTO;
import uz.com.appwarehouse.service.SupplierService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(BaseURI.API + BaseURI.V1 + BaseURI.SUPPLIER)
public class SupplierController {

    private final SupplierService service;

    @GetMapping(BaseURI.GET + BaseURI.ALL)
    public ResponseEntity<ResponseData<List<SupplierDTO>>> getAll() {
        return service.getAll();
    }

    @GetMapping(BaseURI.GET + "/{id}")
    public ResponseEntity<ResponseData<SupplierDTO>> get(@PathVariable(value = "id") Integer id) {
        return service.get(id);
    }

    @PostMapping(BaseURI.ADD)
    public ResponseEntity<ResponseData<SupplierDTO>> add(@Valid @RequestBody SupplierCreateDTO dto) {
        return service.add(dto);
    }

    @PutMapping(BaseURI.EDIT)
    public ResponseEntity<ResponseData<SupplierDTO>> edit(@Valid @RequestBody SupplierUpdateDTO dto) {
        return service.edit(dto);
    }

    @DeleteMapping(BaseURI.DELETE + "/{id}")
    public ResponseEntity<ResponseData<Boolean>> delete(@PathVariable(value = "id") Integer id) {
        return service.delete(id);
    }

}
