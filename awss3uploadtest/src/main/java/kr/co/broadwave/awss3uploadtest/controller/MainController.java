package kr.co.broadwave.awss3uploadtest.controller;

import kr.co.broadwave.awss3uploadtest.Service.AWSS3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;


/**
 * @author InSeok
 * Date : 2019-12-04
 * Remark :
 */
@Controller
public class MainController {

    @Autowired
    AWSS3Service awss3Service;
    @RequestMapping("/")
    public String mainpage(){
        return "index";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("data") MultipartFile multipartFile) throws IOException {
        awss3Service.uploadObject(multipartFile,"storefilename");
        return "";
    }

    @GetMapping("/deletefile/{fileid}")
    @ResponseBody
    public String upload(@PathVariable String fileid)  {
        System.out.println(fileid);
        awss3Service.deleteObject("uploadfiles/20191205","8760546197f5408691e00786919c15b4.jpg");
        return "sucess";
    }

    @RequestMapping("filedownload/{fileid}")
    @ResponseBody
    public byte[] downProcess(HttpServletResponse response,
                              @PathVariable Long fileid) throws IOException {



        byte[] bytes = awss3Service.getObject("uploadfiles/20191205","8760546197f5408691e00786919c15b4.jpg");


        response.setHeader("Content-Disposition",
                "attachment;filename=\"" + URLEncoder.encode("filename", "UTF-8") + "\"");
        response.setContentLength(bytes.length);
        return bytes;
    }
}
