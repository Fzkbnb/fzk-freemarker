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
@ApiModel(description = "打卡资金记录") public class PunchActivityCurrent extends GenericEntity
{
    private static final long serialVersionUID = 1L;

    /**
     * 账户ID
     */
    //@NotNull(message = "账户ID不可为空")
    @ApiModelProperty(value = "账户ID", required = true) private Long                 accountId;

    /**
     * 类型
     */
    //@NotNull(message = "类型不可为空")
    @ApiModelProperty(value = "类型", required = true) private   String               type;

    /**
     * 金额
     */
    //@NotNull(message = "金额不可为空")
    @ApiModelProperty(value = "金额", required = true) private   java.math.BigDecimal amount;

    /**
     * 时间
     */
    @ApiModelProperty(value = "时间") private                    java.util.Date       currentDate;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注") private                    String               remark;

    private                                                    String               accountName;
}

