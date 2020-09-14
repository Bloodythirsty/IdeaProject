package cn.kk.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;

public class Lucenen03_tokenStream {
    public static void tokenStream( ) throws IOException {
        // 1. 创建一个Analyzer对象，StandarAnalyzer对象
        Analyzer standardAnalyzer = new StandardAnalyzer();
        // 2. 获取tokenStream对象
        TokenStream tokenStream = standardAnalyzer.tokenStream("", "Lucene is a Java full-text search engine");
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
