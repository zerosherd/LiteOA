package cn.zerosherd.liteoa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration{

    @Bean
    public PasswordEncoder passwordEncoder(){
//        return NoOpPasswordEncoder.getInstance();  // 不加密
        return new BCryptPasswordEncoder(); // 加密方式bcrypt
    }

    /**
     * HttpSecurity功能设置，根据功能，得到自己的过滤器链
     */
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http// 权限设置
                 .authorizeHttpRequests(authorize ->
                        authorize
                                // 放行无需授权的页面
                                .requestMatchers("/login","/logout","/register","/register.html","/forgot-password","forgot-password.html","/all").permitAll()
                                // 放行静态资源
                                .requestMatchers("/css/**","/js/**","/img/**").permitAll()
                                // 任何资源请求都需要登陆
                                .anyRequest().authenticated()
                )
                // 自定义登陆页面
                .formLogin(form -> {
                    form.loginPage("/login.html").permitAll()
                            //登录失败的返回地址，加了参数，是因为有这个参数，页面会有提示
                            .failureUrl("/login?error")
                    ;
                });
        // 关闭post请求的 csrf
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

}
