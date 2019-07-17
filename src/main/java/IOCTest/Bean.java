package IOCTest;

public class Bean {
    public AnotherBean anotherBean;

    public AnotherBean getAnotherBean() {
        return anotherBean;
    }

    public void setAnotherBean(AnotherBean anotherBean) {
        this.anotherBean = anotherBean;
    }

    public Bean(AnotherBean anotherBean) {
        this.anotherBean = anotherBean;
        System.out.println("I am Bean!!!!");
    }

    @Override
    public String toString() {
        return "Bean{" +
                "anotherBean=" + anotherBean +
                '}';
    }
}
