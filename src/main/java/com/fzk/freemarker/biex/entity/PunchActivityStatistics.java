/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.fzk.freemarker.biex.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 打卡签到活动统计 实体对象
 * <p>File：PunchActivityStatistics.java</p>
 * <p>Title: PunchActivityStatistics</p>
 * <p>Description:PunchActivityStatistics</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 *
 * @author zcx
 * @version 1.0
 */
@ApiModel(description = "打卡签到活动统计") public class PunchActivityStatistics extends GenericEntity
{
    private static final long serialVersionUID = 1L;

    /**
     * 账户ID
     */
    //@NotNull(message = "账户ID不可为空")
    @ApiModelProperty(value = "账户ID", required = true) private        Long                 accountId;

    /**
     * 奖励金币种
     */
    //@NotNull(message = "奖励金币种不可为空")
    @ApiModelProperty(value = "奖励金币种", required = true) private       Long                 stockinfoId;

    /**
     * 累计奖励金
     */
    //@NotNull(message = "累计奖励金不可为空")
    @ApiModelProperty(value = "累计奖励金", required = true) private       java.math.BigDecimal awardAmtTotal;

    /**
     * 累计打卡次数
     */
    //@NotNull(message = "累计打卡次数不可为空")
    @ApiModelProperty(value = "累计打卡次数", required = true) private      Long                 punchTotal;

    /**
     * 历史上最高打卡次数
     */
    //@NotNull(message = "历史上最高打卡次数不可为空")
    @ApiModelProperty(value = "历史上最高打卡次数", required = true) private   Long                 punchCnt;

    /**
     * punchCntHis
     */
    //@NotNull(message = "punchCntHis不可为空")
    @ApiModelProperty(value = "punchCntHis", required = true) private Long                 punchCntHis;

    // 自定义查询类型 awardAmtTotal奖励金累计排名 punchTotal累计打卡排名 punchCnt最后一次连续打卡 punchCntHis历史上最高连续打卡次数
    private String type = "awardAmtTotal";

    // 排名
    private Long rank;
}

