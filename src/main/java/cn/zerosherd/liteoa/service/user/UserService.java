package cn.zerosherd.liteoa.service.user;

import cn.zerosherd.liteoa.dao.UserRepository;
import cn.zerosherd.liteoa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean register(User user) {
        // Check if username already exists
        if (!userRepository.findByUsername(user.getUsername()).isEmpty()) {
            return false; // Username already exists
        }

        // Encode the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Save the new user to the database
        userRepository.save(user);
        return true;
    }

}
