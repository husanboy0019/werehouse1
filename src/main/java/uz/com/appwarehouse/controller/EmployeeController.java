package uz.com.appwarehouse.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.com.appwarehouse.base.BaseURI;
import uz.com.appwarehouse.common.ResponseData;
import uz.com.appwarehouse.dto.employee.EmployeeCreateDTO;
import uz.com.appwarehouse.dto.employee.EmployeeDTO;
import uz.com.appwarehouse.dto.employee.EmployeeUpdateDTO;
import uz.com.appwarehouse.service.EmployeeService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(BaseURI.API + BaseURI.V1 + BaseURI.EMPLOYEE)
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping(BaseURI.GET + BaseURI.ALL)
    public ResponseEntity<ResponseData<List<EmployeeDTO>>> getAll() {
        return service.getAll();
    }

    @GetMapping(BaseURI.GET + "/{id}")
    public ResponseEntity<ResponseData<EmployeeDTO>> get(@PathVariable(value = "id") Integer id) {
        return service.get(id);
    }

    @PostMapping(BaseURI.ADD)
    public ResponseEntity<ResponseData<EmployeeDTO>> add(@Valid @RequestBody EmployeeCreateDTO dto) {
        return service.add(dto);
    }

    @PutMapping(BaseURI.EDIT)
    public ResponseEntity<ResponseData<EmployeeDTO>> edit(@Valid @RequestBody EmployeeUpdateDTO dto) {
        return service.edit(dto);
    }

    @DeleteMapping(BaseURI.DELETE + "/{id}")
    public ResponseEntity<ResponseData<Boolean>> delete(@PathVariable(value = "id") Integer id) {
        return service.delete(id);
    }

}
