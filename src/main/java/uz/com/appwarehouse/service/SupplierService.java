package uz.com.appwarehouse.service;

import org.springframework.http.ResponseEntity;
import uz.com.appwarehouse.common.ResponseData;
import uz.com.appwarehouse.dto.supplier.SupplierCreateDTO;
import uz.com.appwarehouse.dto.supplier.SupplierDTO;
import uz.com.appwarehouse.dto.supplier.SupplierUpdateDTO;

import java.util.List;

public interface SupplierService {

    ResponseEntity<ResponseData<List<SupplierDTO>>> getAll();

    ResponseEntity<ResponseData<SupplierDTO>> get(Integer id);

    ResponseEntity<ResponseData<SupplierDTO>> add(SupplierCreateDTO dto);

    ResponseEntity<ResponseData<SupplierDTO>> edit(SupplierUpdateDTO dto);

    ResponseEntity<ResponseData<Boolean>> delete(Integer id);

}
