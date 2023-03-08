package com.demo.redis.collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
public
class Address {
    @Id
    private String id;
    private String name;
    private String addressNumber;
    private String address;
}
