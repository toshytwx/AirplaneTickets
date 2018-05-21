package gmail.dimon0272.WebApp.dao;

import gmail.dimon0272.WebApp.model.Customer;
import gmail.dimon0272.WebApp.model.Luggage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LuggageDao extends JpaRepository<Luggage, Long>
{
    Luggage findByOwner(Customer customer);
}
