package uz.com.appwarehouse.service.impl;

import lombok.RequiredArgsConstructor;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.util.FileCopyUtils;
import uz.com.appwarehouse.entity.Product;
import uz.com.appwarehouse.service.ProductService;
import uz.com.appwarehouse.service.ReportService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final ProductService productService;
    private final VelocityEngine velocityEngine;

    private static final String EXCEL_EXTENSION = ".xls";

    @Override
    public void getReportProductsFile(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<Product> productList = productService.findAllByActive();

        Map<String, Object> map = new HashMap<>();
        map.put("list", productList);

        String code = VelocityEngineUtils.mergeTemplateIntoString(
                velocityEngine,
                "/templates/products.vm",
                map
        );

        String fileName = "products_" + System.currentTimeMillis() + EXCEL_EXTENSION;
        byte[] bytes = code.getBytes(StandardCharsets.UTF_8);

        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes)) {
            response.setContentType("application/x-ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

            FileCopyUtils.copy(inputStream, response.getOutputStream());
        }
    }

}
