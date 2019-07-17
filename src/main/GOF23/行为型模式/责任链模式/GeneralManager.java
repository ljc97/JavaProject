package 行为型模式.责任链模式;

/**
 * @Author Linjc
 * @Description 总经理
 * @date 2019/6/19
 */
public class GeneralManager extends Leader {

    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDays() < 30) {
            System.out.println("总经理审批了" + request.getEmpName() + "。审批通过");
        } else {
            System.out.println("要请" + request.getLeaveDays() + "天，要出事呀！不允许通过！！！");
        }
    }
}
