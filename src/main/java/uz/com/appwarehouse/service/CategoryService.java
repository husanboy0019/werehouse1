package uz.com.appwarehouse.service;

import org.springframework.http.ResponseEntity;
import uz.com.appwarehouse.common.ResponseData;
import uz.com.appwarehouse.dto.category.CategoryCreateDTO;
import uz.com.appwarehouse.dto.category.CategoryDTO;
import uz.com.appwarehouse.dto.category.CategoryUpdateDTO;
import uz.com.appwarehouse.exception.CustomNotFoundException;

import java.util.List;

public interface CategoryService {

    ResponseEntity<ResponseData<List<CategoryDTO>>> getAll();

    ResponseEntity<ResponseData<CategoryDTO>> get(Integer id);

    ResponseEntity<ResponseData<CategoryDTO>> add(CategoryCreateDTO dto);

    ResponseEntity<ResponseData<CategoryDTO>> edit(CategoryUpdateDTO dto) throws CustomNotFoundException;

    ResponseEntity<ResponseData<Boolean>> delete(Integer id);

}
