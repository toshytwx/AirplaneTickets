package gmail.dimon0272.WebApp.actions;

import gmail.dimon0272.WebApp.model.Customer;
import gmail.dimon0272.WebApp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

public class AddCustomerAction implements Action {
    private CustomerService customerService;
    private Customer customer;

    public AddCustomerAction(CustomerService customerService, Customer customer) {
        this.customerService = customerService;
        this.customer = customer;
    }

    @Override
    public void execute() {
        customerService.saveCustomer(customer);
    }
}
