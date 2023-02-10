package uz.com.appwarehouse.service;

import org.springframework.http.ResponseEntity;
import uz.com.appwarehouse.common.ResponseData;
import uz.com.appwarehouse.dto.income.IncomeCreateDTO;
import uz.com.appwarehouse.dto.income.IncomeDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface IncomeService {

    ResponseEntity<ResponseData<List<IncomeDTO>>> getAll();

    ResponseEntity<ResponseData<IncomeDTO>> get(Integer id);

    ResponseEntity<ResponseData<IncomeDTO>> add(IncomeCreateDTO dto);

    Integer sumTotal(LocalDateTime from, LocalDateTime to);

}
