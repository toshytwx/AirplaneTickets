package mvc.dao;

import mvc.model.Customer;
import mvc.model.Luggage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LuggageDao extends JpaRepository<Luggage, Long> {
    Luggage findByOwner(Customer customer);
}
