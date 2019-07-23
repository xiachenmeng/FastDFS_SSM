package com.qf.controller;

import com.qf.pojo.HouseInfo;
import com.qf.service.HouseInfoService;
import com.qf.util.FastDFSUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MyController {

    @Resource
    private HouseInfoService houseInfoService;

   @RequestMapping("/upload.json")
   @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file){
       try {
           //1.怎样得到名称
           String name=file.getOriginalFilename();
           //2.后缀
           String suffix= name.substring(name.lastIndexOf(".")+1);
           //3.得到上传文件的byte数组
           byte[] b = file.getBytes();
           FastDFSUtils fastDFSUtils=new FastDFSUtils();
           String[] s = fastDFSUtils.upload(b, suffix);
           StringBuffer stringBuffer=new StringBuffer("http://192.168.132.66:82/");
           if (s!=null){
               for (int i=0;i<s.length;i++) {
                   stringBuffer.append(s[i]);
                   if (i==0){
                       stringBuffer.append("/");
                   }
               }
           }
           return stringBuffer.toString();
       } catch (IOException e) {
           e.printStackTrace();

       }
       return null;
   }

    @RequestMapping("/fileupload.json")
    @ResponseBody
    public Map filleupload(@RequestParam("file") MultipartFile file){
        Map map=new HashMap();
        try {
            //1.怎样得到名称
            String name=file.getOriginalFilename();
            //2.后缀
            String suffix= name.substring(name.lastIndexOf(".")+1);
            //3.得到上传文件的byte数组
            byte[] b = file.getBytes();
            FastDFSUtils fastDFSUtils=new FastDFSUtils();
            String[] s = fastDFSUtils.upload(b, suffix);
            StringBuffer stringBuffer=new StringBuffer("http://192.168.132.66:82/");
            if (s!=null){
                for (int i=0;i<s.length;i++) {
                    stringBuffer.append(s[i]);
                    if (i==0){
                        stringBuffer.append("/");
                    }
                }
            }
            String url = stringBuffer.toString();
            map.put("status",200);
            map.put("msg","success");
            map.put("url",url);
            return map;
        } catch (IOException e) {
            e.printStackTrace();
        }
        map.put("status",500);
        map.put("msg","filer");
        return null;
    }

    @RequestMapping("/addHouseInfo.json")
    @ResponseBody
    public    Map<String,Object>  save(HouseInfo info){
        Map<String,Object> map = new HashMap<>();

        int i = houseInfoService.saveHouseInfo(info);
        if (i>0){
            map.put("status","200");
            map.put("msg","success");
        }else{
            map.put("msg","fail");
            map.put("status","500");
        }

        return map;
    }



}
