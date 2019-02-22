package com.fzk.freemarker.biex.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>File：BaseEntity.java</p>
 * <p>Title: BaseEntity</p>
 * <p>Description:基础实体对象</p>
 * <p>Copyright: Copyright (c) 2015/04/21 11:52</p>
 * <p>Company: BloCain</p>
 *
 * @author Playguy
 * @version 1.0
 */
public abstract class GenericEntity implements Serializable
{
    /**
     * 主键编号
     */
    @ApiModelProperty(value = "主键", required = true)
    protected Long id;
}
