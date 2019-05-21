package com.maple.demo.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.maple.demo.utils.ExportExcelUtils;

@Controller
public class TestController {

    @RequestMapping(value = "/index")
    public String test(){
        return "/index";
    }
    
    @RequestMapping(value = "/exportDriver", method = RequestMethod.GET)
    public String exportDriver(
            HttpSession session,HttpServletRequest request,HttpServletResponse response){
        String[] cellname={"编号","姓名","联系电话"};
        String[] keyList={"name","phone"};
        List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
        
        for (int i = 0; i < 10; i++) {
        	Map<String, Object> map = new HashMap<>();
        	map.put("name", "张三"+i);
        	map.put("phone", "1830000000"+i);
        	list.add(map);
		}

        try {
            String exportFileName = "测试数据";
            response.setContentType("application/vnd.ms-excel"); 
            //根据浏览器类型处理文件名称
            String agent = request.getHeader("USER-AGENT").toLowerCase();
            if (agent.indexOf("firefox") > -1){//若是火狐
                exportFileName = new String(exportFileName.getBytes("UTF-8"), "ISO8859-1");
            } else {//其他浏览器
                exportFileName = java.net.URLEncoder.encode(exportFileName, "UTF-8");
            }

            OutputStream out = response.getOutputStream();
            //保存导出的excel的名称
            response.setHeader("Content-Disposition", "attachment;filename="
                    + exportFileName + ".xlsx");
            if (list != null) { 
                ExportExcelUtils.exportExcel2007("司机信息", cellname, list, keyList, out);
            }

            out.flush();
            out.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }  
        return null;
    }
}
