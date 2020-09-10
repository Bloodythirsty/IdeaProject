package unsafe;

import sun.misc.Unsafe;
import sun.util.resources.LocaleNames_ga;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Person {
    /*
    1. 一般非数组对象	 8个字节对象头(mark) + 4/8字节对象指针 + 数据区 + padding内存对齐(按照8的倍数对齐)
    2. 数组对象       8个字节对象头(mark) + 4/8字节对象指针 + 4字节数组长度 + 数据区 + padding内存对齐(按照8的倍数对齐)
        1. 所以 I_OFFSET = 12 = 8个字节对象头(mark) + 4字节对象指针
        2. J_OFFSET = 8个字节对象头(mark) + 4字节对象指针 + int类型4个
        3. TABLE_OFFSET = 8个字节对象头(mark) + 4字节对象指针 + int类型4个 + int类型4个
        4. 则Person总共大小：没赋值的不占内存，复制后又算
            1. ShallowSize（Person） = Size(对象头) + Size(oop指针) + Size(内容) + Size(对齐)
                                    = 8 + 4 + 2*4（两int） + 4（table数组引用）
                                    = 24
            2. Size（String[] table）= 8(数组对象头) + 4(oop指针) + 4(数组长度) + 4*4（数组里面的对象引用）
                                    = 16+16
                                    =32
            3. 则Size(Person) =  24 + 32 = 56 （此处假设table里面没赋值，只是定义了4个元素）
            4. 若table像下面一样已经赋值：
                1. 则size(String) = 8 + 4 + String中的内容

     */
    private int i = 0;
    private int j = 1;
    private static Unsafe UNSAFE;
    private static long I_OFFSET;
    private String[] table = {"1","2","3","4"};

    static{
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");    //theUnsafe : 通过反射机制，获取Unsafe类里面的theUnsafe变量
            field.setAccessible(true);
            /*
            Field.get(Object ob) 返回指定对象上此Field表示的字段的值。 如果值具有原始类型，则该值将自动包装在一个对象中。
                1. 如果基础字段是静态字段，则obj参数被忽略； 它可以为空。
                    否则，基础字段是实例字段。 如果指定的obj参数为null，则该方法将引发NullPointerException。
                2. 如果指定的对象不是声明基础字段的类或接口的实例，则该方法将引发IllegalArgumentException。
                3. 如果此Field对象正在实施Java语言访问控制，并且基础字段不可访问，则该方法将引发IllegalAccessException。
                4. 如果基础字段是静态的，则声明该字段的类（如果尚未初始化）将被初始化。
                5. 否则，将从基础实例或静态字段中检索值。 如果该字段具有原始类型，则该值将在返回之前包装在一个对象中，否则将按原样返回。
                6. 如果字段以obj类型隐藏，则该字段的值将根据前面的规则获得。
             */
            UNSAFE = (Unsafe)field.get(null);

            I_OFFSET = UNSAFE.objectFieldOffset(Person.class.getDeclaredField("i"));    //获取
            Long J_OFFSET = UNSAFE.objectFieldOffset(Person.class.getDeclaredField("j"));    //获取
           // Long UNSAFE_OFFSET = UNSAFE.objectFieldOffset(Person.class.getDeclaredField("UNSAFE"));    //获取
            Long TABLE_OFFSET = UNSAFE.objectFieldOffset(Person.class.getDeclaredField("table"));    //获取对象里面field的偏移量
            System.out.println("I_OFFSET = " + I_OFFSET);
            System.out.println("J_OFFSET = " + J_OFFSET);
           // System.out.println("UNSAFE_OFFSET = " + UNSAFE_OFFSET);
            System.out.println("TABLE_OFFSET = " + TABLE_OFFSET);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return "Person{" +
                "i=" + i +
                ", table=" + Arrays.toString(table) +
                '}';
    }

    public static void main(String[] args) {
        Person person = new Person();
        UNSAFE.compareAndSwapInt(person,I_OFFSET,1,2);      //乐观锁CAS去设置值，若传入的旧制与期望对不上，则不改变值
        System.out.println(UNSAFE.getInt(person,I_OFFSET));
        System.out.println(person);

        long ss = UNSAFE.arrayIndexScale(Person[].class);   //获取数组中一个元素的大小，其实是引用大小 4（32位虚拟机） 8（64位虚拟机）
        long base = UNSAFE.arrayBaseOffset(int[].class);    //获取数组中第一个元素的偏移量，8+4+4 = 16
        System.out.println("ss = " + ss);
        System.out.println("base = " + base);
        System.out.println(UNSAFE.getObject(person.table,base));
        System.out.println(UNSAFE.getObject(person.table,base+ss));
        System.out.println(UNSAFE.getObject(person.table,base+ss*2));
        System.out.println(UNSAFE.getObject(person.table,base+ss*3));

    }
}
