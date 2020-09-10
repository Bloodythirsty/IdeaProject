package cn.kk.controller;

import cn.kk.domain.Permission;
import cn.kk.service.IPermissionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    @RequestMapping(path = "/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",defaultValue = "1",required = true)Integer page,
                                @RequestParam(name = "pageSize",defaultValue = "2",required = true)Integer pageSize) throws Exception {
        PageHelper.startPage(page,pageSize);
        List<Permission> permissionList = permissionService.findAll();
        PageInfo<Permission> pageInfo = new PageInfo<>(permissionList);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("permission-list");
        return mv;
    }

    @RequestMapping(path = "/save.do")
    public String save(Permission permission) throws Exception {
        permissionService.save(permission);
        return "forward:findAll.do";
    }

}
