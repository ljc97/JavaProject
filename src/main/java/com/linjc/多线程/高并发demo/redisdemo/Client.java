package com.linjc.多线程.高并发demo.redisdemo;

import redis.clients.jedis.Jedis;

import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: //TODO
 * @Author: 林经翀（jingchong.lin@ucarinc.com）
 * @Date 2019/9/3 8:38
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        initGoogs();
        System.out.println("################初始化商品完成##################");
        secKill();
        System.out.println("################秒杀商品完成##################");
        print();
    }


    /**
     *  * 初始化商品
     *  
     */
    private static void initGoogs() {
        Jedis jedis = new Jedis("localhost");
        String watchKey = "goods";
        int goodsCount = 20;
        jedis.set(watchKey, String.valueOf(goodsCount));
    }

    /**
     *  * 模拟多个用户抢购
     *  
     */
    private static void secKill() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        // 模拟客户数目
        int clientNum = 21;
        for (int i = 0; i < clientNum; i++) {
            cachedThreadPool.execute(new CustomerThread(i));
        }
        cachedThreadPool.shutdown();
        while (true) {
            if (cachedThreadPool.isTerminated()) {
                System.out.println("所有的线程都结束了！");
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *  * 打印秒杀结果
     *  
     */
    public static void print() {
        Jedis jedis = new Jedis("localhost");
        Set<String> set = jedis.smembers("client");
        int i = 1;
        for (String value : set) {
            System.out.println("第" + i++ + "个抢到商品，" + value + " ");
        }

        jedis.del("client");
    }
}

