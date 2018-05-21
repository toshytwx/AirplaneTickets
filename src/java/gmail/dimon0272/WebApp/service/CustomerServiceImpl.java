package gmail.dimon0272.WebApp.service;

import gmail.dimon0272.WebApp.dao.CustomerDao;
import gmail.dimon0272.WebApp.model.Customer;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerDao customerDao;

    @PersistenceContext
    private EntityManager entityManager;

    private Query query;

    @Override
    public void saveCustomer(Customer customer) {
        customerDao.save(customer);
    }

    @Transactional
    public void updateCustomer(Customer customer) {
        entityManager.merge(customer);
    }

    public Customer findCustomerByName(String surname) {
        return customerDao.findBySurname(surname);
    }

    @Override
    public Customer findCustomerByPhone(String phoneNumber) {
        query = entityManager.createQuery("SELECT DISTINCT a FROM Customer a WHERE a.phoneNumber = :phoneNumber", Customer.class);
        query.setParameter("phoneNumber", phoneNumber);
        return (Customer) query.getSingleResult();
    }
}
