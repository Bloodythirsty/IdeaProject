package kk.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * @author zkk;
 * @create 2020-03-09;
 */
public class Demo04_Jsoup_select {
    public static void main(String[] args) throws IOException {
        String path = Demo04_Jsoup_select.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path),"utf-8");

        //1. 查询name标签
        Elements elements = document.select("name");
        System.out.println(elements);

        System.out.println("-----------------");
        //2. 查询id值为kk
        Elements element = document.select("#kk");      //获取id为kk的元素
        System.out.println(element);
        Elements element1 = document.select("[id='kk']");   //获取id为kk的元素
        System.out.println(element1);
        //3. 获取student，id 为 kk 的name标签。
        System.out.println("-----------------");
        //3.1 获取student，id 为 kk
        Elements elements1 = document.select("student[id='kk']");
        System.out.println(elements1);
        //3.1 获取student，id 为 kk 的name标签
        System.out.println("-----------------");
        Elements elements2 = document.select("student[id='kk'] > name");
        System.out.println(elements2);
    }



}
