package com.linjc.GOF23.创建型模式.建造者模式;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author Linjc
 * @Description 需要生产出的对象
 * @date 2019/6/14
 */
@Data
public class AirShip {
    private OrbitalModule orbitalmodule; //轨道舱

    private Engine engine;  //发动机

    private EscapeTower escapeTower;  //逃逸塔
}

//以下是飞船所需要的零件
class OrbitalModule {
    @Setter
    @Getter
    private String name;
}

class Engine {
    @Setter
    @Getter
    private String name;
}

class EscapeTower {
    @Setter
    @Getter
    private String name;
}