//package com.imis.datamanagement.domain.template;
//
//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.annotation.TableId;
//import com.baomidou.mybatisplus.annotation.TableLogic;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//
//import java.util.List;
//import java.util.Map;
//
//@Data
//@EqualsAndHashCode(callSuper = true)
//public class UserDefined extends AbstractTemplate{
//    static final String TEMPLATE_TYPE = "user_defined";
//    @TableId(type = IdType.ASSIGN_ID)
//    private Long id;
//
//    private Long uploaderId;
//
//    private String num;
//
//    private String introduction;
//
//
//    private Map<String, String> other;
//
//    private List<String> filePath;
//
//    private String createTime;
//
//    private String updateTime;
//
//    @TableLogic
//    private String deleted;
//}
