package com.linjc.多线程.高并发demo.redisdemo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;

/**
 * @Description: //TODO
 * @Author: 林经翀（jingchong.lin@ucarinc.com）
 * @Date 2019/9/3 8:41
 * @Version 1.0
 */
class CustomerThread implements Runnable {
    // 监视的商品
    String watchKey = "goods";
    String clientKey = "client";
    String customerName;

    CustomerThread(int num) {
        this.customerName = "客户编号:" + num;
    }

    @Override
    public void run() {
        try {
//随机暂停
            Thread.sleep((int) (Math.random() * 5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true) {
            System.out.println(customerName + "开始抢商品！");
            Jedis jedis = new Jedis("localhost");
            try {
                jedis.watch(watchKey);
                int goodsCount = Integer.parseInt(jedis.get(watchKey));
                if (goodsCount > 0) {
                    //开启事物
                    Transaction transaction = jedis.multi();
                    transaction.set(watchKey, String.valueOf(goodsCount - 1));
                    //提交事物
                    List<Object> result = transaction.exec();
                    if (!result.isEmpty()) {
                        jedis.sadd(clientKey, customerName);
                        System.out.println("顾客" + customerName + "抢到了￥￥￥￥");
                        break;
                    } else {
                        System.out.println("顾客" + customerName + "没抢到！！！！");
                    }
                } else {
                    System.out.println("顾客" + customerName + "没货了！！！！");
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                jedis.unwatch();
                jedis.close();
            }
        }
    }
}
