package 行为型模式.责任链模式;

/**
 * @Author Linjc
 * @Description
 * @date 2019/6/19
 */
public abstract class Leader {
    protected String name;

    protected Leader nextLeader;  //责任链上的后继对象

    public Leader(String name) {
        this.name = name;
    }

//    设定责任链上的后继对象
    public void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }


//    处理请求的核心方法
    public abstract void handleRequest(LeaveRequest leaveRequest);
}
