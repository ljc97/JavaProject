package 结构型模式.享元模式;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author Linjc
 * @Description 外部状态（UnShareConcreFlyWeight）
 * @date 2019/6/19
 */
@Getter
@Setter
public class Coordinate {

    private int x,y;//定义棋子的坐标

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
