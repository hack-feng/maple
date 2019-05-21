package com.maple.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.maple.demo.utils.UploadUtils;


@Controller
@RequestMapping("/upload")
public class UploadController extends BaseController {

    /**
     * 跳转到上传页面
     * http://127.0.0.1:8082/upload/upload
     * @return
     */
    @RequestMapping("/upload")
    public String upload(){
        return "upload";
    }

    /**
     * 上传文件，并回显
     * @param multipartFile
     * @param model
     * @return
     */
    @PostMapping("/uploadOne")
    public String uploadOne(MultipartFile multipartFile, ModelMap model){
        String result = UploadUtils.upload(multipartFile);
        System.out.println(result);
        model.addAttribute("filename", result);
        return "upload";
    }
}