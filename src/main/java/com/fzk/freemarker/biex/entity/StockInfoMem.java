/*
 * Copyright 2017 BLOCAIN, Inc. All rights reserved. com.blocain
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.fzk.freemarker.biex.entity;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 证券信息表 实体对象
 * <p>File：StockInfoMem.java</p>
 * <p>Title: StockInfoMem</p>
 * <p>Description:StockInfoMem</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: BloCain</p>
 * @author Playguy
 * @version 1.0
 */

public class StockInfoMem extends GenericEntity
{
    private static final long serialVersionUID = 1L;
    
    /**证券代码*/
    //@NotNull(message = "证券代码不可为空")
    @ApiModelProperty(value = "证券代码", required = true)
    private String            stockCode;
    
    /**证券名称*/
    //@NotNull(message = "证券名称不可为空")
    @ApiModelProperty(value = "证券名称", required = true)
    private String            stockName;
    
    /**证券类型(spotExchange现货汇兑 indexFuture指数期货)*/
    //@NotNull(message = "证券类型(spotExchange现货汇兑 indexFuture指数期货)不可为空")
    @ApiModelProperty(value = "证券类型(spotExchange现货汇兑 indexFuture指数期货)", required = true)
    private String            stockType;
    
    /**能否充值(yes可以 no不能)*/
    //@NotNull(message = "能否充值(yes可以 no不能)不可为空")
    @ApiModelProperty(value = "能否充值(yes可以 no不能)", required = true)
    private String            canRecharge;
    
    /**能否提现(yes可以 no不能)*/
    //@NotNull(message = "能否提现(yes可以 no不能)不可为空")
    @ApiModelProperty(value = "能否提现(yes可以 no不能)", required = true)
    private String            canWithdraw;
    
    /**能否交易(yes可以 no不能)*/
    //@NotNull(message = "能否交易(yes可以 no不能)不可为空")
    @ApiModelProperty(value = "能否交易(yes可以 no不能)", required = true)
    private String            canTrade;
    
    /**能否可借(yes可以 no不能)*/
    //@NotNull(message = "能否可借(yes可以 no不能)不可为空")
    @ApiModelProperty(value = "能否可借(yes可以 no不能)", required = true)
    private String            canBorrow;
    
    /**能否互转(yes可以 no不能)*/
    //@NotNull(message = "能否互转(yes可以 no不能)不可为空")
    @ApiModelProperty(value = "能否互转(yes可以 no不能)", required = true)
    private String            canConversion;
    
    /**是否启用(yes可以 no不能)*/
    //@NotNull(message = "是否启用(yes可以 no不能)不可为空")
    @ApiModelProperty(value = "是否启用(yes可以 no不能)", required = true)
    private String            isActive;
    
    /**能否可理财(yes可以 no不能)*/
    //@NotNull(message = "能否可理财(yes可以 no不能)不可为空")
    @ApiModelProperty(value = "能否可理财(yes可以 no不能)", required = true)
    private String            canWealth;
    
    /**是否是交易对(yes是 no不是)*/
    //@NotNull(message = "是否是交易对(yes是 no不是)不可为空")
    @ApiModelProperty(value = "是否是交易对(yes是 no不是)", required = true)
    private String            isExchange;
    
    /**交易标的证券ID*/
    //@NotNull(message = "交易标的证券ID不可为空")
    @ApiModelProperty(value = "交易标的证券ID", required = true)
    private Long              tradeStockinfoId;
    
    /**资金计价单位证券ID*/
    //@NotNull(message = "资金计价单位证券ID不可为空")
    @ApiModelProperty(value = "资金计价单位证券ID", required = true)
    private Long              capitalStockinfoId;
    
    /**清算标的证券ID*/
    //@NotNull(message = "清算标的证券ID不可为空")
    @ApiModelProperty(value = "清算标的证券ID", required = true)
    private Long              clearStockinfoId;
    
    /**外部行情标的证券ID*/
    //@NotNull(message = "外部行情标的证券ID不可为空")
    @ApiModelProperty(value = "外部行情标的证券ID", required = true)
    private Long              quotationStockinfoId;
    
    /**交易标的证券数量单位*/
    //@NotNull(message = "交易标的证券数量单位不可为空")
    @ApiModelProperty(value = "交易标的证券数量单位", required = true)
    private String            tradeAmtUnit;
    
    /**交易标的证券数量单位符号*/
    //@NotNull(message = "交易标的证券数量单位符号不可为空")
    @ApiModelProperty(value = "交易标的证券数量单位符号", required = true)
    private String            tradeAmtSymbol;
    
    /**资金计价单位证券数量单位*/
    //@NotNull(message = "资金计价单位证券数量单位不可为空")
    @ApiModelProperty(value = "资金计价单位证券数量单位", required = true)
    private String            capitalAmtUnit;
    
    /**资金计价单位证券数量单位符号*/
    //@NotNull(message = "资金计价单位证券数量单位符号不可为空")
    @ApiModelProperty(value = "资金计价单位证券数量单位符号", required = true)
    private String            capitalAmtSymbol;
    
    /**资产数量单位*/
    //@NotNull(message = "资产数量单位不可为空")
    @ApiModelProperty(value = "资产数量单位", required = true)
    private String            assetAmtUnit;
    
    /**资产数量单位符号*/
    //@NotNull(message = "资产数量单位符号不可为空")
    @ApiModelProperty(value = "资产数量单位符号", required = true)
    private String            assetAmtSymbol;
    
    /**清算数量单位*/
    //@NotNull(message = "清算数量单位不可为空")
    @ApiModelProperty(value = "清算数量单位", required = true)
    private String            clearAmtUnit;
    
    /**清算数量单位符号*/
    //@NotNull(message = "清算数量单位符号不可为空")
    @ApiModelProperty(value = "清算数量单位符号", required = true)
    private String            clearAmtSymbol;
    
    /**做多最大杠杆*/
    //@NotNull(message = "做多最大杠杆不可为空")
    @ApiModelProperty(value = "做多最大杠杆", required = true)
    private BigDecimal        maxLongLever;
    
    /**做空最大杠杆*/
    //@NotNull(message = "做空最大杠杆不可为空")
    @ApiModelProperty(value = "做空最大杠杆", required = true)
    private BigDecimal        maxShortLever;
    
    /**做多最大杠杆开关*/
    //@NotNull(message = "做多最大杠杆开关不可为空")
    @ApiModelProperty(value = "做多最大杠杆开关", required = true)
    private String            maxLongLeverSwitch;
    
    /**做空最大杠杆开关*/
    //@NotNull(message = "做空最大杠杆开关不可为空")
    @ApiModelProperty(value = "做空最大杠杆开关", required = true)
    private String            maxShortLeverSwitch;
    
    /**单笔委托买入数量上限*/
    //@NotNull(message = "单笔委托买入数量上限不可为空")
    @ApiModelProperty(value = "单笔委托买入数量上限", required = true)
    private BigDecimal        maxSingleBuyEntrustAmt;
    
    /**单笔委托卖出数量上限*/
    //@NotNull(message = "单笔委托卖出数量上限不可为空")
    @ApiModelProperty(value = "单笔委托卖出数量上限", required = true)
    private BigDecimal        maxSingleSellEntrustAmt;
    
    /** 用户多头持仓上限 */
    //@NotNull(message = "用户多头持仓上限不可为空")
    @ApiModelProperty(value = "用户多头持仓上限", required = true)
    private BigDecimal        longAccMaxPosition;
    
    /**用户空头持仓上限*/
    //@NotNull(message = "用户空头持仓上限不可为空")
    @ApiModelProperty(value = "用户空头持仓上限", required = true)
    private BigDecimal        shortAccMaxPosition;
    
    /**交割结算周期*/
    //@NotNull(message = "交割结算周期不可为空")
    @ApiModelProperty(value = "交割结算周期", required = true)
    private String            settlementCycle;
    
    /**交割结算价格*/
    //@NotNull(message = "交割结算价格不可为空")
    @ApiModelProperty(value = "交割结算价格", required = true)
    private BigDecimal        settlementPrice;
    
    /**交割结算步骤*/
    //@NotNull(message = "交割结算步骤不可为空")
    @ApiModelProperty(value = "交割结算步骤", required = true)
    private Integer           settlementStep;
    
    /**备注*/
    @ApiModelProperty(value = "备注")
    private String            remark;
    
    /**创建人*/
    //@NotNull(message = "创建人不可为空")
    @ApiModelProperty(value = "创建人", required = true)
    private Long              createBy;
    
    /**创建时间*/
    //@NotNull(message = "创建时间不可为空")
    @ApiModelProperty(value = "创建时间", required = true)
    private Timestamp         createDate;
    
    /**修改人*/
    @ApiModelProperty(value = "修改人")
    private Long              updateBy;
    
    /**修改时间*/
    //@NotNull(message = "修改时间不可为空")
    @ApiModelProperty(value = "修改时间", required = true)
    private Timestamp         updateDate;
    
    /**多单爆仓价提前比例*/
    //@NotNull(message = "多单爆仓价提前比例不可为空")
    @ApiModelProperty(value = "多单爆仓价提前比例", required = true)
    private BigDecimal        closePositionLongPrePercent;
    
    /**空单爆仓价提前比例*/
    //@NotNull(message = "空单爆仓价提前比例不可为空")
    @ApiModelProperty(value = "空单爆仓价提前比例", required = true)
    private BigDecimal        closePositionShortPrePercent;
    
    /**买入大限价上浮%*/
    //@NotNull(message = "买入大限价上浮%不可为空")
    @ApiModelProperty(value = "买入大限价上浮%", required = true)
    private BigDecimal        buyMaxLimitPriceUpPercent;
    
    /**买入大限价下浮%*/
    //@NotNull(message = "买入大限价下浮%不可为空")
    @ApiModelProperty(value = "买入大限价下浮%", required = true)
    private BigDecimal        buyMaxLimitPriceDownPercent;
    
    /**买入小限价上浮%*/
    //@NotNull(message = "买入小限价上浮不可为空")
    @ApiModelProperty(value = "买入小限价上浮%", required = true)
    private BigDecimal        buyMinLimitPriceUpPercent;
    
    /**买入小限价下浮%*/
    //@NotNull(message = "买入小限价下浮不可为空")
    @ApiModelProperty(value = "买入小限价下浮%", required = true)
    private BigDecimal        buyMinLimitPriceDownPercent;
    
    /**卖出大限价上浮%*/
    //@NotNull(message = "卖出大限价上浮不可为空")
    @ApiModelProperty(value = "卖出大限价上浮%", required = true)
    private BigDecimal        sellMaxLimitPriceUpPercent;
    
    /**卖出大限价下浮%*/
    //@NotNull(message = "卖出大限价下浮不可为空")
    @ApiModelProperty(value = "卖出大限价下浮%", required = true)
    private BigDecimal        sellMaxLimitPriceDownPercent;
    
    /**卖出小限价上浮%*/
    //@NotNull(message = "卖出小限价上浮不可为空")
    @ApiModelProperty(value = "卖出小限价上浮%", required = true)
    private BigDecimal        sellMinLimitPriceUpPercent;
    
    /**卖出小限价下浮%*/
    //@NotNull(message = "卖出小限价下浮不可为空")
    @ApiModelProperty(value = "卖出小限价下浮%", required = true)
    private BigDecimal        sellMinLimitPriceDownPercent;
    
    /**买入价格精度*/
    //@NotNull(message = "买入价格精度不可为空")
    @ApiModelProperty(value = "买入价格精度", required = true)
    private Integer           buyPricePrecision;
    
    /**买入数量精度*/
    //@NotNull(message = "买入数量精度不可为空")
    @ApiModelProperty(value = "买入数量精度", required = true)
    private Integer           buyAmountPrecision;
    
    /**买入最小数量*/
    //@NotNull(message = "买入最小数量不可为空")
    @ApiModelProperty(value = "买入最小数量", required = true)
    private BigDecimal        buyMinAmount;
    
    /**卖出价格精度*/
    //@NotNull(message = "卖出价格精度不可为空")
    @ApiModelProperty(value = "卖出价格精度", required = true)
    private Integer           sellPricePrecision;
    
    /**卖出数量精度*/
    //@NotNull(message = "卖出数量精度不可为空")
    @ApiModelProperty(value = "卖出数量精度", required = true)
    private Integer           sellAmountPrecision;
    
    /**卖出最小数量*/
    //@NotNull(message = "卖出最小数量不可为空")
    @ApiModelProperty(value = "卖出最小数量", required = true)
    private BigDecimal        sellMinAmount;
    
    /**资产配置表*/
    //@NotNull(message = "资产配置表不可为空")
    @ApiModelProperty(value = "资产配置表", required = true)
    private String            tableAsset;
    
    /**借贷资产配置表*/
    //@NotNull(message = "借贷资产配置表不可为空")
    @ApiModelProperty(value = "借贷资产配置表", required = true)
    private String            tableDebitAsset;
    
    /**借贷资产明细配置表*/
    //@NotNull(message = "借贷资产明细配置表不可为空")
    @ApiModelProperty(value = "借贷资产明细配置表", required = true)
    private String            tableDebitAssetDetail;
    
    /**委托配置表*/
    //@NotNull(message = "委托配置表不可为空")
    @ApiModelProperty(value = "委托配置表", required = true)
    private String            tableEntrust;
    
    /**委托历史配置表*/
    //@NotNull(message = "委托历史配置表不可为空")
    @ApiModelProperty(value = "委托历史配置表", required = true)
    private String            tableEntrustHis;
    
    /**成交配置表*/
    //@NotNull(message = "成交配置表不可为空")
    @ApiModelProperty(value = "成交配置表", required = true)
    private String            tableRealDeal;
    
    /**成交历史配置表*/
    //@NotNull(message = "成交历史配置表不可为空")
    @ApiModelProperty(value = "成交历史配置表", required = true)
    private String            tableRealDealHis;
    
    /**资产流水配置表*/
    //@NotNull(message = "资产流水配置表不可为空")
    @ApiModelProperty(value = "资产流水配置表", required = true)
    private String            tableFundCurrent;
    
    /**资产流水历史配置表*/
    //@NotNull(message = "资产流水历史配置表不可为空")
    @ApiModelProperty(value = "资产流水历史配置表", required = true)
    private String            tableFundCurrentHis;
    
    /**行情K线配置表*/
    //@NotNull(message = "行情K线配置表不可为空")
    @ApiModelProperty(value = "tableQuotationKline", required = true)
    private String            tableQuotationKline;
    
    /**提现记录表*/
    //@NotNull(message = "提现记录表不可为空")
    @ApiModelProperty(value = "tableWithdrawRecord", required = true)
    private String            tableWithdrawRecord;
    
    /**webSocketUrl*/
    //@NotNull(message = "webSocketUrl不可为空")
    @ApiModelProperty(value = "webSocketUrl", required = true)
    private String            webSocketUrl;
    
    /**topicKline1m*/
    //@NotNull(message = "topicKline1m不可为空")
    @ApiModelProperty(value = "topicKline1m", required = true)
    private String            topicKline1m;
    
    /**topicKline5m*/
    //@NotNull(message = "topicKline5m不可为空")
    @ApiModelProperty(value = "topicKline5m", required = true)
    private String            topicKline5m;
    
    /**topicKline15m*/
    //@NotNull(message = "topicKline15m不可为空")
    @ApiModelProperty(value = "topicKline15m", required = true)
    private String            topicKline15m;
    
    /**topicKline30m*/
    //@NotNull(message = "topicKline30m不可为空")
    @ApiModelProperty(value = "topicKline30m", required = true)
    private String            topicKline30m;
    
    /**topicKlineHour*/
    //@NotNull(message = "topicKlineHour不可为空")
    @ApiModelProperty(value = "topicKlineHour", required = true)
    private String            topicKlineHour;
    
    /**topicKlineDay*/
    //@NotNull(message = "topicKlineDay不可为空")
    @ApiModelProperty(value = "topicKlineDay", required = true)
    private String            topicKlineDay;
    
    /**topicKlineWeek*/
    //@NotNull(message = "topicKlineWeek不可为空")
    @ApiModelProperty(value = "topicKlineWeek", required = true)
    private String            topicKlineWeek;
    
    /**topicKlineMonth*/
    //@NotNull(message = "topicKlineMonth不可为空")
    @ApiModelProperty(value = "topicKlineMonth", required = true)
    private String            topicKlineMonth;
    
    /**topicEntrustDeepprice*/
    //@NotNull(message = "topicEntrustDeepprice不可为空")
    @ApiModelProperty(value = "topicEntrustDeepprice", required = true)
    private String            topicEntrustDeepprice;
    
    /**topicRealdealTransaction*/
    //@NotNull(message = "topicRealdealTransaction不可为空")
    @ApiModelProperty(value = "topicRealdealTransaction", required = true)
    private String            topicRealdealTransaction;
    
    /**topicRtquotationPrice*/
    //@NotNull(message = "topicRtquotationPrice不可为空")
    @ApiModelProperty(value = "topicRtquotationPrice", required = true)
    private String            topicRtquotationPrice;
    
    /**开放委托类型范围(limitPrice、marketPrice、limitAndMarket)*/
    //@NotNull(message = "开放委托类型范围不可为空")
    @ApiModelProperty(value = "开放委托类型范围(limitPrice、marketPrice、limitAndMarket)", required = true)
    private String            openEntrustType;
    
    /**数字货币借款日利率*/
    //@NotNull(message = "数字货币借款日利率不可为空")
    @ApiModelProperty(value = "数字货币借款日利率", required = true)
    private BigDecimal        digitBorrowDayRate;
    
    /**法定货币借款日利率*/
    //@NotNull(message = "法定货币借款日利率不可为空")
    @ApiModelProperty(value = "法定货币借款日利率", required = true)
    private BigDecimal        legalBorrowDayRate;
    
    /**借款总额度(交易标的)*/
    //@NotNull(message = "借款总额度(交易标的)不可为空")
    @ApiModelProperty(value = "借款总额度(交易标的)", required = true)
    private BigDecimal        tradeDebitTotal;
    
    /**计价标的借款总额度*/
    //@NotNull(message = "计价标的借款总额度不可为空")
    @ApiModelProperty(value = "计价标的借款总额度", required = true)
    private BigDecimal        capitalDebitTotal;
    
    /**理财日收益率*/
    //@NotNull(message = "理财日收益率不可为空")
    @ApiModelProperty(value = "理财日收益率", required = true)
    private BigDecimal        wealthDayRate;
    
    /**理财流水配置表*/
    //@NotNull(message = "理财流水配置表不可为空")
    @ApiModelProperty(value = "理财流水配置表", required = true)
    private String            tableWealthCurrent;
    
    /**做多溢价不高于百分比*/
    //@NotNull(message = "做多溢价不高于百分比不可为空")
    @ApiModelProperty(value = "做多溢价不高于百分比", required = true)
    private BigDecimal        maxLongFuse;
    
    /**做空负溢价不高于百分比*/
    //@NotNull(message = "做空负溢价不高于百分比不可为空")
    @ApiModelProperty(value = "做空负溢价不高于百分比", required = true)
    private BigDecimal        maxShortFuse;
    
    /**盘口累计量比例条分母*/
    //@NotNull(message = "盘口累计量比例条分母不可为空")
    @ApiModelProperty(value = "盘口累计量比例条分母", required = true)
    private BigDecimal        entrustAccumDenom;
    
    /**token合约地址*/
    //@NotNull(message = "token合约地址")
    @ApiModelProperty(value = "token合约地址")
    private String            tokenContactAddr;
    
    /**token小数精度*/
    //@NotNull(message = "token小数精度不可为空")
    @ApiModelProperty(value = "token小数精度", required = true)
    private BigDecimal        tokenDecimals;
    
    /**未认证用户提现当日额度上限*/
    //@NotNull(message = "未认证用户提现当日额度上限不可为空")
    @ApiModelProperty(value = "未认证用户提现当日额度上限", required = true)
    private BigDecimal        unauthUserWithdrawDayUpper;
    
    /**已认证用户提现当日额度上限*/
    //@NotNull(message = "已认证用户提现当日额度上限不可为空")
    @ApiModelProperty(value = "已认证用户提现当日额度上限", required = true)
    private BigDecimal        authedUserWithdrawDayUpper;
    
    /**小额提现热签临界值数量(小于等于就热签,大于就冷签)*/
    //@NotNull(message = "小额提现热签临界值数量(小于等于就热签,大于就冷签)不可为空")
    @ApiModelProperty(value = "小额提现热签临界值数量(小于等于就热签,大于就冷签)", required = true)
    private BigDecimal        smallWithdrawHotSignValue;
    
    /**小额充值手续费数量(小额充值收取SDF费用,但是充值金额要超过SDF的起点,否则不进行充值入账处理)*/
    //@NotNull(message = "小额充值手续费数量(小额充值收取SDF费用,但是充值金额要超过SDF的起点,否则不进行充值入账处理)不可为空")
    @ApiModelProperty(value = "小额充值手续费数量(小额充值收取SDF费用,但是充值金额要超过SDF的起点,否则不进行充值入账处理)", required = true)
    private BigDecimal        smallDepositFeeValue;
    
    /**小额充值标准临界值数量(小于等于就收取SDF，大于就不收取SDF)*/
    //@NotNull(message = "小额充值标准临界值数量(小于等于就收取SDF，大于就不收取SDF)不可为空")
    @ApiModelProperty(value = "小额充值标准临界值数量(小于等于就收取SDF，大于就不收取SDF)", required = true)
    private BigDecimal        smallDepositStandardValue;
    
    /**通道类型*/
    //@NotNull(message = "通道类型(内部internal、外部external)不可为空")
    @ApiModelProperty(value = "通道类型(内部internal、外部external)", required = true)
    private String            channelType;
    
    /**ws通道地址*/
    @ApiModelProperty(value = "ws通道地址")
    private String            channelWs;
    
    /**rest通道地址*/
    @ApiModelProperty(value = "rest通道地址")
    private String            channelRest;
    
    /**撮合交易模式 默认0数量撮合,1金额撮合**/
    //@NotNull(message = "撮合交易模式,默认0 (0数量撮合,1金额撮合)不可为空")
    @ApiModelProperty(value = "撮合交易模式", required = true)
    private Integer           matchtradeMode;
    
    /** 合约类型 inverseSwap反向永续合约,LinearSwap线性永续合约,inverseMonthDelivery反向交割合约*/
    private String            contractType;
    
    /** 合约单张合约面值 */
    private BigDecimal        contractPerValue;
    
    /** 合约保证金对应证券ID */
    private Long              contractMarginStockInfoId;
    
    /** 合约保证金数量单位 */
    private String            contractMarginAmtUnit;
    
    /** 合约保证金数量单位符号 */
    private String            contractMarginAmtSymbol;
    
    /** 合约保证金数量精度 */
    private Long              contractMarginAmtPrecision;
    
    /** 合约外部指数成份 */
    private String            contractIndexComponent;
    
    /** 合约资金费用交换时间 */
    private String            contractFundingRate;
    
    /** 合约资金费用交换调度时间 */
    private Long              contractFundingRateQuartz;
    
    /** 合约分摊结算时间 */
    private String            contractSocialiseLosses;

    /** 爆仓提前量，用于计算实时保证金 */
    private BigDecimal        preClosepositionRatio;
}
