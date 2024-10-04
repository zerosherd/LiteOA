package cn.zerosherd.liteoa.controller.register;

import cn.zerosherd.liteoa.entity.user.User;
import cn.zerosherd.liteoa.utility.InternetProtocolUtil;
import cn.zerosherd.liteoa.utility.DateTimeUtil;
import cn.zerosherd.liteoa.service.user.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.Date;
import java.util.UUID;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @Resource
    private HttpServletRequest request;

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password, @RequestParam String confirmPassword, @RequestParam String email, Model model) throws ParseException, UnknownHostException {
        if (!password.equals(confirmPassword)) {
            model.addAttribute("errorMessage", "Passwords do not match.");
            return "register";
        }

        User user = new User();
        UUID uuid = UUID.randomUUID();
//        String ip = InternetProtocolUtil.getIp(request);
        String ip = InternetProtocolUtil.getIp();
        Date createTime = DateTimeUtil.getFormattedDateTime();

        user.setId(String.valueOf(uuid));
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setStatus(1);
        user.setIp(ip);
        user.setCreateTime(createTime);

        boolean success = userService.register(user);
        if (!success) {
            model.addAttribute("errorMessage", "Username already exists.");
            return "register";
        }else{
            model.addAttribute("errorMessage", "You have successfully registered.");
            return "redirect:/login"; // Redirect to login page after successful registration
        }
    }

}
