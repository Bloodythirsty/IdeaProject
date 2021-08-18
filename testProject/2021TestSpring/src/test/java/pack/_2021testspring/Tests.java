package pack._2021testspring;

import pack._2021testspring.bean.Address;
import pack._2021testspring.bean.Person;
import pack._2021testspring.utils.DateUtils;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zhangkangkang created on 2021/2/5 5:48 下午
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class Tests {

    @Test
    public void testJson(){
        Address address = Address.builder().country("1").province("2").city("3").build();
        Person kk = Person.builder().name("kk").age(12).address(address).build();
        String s = JSONObject.toJSONString(kk);
        System.out.println("s = " + s);

        Person person = JSONObject.parseObject(s, Person.class);
        System.out.println("person = " + person);
    }

    @Test
    public void testDate(){
        List<Person> persons = Lists.newArrayList(
                Person.builder().name("kk").age(11).bir(new DateTime(2021, 1, 1, 01, 20).toDate()).build(),
                Person.builder().name("kk1").age(11).bir(new DateTime(2021, 1, 2, 01, 20).toDate()).build(),
                Person.builder().name("kk2").age(11).bir(new DateTime(2021, 1, 3, 01, 20).toDate()).build(),
                Person.builder().name("kk3").age(11).bir(new DateTime(2021, 1, 4, 01, 20).toDate()).build(),
                Person.builder().name("kk4").age(11).bir(new DateTime(2021, 1, 2, 01, 20).toDate()).build(),
                Person.builder().name("kk5").age(11).bir(new DateTime(2021, 1, 3, 01, 20).toDate()).build()
        );
        Map<String, List<Person>> collect = persons.stream().collect(Collectors.groupingBy(e -> {
            return new DateTime(e.getBir()).toString("yyyy-MM-dd");
        }));
        for (Map.Entry<String, List<Person>> entry : collect.entrySet()) {
            String key = entry.getKey();
            System.out.println("key = " + key);
            System.out.println("entry.getValue() = " + entry.getValue());
        }
    }

    @Resource
    private Address address;

    @Test
    public void testInit(){
//        Address address = new Address();
//        Map<String, String> map = address.getMap();
        Map<String, String> map = address.getMap();
    }

    @Resource
    private DateUtils dateUtils;

    @Test
    public void testAsync() {
        dateUtils.testAsync();
        System.out.println("done");
    }
}
