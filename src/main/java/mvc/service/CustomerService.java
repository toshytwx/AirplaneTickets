package mvc.service;

import mvc.model.Customer;

public interface CustomerService {
    void saveCustomer(Customer customer);
    void updateCustomer(Customer customer);
    Customer findCustomerByName(String name);
}
