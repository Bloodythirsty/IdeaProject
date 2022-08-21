package pack.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.joda.time.DateTime;
import org.springframework.web.bind.annotation.GetMapping;
import pack.bean.FileUploadResultDto;
import pack.bean.QuestionAndAnswerVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author zhangkangkang created on 2021/2/5 11:06 上午
 */
@Slf4j
@RestController
@RequestMapping("/file")
public class FileController {

    @RequestMapping("/uploadFile")
    public FileUploadResultDto uploadFile(MultipartFile file) throws IOException {
        log.info(file.getContentType());
        return parseFile(file, 1L);
    }

    private FileUploadResultDto parseFile(MultipartFile file, Long memberId) throws IOException {
        FileUploadResultDto resultDto = new FileUploadResultDto();
        EasyExcel.read(file.getInputStream(), QuestionAndAnswerVo.class, new ReadListener<QuestionAndAnswerVo>() {

            public static final int BATCH_COUNT = 20;

            private int totalCount, successCount;

            private List<QuestionAndAnswerVo> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

            @Override
            public void invoke(QuestionAndAnswerVo data, AnalysisContext context) {
                if (data.isEmptyAnswer()) {
                    log.info("empty {}", data);
                    totalCount++;
                    return;
                }
                log.info("data :{}" , data);
                data.setMemberId(memberId);
                data.setVersionId(DateTime.now().getMillis());
                data.setCreateTime(DateTime.now().toDate());
                data.setUpdateTime(DateTime.now().toDate());
                cachedDataList.add(data);
                if (cachedDataList.size() >= BATCH_COUNT) {
                    totalCount += cachedDataList.size();
                    saveData();
                    cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
                }
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                totalCount += cachedDataList.size();
                saveData();
                resultDto.setSuccessCount(successCount);
                resultDto.setFailCount(totalCount - successCount);
            }

            private void saveData() {
                try {
                    log.info("{}条数据，开始存储数据库！", cachedDataList.size());

                    successCount += cachedDataList.size();
                } catch (Exception e) {
                    log.error("解析问答到数据库失败", e);
                    log.error("失败数据：{}", cachedDataList);
                }
                log.info("解析问答存储数据库成功！");
            }
        }).sheet().headRowNumber(3).doRead();
        return resultDto;
    }

    @GetMapping("/download")
    public void download(HttpServletResponse response) throws IOException {
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("测试", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");

        EasyExcel.write(response.getOutputStream(), QuestionAndAnswerVo.class).sheet("问答下载表").doWrite(data());
    }

    private List<QuestionAndAnswerVo> data() {
        List<QuestionAndAnswerVo> list = Lists.newArrayList();
        for (int i = 0; i < 20; i++) {
            QuestionAndAnswerVo vo = QuestionAndAnswerVo.builder().title(i + "title").answer(i + "answer").build();
            list.add(vo);
        }
        return list;
    }


}
