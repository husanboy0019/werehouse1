package uz.com.appwarehouse.repo;

import org.springframework.stereotype.Repository;
import uz.com.appwarehouse.base.BaseRepository;
import uz.com.appwarehouse.entity.Employee;

@Repository
public interface EmployeeRepo extends BaseRepository<Employee> {
}
