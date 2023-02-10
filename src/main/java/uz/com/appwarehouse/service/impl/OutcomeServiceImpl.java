package uz.com.appwarehouse.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.com.appwarehouse.common.ResponseData;
import uz.com.appwarehouse.dto.outcome.OutcomeCreateDTO;
import uz.com.appwarehouse.dto.outcome.OutcomeDTO;
import uz.com.appwarehouse.entity.Outcome;
import uz.com.appwarehouse.entity.OutcomeItem;
import uz.com.appwarehouse.mapper.OutcomeItemMapper;
import uz.com.appwarehouse.mapper.OutcomeMapper;
import uz.com.appwarehouse.repo.OutcomeItemRepo;
import uz.com.appwarehouse.repo.OutcomeRepo;
import uz.com.appwarehouse.service.OutcomeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OutcomeServiceImpl implements OutcomeService {

    private final OutcomeRepo repository;
    private final OutcomeItemRepo itemRepository;
    private final OutcomeMapper mapper;
    private final OutcomeItemMapper itemMapper;

    @Override
    public ResponseEntity<ResponseData<List<OutcomeDTO>>> getAll() {
        List<Outcome> list = repository.findAll();
        List<OutcomeDTO> dtoList = new ArrayList<>();
        list.forEach(outcome -> {
            List<OutcomeItem> itemList = itemRepository.findAllByOutcomeId(outcome.getId());
            dtoList.add(generateDto(outcome, itemList));
        });
        return ResponseData.success200(dtoList);
    }

    @Override
    public ResponseEntity<ResponseData<OutcomeDTO>> get(Integer id) {
        Optional<Outcome> outcomeOptional = repository.findById(id);
        if (outcomeOptional.isEmpty()) {
            throw new RuntimeException("Outcome is not found !!!");
        }
        Outcome outcome = outcomeOptional.get();
        List<OutcomeItem> itemList = itemRepository.findAllByOutcomeId(outcome.getId());
        return ResponseData.success200(generateDto(outcome, itemList));
    }

    @Override
    public ResponseEntity<ResponseData<OutcomeDTO>> add(OutcomeCreateDTO dto) {
        Outcome outcome = mapper.toEntity(dto);
        repository.save(outcome);

        Integer outcomeId = outcome.getId();

        List<OutcomeItem> items = new ArrayList<>();
        dto.getItems().forEach(itemDto -> {
            itemDto.setOutcomeId(outcomeId);
            items.add(itemMapper.toEntity(itemDto));
        });
        if (!items.isEmpty()) {
            itemRepository.saveAll(items);
        }
        return ResponseData.success201(generateDto(outcome, items));
    }

    private OutcomeDTO generateDto(Outcome outcome, List<OutcomeItem> items) {
        OutcomeDTO dto = mapper.toDto(outcome);
        dto.setItems(itemMapper.toDto(items));
        return dto;
    }

}
