package cn.kk.manager;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.FSDirectory;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;

public class IndexManager {

    private static IndexWriter indexWriter;

    public static void init() throws IOException {
        indexWriter = new IndexWriter(
                FSDirectory.open(new File("D:\\All_Study\\Java\\All_projects\\IdeaProjects\\05frameWork\\07Lucene\\lucene_IK_index").toPath()),
                new IndexWriterConfig(new IKAnalyzer()));
    }

    public static void addDocument() throws Exception {
        init();
        //创建一个indexWriter对象，使用IKAnalyzer作为分析器
        // IndexWriter indexWriter = new IndexWriter(
        //         FSDirectory.open(new File("D:\\All_Study\\Java\\All_projects\\IdeaProjects\\05frameWork\\07Lucene\\lucene_IK_index").toPath()),
        //         new IndexWriterConfig(new IKAnalyzer()));
        //创建Document
        Document document = new Document();
        //添加域
        document.add(new TextField("name","新添加的文件", Field.Store.YES));
        document.add(new TextField("content","新添加文件的内容", Field.Store.NO));
        document.add(new StoredField("path","d:/新添加/文件的路径"));
        //写入文档
        indexWriter.addDocument(document);
        indexWriter.close();
    }

    /*
            删除全部索引document
     */
    public static void deleteAllDocument() throws IOException {
        init();
        indexWriter.deleteAll();
        indexWriter.close();
    }

    /*
            根据查询内容 删除
     */
    public static void deleteDocument(String field,String value) throws IOException {
        init();
        indexWriter.deleteDocuments(new Term(field,value));
        indexWriter.close();
    }

    /*
            更新
     */
    public static void updateDocument() throws IOException {
        init();
        Document document = new Document();
        document.add(new TextField("name","更新后的", Field.Store.YES));
        document.add(new TextField("name","更新后的", Field.Store.NO));
        document.add(new StoredField("name","更新后的"));
        //跟新
        indexWriter.updateDocument(new Term("name","Spring"),document);
        indexWriter.close();
    }


}
