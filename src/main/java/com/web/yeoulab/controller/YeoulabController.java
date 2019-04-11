package com.web.yeoulab.controller;

import com.web.yeoulab.model.Customer;
import com.web.yeoulab.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping({"/test"})
public class YeoulabController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/")
    public String getHome(){
        return "Here is Yeoulab's home";
    }

    @GetMapping(path = {"/thread"})
    public List<Customer> findAll() throws InterruptedException {
        Date date = new Date();
        long time = date.getTime();
        System.out.println("@@@ find All Function Start : " + time);
        Thread.sleep(10000);
        Date date2 = new Date();
        long time2 = date2.getTime();
        System.out.println("@@@ After Thread Sleep @@@ : " +time2);
        List<Customer> cList = customerRepository.findAll();
        return customerRepository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Customer> findById(@PathVariable Long id){
        System.out.println("id : "+id);
        return customerRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Customer create(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }
}
