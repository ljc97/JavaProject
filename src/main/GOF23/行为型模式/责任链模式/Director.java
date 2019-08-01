package 行为型模式.责任链模式;

/**
 * @Author Linjc
 * @Description 主任
 * @date 2019/6/19
 */
public class Director extends Leader {

    public Director(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDays() < 3) {
            System.out.println("主任审批了" + request.getEmpName() + "。审批通过");
        } else {
            if (this.nextLeader != null) {
                this.nextLeader.handleRequest(request);
            }
        }
    }
}
