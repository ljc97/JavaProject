package 行为型模式.责任链模式;

/**
 * @Author Linjc
 * @Description 经理
 * @date 2019/6/19
 */
public class Manager extends Leader {

    public Manager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDays() < 10) {
            System.out.println("经理审批了" + request.getEmpName() + "。审批通过");
        } else {
            if (this.nextLeader != null) {
                this.nextLeader.handleRequest(request);
            }
        }
    }
}
