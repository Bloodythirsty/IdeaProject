package pack.service;

import java.io.File;
import java.io.IOException;

/**
 * @description: 图库的service
 * @author: zhaobofan
 * @create: 2020/7/6 20:33
 **/
public interface PictureService {

    void uploadAndSave(File file) throws IOException;


}
