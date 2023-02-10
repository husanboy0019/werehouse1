package uz.com.appwarehouse.repo;

import org.springframework.stereotype.Repository;
import uz.com.appwarehouse.base.BaseRepository;
import uz.com.appwarehouse.entity.OutcomeItem;

import java.util.List;

@Repository
public interface OutcomeItemRepo extends BaseRepository<OutcomeItem> {

    List<OutcomeItem> findAllByOutcomeId(Integer outcomeId);

}
