package mybatis.cfg;

/**
 *      1. 用于封装从xml里面取出的
 *          1. sql语句
 *          2. 结果类型的全限定类名
 */
public class Mapper {

    private String queryString ;
    private String resultType ;

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getQueryString() {
        return queryString;
    }

    public String getResultType() {
        return resultType;
    }
}
