package com.linjc.多线程.信号灯法.电影院;

/**
 * @Author Linjc
 * @Description 生产者
 * @date 2019/5/16
 */
public class Player extends Thread {
    private Movie movie;


    public Player(Movie movie) {
        this.movie = movie;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                movie.play("hello");
                System.out.println("生产了：hello");
            } else {
                movie.play("WORD");
                System.out.println("生产了：WORD");
            }
        }
    }
}
