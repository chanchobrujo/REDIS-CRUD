package com.demo.redis.repository;

import com.demo.redis.util.MapperUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public
class RedisRepository {

    private final HashOperations<String, String, String> redisOperator;

    @Autowired
    public RedisRepository (RedisTemplate<String, String> redisTemplate) {
        this.redisOperator = redisTemplate.opsForHash();
    }

    public <T> void insertOrReplace(T value) {
        String json = MapperUtils.toJsonString(value);
        this.redisOperator.put("hash-entitites", "customer", json);
    }

    public <T> Optional<T> getAndParse(String redisKey, String redisHashKey, Class<T> dataType){
        String data = this.redisOperator.get(redisKey, redisHashKey);

        if(Objects.isNull(data))
            return Optional.empty();

        try {
            /**
             * ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
             * 			return Optional.of(mapper.readValue(data, dataType));
             */
            return Optional.empty();
        } catch (Exception e) {
            log.error("[Redis Entity]: {}, [Redis Key]: {}", redisKey, redisHashKey);
            return Optional.empty();
        }
    }
}
