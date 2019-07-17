package 行为型模式.责任链模式;

/**
 * @Author Linjc
 * @Description
 * @date 2019/6/19
 */
public class Client {

    public static void main(String[] args) {
        Leader director = new Director("主任");
        Leader manager = new Manager("经理");
        ViceGeneralManager viceGeneralManager = new ViceGeneralManager("副总经理");
        Leader generalManager = new GeneralManager("总经理");
        director.setNextLeader(manager);
        manager.setNextLeader(viceGeneralManager);
        viceGeneralManager.setNextLeader(generalManager);

        LeaveRequest request = new LeaveRequest("zzz", 19, "zzzzz");

        director.handleRequest(request);
    }
}
