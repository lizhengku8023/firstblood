package com.example.demotest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.UUID;

/**
 * 分布式redis锁的简单实现
 */
public class RedisLock {
    @Autowired
    JedisPool jedisPool;

    public String lockWithTimeOut(String lockName,Long acquireTimeOut,Long timeOut){
        Jedis jedis = jedisPool.getResource();

        //随机生成一个id
        String identifier = UUID.randomUUID().toString();
        //锁名
        String lockKey = "lock:" + lockName;
        //锁的超时时间，多久后自动释放锁
        int lockExpire = (int) (timeOut/1000);
        //超过这个时间，自动放弃锁
        Long end = System.currentTimeMillis() + acquireTimeOut;
        while (System.currentTimeMillis() < end){
            if (jedis.setnx(lockKey,identifier) == 1){
                jedis.expire(lockKey,lockExpire);
                return identifier;
            }
        }
        return null;
    }
}
