package mvc.service;

import mvc.model.Customer;
import mvc.model.Luggage;

public interface LuggageService {
    void saveLuggage(Luggage luggage);
    void updateLuggage(Luggage luggage);
    Luggage findLuggageByOwner(Customer customer);
}
