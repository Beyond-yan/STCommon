package com.beyond.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Service;

/**
 * @Author 闫波
 * @Date 2018/12/3 0003
 **/
@ControllerAdvice

public class ExceptionHandlerAdvice {

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public String handleException(NullPointerException e){
        return "哎呀！出错了";
    }

    @ModelAttribute
    public void init(Model model){
       model.addAttribute("pages" , "1");
    }
}
