package com.demo.redis.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public
class CustomerDto {
    private String id;
    private String name;
    private String lastName;
}
