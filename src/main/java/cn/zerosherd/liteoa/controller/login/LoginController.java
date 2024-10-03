package cn.zerosherd.liteoa.controller.login;


import cn.zerosherd.liteoa.entity.User;
import cn.zerosherd.liteoa.dao.UserRepository;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Resource
    private UserRepository userRepository;

    @RequestMapping("/")
    public String redirect() {
        return "login";
    }

    /**
     * 登陆方法, 用户输入邮箱和密码, 查询数据库检验是否有该账户,如果有,
     * 返回原先页面 ,登陆成功。
     * @param username 用户账号
     * @param password 用户密码
     * @param model Spring MVC中的Model，用来储存经过controller处理后的信息，再由View层渲染
     *         得到前端页面。
     * @return
     */
    @PostMapping(path = "/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        List<User> users = userRepository.findByUsername(username);
        // 如果数据库中未查到该账号:
        if (users.isEmpty()) {
            model.addAttribute("errorMessage","用户不存在");
            return "login";
        } else {
            User user = users.get(0);
            if (passwordEncoder.matches(password, user.getPassword())) {
                return "index";
            } else {
                model.addAttribute("errorMessage","密码错误");
                return "login";
            }
        }
    }

}
