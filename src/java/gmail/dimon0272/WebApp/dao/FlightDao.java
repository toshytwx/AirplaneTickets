package gmail.dimon0272.WebApp.dao;

import gmail.dimon0272.WebApp.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightDao extends JpaRepository<Flight, Long> {
}
