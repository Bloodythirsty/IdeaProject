package cn.kk.controller;

import cn.kk.domain.SysLog;
import cn.kk.service.ISysLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/syslog")
public class SysLogController {

    @Autowired
    private ISysLogService logService;

    @RequestMapping(path = "/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",defaultValue = "1",required = true)Integer page,
                                @RequestParam(name = "pageSize",defaultValue = "2",required = true)Integer pageSize) throws Exception {
        PageHelper.startPage(page,pageSize);
        List<SysLog> list = logService.findAll();
        PageInfo<SysLog> pageInfo = new PageInfo<>(list);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("syslog-list");
        return mv;
    }
}
