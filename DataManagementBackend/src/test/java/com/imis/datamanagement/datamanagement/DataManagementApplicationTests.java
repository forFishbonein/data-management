package com.imis.datamanagement.datamanagement;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SpringBootTest
class DataManagementApplicationTests {

    Map<String, String> map = new HashMap<>();

    List<String> list = new ArrayList<>();


    @Test
    void contextLoads() {
        System.out.println("hello world");

        map.put("k", "v");
        map.put("k2", "v2");

        list.add("asd");
        list.add("asd2");

        String json2 = JSON.toJSONString(list);

        System.out.println(json2);


    }

}
