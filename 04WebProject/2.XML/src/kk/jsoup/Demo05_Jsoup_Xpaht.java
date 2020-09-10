package kk.jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author zkk;
 * @create 2020-03-09;
 */
public class Demo05_Jsoup_Xpaht {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        String path = Demo05_Jsoup_Xpaht.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path),"utf-8");
        //1. 使用Xpath获取
        //1.1 根据document对象，创建JXDocument（来自Xpath包）
        JXDocument jxDocument = new JXDocument(document);
        //1.2 结合Xpaht语法查询,查询所有student
        List<JXNode> jxNodes = jxDocument.selN("//student");
        System.out.println(jxNodes.get(0));
        System.out.println("---------------------");
        //1.3 查询所有student下的name标签
        List<JXNode> names = jxDocument.selN("//student/name");
        System.out.println(names);
        System.out.println("---------------------");
        //1.4 查询所有student下的name标签且带有ID
        List<JXNode> name_ids = jxDocument.selN("//student/name[@id]");
        System.out.println(name_ids);
    }
}
