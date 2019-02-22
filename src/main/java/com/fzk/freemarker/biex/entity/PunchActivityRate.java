/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.fzk.freemarker.biex.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 打卡资金记录 实体对象
 * <p>File：PunchActivityCurrent.java</p>
 * <p>Title: PunchActivityCurrent</p>
 * <p>Description:PunchActivityCurrent</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 *
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "打卡资金记录")
public class PunchActivityRate extends GenericEntity
{
    private static final long serialVersionUID = 1L;

    /**
     * 年化利率 已乘以100
     */
    @ApiModelProperty(value = "年化利率", required = true) private java.math.BigDecimal rate;

    /**
     * 时间
     */
    @ApiModelProperty(value = "时间") private                    java.util.Date       currentDate;

    /**
     * 占比
     */
    @ApiModelProperty(value = "占比") private                    String               percent;
}

