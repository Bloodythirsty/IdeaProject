package Lambda;

import java.util.*;
import java.util.function.Consumer;

public class Test {
    public static void main(String[] args) {
        TreeSet<Person> tree = new TreeSet<>((o1,o2)->{
            if (o1.age >= o2.age)   return -1;
            else return 1;
        });


        tree.add(new Person("zkk",15));
        tree.add(new Person("zkk2",20));
        tree.add(new Person("zkk3",14));
        tree.add(new Person("zkk4",15));
        tree.add(new Person("zkk5",96));
        tree.add(new Person("zkk6",100));
        tree.add(new Person("zkk7",1));

        System.out.println("set = " + tree);
    }

    @org.junit.Test
    public void testList(){
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("zkk",15));
        list.add(new Person("zkk2",20));
        list.add(new Person("zkk3",14));
        list.add(new Person("zkk4",15));
        list.add(new Person("zkk5",96));
        list.add(new Person("zkk6",100));
        list.add(new Person("zkk7",1));

        list.sort((o1,o2)-> o1.age-o2.age);
        // list.sort(Comparator.comparingInt(o -> o.age));
        System.out.println("list = " + list);
    }

    @org.junit.Test
    public void testForeach(){
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,3,4,65,7,8);

        //将集合中的每一个元素都带入到accept方法中，使用方法引用
        list.forEach(System.out::println);
        System.out.println("----------------------------------------");

        //输出集合中的偶数
        list.forEach(ele ->{
            if ((ele&1)==0) System.out.println("ele = " + ele);
        });

        for (int i = 0; i < list.size(); i++) {
            Integer integer = list.get(i);
            System.out.println("integer = " + integer);
        }
    }

    @org.junit.Test
    public void testForeachRemove(){
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,3,4,65,7,8,30);

        //将集合中的每一个元素都带入到accept方法中，使用方法引用
        list.forEach(System.out::println);
        System.out.println("----------------------------------------");

        //输出集合中的偶数
        // Iterator<Integer> iterator = list.iterator();
        // while (iterator.hasNext()){
        //     int temp = iterator.next();
        //     if (temp>10){
        //         iterator.remove();
        //     }
        // }

        list.removeIf(temp -> temp > 10);
        System.out.println("list = " + list);

    }

    @org.junit.Test
    public void testConsumer(){
        Consumer<Integer> consumer = (a) -> {
            System.out.println("a*2 = " + a * 2);
        };

        consumer.accept(10);
    }


}
