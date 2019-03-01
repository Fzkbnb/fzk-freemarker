package com.fzk.freemarker.biex;

import com.fzk.freemarker.biex.producer.BiexProducer;

import java.math.BigDecimal;

/**
 * @program: fzk-freemarker
 *
 * @description: 入口类
 *
 * @author: fzk
 *
 * @create: 2019-02-21 13:40
 **/
public class ProduceServer
{
    public static void main(String[] args) throws ClassNotFoundException
    {
        System.out.println(System.getProperty("user.dir"));//user.dir指定了当前的路径
//        BiexProducer p = new BiexProducer();
//        p.pruduceSql();
//        p.pruduceController();
//        p.pruduceJsp();
//        //传入实体类列表
//        String[] strs = new String[]{"AccountFundCurrentMem","AccountWalletAssetMem","EntrustVCoinMoneyMem","RealDealVCoinMoneyMem"};
//        p.pruduceTmp(strs);
    }

}
