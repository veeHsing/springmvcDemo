package com.zhangwx.controller;

import com.zhangwx.exception.SysException;
import com.zhangwx.model.User;
import com.zhangwx.service.UserService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "index")
    public String index() throws Exception{
        User user = new User();
        user.setUsername("tmr");
        user.setPassword("2222");
//        User user = userService.findAll();
        userService.Insert(user);
        System.out.println("sds");
        return "index";
    }

    @RequestMapping(path = "login")
    public String login(HttpServletRequest request, HttpServletResponse response){
        return "login";
    }

    @RequestMapping(path = "upload")
    public String upload(HttpServletRequest request, MultipartFile img) {
        System.out.println("文件上传...");
        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断该路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }

        //上传文件项
        String filename = img.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String saveName = uuid + "_" + filename.substring(filename.lastIndexOf(File.separator) + 1);
        try {
            int a = 10/0;
            img.transferTo(new File(path,saveName));
        } catch (IOException e) {
            e.printStackTrace();
            throw new SysException(e.getMessage());
        }
        return "index";
    }
}
