package com.demo.redis.repository;

import com.demo.redis.collection.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public
interface CustomerRepository extends JpaRepository<Customer, String> {

}
