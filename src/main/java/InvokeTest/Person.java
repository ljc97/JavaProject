package InvokeTest;

import lombok.Data;

@Data
public class Person {

    public String name;

    private int age;

    protected char sex;

    String tel;

    public void say(String word) {
        System.out.println("I said:" + word);
    }

    private void sleep() {
        System.out.println("I want go sleep");
    }
}
