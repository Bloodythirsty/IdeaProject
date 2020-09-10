package cn.kk.controller;

import cn.kk.domain.Account;
import cn.kk.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/user")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @RequestMapping(path = "/findAll")
    public String findAll(Model model){
        System.out.println("findAll_Controller");
        List<Account> accounts = accountService.findAll();
        model.addAttribute("accounts",accounts);
        return "success";
    }

    @RequestMapping(path = "/saveAccount")
    public String saveAccount( Account account){
        accountService.saveAccount(account);
        return "success";
    }

}
