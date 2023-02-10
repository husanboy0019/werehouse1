package uz.com.appwarehouse.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.com.appwarehouse.base.BaseURI;
import uz.com.appwarehouse.common.ResponseData;
import uz.com.appwarehouse.dto.category.CategoryCreateDTO;
import uz.com.appwarehouse.dto.category.CategoryDTO;
import uz.com.appwarehouse.dto.category.CategoryUpdateDTO;
import uz.com.appwarehouse.exception.CustomNotFoundException;
import uz.com.appwarehouse.service.CategoryService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(BaseURI.API + BaseURI.V1 + BaseURI.CATEGORY)
public class CategoryController {

    private final CategoryService service;

    @GetMapping(BaseURI.GET + BaseURI.ALL)
    public ResponseEntity<ResponseData<List<CategoryDTO>>> getAll() {
        return service.getAll();
    }

    @GetMapping(BaseURI.GET + "/{id}")
    public ResponseEntity<ResponseData<CategoryDTO>> get(@PathVariable(value = "id") Integer id) {
        return service.get(id);
    }

    @PostMapping(BaseURI.ADD)
    public ResponseEntity<ResponseData<CategoryDTO>> add(@Valid @RequestBody CategoryCreateDTO dto) {
        return service.add(dto);
    }

    @PutMapping(BaseURI.EDIT)
    public ResponseEntity<ResponseData<CategoryDTO>> edit(@Valid @RequestBody CategoryUpdateDTO dto) throws CustomNotFoundException {
        return service.edit(dto);
    }

    @DeleteMapping(BaseURI.DELETE + "/{id}")
    public ResponseEntity<ResponseData<Boolean>> delete(@PathVariable(value = "id") Integer id) {
        return service.delete(id);
    }

}
