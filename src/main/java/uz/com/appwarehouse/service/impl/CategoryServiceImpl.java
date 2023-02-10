package uz.com.appwarehouse.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.com.appwarehouse.common.ResponseData;
import uz.com.appwarehouse.dto.category.CategoryCreateDTO;
import uz.com.appwarehouse.dto.category.CategoryDTO;
import uz.com.appwarehouse.dto.category.CategoryUpdateDTO;
import uz.com.appwarehouse.entity.Category;
import uz.com.appwarehouse.exception.CustomNotFoundException;
import uz.com.appwarehouse.mapper.CategoryMapper;
import uz.com.appwarehouse.repo.CategoryRepo;
import uz.com.appwarehouse.service.CategoryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo repository;
    private final CategoryMapper mapper;

    @Override
    public ResponseEntity<ResponseData<List<CategoryDTO>>> getAll() {
        List<Category> list = repository.findAll();
        List<CategoryDTO> dtoList = new ArrayList<>();
        list.forEach(category -> dtoList.add(mapper.toDto(category)));
        return ResponseData.success200(dtoList);
    }

    @Override
    public ResponseEntity<ResponseData<CategoryDTO>> get(Integer id) {
        Optional<Category> categoryOptional = repository.findById(id);
        if (categoryOptional.isEmpty()) {
            throw new RuntimeException("Category is not found !!!");
        }
        return ResponseData.success200(mapper.toDto(categoryOptional.get()));
    }

    @Override
    public ResponseEntity<ResponseData<CategoryDTO>> add(CategoryCreateDTO dto) {
        Category category = mapper.toEntity(dto);
        repository.save(category);
        return ResponseData.success201(mapper.toDto(category));
    }

    @Override
    public ResponseEntity<ResponseData<CategoryDTO>> edit(CategoryUpdateDTO dto) throws CustomNotFoundException {
        Optional<Category> categoryOptional = repository.findById(dto.getId());
        if (categoryOptional.isEmpty()) {
            throw new CustomNotFoundException("Category is not found !!!");
        }
        Category category = mapper.toEntity(categoryOptional.get(), dto);
        repository.save(category);
        return ResponseData.success202(mapper.toDto(category));
    }

    @Override
    public ResponseEntity<ResponseData<Boolean>> delete(Integer id) {
        Optional<Category> categoryOptional = repository.findById(id);
        if (categoryOptional.isEmpty()) {
            throw new RuntimeException("Category is not found !!!");
        }
        repository.delete(categoryOptional.get());
        return ResponseData.success200(true);
    }

}
