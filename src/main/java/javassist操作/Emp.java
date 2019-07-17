package javassist操作;

/**
 * @Author Linjc
 * @Description
 * @date 2019/5/24
 */
public class Emp {
    private String empNo;

    private String empName;

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Emp() {
    }

    public Emp(String empNo, String empName) {
        this.empNo = empNo;
        this.empName = empName;
    }
}
