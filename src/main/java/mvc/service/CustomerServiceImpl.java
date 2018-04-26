package mvc.service;

import mvc.Main;
import mvc.dao.CustomerDao;
import mvc.model.Customer;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerDao customerDao;

    public void saveCustomer(Customer customer) {
        customerDao.save(customer);
    }

    @Transactional
    public void updateCustomer(Customer customer) {
        try (final Session session = Main.getSession()) {
            session.merge(customer);
        }
    }

    public Customer findCustomerByName(String name) {
        return customerDao.findByCustomerName(name);
    }
}