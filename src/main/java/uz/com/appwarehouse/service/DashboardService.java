package uz.com.appwarehouse.service;

import org.springframework.http.ResponseEntity;
import uz.com.appwarehouse.common.ResponseData;

public interface DashboardService {

    ResponseEntity<ResponseData<Integer>> sumTotal(String from, String to);

    ResponseEntity<ResponseData<Integer>> sumTotal(String date);

}
