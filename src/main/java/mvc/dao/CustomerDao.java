package mvc.dao;

import mvc.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer,Long>{
    Customer findByCustomerName(String name);
}
