package cn.zerosherd.liteoa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration{

    /*重写加密方式*/
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 基于数据源的用户认证
     */
    @Bean
    UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return null;
            }
        };
    }


    /**
     * HttpSecurity功能设置，根据功能，得到自己的过滤器链
     */
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http// 权限设置
                 .authorizeHttpRequests(authorize ->
                        authorize
                                // /login 放行
                                .requestMatchers("/login.html").permitAll()
                                // /test1路径需要test1权限
                                .requestMatchers("/index").permitAll()
                                // 其他任何资源请求
                                // 任何资源请求
                                .anyRequest()
                                // 都需要登陆
                                .authenticated()
                )
                // 自定义登陆页面
                .formLogin(form -> {
                    form.loginPage("/login.html").permitAll()
                            //自定义表单用户名参数，默认是username
                            .usernameParameter("username")
                            //自定义表单密码参数，默认是password
                            .passwordParameter("password")
                            //登录失败的返回地址，加了参数，是因为有这个参数，页面会有提示
                            .failureUrl("/login?error")
                            //登陆成功的页面
                            .defaultSuccessUrl("/index.html")
                    ;
                });
        // 关闭post请求的 csrf
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

}
