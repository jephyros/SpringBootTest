package com.example.awsiottest.controller;

import com.example.awsiottest.service.AwsIotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author InSeok
 * Date : 2019-09-30
 * Remark :
 */
@Controller
public class MainController {
    @Autowired
    AwsIotService awsIotService;

    @RequestMapping("/")
    public String index(){
       awsIotService.mqttsubscribe();

        return "index";

    }

    @RequestMapping("/subscribe")
    public String subscribe(){
        awsIotService.mqttsubscribe2();

        return "index";

    }

    @RequestMapping("/shadowsend")
    public String shadowsend(){
        //awsIotService.shadowtest();
        awsIotService.shadowNonblockingSend();

        return "shadowsend";

    }

    @RequestMapping("/shadowlisten")
    public String shadowlisten(){
        //awsIotService.mqttsubscribe2();

        return "shadowlisten";

    }

    @RequestMapping("/about")
    public String about(){

        awsIotService.mqtttest();


        return "about";

    }
}
