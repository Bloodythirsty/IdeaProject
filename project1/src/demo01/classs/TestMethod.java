package demo01.classs;

import demo01.domain.User;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestMethod {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        // System.out.println(Test.class.getName());
        // System.out.println(Class.forName(Test.class.getName()));
        // System.out.println(Class.forName(Test.class.getName()).newInstance());

        Method hello = TestMethod.class.getDeclaredMethod("hello");
        System.out.println(hello.getDeclaringClass());
        System.out.println(hello.getDeclaringClass().getName());
        System.out.println(hello.getDeclaringClass().getModifiers());
        System.out.println(hello.getDeclaringClass().getDeclaredConstructors());


        System.out.println(hello.getModifiers());
        System.out.println(hello.getDefaultValue());
        System.out.println(hello.getGenericReturnType());
        System.out.println(hello.getReturnType());

    }




    public static List<User> hello(){
        List<User> list = new ArrayList<>();
        list.add(new User());
        return list;
    }
}
