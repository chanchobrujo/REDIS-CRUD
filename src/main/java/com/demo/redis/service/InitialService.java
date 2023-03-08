package com.demo.redis.service;

import com.demo.redis.collection.Address;
import com.demo.redis.collection.Customer;
import com.demo.redis.repository.CustomerRepository;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;

@Component
@RequiredArgsConstructor
public
class InitialService implements CommandLineRunner {
    private final CustomerRepository repository;

    @Override
    public
    void run (String... args) {
        Faker faker = new Faker();
        Address address = new Address();
        address.setAddress(faker.address().streetAddress());
        address.setAddressNumber(faker.address().streetAddressNumber());
        address.setName(faker.address().cityName());
        Customer customer = new Customer();
        customer.setName(faker.name().firstName());
        customer.setLastName(faker.name().lastName());
        customer.setAddress(address);
        this.repository.save(customer);
        this.repository.findAll().forEach(cus -> {
            System.out.println(cus.getName());
        });
    }
}
