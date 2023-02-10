package uz.com.appwarehouse.repo;

import org.springframework.stereotype.Repository;
import uz.com.appwarehouse.base.BaseRepository;
import uz.com.appwarehouse.entity.IncomeItem;

import java.util.List;

@Repository
public interface IncomeItemRepo extends BaseRepository<IncomeItem> {

    List<IncomeItem> findAllByIncomeId(Integer incomeId);

}
