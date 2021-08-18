package pack._2021testspring.controller;

import pack._2021testspring.bean.ChannelInfoQuery;
import pack._2021testspring.bean.DriverInfoDownloadTaskRequest;
import pack._2021testspring.bean.Person;
import pack._2021testspring.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author zhangkangkang created on 2021/2/5 11:06 上午
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class FileController {

    @RequestMapping("/uploadFile")
    public void uploadFile(MultipartFile file) {
        log.info(file.getContentType());
    }

    @RequestMapping("/params")
    public void uploadFile(@RequestBody Person person) {
        log.info(person.toString());
    }

    @RequestMapping("/test")
    public void test(@RequestParam("dataType") String dataType,
                     @RequestParam("channelName") String channelName
                     ) {
        log.info(dataType);
        log.info(channelName);
    }

    @RequestMapping("/testVo")
    public void uploadFile(@RequestBody DriverInfoDownloadTaskRequest request) {
        log.info(request.toString());
    }

    @RequestMapping("/testPage")
    public void page(@RequestBody ChannelInfoQuery query) {
        log.info(query.toString());
        log.info("pageNu"+query.getPageNum());
        log.info("pagesize"+query.getPageSize());
    }

    @Resource
    private DateUtils dateUtils;

    @RequestMapping("/testAsync")
    public void testAsync() {
        dateUtils.testAsync();
        System.out.println("done");
    }
}
