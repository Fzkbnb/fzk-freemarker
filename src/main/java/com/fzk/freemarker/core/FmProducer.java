package com.fzk.freemarker.core;

import com.fzk.freemarker.core.util.PropertyUtil;
import com.fzk.freemarker.core.util.StringUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @program: fzk-freemarker
 *
 * @description: 自身工具类生成类
 *
 * @author: fzk
 *
 * @create: 2019-03-01 17:02
 **/
public class FmProducer extends ParentProducer
{
    public static Properties prop       = PropertyUtil.getProperties("param/fm.properties");

    public static String     targetName = prop.getProperty("targetName");

    public static String     parentName = prop.getProperty("parentName");

    @Override public void run()
    {
        Map<String, Object> map = new HashMap<>();
        map.put("targetName", targetName);
        String targetName1 = StringUtil.toUpperCaseFirstOne(targetName);
        map.put("TargetName", targetName1);
        map.put("parentName", parentName);
        String templatePath = PATH_TEMPLATE + "/";
        String templateName = "fm.ftl";
        produce(templatePath, templateName, targetName1+"Producer.java", map);
    }
}
