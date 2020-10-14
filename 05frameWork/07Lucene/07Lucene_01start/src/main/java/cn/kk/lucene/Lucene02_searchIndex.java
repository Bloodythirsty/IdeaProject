package cn.kk.lucene;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.*;
import org.apache.lucene.store.FSDirectory;

import java.io.File;

public class Lucene02_searchIndex {
    public static void searchIndex(String field,String queryKey) throws Exception{
        // 1. 创建一个Directory对象，指定索引库
        FSDirectory indexDir = FSDirectory.open(new File("D:\\All_Study\\Java\\All_projects\\IdeaProjects\\05frameWork\\07Lucene\\lucene_IK_index").toPath());
        // 2. 创建indexReader对象
        DirectoryReader dirReader = DirectoryReader.open(indexDir);
        // 3. 创建indexSearch对象，传入indexReader对象
        IndexSearcher indexSearcher = new IndexSearcher(dirReader);
        // 4. 创建一个Query对象，termQuery
        Query termQuery = new TermQuery(new Term(field,queryKey));
        // 5. 执行查询，得到TopDocs对象
            //第二个参数n，返回的记录数
        TopDocs topDocs = indexSearcher.search(termQuery, 10);

        // 6. 取查询结果的总记录数
        long totalHits = topDocs.totalHits;
        System.out.println("总记录数 = " + totalHits);
        // 7. 取文档列表
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        // 8. 打印文档内容
        for (ScoreDoc scoreDoc : scoreDocs) {
            //取文档id
            int id = scoreDoc.doc;
            //根据id取文档
            Document doc = indexSearcher.doc(id);
            System.out.println("doc.get(\"name\") = " + doc.get("name"));
            System.out.println("doc.get(\"path\") = " + doc.get("path"));
            System.out.println("doc.get(\"size\") = " + doc.get("size"));
            //System.out.println("doc.get(\"content\") = " + doc.get("content"));
            System.out.println("------------------------------------");
        }
        // 9. 关闭indexReader
        dirReader.close();
    }
}
