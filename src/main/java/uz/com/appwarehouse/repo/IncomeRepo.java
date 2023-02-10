package uz.com.appwarehouse.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.com.appwarehouse.base.BaseRepository;
import uz.com.appwarehouse.entity.Income;

import java.time.LocalDateTime;

@Repository
public interface IncomeRepo extends BaseRepository<Income> {

    @Query(value = "SELECT sum(i.cost) from incomes t " +
            "inner join income_items i on t.id = i.income_id " +
            "where t.date_time between :from and :to ", nativeQuery = true)
    Integer sumTotalByDate(LocalDateTime from, LocalDateTime to);

}
