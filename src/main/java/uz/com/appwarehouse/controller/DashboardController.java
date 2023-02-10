package uz.com.appwarehouse.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.com.appwarehouse.base.BaseURI;
import uz.com.appwarehouse.common.ResponseData;
import uz.com.appwarehouse.service.DashboardService;

@RestController
@RequiredArgsConstructor
@RequestMapping(BaseURI.API + BaseURI.V1 + BaseURI.DASHBOARD)
public class DashboardController {

    private final DashboardService service;

    @GetMapping(BaseURI.TOTAL)
    public ResponseEntity<ResponseData<Integer>> sumTotal(@RequestParam(value = "from") String from,
                                                          @RequestParam(value = "to") String to) {
        return service.sumTotal(from, to);
    }

    @GetMapping(BaseURI.TOTAL2)
    public ResponseEntity<ResponseData<Integer>> sumTotal2(@RequestParam(value = "date") String date) {
        return service.sumTotal(date);
    }

}
