package pack._2021testspring.controller;

import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pack._2021testspring.bean.ChannelInfoQuery;
import pack._2021testspring.bean.DriverInfoDownloadTaskRequest;
import pack._2021testspring.bean.Person;
import pack._2021testspring.utils.DateUtils;

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

}
