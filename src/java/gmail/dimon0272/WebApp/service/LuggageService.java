package gmail.dimon0272.WebApp.service;

import gmail.dimon0272.WebApp.model.Customer;
import gmail.dimon0272.WebApp.model.Luggage;

public interface LuggageService {
    void saveLuggage(Luggage luggage);
    void updateLuggage(Luggage luggage);
    Luggage findLuggageByOwner(Customer customer);
}
