package gmail.dimon0272.WebApp.service;

import gmail.dimon0272.WebApp.model.Customer;

public interface CustomerService {
    void saveCustomer(Customer customer);
    void updateCustomer(Customer customer);
    Customer findCustomerByName(String name);
    Customer findCustomerByPhone(String phoneNumber);
}
