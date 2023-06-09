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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class MongoDBService {

    final MongoTemplate mongoTemplate;

    public MongoDBService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Integer getMongoId(AbstractTemplate abstractTemplate) {
        Integer id = MongoUtil.getMongoId();
        Query query = new Query(Criteria.where("_id").is(id));
        AbstractTemplate at = mongoTemplate.findOne(query, abstractTemplate.getClass());
        if (at != null) {
            getMongoId(abstractTemplate);
        }
        return id;
    }

    public AbstractTemplate getOneFile(AbstractTemplate abstractTemplate) {
        Integer id = abstractTemplate.getId();
        Query query = new Query(Criteria.where("id").is(id));
        AbstractTemplate at = mongoTemplate.findOne(query, abstractTemplate.getClass());
        if (abstractTemplate.getId() == null) {
            throw new GlobalException(CodeMsg.FILE_NOT_EXIST);
        }
        if (at == null) {
            throw new GlobalException(CodeMsg.FILE_NOT_EXIST);
        }
        if (at.getDeleted() == null || at.getDeleted().equals("1")) {
            throw new GlobalException(CodeMsg.FILE_NOT_EXIST);
        }

        return at;
    }

    //获取当前用户的所有资源（个人详情）
    public List<Object> getById(Long id) {
        System.out.println("id = " + id);
//        Criteria criteria = new Criteria();
//        Query query = new Query(Criteria.where("uploaderId").is(String.valueOf(id)));
        Query query = new Query();
        query.addCriteria(Criteria.where("uploaderId").is(String.valueOf(id)));
        System.out.println(query);
        query.addCriteria(Criteria.where("deleted").is("0"));

        List<Achievement> achievements = mongoTemplate.find(query, Achievement.class);
        List<Communication> communications = mongoTemplate.find(query, Communication.class);
        List<Honor> honors = mongoTemplate.find(query, Honor.class);
        List<Office> offices = mongoTemplate.find(query, Office.class);
        List<Party> parties = mongoTemplate.find(query, Party.class);
        List<Studying> studyings = mongoTemplate.find(query, Studying.class);
        List<StudentContest> studentContests = mongoTemplate.find(query, StudentContest.class);
        List<Teaching> teachings = mongoTemplate.find(query, Teaching.class);
        List<UserDefined> userDefineds = mongoTemplate.find(query, UserDefined.class);

        List<Object> l = new ArrayList<>();
        l.add(achievements);
        l.add(communications);
        l.add(honors);
        l.add(offices);
        l.add(parties);
        l.add(studyings);
        l.add(studentContests);
        l.add(teachings);
        l.add(userDefineds);

        System.out.println(l);

        return l;
    }

    //获取所有用户的所有资源（资源广场）
    public List<Object> getAll() {
        Query query = new Query(Criteria.where("deleted").is("0"));
        List<Achievement> achievements = mongoTemplate.find(query, Achievement.class);
        List<Communication> communications = mongoTemplate.find(query, Communication.class);
        List<Honor> honors = mongoTemplate.find(query, Honor.class);
        List<Office> offices = mongoTemplate.find(query, Office.class);
        List<Party> parties = mongoTemplate.find(query, Party.class);
        List<Studying> studyings = mongoTemplate.find(query, Studying.class);
        List<StudentContest> studentContests = mongoTemplate.find(query, StudentContest.class);
        List<Teaching> teachings = mongoTemplate.find(query, Teaching.class);
        List<UserDefined> userDefineds = mongoTemplate.find(query, UserDefined.class);

        List<Object> l = new ArrayList<>();

        l.add(studyings);
        l.add(teachings);
        l.add(honors);
        l.add(achievements);
        l.add(studentContests);
        l.add(communications);
        l.add(parties);
        l.add(offices);
        l.add(userDefineds);

        return l;
    }

    public void insertTemplate(@RequestBody AbstractTemplate abstractTemplate) {
        System.out.println(abstractTemplate.getUploaderId());
        abstractTemplate.setTEMPLATE_TYPE(abstractTemplate.getClass().getSimpleName().toLowerCase(Locale.ROOT));
        abstractTemplate.setId(getMongoId(abstractTemplate));
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        abstractTemplate.setCreateTime(dateFormat.format(date));
        abstractTemplate.setUpdateTime(dateFormat.format(date));
        abstractTemplate.setDeleted("0");
        mongoTemplate.insert(abstractTemplate);
    }

    public void updateTemplate(@RequestBody AbstractTemplate abstractTemplate) {
        Query query = new Query(Criteria.where("_id").is(abstractTemplate.getId()));
        AbstractTemplate at = mongoTemplate.findOne(query, abstractTemplate.getClass());
        if (at == null) {
            throw new GlobalException(CodeMsg.FILE_NOT_EXIST);
        }
        if (at.getDeleted() == null || at.getDeleted().equals("1")) {
            throw new GlobalException(CodeMsg.FILE_NOT_EXIST);
        }

        Update update = new Update();

        System.out.println(abstractTemplate);
        try {
            Class c = Class.forName(abstractTemplate.getClass().getName());
            Field[] fields = c.getDeclaredFields();
            for (Field f : fields) {
                f.setAccessible(true);
            }
            for (Field f : fields) {
                String field = f.toString().substring(f.toString().lastIndexOf(".") + 1);
                update.set(field, f.get(abstractTemplate));
            }
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            abstractTemplate.setUpdateTime(dateFormat.format(date));
            update.set("updateTime", abstractTemplate.getUpdateTime());
            mongoTemplate.updateFirst(query, update, abstractTemplate.getClass().getSimpleName().toLowerCase(Locale.ROOT));
            System.out.println(update);
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
        Update update = new Update();
        update.set("deleted", "1");
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        abstractTemplate.setUpdateTime(dateFormat.format(date));
        update.set("updateTime", abstractTemplate.getUpdateTime());
        mongoTemplate.updateFirst(query, update, abstractTemplate.getClass().getSimpleName().toLowerCase(Locale.ROOT));
    }


}
