/**
 * @author zhangkangkang
 * @date 2021/08/18 16:52
 */
public class TestRegix {
    public static void main(String[] args) {
        boolean matches = "www.baodyc1.com".matches("^[0-9A-Za-z\\.]+$");
        boolean matches1 = "www.张.com".matches("^[0-9A-Za-z\\.]+$");
        boolean matches11 = "www.AAAAAaodyc1.com".matches("^[0-9A-Za-z\\.]+$");
        boolean matches111 = "腾讯".matches("^[0-9A-Za-z\\.]+$");
        boolean matches1111 = "".matches("^[0-9A-Za-z.]+$");
        boolean matches11111 = "www.baodyc1.com".matches("^[0-9A-Za-z\\.]+$");

        double ceil = Math.ceil(5 / 2.0);
    }
}
