package testService;

import com.google.common.base.CaseFormat;
import org.joda.time.DateTime;
import org.junit.Test;
import service.ServiceTest;

import javax.annotation.Resource;

/**
 * @author zhangkangkang created on 2021/3/12 10:53 上午
 */
public class TestService {

    ServiceTest serviceTest = new ServiceTest();

    @Test
    public void testService() throws InterruptedException {
        serviceTest.task();
    }

    @Test
    public void testTime() {
        DateTime begintTime = new DateTime(2021, 03, 1, 10, 10);
        String s = begintTime.toString("yyyy-MM-dd");
        System.out.println("s = " + s);
    }

    @Test
    public void testCamer() {
        System.out.println(CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, "test-data"));//testData
        System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "test_data"));//testData
        System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "test_data"));//TestData

        System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, "testData"));//testdata
        System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, "TestData"));//test_data
        System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_HYPHEN, "testData"));//test-data
    }
}
