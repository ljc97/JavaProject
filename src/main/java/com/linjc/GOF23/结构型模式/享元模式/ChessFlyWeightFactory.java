package com.linjc.GOF23.结构型模式.享元模式;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Linjc
 * @Description
 * @date 2019/6/19
 */
public class ChessFlyWeightFactory {
    //享元池
    private static Map<String, ChessFlyWeight> map = new HashMap<>();


    public static ChessFlyWeight getChess(String color) {
        if (map.get(color) != null) {
            return map.get(color);
        } else {
            ChessFlyWeight chessFlyWeight = new ConcreteChess(color);
            map.put(color, chessFlyWeight);
            return chessFlyWeight;
        }
    }


}
