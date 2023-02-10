package uz.com.appwarehouse.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.com.appwarehouse.common.ResponseData;
import uz.com.appwarehouse.helper.Utils;
import uz.com.appwarehouse.service.DashboardService;
import uz.com.appwarehouse.service.IncomeService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {

    private final IncomeService incomeService;

    @Override
    public ResponseEntity<ResponseData<Integer>> sumTotal(String from, String to) {
        LocalDateTime fromTime = Utils.toLocalDateTime(from);
        LocalDateTime toTime = Utils.toLocalDateTime(to);
        return ResponseData.success200(incomeService.sumTotal(fromTime, toTime));
    }

    @Override
    public ResponseEntity<ResponseData<Integer>> sumTotal(String date) {
        LocalDate localDate = Utils.toLocalDate(date);
        LocalDateTime fromTime = LocalDateTime.of(localDate, LocalTime.MIN);
        LocalDateTime toTime = LocalDateTime.of(localDate, LocalTime.MAX);
        return ResponseData.success200(incomeService.sumTotal(fromTime, toTime));
    }
}
