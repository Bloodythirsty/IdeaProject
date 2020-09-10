package cn.kk.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(path = "/user")
public class FileUpload {

    @RequestMapping(path = "/fileupload1")
    public String fileUpload(HttpServletRequest request) throws Exception {
        System.out.println("文件上传");
        // 使用fileupload完成上传
        //1. 指定上传的位置
        // System.out.println(request.getServletPath());        //  /user/fileupload1
        // System.out.println(request.getContextPath());        //  /03Spring_day02_fileUpload_war_exploded
        // System.out.println(request.getRequestURL().toString());  //  http://localhost:8080/03Spring_day02_fileUpload_war_exploded/user/fileupload1
        String path = request.getSession().getServletContext().getRealPath("/uploads");
        File file = new File(path);
        if (!file.exists()){
            //2. 创建文件加
            file.mkdirs();
        }

        // 3. 获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);

        //4. 解析
        List<FileItem> items = upload.parseRequest(request);

        //5. 遍历解析到上传项
        for (FileItem item : items) {
            //6. 判断item是否是上传文件的选项
            if (item.isFormField()){
                // 是普通表单项
            }else{
                //是上传文件项
                String fileName = item.getName();
                //给文件加UUID
                String uuid = UUID.randomUUID().toString().replace("-", "");
                fileName = uuid + "_" +fileName;
                //上传
                item.write(new File(path,fileName));
                // 删除临时文件
                item.delete();
            }
        }
        return "success";
    }

    /*
            MultipartFile upload :此处参数名和jsp的name要一模一样
                MultipartFile ：相当于上传的文件选项已经拿到
     */
    @RequestMapping(path = "/fileuploadMVC")
    public String fileuploadMVC(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("文件上传MVC");
        String path = request.getSession().getServletContext().getRealPath("/uploads");
        File file = new File(path);
        if (!file.exists()){
            //2. 创建文件加
            file.mkdirs();
        }

        //拿名字
        String fileName = upload.getOriginalFilename();
        //给文件加UUID
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fileName = uuid + "_" +fileName;
        //上传
        upload.transferTo(new File(path,fileName));

        return "success";
    }

    @RequestMapping(path = "/fileuploadMVCbyServer")
    public String fileuploadMVCbyServer(MultipartFile upload) throws Exception {
        System.out.println("跨服务器文件上传MVC");

        //拿名字
        String fileName = upload.getOriginalFilename();
        //给文件加UUID
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fileName = uuid + "_" +fileName;

        //定义上传跨服务器的路径(部署成功后网页的地址+上传的文件名)
        String serverPath = "http://localhost:9090/04SpringMVC_day02_fileUploadServer_war_exploded/uploads";

        //跨服务器上传
        // 1 . 创建客户端对象。
        Client client = Client.create();
        //2. 和图片服务器进行连接
        WebResource webResource = client.resource(serverPath + "/" + fileName);
        //3. 上传到服务器
        webResource.type(MediaType.MULTIPART_FORM_DATA_TYPE).put(upload.getBytes());
        return "success";
    }

}
