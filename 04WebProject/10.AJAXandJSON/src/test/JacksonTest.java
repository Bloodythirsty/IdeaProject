package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.*;

public class JacksonTest {

    //JAVA对象转为JSON
    @Test   //一般下载到库中后以后就可以直接用
    public void test1() throws Exception {
        //1. 创建person
        Person p = new Person();
        p.setAge(22);
        p.setGender("男");
        p.setName("张三");

        //2. 创建核心对象
        ObjectMapper mapper = new ObjectMapper();

        //3. 转换
        /*
        方法：
            1. writeValue(参数1, obj);
                1. 参数1：
                    - File: 将OBJ对象转换为JSon字符串，并保存到指定文件
                    - Writer：将OBJ对象转换为JSon字符串，并将JSON数据填充到字符输出流中
                    - OutPutStream：将OBJ对象转换为JSon字符串，并将JSON数据填充到字节输出流中
            2. writeValueAsString(obj); 将对象转为JSON字符串
         */

//        //2. writeValueAsString(obj); 将对象转为JSON字符串
//        String string = mapper.writeValueAsString(p);
//        System.out.println("string = " + string);

        //1. writeValue(参数1, obj);
        //1.1 将数据写到本项目下，json.txt
        //mapper.writeValue(new File("json.txt"),p);
        //1.2 关联到字符输出流
        //mapper.writeValue(new FileWriter("json_1.txt"),p);
        // 1.3 输出到控制套
        mapper.writeValue(System.out,p);
    }


    @Test   //一般下载到库中后以后就可以直接用
    public void test2() throws Exception {
        //1. 创建person
        Person p = new Person();
        p.setAge(22);
        p.setGender("男");
        p.setName("张三");
        p.setBir(new Date());

        //2. 创建核心对象
        ObjectMapper mapper = new ObjectMapper();

        //3. 转换
        String string = mapper.writeValueAsString(p);
        System.out.println("string = " + string);       //{"name":"张三","gender":"男","age":22,"bir":"2020年04月25日"}
    }

    @Test   //一般下载到库中后以后就可以直接用
    public void test3() throws Exception {
        //1. 创建person
        Person p1 = new Person();
        p1.setAge(22);
        p1.setGender("男");
        p1.setName("李四");
        p1.setBir(new Date());

        Person p2 = new Person();
        p2.setAge(22);
        p2.setGender("男");
        p2.setName("王五");
        p2.setBir(new Date());

        Person p3 = new Person();
        p3.setAge(22);
        p3.setGender("男");
        p3.setName("张三");
        p3.setBir(new Date());

        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);


        //2. 创建核心对象
        ObjectMapper mapper = new ObjectMapper();

        //3. 转换
        String string = mapper.writeValueAsString(list);
        System.out.println("string = " + string);
    }

    @Test   //一般下载到库中后以后就可以直接用
    public void test4() throws Exception {
        //1. 创建Map
        Map<String,Object> map = new HashMap<>();
        map.put("name","zhangsan");
        map.put("age",22);

        //2. 创建核心对象
        ObjectMapper mapper = new ObjectMapper();

        //3. 转换
        String string = mapper.writeValueAsString(map);
        System.out.println("string = " + string);
    }

    //JSON转JAVA
    @Test   //一般下载到库中后以后就可以直接用
    public void test5() throws Exception {
        //创建JSON字符串
        String json = "{\"name\":\"张三\",\"gender\":\"男\",\"age\":22,\"bir\":\"2020年04月25日\"}";
        //创建对象
        ObjectMapper mapper = new ObjectMapper();
        //调用方法
        Person person = mapper.readValue(json, Person.class);
        System.out.println("person = " + person);
    }

}
