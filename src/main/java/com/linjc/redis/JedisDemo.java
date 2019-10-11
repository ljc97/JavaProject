package com.linjc.redis;

/**
 * @Author Linjc
 * @Description
 * @date 2019/9/1
 */
public class JedisDemo {

    public static void main(String[] args) {
        RedisUtil redisUtil = RedisUtil.getRedisUtil();
        try {
//            字符串的添加
//            redisUtil.set("name", "yytljc");
//            System.out.println(redisUtil.get("name"));
//            redisUtil.append("name", "1314");

//            判断是否存在key
//            System.out.println(redisUtil.exists("name"));

//            redisUtil.mset("a","A","s","S");
//            System.out.println(redisUtil.mget("a","s"));


//            取出所有的key
//            Stream<String> stream = redisUtil.keys("*").stream();
//            stream.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
}
