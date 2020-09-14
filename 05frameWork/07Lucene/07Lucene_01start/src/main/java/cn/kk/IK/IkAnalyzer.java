package cn.kk.IK;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;

public class IkAnalyzer {
    public static void tokenStreamIK( ) throws IOException {
        // 1. 创建一个Analyzer对象，StandarAnalyzer对象
        Analyzer standardAnalyzer = new IKAnalyzer();
        // 2. 获取tokenStream对象
        TokenStream tokenStream = standardAnalyzer.tokenStream("", "图像、活动影像等非结构化数据进行综合管理的大型软件。本教程只讨论文本检索。");
        // 3. 向tokenStream对象设置一个引用，用于遍历
        CharTermAttribute charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);
        // 4. 调用tokenStream对象的reset方法，把这个引用放到最顶端（不调用抛异常）
        tokenStream.reset();
        // 5. 遍历tokenStream
        while (tokenStream.incrementToken()){
            System.out.println(charTermAttribute.toString());
        }
        // 6. 关闭tokenStream
        tokenStream.close();

    }
}
