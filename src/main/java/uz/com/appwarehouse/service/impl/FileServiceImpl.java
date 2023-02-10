package uz.com.appwarehouse.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import uz.com.appwarehouse.common.ResponseData;
import uz.com.appwarehouse.dto.file.ProductFileDTO;
import uz.com.appwarehouse.entity.ProductFile;
import uz.com.appwarehouse.helper.Utils;
import uz.com.appwarehouse.mapper.ProductFileMapper;
import uz.com.appwarehouse.repo.ProductFileRepo;
import uz.com.appwarehouse.service.FileService;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final ProductFileRepo repository;
    private final ProductFileMapper mapper;

    private final Path root = Paths.get("D:\\MyFiles");

    @Override
    public ResponseEntity<ResponseData<List<ProductFileDTO>>> getAllByProduct(Integer productId) {
        List<ProductFile> list = repository.findAllByProductId(productId);
        List<ProductFileDTO> responseList = new ArrayList<>();
        for (ProductFile file : list) {
            ProductFileDTO dto = mapper.toDto(file);
            responseList.add(dto);
        }
        return ResponseData.success200(responseList);
    }

    @Override
    public ResponseEntity<ResponseData<ProductFileDTO>> upload(MultipartFile file) {
        final String fileOriginalName = file.getOriginalFilename();
        if (!StringUtils.hasText(fileOriginalName)) {
            throw new RuntimeException("File name should not be null !!!");
        }

        String format = fileOriginalName.split("\\.")[1];

        final String fileName = UUID.randomUUID().toString() + "." + format;

        // save file to my files
        try {
            Files.copy(file.getInputStream(), root.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ProductFile productFile = new ProductFile();
        productFile.setName(fileName);
        productFile.setOriginalName(fileOriginalName);
        productFile.setSize(file.getSize());
        productFile.setMimeType(file.getContentType());
        repository.save(productFile);

        return ResponseData.success201(mapper.toDto(productFile));
    }

    @Override
    public void download(String name, HttpServletResponse response) {
        Optional<ProductFile> productFileOptional = repository.findByName(name);
        if (productFileOptional.isEmpty()) {
            throw new RuntimeException("File is not found !!!");
        }
        ProductFile file = productFileOptional.get();

        response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getOriginalName() + "\"");
        response.setContentType(file.getMimeType());

        Path filePath = root.resolve(name).normalize();

        try {
            FileCopyUtils.copy(new FileInputStream(filePath.toString()), response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void attachProduct(List<Integer> ids, Integer productId) {
        List<ProductFile> files = new ArrayList<>();
        for (Integer id : ids) {
            Optional<ProductFile> productFileOptional = repository.findById(id);
            if (productFileOptional.isPresent()) {
                ProductFile file = productFileOptional.get();
                file.setProductId(productId);
                files.add(file);
            }
        }
        if (Utils.isPresent(files)) {
            repository.saveAll(files);
        }
    }

}
