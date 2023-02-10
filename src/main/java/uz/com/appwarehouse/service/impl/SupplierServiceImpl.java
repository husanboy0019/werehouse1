package uz.com.appwarehouse.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.com.appwarehouse.common.ResponseData;
import uz.com.appwarehouse.dto.supplier.SupplierCreateDTO;
import uz.com.appwarehouse.dto.supplier.SupplierDTO;
import uz.com.appwarehouse.dto.supplier.SupplierUpdateDTO;
import uz.com.appwarehouse.entity.Supplier;
import uz.com.appwarehouse.mapper.SupplierMapper;
import uz.com.appwarehouse.repo.SupplierRepo;
import uz.com.appwarehouse.service.SupplierService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepo repository;
    private final SupplierMapper mapper;

    @Override
    public ResponseEntity<ResponseData<List<SupplierDTO>>> getAll() {
        List<Supplier> list = repository.findAll();
        List<SupplierDTO> dtoList = new ArrayList<>();
        list.forEach(category -> dtoList.add(mapper.toDto(category)));
        return ResponseData.success200(dtoList);
    }

    @Override
    public ResponseEntity<ResponseData<SupplierDTO>> get(Integer id) {
        Optional<Supplier> supplierOptional = repository.findById(id);
        if (supplierOptional.isEmpty()) {
            throw new RuntimeException("Supplier is not found !!!");
        }
        return ResponseData.success200(mapper.toDto(supplierOptional.get()));
    }

    @Override
    public ResponseEntity<ResponseData<SupplierDTO>> add(SupplierCreateDTO dto) {
        Supplier supplier = mapper.toEntity(dto);
        repository.save(supplier);
        return ResponseData.success201(mapper.toDto(supplier));
    }

    @Override
    public ResponseEntity<ResponseData<SupplierDTO>> edit(SupplierUpdateDTO dto) {
        Optional<Supplier> supplierOptional = repository.findById(dto.getId());
        if (supplierOptional.isEmpty()) {
            throw new RuntimeException("Supplier is not found !!!");
        }
        Supplier category = mapper.toEntity(supplierOptional.get(), dto);
        repository.save(category);
        return ResponseData.success202(mapper.toDto(category));
    }

    @Override
    public ResponseEntity<ResponseData<Boolean>> delete(Integer id) {
        Optional<Supplier> supplierOptional = repository.findById(id);
        if (supplierOptional.isEmpty()) {
            throw new RuntimeException("Supplier is not found !!!");
        }
        repository.delete(supplierOptional.get());
        return ResponseData.success200(true);
    }

}
