package demo01.classs;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TestMain {
    public static void main(String[] args) {
        Class domainClass = TestTypeUsage.class;
        Method[] methods = domainClass.getMethods();
        for (Method m:methods){

            System.out.println("================================");

            System.out.println("m = " + m);                         //public abstract java.util.Map demo01.classs.TestTypeUsage.find()
            boolean flag = m.isAnnotationPresent(Select.class);
            if (flag){
                Select selectAnno = m.getAnnotation(Select.class);
                String value = selectAnno.value();
                System.out.println("selectValue = " + value);

                Type type = m.getGenericReturnType();
                System.out.println("type = " + type);               //java.util.Map<java.lang.String, demo01.domain.User>

                ParameterizedType ptype = (ParameterizedType)type;
                Type[] types = ptype.getActualTypeArguments();          //获取String，User
                for (int i = 0; i < types.length; i++) {
                    System.out.println("------------------------------");
                    System.out.println("p = " + types[i]);                  //types[0]就是String class：class java.lang.String
                    System.out.println(types[i].getClass());                //class java.lang.Class
                    System.out.println(types[i].getClass().getName());      //java.lang.Class
                    System.out.println(types[i].getTypeName());             //java.lang.String

                    Class clazz = (Class) types[i];
                    System.out.println("clazz.getName() = " + clazz.getName()); //java.lang.String

                }
            }
        }
    }
}
