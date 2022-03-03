package com.example.demo.controlller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @GetMapping({"/","/index"})
    public String index(Model model){
        model.addAttribute("msg","hello shiro");
        return "index";
    }
    @GetMapping("/user/add")
    public String add(){
        return "user/add";
    }

    @GetMapping("/user/update")
    public String update(){
        return "user/update";
    }

    @GetMapping("/toLogin")
    public String login(){
        return "login";
    }

    @GetMapping("/login")
    public String toLogin(String username,String password,Model model){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);

        try {
            subject.login(token);
            return "index";
        }catch(UnknownAccountException e){ //用户名错误
            model.addAttribute("msg","用户名错误");
            return "login";
        }catch (IncorrectCredentialsException e) { //密码错误
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }

    @RequestMapping("/noauth")
    @ResponseBody
    public String noAuth(){
        return "未经授权无法访问";
    }
}
