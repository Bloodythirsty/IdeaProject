package TestFan;

import serializable.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author zhangkangkang
 * @date 2021/08/10 17:14
 */
public  class Convertor<T> {
    public T test(T t) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<?> declaredConstructor = t.getClass().getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        T s = (T) declaredConstructor.newInstance("s");
        return s;
    }

    public static void main(String[] args) {
    }
}
