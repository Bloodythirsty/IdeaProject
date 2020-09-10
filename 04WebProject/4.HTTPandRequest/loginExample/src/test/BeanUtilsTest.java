package test;

import kk.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static org.apache.commons.beanutils.BeanUtils.getProperty;

/**
 * @author zkk;
 * @create 2020-03-26;
 */

public class BeanUtilsTest {

    @Test
    public void test(){
        User user = new User();
        try {
            //BeanUtils.setProperty(user,"username","zhang");       //设置username
            //BeanUtils.setProperty(user,"password","wowowo");      //设置password
            BeanUtils.setProperty(user,"haha","male");  //设置gender，用属性！！（set后面的小写）
            System.out.println("user = " + user);

            String gender = BeanUtils.getProperty(user,"haha");
            System.out.println("gender = " + gender);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
