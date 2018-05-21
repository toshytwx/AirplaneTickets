package gmail.dimon0272.WebApp.dao;

import gmail.dimon0272.WebApp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, Long>
{
    Customer findBySurname(String surname);
}
