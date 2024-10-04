package cn.zerosherd.liteoa.controller.search;

import cn.zerosherd.liteoa.dao.user.UserRepository;
import cn.zerosherd.liteoa.entity.user.User;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AllUserInfoController {

    @Resource
    private UserRepository userRepository;

    @RequestMapping("/all")
    public List<User> allUserInfo() {
        return userRepository.findAll();
//        return userRepository.findByUsername("user");
    }

}
