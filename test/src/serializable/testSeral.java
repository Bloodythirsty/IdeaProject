package serializable;

import org.junit.Test;
import serializable.Student;

import java.io.*;

public class testSeral {
    public static void main(String[] args) {
        Student student = new Student();
        student.setAge(18);
        student.setName("kk");
        student.setSex("mail");
        // student.setAddr("beijing");

        ser(student);

    }

    public static void ser(Student student){
        ObjectOutputStream oos = null;
        try{
            FileOutputStream fos = new FileOutputStream("student.out");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(student);
            oos.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testReSer(){
        ObjectInputStream ois = null;

        try {
            FileInputStream fileInputStream = new FileInputStream("student.out");
            ois = new ObjectInputStream(fileInputStream);
            Student s = null;
            s = (Student) ois.readObject();
            System.out.println("s.getName() = " + s.getName());
            System.out.println("s.getSex() = " + s.getSex());
            System.out.println("s.getAge() = " + s.getAge());
            // System.out.println("s.getAddr() = " + s.getAddr());
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
