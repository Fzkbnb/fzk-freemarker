package com.fzk.freemarker.core.util;

import com.fzk.freemarker.biex.entity.PunchActivityDeposit;
import io.swagger.annotations.ApiModelProperty;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

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
    public static Map<String,Object> buildCommonMap(Class<PunchActivityDeposit> object)
    {
        Map<String, Object> map = new HashMap<>();
        String entityName = object.getSimpleName();
        //实体类名称
        map.put("entityName", entityName);
        //实体类代码：首字母小写
        map.put("entityCode", StringUtil.toLowerCaseFirstOne(entityName));
        return map;
    }
}
