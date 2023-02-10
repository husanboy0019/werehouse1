package uz.com.appwarehouse.service;

import org.springframework.http.ResponseEntity;
import uz.com.appwarehouse.common.ResponseData;
import uz.com.appwarehouse.dto.product.ProductCreateDTO;
import uz.com.appwarehouse.dto.product.ProductDTO;
import uz.com.appwarehouse.dto.product.ProductUpdateDTO;
import uz.com.appwarehouse.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAllByActive();

    ResponseEntity<ResponseData<List<ProductDTO>>> getAll();

    ResponseEntity<ResponseData<ProductDTO>> get(Integer id);

    ResponseEntity<ResponseData<ProductDTO>> add(ProductCreateDTO dto);

    ResponseEntity<ResponseData<ProductDTO>> edit(ProductUpdateDTO dto);

    ResponseEntity<ResponseData<Boolean>> delete(Integer id);

}
