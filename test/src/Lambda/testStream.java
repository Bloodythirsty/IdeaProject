package Lambda;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class testStream {

    private ArrayList<Apple> getApples() {
        ArrayList<Apple> apples = new ArrayList<>();
        apples.add(new Apple(1,"green",100,"北京"));
        apples.add(new Apple(2,"red",120,"北京"));
        apples.add(new Apple(3,"green",200,"天津"));
        apples.add(new Apple(4,"red",110,"天津"));
        apples.add(new Apple(5,"green",100,"河南"));
        apples.add(new Apple(6,"red",1200,"河南"));
        apples.add(new Apple(7,"green",100,"安徽"));
        apples.add(new Apple(8,"red",1000,"安徽"));
        return apples;
    }

    //获取红色最大值

    @Test
    public void testStream(){
        ArrayList<Apple> apples = getApples();

        Apple apple = apples.stream()
                .filter(e -> e.getColor().equals("red"))
                .max(Comparator.comparingInt(Apple::getWeight))
                .get();
        System.out.println("apple = " + apple);
    }

    //打印红色
    @Test
    public void testStream2(){
        ArrayList<Apple> apples = getApples();
        List<Apple> red = apples.stream()
                .filter(o1 -> o1.getColor().equals("red"))
                .collect(Collectors.toList());
        System.out.println("red = " + red);

        System.out.println("============================");

        apples.stream()
                .filter(o1 -> o1.getWeight()>1000)
                .forEach(System.out::println);
    }

    //转换
    @Test
    public void testStream3(){
        ArrayList<Apple> apples = getApples();
        apples.stream()
                .map(apple -> apple.getColor())     //Appple对象转换为String
                .distinct()
                .peek(System.out::println)
                .toArray();
    }

    //分组
    @Test
    public void testStream4(){
        ArrayList<Apple> apples = getApples();
        Map<String, List<Apple>> collect = apples.stream()
                .collect(Collectors.groupingBy(apple -> apple.getColor()));
        System.out.println("collect = " + collect);
    }

    @Test
    public void flatMap() {
        Stream<int[]> stream = IntStream
                .rangeClosed(1, 10)
                .boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 10)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                        .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                );
        stream.limit(5).forEach(a -> System.out.println(a[0] + " " + a[1] + " " + a[2]));
    }

    @Test
    public void testMapStream() {
        Map<String,String> map = new HashMap<>();
        map.put("zhang","kang");
        map.put("wang","wu");
        map.put("lisi","ahha");

        Set<String> strings = map.keySet();
        Collection<String> values = map.values();
        Set<Map.Entry<String, String>> entries = map.entrySet();
        entries.stream()
                .filter(o -> {
                    int a = o.getKey().compareTo("a");
                    if (a>=0) return true;
                    else return false;
                })
                .peek(System.out::println)
                .collect(Collectors.toSet());

        String collect = strings.stream()
                .collect(Collectors.joining(","));
        System.out.println("collect = " + collect);

    }


}
