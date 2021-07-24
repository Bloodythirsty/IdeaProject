package pojo;

import java.util.Objects;

public class User {
    private String name;
    private Integer age;
    public ClassesInfo classesInfo;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setClassesInfo(ClassesInfo classesInfo) {
        this.classesInfo = classesInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(age, user.age) &&
                Objects.equals(classesInfo, user.classesInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, classesInfo);
    }
}
