package kk.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author zkk;
 * @create 2020-03-08;
 */

/*
    Jsoup对象的使用
 */
public class Demo02_Jsoup01 {
    public static void main(String[] args) throws IOException {
        String path = Demo02_Jsoup01.class.getClassLoader().getResource("student.xml").getPath();
        /*//1. 第一种	parse​(File in, String charsetName)
        Document document = Jsoup.parse(new File(path),"utf-8");
        System.out.println(document);       //会把整个xml文档打印*/

        /*//2. 第二种    	parse​(String html)  string为xml内容
        Document document = Jsoup.parse("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "\n" +
                "<students>\n" +
                "    <student>\n" +
                "        <name>张三</name>\n" +
                "        <age>18</age>\n" +
                "        <gender>男</gender>\n" +
                "    </student>\n" +
                "    <student>\n" +
                "        <name>李四</name>\n" +
                "        <age>19</age>\n" +
                "        <gender>女</gender>\n" +
                "    </student>\n" +
                "</students>");
        System.out.println(document);       //会把整个xml文档打印*/

        //3. 第三种 	parse​(URL url, int timeoutMillis)
        URL url = new URL("https://www.baidu.com");
        Document document = Jsoup.parse(url,10000);
        System.out.println(document);
    }
}
