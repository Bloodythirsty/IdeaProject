package cn.kk.controller;

import cn.kk.domain.Orders;
import cn.kk.service.IOrdersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/orders")
public class OrdersController {

    @Autowired
    private IOrdersService ordersService;

    //未分页
    // @RequestMapping(path = "/findAll.do")
    // public ModelAndView findAll(){
    //     ModelAndView modelAndView = new ModelAndView();
    //     List<Orders> ordersList = ordersService.findAll();
    //     modelAndView.addObject("ordersList",ordersList);
    //     modelAndView.setViewName("orders-list");
    //     return modelAndView;
    // }

    //分页
    @Secured("ROLE_orderR")
    @RequestMapping(path = "/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",defaultValue = "1") Integer page,
                                @RequestParam(name = "pageSize",defaultValue = "2") Integer pageSize) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        PageHelper.startPage(page,pageSize);                //必须在查询数据库之前设置，才起作用
        List<Orders> ordersList = ordersService.findAll();
        //分页bean
        PageInfo<Orders> pageInfo = new PageInfo<>(ordersList);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("orders-list");
        return modelAndView;
    }


    //订单详情查询
    @RequestMapping(path = "/findById.do")
    public ModelAndView findById(@RequestParam(name = "ordersId",required = true)String orderId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Orders byId = ordersService.findById(orderId);
        mv.addObject("orders",byId);
        mv.setViewName("orders-show");
        return mv;
    }

    /*
            用posyMan测试接口
            1. 需要导入
     */
    @RequestMapping(path = "/findById1.do")
    public @ResponseBody Orders findById1(@RequestParam(name = "ordersId",required = true)String orderId) throws Exception {
        Orders byId = ordersService.findById(orderId);
        return byId;
    }
}
