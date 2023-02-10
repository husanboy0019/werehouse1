package uz.com.appwarehouse.repo;

import org.springframework.stereotype.Repository;
import uz.com.appwarehouse.base.BaseRepository;
import uz.com.appwarehouse.entity.ProductFile;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductFileRepo extends BaseRepository<ProductFile> {

    Optional<ProductFile> findByName(String name);

    List<ProductFile> findAllByProductId(Integer productId);

}
