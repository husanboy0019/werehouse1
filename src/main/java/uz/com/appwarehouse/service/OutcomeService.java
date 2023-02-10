package uz.com.appwarehouse.service;

import org.springframework.http.ResponseEntity;
import uz.com.appwarehouse.common.ResponseData;
import uz.com.appwarehouse.dto.outcome.OutcomeCreateDTO;
import uz.com.appwarehouse.dto.outcome.OutcomeDTO;

import java.util.List;

public interface OutcomeService {

    ResponseEntity<ResponseData<List<OutcomeDTO>>> getAll();

    ResponseEntity<ResponseData<OutcomeDTO>> get(Integer id);

    ResponseEntity<ResponseData<OutcomeDTO>> add(OutcomeCreateDTO dto);

}
