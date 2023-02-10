package uz.com.appwarehouse.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.com.appwarehouse.common.ResponseData;
import uz.com.appwarehouse.dto.warehouse.WarehouseCreateDTO;
import uz.com.appwarehouse.dto.warehouse.WarehouseDTO;
import uz.com.appwarehouse.dto.warehouse.WarehouseUpdateDTO;
import uz.com.appwarehouse.entity.Warehouse;
import uz.com.appwarehouse.mapper.WarehouseMapper;
import uz.com.appwarehouse.repo.WarehouseRepo;
import uz.com.appwarehouse.service.WarehouseService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {

    private final WarehouseRepo repository;
    private final WarehouseMapper mapper;

    @Override
    public ResponseEntity<ResponseData<List<WarehouseDTO>>> getAll() {
        List<Warehouse> list = repository.findAll();
        List<WarehouseDTO> dtoList = new ArrayList<>();
        list.forEach(warehouse -> dtoList.add(mapper.toDto(warehouse)));
        return ResponseData.success200(dtoList);
    }

    @Override
    public ResponseEntity<ResponseData<WarehouseDTO>> get(Integer id) {
        Optional<Warehouse> warehouseOptional = repository.findById(id);
        if (warehouseOptional.isEmpty()) {
            throw new RuntimeException("Warehouse is not found !!!");
        }
        return ResponseData.success200(mapper.toDto(warehouseOptional.get()));
    }

    @Override
    public ResponseEntity<ResponseData<WarehouseDTO>> add(WarehouseCreateDTO dto) {
        Warehouse warehouse = mapper.toEntity(dto);
        repository.save(warehouse);
        return ResponseData.success201(mapper.toDto(warehouse));
    }

    @Override
    public ResponseEntity<ResponseData<WarehouseDTO>> edit(WarehouseUpdateDTO dto) {
        Optional<Warehouse> warehouseOptional = repository.findById(dto.getId());
        if (warehouseOptional.isEmpty()) {
            throw new RuntimeException("Warehouse is not found !!!");
        }
        Warehouse warehouse = mapper.toEntity(warehouseOptional.get(), dto);
        repository.save(warehouse);
        return ResponseData.success202(mapper.toDto(warehouse));
    }

    @Override
    public ResponseEntity<ResponseData<Boolean>> delete(Integer id) {
        Optional<Warehouse> warehouseOptional = repository.findById(id);
        if (warehouseOptional.isEmpty()) {
            throw new RuntimeException("Warehouse is not found !!!");
        }
        repository.delete(warehouseOptional.get());
        return ResponseData.success200(true);
    }

}
