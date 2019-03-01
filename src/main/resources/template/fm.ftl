package com.fzk.freemarker.${parentName}.producer;


/**
* @program: fzk-freemarker
*
* @description:
*
* @author: fzk
*
* @create: ${.now?datetime}
**/
public class ${TargetName}Producer extends ParentProducer
{
public static Properties prop        = PropertyUtil.getProperties("param/${parentName}/${targetName}.properties");
public static String     parentPath = prop.getProperty("/${parentName}");
public static String     targetFileName      = prop.getProperty("targetFileName");
@Override
public void run()
{
Map<String, Object> map = new HashMap<>();
Map<String,String> propMap = PropertyUtil.getKeyValueMap(prop);
for (Map.Entry<String, String> entry : propMap.entrySet()) {
map.put(entry.getKey(), entry.getValue());
}
String templatePath =PATH_TEMPLATE+parentPath+"/";
String templateName = "${targetName}.ftl";
produce(templatePath, templateName, targetFileName, map);
}
}
