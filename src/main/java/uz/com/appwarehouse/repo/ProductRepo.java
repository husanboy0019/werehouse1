package uz.com.appwarehouse.repo;

import org.springframework.stereotype.Repository;
import uz.com.appwarehouse.base.BaseRepository;
import uz.com.appwarehouse.entity.Product;

import java.util.List;

@Repository
public interface ProductRepo extends BaseRepository<Product> {

    List<Product> findAllByActiveIsTrueOrderByIdDesc();

}
