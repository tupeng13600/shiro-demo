package com.tp.shiro.cache;

import com.tp.shiro.exception.DemoException;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

/**
 * Created by tupeng on 2017/7/14.
 */
public class DemoCacheManager implements CacheManager {

    private DemoCache cache;

    @Override
    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        if(null == cache) {
            throw new DemoException("cache 不能为空");
        }
        return cache;
    }

    public void setCache(DemoCache cache) {
        this.cache = cache;
    }
}
