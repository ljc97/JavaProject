package test1;

import com.linjc.IOCTest.AnotherBean;
import com.linjc.IOCTest.Bean;
import com.linjc.IOCTest.IOCtest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IOCtestTest {

    public IOCtest ioCtest = new IOCtest();

    @Before
    public void setUp() throws Exception {
        ioCtest.setBean(AnotherBean.class, "anotherBean");
        ioCtest.setBean(Bean.class, "bean", "anotherBean");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void test() {
        Bean bean = (Bean) ioCtest.getBean("bean");
        System.out.println(bean.toString());
    }
}