package com.linjc.多线程.信号灯法.电影院;

/**
 * @Author Linjc
 * @Description
 * @date 2019/5/16
 */
public class App {
    public static void main(String[] args) {
//        创建资源
        Movie movie = new Movie();

//        创建多个线程
        Thread player = new Player(movie);
        Thread watcher = new Watcher(movie);

        player.start();
        watcher.start();
    }
}
