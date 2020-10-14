package cn.kk.manager;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.LongPoint;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;

public class MyIndexSearch {

    private static IndexSearcher indexSearcher;
    public static void init() throws IOException {
        // 1. 创建一个Directory对象，指定索引库
        FSDirectory indexDir = FSDirectory.open(new File("D:\\All_Study\\Java\\All_projects\\IdeaProjects\\05frameWork\\07Lucene\\lucene_IK_index").toPath());
        // 2. 创建indexReader对象
        DirectoryReader dirReader = DirectoryReader.open(indexDir);
        // 3. 创建indexSearch对象，传入indexReader对象
        indexSearcher = new IndexSearcher(dirReader);
    }

    /*
            范围查询：必须是 LongPoint("size",fileSize);存的
     */
    public static void RangeSearch(Long low,Long upper) throws Exception{
        init();
        //创建query对象
        Query rangeQuery = LongPoint.newRangeQuery("size", low, upper);
        TopDocs topDocs = indexSearcher.search(rangeQuery, 10);
        show(topDocs);
    }

    private static void show(TopDocs topDocs) throws IOException {
        System.out.println("topDocs.totalHits = " + topDocs.totalHits);
        ScoreDoc[] docs = topDocs.scoreDocs;
        for (ScoreDoc doc : docs) {
            //获取文档id
            int id = doc.doc;
            //取文档
            Document document = indexSearcher.doc(id);
            System.out.println("document.get(\"name\") = " + document.get("name"));
            System.out.println("document.get(\"path\") = " + document.get("path"));
            System.out.println("document.get(\"size\") = " + document.get("size"));
        }
    }

    /*
            queryParser：语句分词查询
     */
    public static void queryParserSearch() throws Exception{
        init();
        //创建query对象
        QueryParser queryParser = new QueryParser("name", new IKAnalyzer());
        Query query = queryParser.parse("licene是apache是java主力开发索引。");
        TopDocs topDocs = indexSearcher.search(query, 10);
        show(topDocs);
    }

}
