package com.test.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//controller 处理请求并返回一个ModelAndView，实现接口Controller的类就是一个控制器。
public class HelloController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav = new ModelAndView();

        // 业务代码
        String result = "HelloSpringMVC!"; // 假设这个为调用业务代码的返回值。
        mav.addObject("msg", result);

        // 视图跳转到hello.jsp
        mav.setViewName("hello"); //: /WEB-INF/jsp/hello.jsp

        return mav;
    }
}
