package org.example.controller;

import org.example.exception.AppException;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Object register(User user, MultipartFile headFile){
        //数据的非功能性校验，此处省略
        //保存用户头像到服务端本地
        //上传路径映射为http服务路径
        if (headFile != null){
            String head = userService.saveHead(headFile);

            //用户头像的路径设置到user对象的head属性中
            user.setHead(head);
        }
        userService.register(user);
        return null;
    }

    @PostMapping("/login")
    public Object login(@RequestBody User user, HttpServletRequest request){
        User exist = userService.queryByUsername(user.getUsername());
        //如果用户不存在
        if (exist == null){
            throw new AppException("LOG001","用户不存在");
        }
        if (!user.getPassword().equals(exist.getPassword())){
            throw new AppException("LOG002","用户名或密码错误");
        }
        //校验通过保存数据库用户到session中
        HttpSession session = request.getSession();
        session.setAttribute("user",exist);
        return null;
    }
    @GetMapping("/logout")
    public Object logout(HttpSession session){
        session.removeAttribute("user");
        return null;
    }
}
