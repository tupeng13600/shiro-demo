package com.tp.shiro.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by tupeng on 2017/7/14.
 */
public class DemoCache<K, V> implements Cache<K, V> {

    private static Logger logger = LoggerFactory.getLogger(DemoCache.class);

    public static volatile Map cache = new ConcurrentHashMap<>();

    @Override
    public V get(K key) throws CacheException {
        logger.info("get authorization from cache:{}", key);
        return (V)cache.get(key);
    }

    @Override
    public V put(K key, V value) throws CacheException {
        logger.info("put authorization to cache:{}:{}", key, value);
        cache.put(key, value);
        return value;
    }

    @Override
    public V remove(K key) throws CacheException {
        logger.info("prepare to delete authorization from cache:{}", key);
        V value = (V)cache.get(key);
        if(null != value) {
            cache.remove(key);
            logger.info("delete authorization from cache success:{}", key);
        }
        return value;
    }

    @Override
    public void clear() throws CacheException {
        cache.clear();
        logger.info("clear the cache ...");
    }

    @Override
    public int size() {
        return cache.size();
    }

    @Override
    public Set<K> keys() {
        return cache.keySet();
    }

    @Override
    public Collection<V> values() {
        return cache.values();
    }
}
