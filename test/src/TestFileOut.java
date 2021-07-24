import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class TestFileOut {
    /*
            利用printStrean，打印到文件
     */
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("testFileOut.text",true);
        String s = "zhang langlang\n\n";
        fileOutputStream.write(s.getBytes());
        fileOutputStream.write(100);
        PrintStream ps = new PrintStream(fileOutputStream);
        float f = 10.786f;
        ps.printf("%10.3f\n",f);
        ps.printf("%-10.3f\n",f);
        ps.printf("%-10.2f\n",f);


    }
    @Test
    public void testByte(){
        String abc = "abc康";
        byte[] bytes = abc.getBytes();
        for (byte aByte : bytes) {
            System.out.println("aByte = " + aByte);
        }

        char[] chars = abc.toCharArray();
        for (char aChar : chars) {
            System.out.println("aChar = " + aChar);
        }

        byte b= (byte) 300;
        /*
                127以上越界: 128 变成 -128 (300-128=172)
                 -128 + 128 = 0  (172-128=44)
                 0+44=44
         */
        System.out.println("b = " + b);

        for (int i=0;i<300;i++){
            byte bt = (byte) i;
            System.out.println(" i = "+i+" ,bt="+bt);
        }
    }

}


