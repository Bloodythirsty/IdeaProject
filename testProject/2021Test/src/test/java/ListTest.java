import com.google.common.collect.Lists;
import model.User;
import org.joda.time.DateTime;
import org.junit.Test;
import service.ServiceTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author zhangkangkang created on 2021/3/15 12:39 上午
 */
public class ListTest {

    // 多个字段排序
    @Test
    public void testOrderBy() {
        List<User> users = Lists.newArrayList(
                User.builder().userId(1).userName("kk1").gender("男").hireDate(DateTime.now().toDate()).salary(111.0).build(),
                User.builder().userId(1).userName("kk2").gender("男").hireDate(DateTime.now().toDate()).salary(112.0).build(),
                User.builder().userId(2).userName("kk3").gender("男").hireDate(DateTime.now().toDate()).salary(113.0).build(),
                User.builder().userId(2).userName("kk4").gender("男").hireDate(DateTime.now().toDate()).salary(114.0).build()
        );
        // 1。
//        Comparator<User> userId = Comparator.comparing(User::getUserId);
//        Comparator<User> userName = Comparator.comparing(User::getUserName).reversed();
//        users.sort(userId.thenComparing(userName));

        //2。
//        List<User> collect = users.stream().sorted(Comparator.comparing(User::getUserId).thenComparing(Comparator.comparing(User::getUserName).reversed())).collect(Collectors.toList());
//        for (User user : users) {
//            System.out.println("user = " + user);
//        }
//        for (User user : collect) {
//            System.out.println("user = " + user);
//        }

        Comparator<User> cmp = Comparator.comparing(User::getUserId).thenComparing(Comparator.comparing(User::getUserName).reversed());
        users.sort(cmp);
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }

    // 多个字段去重

    @Test
    public void testDistinct() {
        List<User> users = Lists.newArrayList(
                User.builder().userId(1).userName("kk1").gender("男").hireDate(DateTime.now().toDate()).salary(111.0).build(),
                User.builder().userId(1).userName("kk2").gender("男").hireDate(DateTime.now().toDate()).salary(1121.0).build(),
                User.builder().userId(1).userName("kk2").gender("男").hireDate(DateTime.now().toDate()).salary(1122.0).build(),
                User.builder().userId(2).userName("kk3").gender("男").hireDate(DateTime.now().toDate()).salary(1133.0).build(),
                User.builder().userId(2).userName("kk3").gender("男").hireDate(DateTime.now().toDate()).salary(1134.0).build(),
                User.builder().userId(2).userName("kk4").gender("男").hireDate(DateTime.now().toDate()).salary(114.0).build()
        );

//        ArrayList<User> collect = users.stream().collect(Collectors.collectingAndThen(
//                Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(o -> o.getUserId() + ";" + o.getUserName()))),
//                ArrayList::new));

        ArrayList<User> collect = users.stream().collect(Collectors.collectingAndThen(
                Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(User::getUserId))),
                ArrayList::new));

        for (User user : collect) {
            System.out.println("user = " + user);
        }
    }

    @Resource
    private ServiceTest serviceTest;

    @Test
    public void test() {
        List<User> users = Lists.newArrayList(
                User.builder().userId(1).userName("kk1").gender("男").hireDate(DateTime.now().toDate()).salary(111.0).build(),
                User.builder().userId(1).userName("kk2").gender("男").hireDate(DateTime.now().toDate()).salary(1121.0).build(),
                User.builder().userId(1).userName("kk2").gender("男").hireDate(DateTime.now().toDate()).salary(1122.0).build(),
                User.builder().userId(2).userName("kk3").gender("男").hireDate(DateTime.now().toDate()).salary(1133.0).build(),
                User.builder().userId(2).userName("kk3").gender("男").hireDate(DateTime.now().toDate()).salary(1134.0).build(),
                User.builder().userId(2).userName("kk4").gender("男").hireDate(DateTime.now().toDate()).salary(114.0).build()
        );
        serviceTest.distinct(users);

        for (User user : users) {
            System.out.println("user = " + user);
        }
    }
}
