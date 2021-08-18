import utils.HttpClientUtils;

public class TestHttpClient {
    public static void main(String[] args) {
        String url = "http://www.baidu.com";
        String s = HttpClientUtils.doGet(url);
        System.out.println("s = " + s);
    }
}
