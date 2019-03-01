package com.fzk.freemarker.core.util;

import com.fzk.freemarker.biex.entity.PunchActivityDeposit;
import com.fzk.freemarker.core.model.PropertyModel;
import io.swagger.annotations.ApiModelProperty;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

/**
 * @program: fzk-freemarker
 *
 * @description: 实体类信息处理工具类
 *
 * @author: fzk
 *
 * @create: 2019-02-21 09:22
 **/
public class EntityUtil
{
    /**
     * 构建实体类属性描述信息map
     * @param object
     * @return
     */
    public static Map<String, String> buildPropertyMap(Class object)
    {
        Map<String, String> entityMap = new HashMap<>();
        Field[] fields = object.getDeclaredFields(); //获取实体类的所有属性，返回Field数组
        for (int j = 0; j < fields.length; j++)
        { //遍历所有属性
            Field field = fields[j];
            String fieldName = field.getName();
            String info = fieldName;//如果属性没有描述信息，则默认使用属性名作为描述信息
            if (field.isAnnotationPresent(ApiModelProperty.class))
            {
                ApiModelProperty des = field.getAnnotation(ApiModelProperty.class);
                info = des.value();
            }
            entityMap.put(fieldName, info);
        }
        return entityMap;
    }

    /**
     * 构建实体类属性描述信息map
     * @param object
     * @return
     */
    public static Map<String, Object> buildControllerMap(Class object)
    {
        Map<String, Object> map = new HashMap<>();
        String className = object.getSimpleName();
        map.put("className", className);
        map.put("entityCode", StringUtil.toLowerCaseFirstOne(className));
        String targetName = new StringBuilder(className).append("Controller.java").toString();
        map.put("targetName", targetName);
        return map;
    }

    /**
     * 构造通用map参数
     * @param object
     * @return
     */
    public static Map<String, Object> buildCommonMap(Class<PunchActivityDeposit> object)
    {
        Map<String, Object> map = new HashMap<>();
        String entityName = object.getSimpleName();
        //实体类名称
        map.put("entityName", entityName);
        //实体类代码：首字母小写
        map.put("entityCode", StringUtil.toLowerCaseFirstOne(entityName));
        return map;
    }

    public static Map<String, String> buildPropertyTypeMap(String className) throws ClassNotFoundException
    {
        Map<String, String> map = new HashMap<>();
        Class cls = Class.forName("com.fzk.freemarker.biex.entity." + className);
        Field[] fields = cls.getDeclaredFields();
        for (int i = 0; i < fields.length; i++)
        {
            Field f = fields[i];
            map.put(f.getName(), f.getType().getSimpleName());
        }
        return map;
    }

    public static List<PropertyModel> buildPropertyList_ignite(String className) throws ClassNotFoundException
    {
        List<PropertyModel> models = new ArrayList<>();
        Class cls = Class.forName("com.fzk.freemarker.biex.entity." + className);
        Field[] fields = cls.getDeclaredFields();
        for (int i = 0; i < fields.length; i++)
        {
            Field f = fields[i];
            PropertyModel model = new PropertyModel();
            model.setName(f.getName());
            String type = f.getType().getSimpleName();
            model.setType(type);
            if (String.class.equals(f.getType()))
            {
                model.setIgniteType("VARCHAR");
            }
            else if (Long.class.equals(f.getType()) || Integer.class.equals(f.getType()) || BigDecimal.class.equals(f.getType()))
            {
                model.setIgniteType("NUMERIC");
            }
            else if (Date.class.equals(f.getType()) || Timestamp.class.equals(f.getType()) || java.sql.Date.class.equals(f.getType()))
            {
                model.setIgniteType("TIMESTAMP");
            }
            else
            {
                model.setIgniteType("不支持的类型");
            }
            models.add(model);
        }
        return models;
    }
}
