package 结构型模式.享元模式;

//享元类
public interface ChessFlyWeight {
    void setColor(String color);

    String getColor();

    void display(Coordinate coordinate);
}


class ConcreteChess implements ChessFlyWeight {

    private String color;

    public ConcreteChess(String color) {
        this.color = color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void display(Coordinate coordinate) {
        System.out.println("棋子颜色:" + color);
        System.out.println("棋子位置X:" + coordinate.getX() + ",Y:" + coordinate.getY());
    }
}