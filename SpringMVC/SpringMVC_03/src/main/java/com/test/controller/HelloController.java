package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/HelloController")
public class HelloController {

    // 示例一：
    //真实访问地址 : 项目名/HelloController/hello
    @RequestMapping("/hello")
    public String sayHello(Model model){
        //向模型model中添加属性msg与值，可以在JSP页面中取出并渲染
        model.addAttribute("msg","hello,SpringMVC");
        //web-inf/jsp/hello.jsp 返回视图名称
        return "hello";
    }

    // 示例二：
    @RequestMapping("/test1")
    public String test1(Model model){
        //向模型model中添加属性msg与值，可以在JSP页面中取出并渲染
        model.addAttribute("msg","test1 SpringMVC");
        //web-inf/jsp/test.jsp 返回视图名称
        return "test";
    }

    // 示例三：
    @RequestMapping("/test/{p1}/{p2}")
//    @GetMapping("/test/{p1}/{p2}")
    public String test(@PathVariable int p1, @PathVariable int p2, Model model){
        int result = p1 + p2;
        model.addAttribute("msg",result);

        return "test"; // 默认页面为转发的方式
        // return "redirect:/hello"; // 重定向到/hello路径
    }
}
