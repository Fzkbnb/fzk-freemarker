package com.fzk.freemarker.biex;

import com.fzk.freemarker.biex.producer.BiexProducer;

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
        BiexProducer p = new BiexProducer();
//        p.pruduceSql();
//        p.pruduceController();
        p.pruduceJsp();
    }
}
