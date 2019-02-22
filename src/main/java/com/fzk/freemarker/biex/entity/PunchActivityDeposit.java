/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.fzk.freemarker.biex.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 打卡签到活动保证金记录 实体对象
 * <p>File：PunchActivityDeposit.java</p>
 * <p>Title: PunchActivityDeposit</p>
 * <p>Description:PunchActivityDeposit</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 *
 * @author Playguy
 * @version 1.0
 */
@ApiModel(description = "打卡签到活动保证金记录") public class PunchActivityDeposit extends GenericEntity
{
    private static final long serialVersionUID = 1L;

    /**
     * 账户ID
     */
    @ApiModelProperty(value = "账户ID", required = true) private      Long                 accountId;

    /**
     * 保证金币种
     */
    @ApiModelProperty(value = "保证金币种", required = true) private     Long                 stockinfoId;

    /**
     * 保证金金额
     */
    @ApiModelProperty(value = "保证金金额", required = true) private     java.math.BigDecimal depositAmt;

    /**
     * 支付保证金时间
     */
    @ApiModelProperty(value = "支付保证金时间", required = true) private   java.util.Date       paymentDate;

    /**
     * 支付保证金时间
     */
    @ApiModelProperty(value = "支付保证金时间", required = true) private   Integer              paymentDateInt;

    /**
     * 周期内累计签到次数
     */
    @ApiModelProperty(value = "周期内累计签到次数", required = true) private Integer              punchCnt;

    /**
     * 有效状态 yes有效 no无效或过期
     */
    @ApiModelProperty(value = "有效状态", required = true) private      String               status;

    private                                                         String               accountName;

    private                                                         String               stockCode;
}

