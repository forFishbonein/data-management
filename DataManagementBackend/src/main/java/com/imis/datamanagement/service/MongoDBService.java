package com.imis.datamanagement.service;
/*
 *
 * @Time : 2022/10/11
 * @Author : https://blog.csdn.net/m0_56170277
 * @File : DataManagement4IMIS
 */

import com.alibaba.fastjson.JSON;
import com.imis.datamanagement.common.result.CodeMsg;
import com.imis.datamanagement.domain.template.*;
import com.imis.datamanagement.exception.GlobalException;
import com.imis.datamanagement.redis.utils.MongoUtil;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class MongoDBService {

    @Resource
    MongoTemplate mongoTemplate;

    public Integer getMongoId(AbstractTemplate abstractTemplate) {
        Integer id = MongoUtil.getMongoId();
        Query query = new Query(Criteria.where("_id").is(id));
        AbstractTemplate at = mongoTemplate.findOne(query, abstractTemplate.getClass());
        if (at != null) {
            getMongoId(abstractTemplate);
        }
        return id;
    }

    //获取当前用户的所有资源（个人详情）
    public String getById(Long id) {
        System.out.println("id = " + id);
        Query query = new Query(Criteria.where("uploaderId").is(id));
        List<Achievememnt> achievememnts = mongoTemplate.find(query, Achievememnt.class);
        List<Communication> communications = mongoTemplate.find(query, Communication.class);
        List<Honor> honors = mongoTemplate.find(query, Honor.class);
        List<Office> offices = mongoTemplate.find(query, Office.class);
        List<Party> parties = mongoTemplate.find(query, Party.class);
        List<StudentContest> studentContests = mongoTemplate.find(query, StudentContest.class);
        List<Teaching> teachings = mongoTemplate.find(query, Teaching.class);
        List<UserDefined> userDefineds = mongoTemplate.find(query, UserDefined.class);

        List<Object> l = new ArrayList<>();
        l.add(achievememnts);
        l.add(communications);
        l.add(honors);
        l.add(offices);
        l.add(parties);
        l.add(studentContests);
        l.add(teachings);
        l.add(userDefineds);

        String json = JSON.toJSONString(l);

        return json;
    }

    //TODO 获取所有用户的所有资源（资源广场）
    public List<Object> getAll() {
        Query query = new Query();
        List<Achievememnt> achievememnts = mongoTemplate.find(query, Achievememnt.class);
        List<Communication> communications = mongoTemplate.find(query, Communication.class);
        List<Honor> honors = mongoTemplate.find(query, Honor.class);
        List<Office> offices = mongoTemplate.find(query, Office.class);
        List<Party> parties = mongoTemplate.find(query, Party.class);
        List<StudentContest> studentContests = mongoTemplate.find(query, StudentContest.class);
        List<Teaching> teachings = mongoTemplate.find(query, Teaching.class);
        List<UserDefined> userDefineds = mongoTemplate.find(query, UserDefined.class);

        List<Object> l = new ArrayList<>();
        l.add(achievememnts);
        l.add(communications);
        l.add(honors);
        l.add(offices);
        l.add(parties);
        l.add(studentContests);
        l.add(teachings);
        l.add(userDefineds);


        return l;
    }

    //TODO 根据条件获取用户资源（资源广场）

    public void insertTemplate(AbstractTemplate abstractTemplate) {
        abstractTemplate.setId(getMongoId(abstractTemplate));
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        abstractTemplate.setCreateTime(dateFormat.format(date));
        abstractTemplate.setUpdateTime(dateFormat.format(date));
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
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            abstractTemplate.setUpdateTime(dateFormat.format(date));
            update = new Update().set("updateTime", abstractTemplate.getUpdateTime());
            mongoTemplate.updateFirst(query, update, abstractTemplate.getClass().getSimpleName().toLowerCase(Locale.ROOT));
        } catch (ClassNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void deleteTemplate(AbstractTemplate abstractTemplate) {
        Query query = new Query(Criteria.where("_id").is(abstractTemplate.getId()));
        AbstractTemplate at = mongoTemplate.findOne(query, abstractTemplate.getClass());
        System.out.println(at);
        if (at == null) {
            throw new GlobalException(CodeMsg.FILE_NOT_EXIST);
        }
        Update update = null;
        update = new Update().set("0", abstractTemplate.getDeleted());
        mongoTemplate.updateFirst(query, update, abstractTemplate.getClass().getSimpleName().toLowerCase(Locale.ROOT));
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        abstractTemplate.setUpdateTime(dateFormat.format(date));
        update = new Update().set("updateTime", abstractTemplate.getUpdateTime());
        mongoTemplate.updateFirst(query, update, abstractTemplate.getClass().getSimpleName().toLowerCase(Locale.ROOT));
    }


}