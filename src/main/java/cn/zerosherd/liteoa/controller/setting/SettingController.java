package cn.zerosherd.liteoa.controller.setting;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SettingController {

    @RequestMapping("/setting")
    public String toSetting() {
        return "/setting/setting.html";
    }

}
