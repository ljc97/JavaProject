package 行为型模式.迭代器模式;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author Linjc
 * @Description 自定义的聚合类
 * @date 2019/6/20
 */
@Setter
@Getter
public class ConcreteMyAggregate {
    private List list = new LinkedList();

    public void addObject(Object obj) {
        list.add(obj);
    }

    public void delObject(Object obj) {
        list.remove(obj);
    }

    //    提供对外的内部类方法
    public MyIterator createInterator() {
        return new ConcreteInterator();
    }

    //    使用内部类定义迭代器，可以直接使用外部类的属性
    private class ConcreteInterator implements MyIterator {
        //        定义游标用于记录遍历时的位置，默认为第一个位置
        private int cursor;

        public void isLegal() {
            if (cursor > list.size() - 1) {
                throw new RuntimeException("数组越界了。。。");
            }
        }

        @Override
        public void first() {
            cursor = 0;
        }

        @Override
        public void next() {
            if (cursor < list.size()) {
                cursor++;
            }
        }

        @Override
        public boolean hasNext() {
            return cursor < list.size();
        }

        @Override
        public boolean isFirst() {
            return cursor == 0;
        }

        @Override
        public boolean isLast() {
            return cursor == list.size() - 1;
        }

        @Override
        public Object getCurrentObj() {
            isLegal();
            return list.get(cursor);
        }
    }

}
