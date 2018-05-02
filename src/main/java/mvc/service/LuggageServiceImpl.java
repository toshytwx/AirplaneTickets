package mvc.service;

import mvc.dao.LuggageDao;
import mvc.model.Customer;
import mvc.model.Luggage;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utils.SessionUtils;

@Service
public class LuggageServiceImpl implements LuggageService {
    @Autowired
    LuggageDao luggageDao;

    @Override
    public void saveLuggage(Luggage luggage) {
        luggageDao.save(luggage);
    }

    @Override
    public void updateLuggage(Luggage luggage) {
        try (Session session = SessionUtils.getSession()) {
            session.merge(luggage);
        }
    }

    @Override
    @Transactional
    public Luggage findLuggageByOwner(Customer customer) {
        return luggageDao.findByOwner(customer);
    }
}
