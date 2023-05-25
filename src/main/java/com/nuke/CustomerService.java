package com.nuke;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }
    public void addCustomer(Main.NewCustomerRequest request){
        Customer customer =  new Customer(request.name(), request.email(),request.age());
        customerRepository.save(customer);
    }
    public  void deleteCustomer(Integer id){
        customerRepository.deleteById(id);;
    }
    public void updateCustomer(Integer id, Main.NewCustomerRequest request){
        Customer customer = customerRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Customer Not Found"));
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setAge(request.age());
        customerRepository.save(customer);
    }
}
