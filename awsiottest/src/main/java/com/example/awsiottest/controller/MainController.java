package com.example.awsiottest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author InSeok
 * Date : 2019-09-30
 * Remark :
 */
@Controller
public class MainController {
    @RequestMapping("/")
    public String index(){
        return "index";

    }
}
