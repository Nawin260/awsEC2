package com.devarinti.user_demo.Controller;

import com.devarinti.user_demo.DTO.CustomerDTO;
import com.devarinti.user_demo.Entity.Customer;
import com.devarinti.user_demo.Service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }

    @PostMapping("/signup")
    public ResponseEntity<CustomerDTO> signUp(@RequestBody Customer customer) {
        CustomerDTO response = customerService.signUp(customer);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/findById")
    public ResponseEntity<CustomerDTO> findById(@RequestParam String email){
        CustomerDTO response = customerService.findByEmail(email);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<CustomerDTO>> findById(){
        List<CustomerDTO> response = customerService.findAllEmail();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/home")
    public String homePage(){
        return "Hey there Welcome to Home Page.";
    }
    @GetMapping("/")
    public String login(){
        return "Hey you are in login Page.";
    }

    @GetMapping("/pb")
    public String vaishPage(){
        return "Hello Vaishhh PB";
    }
}
