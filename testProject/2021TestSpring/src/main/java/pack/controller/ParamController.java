package pack.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pack.bean.ChannelInfoQuery;
import pack.bean.DriverInfoDownloadTaskRequest;
import pack.bean.Person;
import pack.utils.DateUtils;

/**
 * Description:
 *
 * @Author: heisenzhang@tencent.com
 * @DateTime: 2022-03-23 11:39 AM
 */
@Slf4j
@RestController
@RequestMapping("/param")
public class ParamController {

    @RequestMapping("/params")
    public void uploadFile(@RequestBody Person person) {
        log.info(person.toString());
    }

    @PostMapping("/list")
    public void test(@RequestBody List<Long> questionIds) {
        log.info("{}", questionIds);
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

    @PostMapping("/post")
    public void test111(@RequestParam String token, @RequestBody String content){
        log.info("token{}", token);
        log.info("content: {}" , content);
    }

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/zhangkangkang/Documents/diseaseCardData/1");
        LineNumberReader reader = new LineNumberReader(
                new FileReader(file));
        reader.skip(file.length());
        System.out.println(reader.getLineNumber());
    }

}
