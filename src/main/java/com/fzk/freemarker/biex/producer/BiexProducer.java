package com.fzk.freemarker.biex.producer;

import com.fzk.freemarker.biex.config.GlobalConfig;
import com.fzk.freemarker.biex.entity.PunchActivityDeposit;
import com.fzk.freemarker.core.util.EntityUtil;
import com.fzk.freemarker.core.util.ProducerUtil;
import com.fzk.freemarker.core.util.PropertyUtil;
import com.fzk.freemarker.core.util.StringUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @program: fzk-freemarker
 *
 * @description: 自动生成工具类
 *
 * @author: fzk
 *
 * @create: 2019-02-21 13:42
 **/
public class BiexProducer
{
    public static Properties prop                   = PropertyUtil.getProperties("param/biex/biex.properties");

    public static String     AUTHOR                 = prop.getProperty("author");

    public static String     PROJECTNAME            = prop.getProperty("projectName");

    public static String     PARENTCODE             = prop.getProperty("parentCode");

    public static String     PARENTNAME             = prop.getProperty("parentName");

    public static String     CLASSNAME              = prop.getProperty("className");

    public static String     CLASS_DESCRIPTION      = prop.getProperty("class.description");

    public static String     ENABLE_OPERATOR        = prop.getProperty("enable.operator");

    public static String     BASEPACKAGE            = prop.getProperty("basePackage");

    public static String     ENABLE_LINK            = prop.getProperty("enable.link");

    public static String     LINK_ENABLE_OPERATOR   = prop.getProperty("link.enable.operator");

    public static String     LINK_CLASSNAME         = prop.getProperty("link.className");

    public static String     LINK_CLASS_DESCRIPTION = prop.getProperty("link.class.description");

    public static String     ORDERNAME              = prop.getProperty("orderName");

    public static String     INDEXID                = prop.getProperty("indexId");

    public static String     DATAID                 = prop.getProperty("dataId");

    public static String     OPERATORID             = prop.getProperty("operatorId");

    public static String     PARENTID               = prop.getProperty("parentId");

    public static String     SQLFILENAME            = prop.getProperty("sqlFileName");

    public static String     SQL_ENABLE_PARENT      = prop.getProperty("sql.enable.parent");

    /**
     * 自动生成jsp
     */
    public void pruduceJsp() throws ClassNotFoundException
    {
        Map<String, Object> map = new HashMap<>();
        String className = CLASSNAME;
        map.put("classCode", StringUtil.toLowerCaseFirstOne(className));
        map.put("orderName", ORDERNAME);
        map.put("parentCode", PARENTCODE);
        map.put("hasOperator", Boolean.parseBoolean(ENABLE_OPERATOR));
        map.put("hasSubData", Boolean.parseBoolean(ENABLE_LINK));
        Map<String, String> entityMap = EntityUtil.buildPropertyMap(Class.forName(GlobalConfig.CLASSPATH_BIEX_ENTITY + "." + className));
        map.put("entityMap", entityMap);
        map.put("hasSubOperator", Boolean.parseBoolean(LINK_ENABLE_OPERATOR));
        map.put("subClassCode", StringUtil.toLowerCaseFirstOne(LINK_CLASSNAME));
        map.put("subOrderName", LINK_CLASS_DESCRIPTION);
        if (Boolean.parseBoolean(ENABLE_LINK))
        {
            Map<String, String> subEntityMap = EntityUtil.buildPropertyMap(Class.forName(GlobalConfig.CLASSPATH_BIEX_ENTITY + "." + LINK_CLASSNAME));
            map.put("subEntityMap", subEntityMap);
        }
        ProducerUtil.produce(GlobalConfig.TEMPLATEPATH_BIEX_JSP, GlobalConfig.TEMPLATENAME_BIEX_JSP_LIST, GlobalConfig.TARGETNAME_BIEX_JSP_LIST, map);
    }

    /**
     * 自动生成controller
     */
    public void pruduceController()
    {
        Map<String, Object> map = EntityUtil.buildControllerMap(PunchActivityDeposit.class);
        map.put("className", CLASSNAME);
        map.put("entityCode", StringUtil.toLowerCaseFirstOne(CLASSNAME));
        String targetName = new StringBuilder(CLASSNAME).append("Controller.java").toString();
        map.put("basePackage", BASEPACKAGE);
        map.put("projectName", PROJECTNAME);
        map.put("author", AUTHOR);
        map.put("parentCode", PARENTCODE);
        map.put("entityDes", CLASS_DESCRIPTION);
        map.put("hasOperator", Boolean.parseBoolean(ENABLE_OPERATOR));
        ProducerUtil.produce(GlobalConfig.TEMPLATEPATH_BIEX_CONTROLLER, GlobalConfig.TEMPLATENAME_BIEX_CONTROLLER_BOSSENTITY, targetName, map);
    }

    /**
     * 自动生成sql
     */
    public void pruduceSql()
    {
        Map<String, Object> map = new HashMap<>();
        map.put("classCode", StringUtil.toLowerCaseFirstOne(CLASSNAME));
        map.put("author", AUTHOR);
        map.put("parentName", PARENTNAME);
        map.put("parentCode", PARENTCODE);
        map.put("hasOperator", Boolean.parseBoolean(ENABLE_OPERATOR));
        map.put("orderName", ORDERNAME);
        map.put("indexId", INDEXID);
        map.put("dataId", DATAID);
        map.put("parentId", PARENTID);
        map.put("hasParent", Boolean.parseBoolean(SQL_ENABLE_PARENT));
        if (Boolean.parseBoolean(ENABLE_OPERATOR))
        {
            map.put("operatorId", OPERATORID);
        }
        ProducerUtil.produce(GlobalConfig.TEMPLATEPATH_BIEX_SQL, GlobalConfig.TEMPLATENAME_BIEX_SQL_RESOURCES, SQLFILENAME, map);
    }
    /**
     * 临时文件
     */
    /**
     * 自动生成sql
     */
    public void pruduceTmp(String[] strs) throws ClassNotFoundException
    {
        //        Map<String, Object> map = new HashMap<>();
        //        List<PropertyModel> models = EntityUtil.buildPropertyList_ignite("StockInfoMem");
        //        map.put("props", models);
        //        ProducerUtil.produce(GlobalConfig.TEMPLATEPATH_BIEX_TEMP, "temp.ftl", "temp.java", map);
        //2.
        //        Map<String, Object> map = new HashMap<>();
        //        String entityName="TradeFeeRateGroupMem";
        //        String targetName = entityName+"oryServiceImpl.java";
        //        map.put("entityName",entityName);
        //        map.put("entityName1",StringUtil.toLowerCaseFirstOne(entityName));
        //        ProducerUtil.produce(GlobalConfig.TEMPLATEPATH_BIEX_TEMP, "temp1.ftl", targetName, map);
        for (int i = 0; i < strs.length; i++)
        {
            Map<String, Object> map = new HashMap<>();
            String entityName = strs[i];
            String targetName = entityName + "oryServiceImpl.java";
            map.put("entityName", entityName);
            map.put("entityName1", StringUtil.toLowerCaseFirstOne(entityName));
            ProducerUtil.produce(GlobalConfig.TEMPLATEPATH_BIEX_TEMP, "temp1.ftl", targetName, map);
        }
//        for (int i = 0; i < strs.length; i++)
//        {
//            Map<String, Object> map = new HashMap<>();
//            String entityName = strs[i];
//            String targetName = entityName + "oryRepository.java";
//            map.put("entityName", entityName);
//            ProducerUtil.produce(GlobalConfig.TEMPLATEPATH_BIEX_TEMP, "temp2.ftl", targetName, map);
//        }
    }
}
