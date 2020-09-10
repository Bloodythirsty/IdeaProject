package cn.kk.controller;

import cn.kk.domain.Items;
import cn.kk.service.IItemsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping(path = "/items")
public class ItemsController {

    @Resource(name = "itemsService")
    private IItemsService itemsService;

    @RequestMapping(path = "/findById")
    public String findById(Integer id, Model model){
        System.out.println("controller_findById");
        Items item = itemsService.findById(id);
        model.addAttribute("item",item);
        return "success";
    }
}
