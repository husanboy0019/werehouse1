package uz.com.appwarehouse.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.com.appwarehouse.base.BaseURI;
import uz.com.appwarehouse.common.ResponseData;
import uz.com.appwarehouse.dto.file.ProductFileDTO;
import uz.com.appwarehouse.service.FileService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(BaseURI.API + BaseURI.V1 + BaseURI.FILE)
public class FileController {

    private final FileService service;

    @GetMapping(BaseURI.GET + BaseURI.ALL + "/{productId}")
    public ResponseEntity<ResponseData<List<ProductFileDTO>>> getAllByProduct(@PathVariable(value = "productId") Integer productId) {
        return service.getAllByProduct(productId);
    }

    @PostMapping(BaseURI.UPLOAD)
    public ResponseEntity<ResponseData<ProductFileDTO>> upload(@RequestParam(value = "file") MultipartFile file) {
        return service.upload(file);
    }

    @GetMapping(BaseURI.DOWNLOAD + "/{filename:.+}")
    public void download(@PathVariable(name = "filename") String name, HttpServletResponse response) {
        service.download(name, response);
    }

}
