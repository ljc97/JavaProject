package com.linjc.GOF23.结构型模式.组合模式;

public interface Component {
    void operation();
}

//容器节点
interface Composite extends Component {
    void add(Component component);

    void del(Component component);

    Component getChild(int index);
}

//叶子节点
interface Leaf extends Component {

}
