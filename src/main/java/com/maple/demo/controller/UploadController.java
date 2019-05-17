package com.maple.demo.controller;

import com.maple.demo.utils.UploadUtils;
import org.apache.http.entity.ContentType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.mock.web.MockMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


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
        String result;

        //直接从本地获取文件，模拟上传
//        File file = new File("D:\\WORKPATH\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp4\\wtpwebapps\\upFiles\\uploads/2019/05/17/9b9bca4f-09b9-41cb-bdb6-e806f7e72501.png");
//            FileInputStream fileInputStream = new FileInputStream(file);
//            MultipartFile multipartFile = new MockMultipartFile(file.getName(), file.getName(),
//                    ContentType.APPLICATION_OCTET_STREAM.toString(), fileInputStream);

        result = UploadUtils.upload(multipartFile);
        System.out.println(result);
        model.addAttribute("filename", result);
        return "upload";
    }
}