package com.tp.shiro.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * Created by Tupeng <tupeng@gengee.cn>
 */
public class MongoOperation<V> {

    @Autowired
    protected MongoTemplate mongoTemplate;

    /**
     * 保存
     * @param objects
     */
    protected void save(V...objects) {
        if(null != objects && objects.length >= 1) {
            for(V object : objects) {
                mongoTemplate.save(object);
            }
        }
    }

    /**
     * 查找
     * @param args
     * @param c
     * @return
     */
    protected List<V> get(List<OperationArg> args, Class<V> c) {
        return (List<V>) mongoTemplate.find(this.generateQuery(args), c);
    }

    /**
     * 更新
     * @param args
     * @param object
     */
    protected void update(List<OperationArg> args, List<V> object) {
        // TODO: 2016/12/28 待完成
    }

    protected void delete(List<OperationArg> args) {
            mongoTemplate.remove(this.generateQuery(args));
    }

    /**
     * list all data 4 collections
     *
     * @param c
     * @return
     */
    protected List<V> listAll(Class<V> c) {
        return mongoTemplate.findAll(c);
    }

    private Query generateQuery(List<OperationArg> argList) {
        Criteria criteria = null;
        if (null != argList) {
            for (OperationArg arg : argList) {
                if (null == criteria) {
                    criteria = Criteria.where(arg.getArgName()).is(arg.getArgValue());
                } else {
                    criteria.and(arg.getArgName()).is(arg.getArgValue());
                }
            }
        }
        return Query.query(criteria);
    }

}
