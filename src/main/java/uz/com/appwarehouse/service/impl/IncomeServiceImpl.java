package uz.com.appwarehouse.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.com.appwarehouse.common.ResponseData;
import uz.com.appwarehouse.dto.income.IncomeCreateDTO;
import uz.com.appwarehouse.dto.income.IncomeDTO;
import uz.com.appwarehouse.entity.Income;
import uz.com.appwarehouse.entity.IncomeItem;
import uz.com.appwarehouse.mapper.IncomeItemMapper;
import uz.com.appwarehouse.mapper.IncomeMapper;
import uz.com.appwarehouse.repo.IncomeItemRepo;
import uz.com.appwarehouse.repo.IncomeRepo;
import uz.com.appwarehouse.service.IncomeService;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IncomeServiceImpl implements IncomeService {

    private final IncomeRepo repository;
    private final IncomeItemRepo itemRepository;
    private final IncomeMapper mapper;
    private final IncomeItemMapper itemMapper;

    @Override
    public ResponseEntity<ResponseData<List<IncomeDTO>>> getAll() {
        List<Income> list = repository.findAll();
        List<IncomeDTO> dtoList = new ArrayList<>();
        list.forEach(income -> {
            List<IncomeItem> itemList = itemRepository.findAllByIncomeId(income.getId());
            dtoList.add(generateDto(income, itemList));
        });
        return ResponseData.success200(dtoList);
    }

    @Override
    public ResponseEntity<ResponseData<IncomeDTO>> get(Integer id) {
        Optional<Income> incomeOptional = repository.findById(id);
        if (incomeOptional.isEmpty()) {
            throw new RuntimeException("Income is not found !!!");
        }
        Income income = incomeOptional.get();
        List<IncomeItem> itemList = itemRepository.findAllByIncomeId(income.getId());
        return ResponseData.success200(generateDto(income, itemList));
    }

    @Override
    public ResponseEntity<ResponseData<IncomeDTO>> add(IncomeCreateDTO dto) {
        Income income = mapper.toEntity(dto);
        repository.save(income);

        Integer incomeId = income.getId();
        Income saved = repository.findById(incomeId).get();

        List<IncomeItem> items = new ArrayList<>();
        dto.getItems().forEach(itemDto -> {
            itemDto.setIncomeId(incomeId);
            items.add(itemMapper.toEntity(itemDto));
        });
        if (!items.isEmpty()) {
            itemRepository.saveAll(items);
        }
        return ResponseData.success201(generateDto(saved, items));
    }

    @Override
    public Integer sumTotal(LocalDateTime from, LocalDateTime to) {
        return repository.sumTotalByDate(from, to);
    }

    private IncomeDTO generateDto(Income income, List<IncomeItem> items) {
        IncomeDTO dto = mapper.toDto(income);
        dto.setItems(itemMapper.toDto(items));
        return dto;
    }

}
