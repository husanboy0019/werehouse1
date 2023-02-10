package uz.com.appwarehouse.service;

import org.springframework.http.ResponseEntity;
import uz.com.appwarehouse.common.ResponseData;
import uz.com.appwarehouse.dto.warehouse.WarehouseCreateDTO;
import uz.com.appwarehouse.dto.warehouse.WarehouseDTO;
import uz.com.appwarehouse.dto.warehouse.WarehouseUpdateDTO;

import java.util.List;

public interface WarehouseService {

    ResponseEntity<ResponseData<List<WarehouseDTO>>> getAll();

    ResponseEntity<ResponseData<WarehouseDTO>> get(Integer id);

    ResponseEntity<ResponseData<WarehouseDTO>> add(WarehouseCreateDTO dto);

    ResponseEntity<ResponseData<WarehouseDTO>> edit(WarehouseUpdateDTO dto);

    ResponseEntity<ResponseData<Boolean>> delete(Integer id);

}
