package com.fzk.freemarker.core.util;

import com.fzk.freemarker.biex.config.GlobalConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.Map;

/**
 * @program: fzk-freemarker
 *
 * @description: 自动生成指定文件工具类
 *
 * @author: fzk
 *
 * @create: 2019-02-21 16:51
 **/
public class ProducerUtil
{
    /**
     * 生成指定文件
     */
    public static  void produce(String templatePath, String templateName, String targetName, Map<String, Object> dataMap)
    {

        // step1 创建freeMarker配置实例
        Configuration configuration = new Configuration();
        Writer out = null;
        try
        {
            // step2 获取模版路径
            configuration.setDirectoryForTemplateLoading(new File(templatePath));
            // step3 创建数据模型
            // step4 加载模版文件
            Template template = configuration.getTemplate(templateName);
            // step5 生成数据
            File docFile = new File(GlobalConfig.TARGET_PATH + targetName);
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
            // step6 输出文件
            template.process(dataMap, out);
            System.out.println(">>>>>>文件创建成功:" + targetName);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (null != out)
                {
                    out.flush();
                }
            }
            catch (Exception e2)
            {
                e2.printStackTrace();
            }
        }
    }
}
