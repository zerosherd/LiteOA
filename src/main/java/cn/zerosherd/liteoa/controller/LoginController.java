package cn.zerosherd.liteoa.controller;


import cn.zerosherd.liteoa.entity.User;
import cn.zerosherd.liteoa.service.UserService;
import cn.zerosherd.liteoa.utility.UserRepository;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class LoginController {

    @Resource
    private UserRepository userRepository;

    @RequestMapping("/")
    public String redirect() {
        return "login.html";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/index")
    public List<User> index() {
        return userRepository.findAll();
    }

}
