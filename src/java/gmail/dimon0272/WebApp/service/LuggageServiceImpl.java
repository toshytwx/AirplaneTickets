package gmail.dimon0272.WebApp.service;

import gmail.dimon0272.WebApp.dao.LuggageDao;
import gmail.dimon0272.WebApp.model.Customer;
import gmail.dimon0272.WebApp.model.Luggage;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Service
public class LuggageServiceImpl implements LuggageService {
    @Autowired
    LuggageDao luggageDao;

    @PersistenceContext
    private EntityManager entityManager;

    private Query query;

    @Override
    public void saveLuggage(Luggage luggage) {
        luggageDao.save(luggage);
    }

    @Override
    public void updateLuggage(Luggage luggage) {
        entityManager.merge(luggage);
    }

    @Override
    @Transactional
    public Luggage findLuggageByOwner(Customer customer) {
        query = entityManager.createQuery("SELECT t FROM Luggage t WHERE t.id = :id", Luggage.class);
        query.setParameter("id", customer.getId());
        return (Luggage) query.getSingleResult();
    }
}
