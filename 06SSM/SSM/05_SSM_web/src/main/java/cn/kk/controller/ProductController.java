package cn.kk.controller;

import cn.kk.domain.Product;
import cn.kk.service.impl.ProductServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @RolesAllowed({"productR","ADMIN"})
    @RequestMapping(path = "/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",defaultValue = "1",required = true) Integer page,
                                @RequestParam(name = "pageSize",defaultValue = "2",required = true) Integer pageSize) throws Exception {
        //分页
        PageHelper.startPage(page,pageSize);
        List<Product> productList = productService.findAll();

        final PageInfo<Product> pageInfo = new PageInfo<>(productList);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("product-list1");
        return mv;
    }

    @RequestMapping(path = "/save.do")
    public String  saveOne(Product product) throws Exception {
        productService.saveOne(product);
        return "forward:findAll.do";
    }

}
