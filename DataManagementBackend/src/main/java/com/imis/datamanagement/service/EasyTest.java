package com.imis.datamanagement.service;


import com.alibaba.excel.EasyExcel;
import com.imis.datamanagement.domain.DemoData;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EasyTest {
    String PATH = "D:\\xunlei\\datas\\";

    //模拟写入数据
    private List<DemoData> data() {
        java.util.List<DemoData> list = new ArrayList<DemoData>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
//            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.5);
            list.add(data);
        }
        return list;
    }

    //根据ist写 excel
    @Test
    public void simplewrite() {
        String fileName = PATH + "EasyTest.xlsx";
        //这里需要指定写用哪个 class去写，然后写到第一个 sheet，名字为模板然后文件流会自动关闭
        //write(fileName,格式类)
        //sheet（表名）
        //doWrite（数据）
        EasyExcel.write(fileName, DemoData.class).sheet("模板").doWrite(data());
    }
}
