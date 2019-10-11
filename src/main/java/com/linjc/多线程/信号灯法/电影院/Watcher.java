package com.linjc.多线程.信号灯法.电影院;

/**
 * @Author Linjc
 * @Description 消费者
 * @date 2019/5/16
 */
public class Watcher extends Thread {
    private Movie movie;

    public Watcher(Movie movie) {
        this.movie = movie;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            movie.watch();
        }
    }
}
