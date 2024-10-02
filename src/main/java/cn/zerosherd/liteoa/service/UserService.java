package cn.zerosherd.liteoa.service;

import cn.zerosherd.liteoa.entity.User;
import cn.zerosherd.liteoa.utility.UserRepository;
import jakarta.annotation.Resource;

import java.util.List;

public class UserService {

    @Resource
    private UserRepository userRepository;

    /**
     * 测试查询
     *
     * @return
     */
    public List<User> selectAllUser() {
        return userRepository.findAll();
    }

}
