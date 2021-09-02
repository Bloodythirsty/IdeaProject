package testClone;

import model.User;

import java.util.Objects;

/**
 * @author zhangkangkang
 * @date 2021/09/01 13:31
 */
public class CloneTest1 implements Cloneable{
    private int age;
    private User user;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CloneTest1(int age, User user) {
        this.age = age;
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CloneTest1 that = (CloneTest1) o;
        return age == that.age && Objects.equals(user, that.user);
    }

    @Override
    public String toString() {
        return "CloneTest1{" +
                "age=" + age +
                ", user=" + user +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, user);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        CloneTest1 o = (CloneTest1)super.clone();
        o.user = (User) this.user.clone();
        return o;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        User kk = User.builder().userId(1).userName("kk").build();
        CloneTest1 cloneTest1 = new CloneTest1(11, kk);
        CloneTest1 cloneTest2 = (CloneTest1)cloneTest1.clone();
        cloneTest2.getUser().setUserId(2);
        cloneTest2.setAge(12);
        CloneTest1 cloneTest3 = cloneTest2;
        cloneTest3.setAge(13);
        System.out.println(cloneTest1.toString());
        System.out.println(cloneTest2.toString());
        System.out.println(cloneTest3.toString());
        System.out.println(cloneTest1 == cloneTest2);
    }
}
