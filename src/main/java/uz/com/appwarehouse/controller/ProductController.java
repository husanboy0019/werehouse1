package uz.com.appwarehouse.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.com.appwarehouse.base.BaseURI;
import uz.com.appwarehouse.common.ResponseData;
import uz.com.appwarehouse.dto.product.ProductCreateDTO;
import uz.com.appwarehouse.dto.product.ProductDTO;
import uz.com.appwarehouse.dto.product.ProductUpdateDTO;
import uz.com.appwarehouse.service.ProductService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(BaseURI.API + BaseURI.V1 + BaseURI.PRODUCT)
public class ProductController {

    private final ProductService service;

    @GetMapping(BaseURI.GET + BaseURI.ALL)
    public ResponseEntity<ResponseData<List<ProductDTO>>> getAll() {
        return service.getAll();
    }

    @GetMapping(BaseURI.GET + "/{id}")
    public ResponseEntity<ResponseData<ProductDTO>> get(@PathVariable(value = "id") Integer id) {
        return service.get(id);
    }

    @PostMapping(BaseURI.ADD)
    public ResponseEntity<ResponseData<ProductDTO>> add(@Valid @RequestBody ProductCreateDTO dto) {
        return service.add(dto);
    }

    @PutMapping(BaseURI.EDIT)
    public ResponseEntity<ResponseData<ProductDTO>> edit(@Valid @RequestBody ProductUpdateDTO dto) {
        return service.edit(dto);
    }

    @DeleteMapping(BaseURI.DELETE + "/{id}")
    public ResponseEntity<ResponseData<Boolean>> delete(@PathVariable(value = "id") Integer id) {
        return service.delete(id);
    }

}
