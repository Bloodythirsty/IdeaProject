package TestBase;

import model.UserSon;
import org.junit.Test;

/**
 * Created by kangkang on 2021/3/21 1:39
 */
public class TestBas {
    // 测试父类私有属性子类能否使用
    @Test
    public void test1(){
        UserSon userSon = new UserSon();
        userSon.setGender("s");
    }
}
