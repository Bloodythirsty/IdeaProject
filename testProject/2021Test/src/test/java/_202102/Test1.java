package _202102;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import model.SimpleUser;
import model.User;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.junit.Test;
import org.apache.commons.collections4.CollectionUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * @author zhangkangkang created on 2021/2/2 4:21 下午
 */
public class Test1 {

    @Test
    public void Test() {
        List<Integer> integers = Lists.newArrayList(1, 2, 3,3,4,4, 5);
        List<Integer> integers1 = Lists.newArrayList(4, 5, 6, 7, 8);

        //交集
        Collection<Integer> duplicated = CollectionUtils.intersection(integers, integers1);
        for (Integer integer : duplicated) {
            System.out.println("交集 = " + integer);
        }
        System.out.println(" ========================= ");

        //差集的补集
        Collection<Integer> disjunction = CollectionUtils.disjunction(integers, duplicated);
        for (Integer integer : disjunction) {
            System.out.println("差集的补集 = " + integer);
        }
        System.out.println(" ========================= ");

        Collection<Integer> disjunction1 = CollectionUtils.disjunction(integers, integers1);
        for (Integer integer : disjunction1) {
            System.out.println("1 disjunction 2 = " + integer);
        }

        System.out.println(" ========================= ");


        // 并集
        Collection<Integer> union = CollectionUtils.union(integers, integers1);
        for (Integer integer : union) {
            System.out.println("并集 = " + integer);
        }

        System.out.println(" ========================= ");
        // 差集
        Collection<Integer> subtract = CollectionUtils.subtract(integers, integers1);
        for (Integer integer : subtract) {
            System.out.println("差集 = " + integer);
        }

        System.out.println(" ========================= ");
        // 差集
        Collection<Integer> integers2 = CollectionUtils.removeAll(integers, integers1);
        for (Integer integer : integers2) {
            System.out.println("removeall = " + integer);
        }

        System.out.println(" ========================= ");
        // 差集
        CollectionUtils.removeAll(integers, integers1);
        for (Integer integer : integers2) {
            System.out.println("removeall = " + integer);
        }
    }

    @Test
    public void testPartition(){
        ArrayList<Integer> list = Lists.newArrayList();
        for (int i = 0; i < 1020; i++) {
            list.add(i);
        }
        List<List<Integer>> partition = Lists.partition(list, 100);
        for (List<Integer> integers : partition) {
            System.out.println("integers.size() = " + integers.size());
        }
    }


    @Test
    public void testLength(){
        String s = "2021-21-21~2021-21-21";
        System.out.println("s.length() = " + s.length());
        String line = System.getProperty("line.separator");
    }

    @Test
    public void testString(){
        String s = String.format("你好%s,你在%s\n提交了一份%d", "张康康", "2021-01-21", 5);
        System.out.println("s = " + s);

        String s1 = "text.text";
        String substring = s1.substring(s1.lastIndexOf("."));
        System.out.println("substring = " + substring);
    }

    @Test
    public void testSystem(){
        System.out.println("java.home : "+System.getProperty("java.home"));

        System.out.println("java.class.version : "+System.getProperty("java.class.version"));

        System.out.println("java.class.path : "+System.getProperty("java.class.path"));

        System.out.println("java.library.path : "+System.getProperty("java.library.path"));

        System.out.println("java.io.tmpdir : "+System.getProperty("java.io.tmpdir"));

        System.out.println("java.compiler : "+System.getProperty("java.compiler"));

        System.out.println("java.ext.dirs : "+System.getProperty("java.ext.dirs"));

        System.out.println("user.name : "+System.getProperty("user.name"));

        System.out.println("user.home : "+System.getProperty("user.home"));

        System.out.println("user.dir : "+System.getProperty("user.dir"));


        Properties properties = System.getProperties();
        for (Object o : properties.keySet()) {
            System.out.println("o = " + o + "," + properties.get(o));
        }
    }

    @Test
    public void testJodaTime(){
        DateTime begin = new DateTime(2021, 3, 5, 5, 4);
        DateTime end = new DateTime(2021, 2, 25, 5, 4);
        int days = Days.daysBetween(end, begin).getDays();
        System.out.println("days = " + days);
    }

    @Test
    public void testIO1() throws IOException {
        File file = new File("/Users/didi/Documents/work/Snipaste_2021-03-01_14-48-17.png");
        byte[] buffer = new byte[(int)file.length()];
        FileInputStream fi = new FileInputStream(file);

        int offset = 0;
        int numRead = 0;
        while (offset < buffer.length && (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0) {
            offset += numRead;
        }

        fi.close();
    }

    @Test
    public void testJson(){
        String s = "select count(*) from (select * from ? where task_id = #{taskId}) tdt left join (select * from supervision.dwd_netcar_order_detail_df where dt='#(dt)') odt on odt.#{dataType} = tdt.value";
        String s1 = s.replaceAll("#\\{taskId}", "1");
        String s2 = s.replaceAll("#\\{sssss}", "2");
    }

    @Test
    public void testFor(){
        int index=0;
        int daysLimit = 2;
        for (int i = 0,k=1; i <= 8; i++,k++) {
            // TODO zhangkangkang 形成xlsx文件
            if (index++ == daysLimit) {
                index = 0;
            }
            System.out.println("i = " + i);
        }
    }

    @Test
    public void testStream(){
        List<User> users = Lists.newArrayList(
                User.builder().userId(1).userName("kk1").gender("男").hireDate(DateTime.now().toDate()).salary(111.0).build(),
                User.builder().userId(2).userName("kk2").gender("男").hireDate(DateTime.now().toDate()).salary(112.0).build(),
                User.builder().userId(3).userName("kk3").gender("男").hireDate(DateTime.now().toDate()).salary(113.0).build(),
                User.builder().userId(4).userName("kk4").gender("男").hireDate(DateTime.now().toDate()).build()
        );

        List<User> collect = users.stream().filter(e -> {
            return e.getUserId() == 1;
        }).collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }

    @Test
    public void testMap() {
        Map<String,String> map = Maps.newHashMap();
        map.put("1","1");
        map.put("2","3");
        map.put("3","3");
        map.put("4","4");
        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            System.out.println("stringStringEntry.getKey() = " + stringStringEntry.getKey());
            System.out.println("stringStringEntry.getValue() = " + stringStringEntry.getValue());
        }
    }

    @Test
    public void testString1() {
        String path = "test/d/e/w/122.exe";
        String name = path.substring(path.lastIndexOf("/")+1,path.lastIndexOf("."));
        System.out.println("name = " + name);
//        List<String> lis = Lists.newArrayList("1","2","3");
//        String join = StringUtils.join(lis, ",");
//        System.out.println("join = " + join);
    }

    @Test
    public void testLIst() {
        ArrayList<Integer> integers = Lists.newArrayList(1, 2, 3, 4);
        integers.remove(integers.size()-1);
        System.out.println("integers = " + integers);
    }

    @Test
    public void testEncode() throws UnsupportedEncodingException {
        String decode = URLDecoder.decode("%E5%8C%97%E4%BA%AC20210303.cvs", "utf-8");
//        String decode = URLDecoder.decode("%20", "utf-8");
        System.out.println("decode = " + decode);
        System.out.println("Charsets.UTF_8.toString() = " + Charsets.UTF_8.toString());
    }


    @Test
    public void testTime() {
        DateTime now = new DateTime(2021,02,03,10,10);
        String mm = now.toString("MM");
        System.out.println("mm = " + mm);
        String yyyy = now.toString("yyyy");
        System.out.println("yyyy = " + yyyy);
        String dd = now.toString("dd");
        System.out.println("dd = " + dd);
    }
}
