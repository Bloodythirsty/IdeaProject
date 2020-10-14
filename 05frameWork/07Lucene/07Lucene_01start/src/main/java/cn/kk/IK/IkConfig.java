package cn.kk.IK;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;

public class IkConfig {
    public static void createIndexIk() throws Exception {
        // 1. 创建一个Directory对象，指定索引库保存的位置
        //把索引库保存到内存中
        // RAMDirectory ramD = new RAMDirectory();
        //把索引库保存到磁盘
        FSDirectory directory = FSDirectory.open(new File("D:\\All_Study\\Java\\All_projects\\IdeaProjects\\05frameWork\\07Lucene\\lucene_IK_index").toPath());
        // 2. 基于Directory对象创建一个IndexWriter对象
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(new IKAnalyzer());
        IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);
        // 3. 读取从盘文件，对应每个文件创建文档对象
        File dir = new File("F:\\2019黑马\\PPT&笔记\\61.Lucene\\lucene\\02.参考资料\\searchsource");
        //取出文件
        File[] files = dir.listFiles();
        for (File file : files) {
            //取文件名
            String fileName = file.getName();
            //文件路径
            String filePath = file.getPath();
            //文件内容，使用common-io中的工具,读成字符串
            String fileContent = FileUtils.readFileToString(file, "utf-8");
            //文件大小
            long fileSize = FileUtils.sizeOf(file);
            //3.1. 创建Field域，lucene包下的
            // name:域名称     fileName：域内容     store：是否存储
            Field fieldName = new TextField("name",fileName, Field.Store.YES);
            // Field fieldPath = new TextField("path", filePath, Field.Store.YES);
            // 不分析，不索引，只存储（默认）
            Field fieldPath = new StoredField("path", filePath);
            Field fieldContent = new TextField("content",fileContent, Field.Store.YES);
            //Field fieldSize = new TextField("size",fileSize+"", Field.Store.YES);
            /*
               LongPoint: 分析，索引，不存储（默认）
                想要存储，应该还建立storedField
                storedField:不分析，不索引，只存储（默认）
             */
            Field fieldSizeValue = new LongPoint("size",fileSize);
            Field fieldSizeStore = new StoredField("size",fileSize);
            //3.2. 创建文档对象
            Document document = new Document();
            // 4. 向文件对象中添加域
            document.add(fieldName);
            document.add(fieldPath);
            document.add(fieldContent);
            //document.add(fieldSize);
            document.add(fieldSizeValue);
            document.add(fieldSizeStore);
            // 5. 把文档对象写入索引库
            indexWriter.addDocument(document);
        }
        // 6. 关闭IndexWriter对象
        indexWriter.close();
    }
}
