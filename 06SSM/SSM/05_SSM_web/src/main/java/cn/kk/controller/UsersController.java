package cn.kk.controller;

import cn.kk.domain.Role;
import cn.kk.domain.Users;
import cn.kk.service.IUserService;
import cn.kk.utils.UUIDutils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(path = "/user")
public class UsersController {

    @Resource(name = "userService")
    private IUserService userService;

    //有Admin权限即可
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(path = "/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",defaultValue = "1",required = true)Integer page,
                                @RequestParam(name = "pageSize",defaultValue = "2",required = true) Integer pageSize) throws Exception {
        //分页
        PageHelper.startPage(page,pageSize);
        List<Users> usersList = userService.findAll();
        PageInfo<Users> pageInfo = new PageInfo<>(usersList);

        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("user-list");
        return mv;
    }

    //  只有qq这个用户可以保存用户
    @PreAuthorize("authentication.principal.username == 'qq'")
    @RequestMapping(path = "/save.do")
    public String save(Users users) throws Exception {
        users.setId(UUIDutils.getLowerUUID());
        userService.save(users);
        return "forward:findAll.do";
    }

    @RequestMapping(path = "/findById.do")
    public ModelAndView findById(String id) throws Exception {
        Users users = userService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user",users);
        mv.setViewName("user-show");
        return mv;
    }

    @RequestMapping(path = "/findByIdAndNotRole.do")
    public ModelAndView findByIdAndNotRole(String id) throws Exception {
        Users users = userService.findByIdAndNotRole(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("users",users);
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping(path = "/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId")String userId,
                                      @RequestParam(name = "ids")String[] roleIds) throws Exception {
        userService.addRoleToUser(userId,roleIds);
        return "forward:findAll.do";
    }
}
