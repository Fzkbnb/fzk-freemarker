/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.fzk.freemarker.biex.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 打卡签到记录 实体对象
 * <p>File：PunchActivityRecord.java</p>
 * <p>Title: PunchActivityRecord</p>
 * <p>Description:PunchActivityRecord</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 *
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "打卡签到记录") public class PunchActivityRecord extends GenericEntity
{
    private static final long serialVersionUID = 1L;

    /**
     * 账户ID
     */
    @ApiModelProperty(value = "账户ID", required = true) private  Long                 accountId;

    /**
     * stockinfoId
     */
    @ApiModelProperty(value = "证券ID", required = true) private  Long                 stockinfoId;

    /**
     * 保证金ID
     */
    @ApiModelProperty(value = "保证金ID", required = true) private Long                 depositId;

    /**
     * 打卡时间
     */
    @ApiModelProperty(value = "打卡时间") private                   java.util.Date       createDate;

    /**
     * 打卡时间
     */
    @ApiModelProperty(value = "打卡时间", required = true) private  Integer              createDateInt;

    /**
     * 奖励金额
     */
    @ApiModelProperty(value = "奖励金额", required = true) private  java.math.BigDecimal awardAmt;

    /**
     * 奖励状态(noAward不需要奖励，needAward需奖励，alreadyAward已奖励)
     */
    @ApiModelProperty(value = "奖励状态", required = true) private  String               awardStatus;

    /**
     * 奖励时间
     */
    @ApiModelProperty(value = "奖励时间") private                   java.util.Date       awardDate;

    private                                                     java.math.BigDecimal depositAmt;
}

