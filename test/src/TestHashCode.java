import pojo.ClassesInfo;
import pojo.User;

public class TestHashCode {
    public static void main(String[] args) {
        User user = new User();
        user.setAge(11);
        user.setName("kk");
        user.setClassesInfo(new ClassesInfo("part","ddd"));
        System.out.println("user.hashCode() = " + user.hashCode());
        user.setClassesInfo(new ClassesInfo("part111","ddd"));
        System.out.println("user.hashCode() = " + user.hashCode());
        user.setName("kk1");
        System.out.println("user.hashCode() = " + user.hashCode());
    }
}
