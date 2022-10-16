package com.imis.datamanagement.service;
/*
 *
 * @Time : 2022/10/11
 * @Author : https://blog.csdn.net/m0_56170277
 * @File : DataManagement4IMIS
 */

import com.imis.datamanagement.common.result.CodeMsg;
import com.imis.datamanagement.domain.template.AbstractTemplate;
import com.imis.datamanagement.exception.GlobalException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Service
public class MongoDBService {

    @Resource
    MongoTemplate mongoTemplate;

    public void insertTemplate(AbstractTemplate abstractTemplate) {
        Query query = new Query(Criteria.where("_id").is(abstractTemplate.getId()));
        AbstractTemplate at = mongoTemplate.findOne(query, abstractTemplate.getClass());
        if (at != null) {
            throw new GlobalException(CodeMsg.FILE_EXIST);
        }

        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        abstractTemplate.setCreateTime(dateFormat.format(date));
        abstractTemplate.setDeleted("0");
        mongoTemplate.insert(abstractTemplate);
    }

    //如果传入是null，也会被改为null
    public void updateTemplate(AbstractTemplate abstractTemplate) {
        Query query = new Query(Criteria.where("_id").is(abstractTemplate.getId()));
        AbstractTemplate at = mongoTemplate.findOne(query, abstractTemplate.getClass());
        if (at == null) {
            throw new GlobalException(CodeMsg.FILE_NOT_EXIST);
        }
        if (at.getDeleted() == null | at.getDeleted().equals("1")) {
            throw new GlobalException(CodeMsg.FILE_NOT_EXIST);
        }

        Update update = null;
        
        try {
            Class c = Class.forName(abstractTemplate.getClass().getName());
            Field[] fields = c.getDeclaredFields();
            for (Field f : fields) {
                f.setAccessible(true);
            }
            for (Field f : fields) {
                String field = f.toString().substring(f.toString().lastIndexOf(".") + 1);
                update = new Update().set(field, f.get(abstractTemplate));
                mongoTemplate.updateFirst(query, update, abstractTemplate.getClass().getSimpleName().toLowerCase(Locale.ROOT));
            }
            Date date = new Date();
            SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            abstractTemplate.setUpdateTime(dateFormat.format(date));
            update = new Update().set("updateTime", abstractTemplate.getUpdateTime());
            mongoTemplate.updateFirst(query, update, abstractTemplate.getClass().getSimpleName().toLowerCase(Locale.ROOT));
        } catch (ClassNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
