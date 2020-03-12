package com.zhangwx.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SysExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        SysException sysException = null;
        if (e instanceof SysException){
            sysException = (SysException) e;
        }else {
            sysException = new SysException(e.getMessage());
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg",sysException.getMsg());
        mv.setViewName("error");
        return mv;

    }
}
