package uz.com.appwarehouse.service;

import org.springframework.http.ResponseEntity;
import uz.com.appwarehouse.common.ResponseData;
import uz.com.appwarehouse.dto.employee.EmployeeCreateDTO;
import uz.com.appwarehouse.dto.employee.EmployeeDTO;
import uz.com.appwarehouse.dto.employee.EmployeeUpdateDTO;

import java.util.List;

public interface EmployeeService {

    ResponseEntity<ResponseData<List<EmployeeDTO>>> getAll();

    ResponseEntity<ResponseData<EmployeeDTO>> get(Integer id);

    ResponseEntity<ResponseData<EmployeeDTO>> add(EmployeeCreateDTO dto);

    ResponseEntity<ResponseData<EmployeeDTO>> edit(EmployeeUpdateDTO dto);

    ResponseEntity<ResponseData<Boolean>> delete(Integer id);

}
