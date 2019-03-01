package com.fzk.freemarker.js.producer;

import com.fzk.freemarker.core.ParentProducer;
import com.fzk.freemarker.core.util.PropertyUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @program: fzk-freemarker
 *
 * @description: 映射型变量下单菜单生成
 *
 * @author: fzk
 *
 * @create: 2019-03-01 14:28
 **/
public class VarMappingOptionProducer extends ParentProducer
{
    public static Properties prop           = PropertyUtil.getProperties("param/js/var_mappingOption.properties");

    public static String     parentPath     = prop.getProperty("parentPath");

    public static String     targetFileName = prop.getProperty("targetFileName");

    @Override public void run()
    {
        Map<String, Object> map = new HashMap<>();
        Map<String, String> propMap = PropertyUtil.getKeyValueMap(prop);
        for (Map.Entry<String, String> entry : propMap.entrySet())
        {
            map.put(entry.getKey(), entry.getValue());
        }
        String templatePath = PATH_TEMPLATE + parentPath + "/";
        String templateName = "";
        produce(templatePath, templateName, targetFileName, map);
    }
}
