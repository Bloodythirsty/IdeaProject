import org.junit.Test;
import utils.DirectoryUtils;

import java.io.File;

/**
 * Created by kangkang on 2021/3/18 21:46
 */
public class TestFile {

   @Test
   public void testS(){
       File file = new File("D:\\All_Study\\Java\\test\\s");
       // DirectoryUtils.deleteFile(file,"._");
       if (file.exists()) {
           File[] files = file.listFiles();
           System.out.println("files = " + files.length);
       }
   }
}
