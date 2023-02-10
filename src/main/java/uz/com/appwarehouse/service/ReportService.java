package uz.com.appwarehouse.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ReportService {

    void getReportProductsFile(HttpServletRequest request, HttpServletResponse response) throws IOException;

}
