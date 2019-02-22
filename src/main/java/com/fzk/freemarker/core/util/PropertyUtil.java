package com.fzk.freemarker.core.util;

import java.io.InputStream;
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
}
