package kk.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * @author zkk;
 * @create 2020-03-08;
 */
public class Demo03_Jsoup_Document_Element {
    public static void main(String[] args) throws IOException {
        String path = Demo03_Jsoup_Document_Element.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path),"utf-8");
        //1.1 获取所有student对象
        Elements elements = document.getElementsByTag("student");
        for (Element e: elements) {
            System.out.println(e);
        }

    }
}
