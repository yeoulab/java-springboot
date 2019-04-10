package com.web;

import com.web.yeoulab.model.Customer;
import com.web.yeoulab.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.LongStream;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] arg){

        SpringApplication.run(MainApplication.class, arg);
    }

    @Bean
    CommandLineRunner init(CustomerRepository customerRepository){
        return args -> {
            customerRepository.deleteAll();
            LongStream.range(1, 11)
                    .mapToObj(i -> {
                    Customer c = new Customer();
                    c.setName("Name" + i);
                    c.setEmail("email" + i + "@email.com");
                    c.setPwd("111" + i);
                    return c;
            }).map(v -> customerRepository.save(v)).forEach(System.out::println);
        };
    }
}