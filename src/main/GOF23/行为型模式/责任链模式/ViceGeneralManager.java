package 行为型模式.责任链模式;

/**
 * @Author Linjc
 * @Description 副总经理
 * @date 2019/6/19
 */
public class ViceGeneralManager extends Leader {

    public ViceGeneralManager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDays() < 20) {
            System.out.println("副总经理审批了" + request.getEmpName() + "。审批通过");
        } else {
            if (this.nextLeader != null) {
                this.nextLeader.handleRequest(request);
            }
        }
    }
}
