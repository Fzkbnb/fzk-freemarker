package com.fzk.freemarker.core.model;

/**
 * @program: fzk-freemarker
 *
 * @description: 屬性模型類
 *
 * @author: fzk
 *
 * @create: 2019-02-26 16:01
 **/
public class PropertyModel
{
    private String name;

    private String type;

    private String igniteType;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getIgniteType()
    {
        return igniteType;
    }

    public void setIgniteType(String igniteType)
    {
        this.igniteType = igniteType;
    }
}
