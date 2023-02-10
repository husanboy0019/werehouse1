package uz.com.appwarehouse.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.com.appwarehouse.common.ResponseData;
import uz.com.appwarehouse.dto.employee.EmployeeCreateDTO;
import uz.com.appwarehouse.dto.employee.EmployeeDTO;
import uz.com.appwarehouse.dto.employee.EmployeeUpdateDTO;
import uz.com.appwarehouse.entity.Employee;
import uz.com.appwarehouse.mapper.EmployeeMapper;
import uz.com.appwarehouse.repo.EmployeeRepo;
import uz.com.appwarehouse.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo repository;
    private final EmployeeMapper mapper;

    @Override
    public ResponseEntity<ResponseData<List<EmployeeDTO>>> getAll() {
        List<Employee> list = repository.findAll();
        List<EmployeeDTO> dtoList = new ArrayList<>();
        list.forEach(employee -> dtoList.add(mapper.toDto(employee)));
        return ResponseData.success200(dtoList);
    }

    @Override
    public ResponseEntity<ResponseData<EmployeeDTO>> get(Integer id) {
        Optional<Employee> employeeOptional = repository.findById(id);
        if (employeeOptional.isEmpty()) {
            throw new RuntimeException("Employee is not found !!!");
        }
        return ResponseData.success200(mapper.toDto(employeeOptional.get()));
    }

    @Override
    public ResponseEntity<ResponseData<EmployeeDTO>> add(EmployeeCreateDTO dto) {
        Employee employee = mapper.toEntity(dto);
        repository.save(employee);
        return ResponseData.success201(mapper.toDto(employee));
    }

    @Override
    public ResponseEntity<ResponseData<EmployeeDTO>> edit(EmployeeUpdateDTO dto) {
        Optional<Employee> employeeOptional = repository.findById(dto.getId());
        if (employeeOptional.isEmpty()) {
            throw new RuntimeException("Employee is not found !!!");
        }
        Employee employee = mapper.toEntity(employeeOptional.get(), dto);
        repository.save(employee);
        return ResponseData.success201(mapper.toDto(employee));
    }

    @Override
    public ResponseEntity<ResponseData<Boolean>> delete(Integer id) {
        Optional<Employee> employeeOptional = repository.findById(id);
        if (employeeOptional.isEmpty()) {
            throw new RuntimeException("Employee is not found !!!");
        }
        repository.delete(employeeOptional.get());
        return ResponseData.success200(true);
    }

}
