package uz.com.appwarehouse.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.com.appwarehouse.base.BaseURI;
import uz.com.appwarehouse.service.ReportService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping(BaseURI.API + BaseURI.V1 + BaseURI.REPORT)
public class ReportController {

    private final ReportService service;

    @GetMapping(BaseURI.PRODUCT)
    public void reportProducts(HttpServletRequest request, HttpServletResponse response) {
        try {
            service.getReportProductsFile(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
