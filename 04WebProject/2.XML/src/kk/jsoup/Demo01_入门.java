package kk.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;        //导入的时这个Document，而不是javax中的
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;       //不是javax的

import java.io.File;
import java.io.IOException;

/**
 * @author zkk;
 * @create 2020-03-08;
 */
public class Demo01_入门 {
    public static void main(String[] args) throws IOException {
        //1.获取document对象
        //1.1 获取xml文件路径
        String path = Demo01_入门.class.getClassLoader().getResource("student.xml").getPath();   //xml文件要放在src下
        //2.2 解析XML文档，获取dom树
        Document document = Jsoup.parse(new File(path),"utf-8");
        //2.获取元素对象：Element
        Elements elements = document.getElementsByTag("name");
        System.out.println(elements.size());
        //2.1获取第一个name
        Element element = elements.get(0);
        System.out.println(element.text());
    }
}
