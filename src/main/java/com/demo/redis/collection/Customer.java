package com.demo.redis.collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
@RedisHash("customer")
public
class Customer {
    @Id
    private String id;
    private String name;
    private String lastName;
    private Address address;
}
