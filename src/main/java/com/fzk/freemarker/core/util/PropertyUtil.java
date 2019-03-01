package com.fzk.freemarker.core.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class PropertyUtil
{
    /**
     * 获取配置文件.
     */
    public static Properties getProperties(String path)
    {
        Properties prop = new Properties();
        try
        {
            InputStream in = PropertyUtil.class.getClassLoader().getResourceAsStream(path);
            prop.load(in);
            in.close();
        }
        catch (Exception e)
        {
            System.out.println("该配置文件读取异常：" + path);
        }
        return prop;
    }

    public static Map<String, String> getKeyValueMap(Properties props)
    {
        /**begin*******直接遍历文件key值获取*******begin*/
        Iterator<String> iterator = props.stringPropertyNames().iterator();
        Map<String, String> map = new HashMap<>();
        while (iterator.hasNext())
        {
            String key = iterator.next();
            String value = props.getProperty(key);
            map.put(key, value);
        }
        return map;
    }
}
