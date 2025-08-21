package com.devarinti.user_demo.Service;

import com.devarinti.user_demo.DTO.CustomerDTO;
import com.devarinti.user_demo.Entity.Customer;
import com.devarinti.user_demo.Exceptions.CustomerExistException;
import com.devarinti.user_demo.Interface.CustomerMapper;
import com.devarinti.user_demo.Repository.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepo customerRepo;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepo customerRepo, CustomerMapper customerMapper) {
        this.customerRepo = customerRepo;
        this.customerMapper=customerMapper;
    }

    public CustomerDTO signUp(Customer customer) {
        if(customerRepo.existsById(customer.getEmail())){
            throw new CustomerExistException("Customer with email " + customer.getEmail() + " already exists.");
        }

        Customer saved = customerRepo.save(customer);
        return customerMapper.toDTO(saved);

    }

    public CustomerDTO findByEmail(String email) {
        if(!customerRepo.existsById(email)){
            throw new CustomerExistException("Customer with email " + email + " not exists. Please signUp");
        }

        Optional<Customer> exists = customerRepo.findById(email);
        if(exists.isPresent()){
            return customerMapper.toDTO(exists.get());
        }

        throw new RuntimeException("Unexpected error occurred while retrieving customer with email: " + email);

    }

    public List<CustomerDTO> findAllEmail() {
        List<Customer> customers = customerRepo.findAll();
        List<CustomerDTO> customerDTOs = new ArrayList<>();

        for (Customer customer : customers) {
            CustomerDTO dto = new CustomerDTO();
            dto.setEmail(customer.getEmail());
            customerDTOs.add(dto);
        }
        return customerDTOs;
    }

}
