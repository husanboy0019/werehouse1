package uz.com.appwarehouse.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import uz.com.appwarehouse.common.ResponseData;
import uz.com.appwarehouse.dto.file.ProductFileDTO;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface FileService {

    ResponseEntity<ResponseData<List<ProductFileDTO>>> getAllByProduct(Integer productId);

    ResponseEntity<ResponseData<ProductFileDTO>> upload(MultipartFile file);

    void download(String name, HttpServletResponse response);

    void attachProduct(List<Integer> ids, Integer productId);

}
