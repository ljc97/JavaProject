package InvokeTest.reflect;

import InvokeTest.reflect.model.Student;

public class Test {
    public static void main(String[] args) {
//        ClassUtil.printClassMessage(Student.class);
//        ClassUtil.getFields(new Integer(1));
        ClassUtil.getContructor(new Student());
    }

}
