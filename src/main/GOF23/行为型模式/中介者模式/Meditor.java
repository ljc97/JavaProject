package 行为型模式.中介者模式;

import java.util.HashMap;
import java.util.Map;

public interface Meditor {
    void register(String deptName, Department department);

    void command(String deptName);
}

//中介者的实现类（总经理）
class Manager implements Meditor {
    private Map<String, Department> map = new HashMap<>();

    @Override
    public void register(String deptName, Department department) {
        map.put(deptName, department);
    }

    @Override
    public void command(String deptName) {
        Department department = map.get(deptName);
        if (department != null) {
            department.selfAction();
        } else {
            System.out.println("不存在该部门。。。");
        }
    }
}