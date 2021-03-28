package cn.kk.controller;

import cn.kk.domain.Role;
import cn.kk.service.IRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/role")
@PreAuthorize("hasRole('ROLE_ADMIN_PRODUCTANDORDER')")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @RequestMapping(path = "/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",defaultValue = "1",required = true)Integer page,
                                @RequestParam(name = "pageSize",defaultValue = "2",required = true) Integer pageSiez) throws Exception {
        //分页
        PageHelper.startPage(page,pageSiez);
        List<Role> roleList = roleService.findAll();
        PageInfo<Role> pageInfo = new PageInfo<>(roleList);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("role-list");
        return mv;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(path = "/save.do")
    public String save(Role role) throws Exception {
        roleService.save(role);
        return "forward:findAll.do";
    }

    /*
            查询角色的权限
     */
    @RequestMapping(path = "/findById.do")
    public ModelAndView findById(String roleId) throws Exception {
        Role role = roleService.findById(roleId);
        ModelAndView mv = new ModelAndView();
        mv.addObject("role",role);
        mv.setViewName("role-show");
        return mv;
    }

    /*
            添加权限
     */
    @RequestMapping(path = "/findRoleContainNoPermission.do")
    public ModelAndView findRoleContainNoPermission(@RequestParam(name = "roleId") String roleId) throws Exception {
        Role role = roleService.findRoleContainNoPermission(roleId);
        ModelAndView mv = new ModelAndView();
        mv.addObject("role",role);
        mv.setViewName("role-permission-add");
        return mv;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(path = "/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId") String roleId,
                                            @RequestParam(name = "ids")String[] permissionIds) throws Exception {
        roleService.addPermissionToRole(roleId,permissionIds);
        ModelAndView mv = new ModelAndView();
        return "forward:findAll.do";
    }
}
