package cn.kk.lucene;

import cn.kk.IK.IkAnalyzer;
import cn.kk.IK.IkConfig;
import cn.kk.manager.IndexManager;
import cn.kk.manager.MyIndexSearch;

import java.io.IOException;

public class Test {

    @org.junit.Test
    public void name() throws Exception {
        Lucene01_createIndex.createIndex();
    }

    @org.junit.Test
    public void testSearch() throws Exception{
        Lucene02_searchIndex.searchIndex("name","Spring");

    }

    @org.junit.Test
    public void testTokenStream() throws IOException {
        Lucenen03_tokenStream.tokenStream();
    }

    @org.junit.Test
    public void testIK() throws IOException {
        IkAnalyzer.tokenStreamIK();
    }

    @org.junit.Test
    public void testIKConfig() throws Exception {
        IkConfig.createIndexIk();
    }

    @org.junit.Test
    public void testOtherField() throws Exception {
        Lucene01_createIndex_otherField.createIndex();
    }

    @org.junit.Test
    public void testManager() throws Exception {
        IndexManager.addDocument();
    }

    @org.junit.Test
    public void deleteAllDocument() throws IOException {
        IndexManager.deleteAllDocument();
    }

    @org.junit.Test
    public void testDeleteByTerm() throws IOException {
        IndexManager.deleteDocument("name","apache");
    }

    @org.junit.Test
    public void testUpdate() throws IOException {
        IndexManager.updateDocument();
    }

    @org.junit.Test
    public void testSearchRange() throws Exception {
        MyIndexSearch.RangeSearch(500L,1000L);
    }

    @org.junit.Test
    public void testQueryParser() throws Exception {
        MyIndexSearch.queryParserSearch();
    }
}
