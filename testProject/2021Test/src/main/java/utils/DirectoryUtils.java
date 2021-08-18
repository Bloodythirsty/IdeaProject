package utils;

import java.io.File;

/**
 * Created by Kangkang on 2021/3/18 21:11
 */
public class DirectoryUtils {

    public static void deleteFile(File file, String filePrefix) {
        if (!file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File file1 : files) {
                    deleteFile(file1, filePrefix);
                }

            }
        } else if (file.getName().startsWith(filePrefix)) {
            boolean delete = file.delete();
            System.out.println(file.getName() + "==" + delete);
        }

    }
}
