package kr.co.broadwave.awss3uploadtest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author InSeok
 * Date : 2019-12-04
 * Remark :
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String mainpage(){
        return "index";
    }
}
