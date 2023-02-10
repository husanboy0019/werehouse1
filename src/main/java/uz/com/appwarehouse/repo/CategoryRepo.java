package uz.com.appwarehouse.repo;

import org.springframework.stereotype.Repository;
import uz.com.appwarehouse.base.BaseRepository;
import uz.com.appwarehouse.entity.Category;

@Repository
public interface CategoryRepo extends BaseRepository<Category> {
}
