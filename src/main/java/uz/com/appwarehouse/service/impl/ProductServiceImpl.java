package uz.com.appwarehouse.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.com.appwarehouse.common.ResponseData;
import uz.com.appwarehouse.dto.product.ProductCreateDTO;
import uz.com.appwarehouse.dto.product.ProductDTO;
import uz.com.appwarehouse.dto.product.ProductUpdateDTO;
import uz.com.appwarehouse.entity.Product;
import uz.com.appwarehouse.mapper.ProductMapper;
import uz.com.appwarehouse.repo.ProductRepo;
import uz.com.appwarehouse.service.FileService;
import uz.com.appwarehouse.service.ProductService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo repository;
    private final ProductMapper mapper;
    private final FileService fileService;

    @Override
    public List<Product> findAllByActive() {
        return repository.findAllByActiveIsTrueOrderByIdDesc();
    }

    @Override
    public ResponseEntity<ResponseData<List<ProductDTO>>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<ResponseData<ProductDTO>> get(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseData<ProductDTO>> add(ProductCreateDTO dto) {
        Product product = mapper.toEntity(dto);
        repository.save(product);
        fileService.attachProduct(dto.getFileIds(), product.getId());
        return ResponseData.success201(mapper.toDto(product));
    }

    @Override
    public ResponseEntity<ResponseData<ProductDTO>> edit(ProductUpdateDTO dto) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseData<Boolean>> delete(Integer id) {
        return null;
    }

}
