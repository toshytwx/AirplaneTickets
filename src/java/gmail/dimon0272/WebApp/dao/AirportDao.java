package gmail.dimon0272.WebApp.dao;

import gmail.dimon0272.WebApp.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirportDao extends JpaRepository<Airport, Long> {
    Airport findAirportByName(String name);
}
