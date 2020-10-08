package org.lanqiao.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;


// Security 配置,继承WebSecurityConfigurerAdapter这个类
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyAuthenticationFailureHandler failureHandler;

    @Autowired
    private MyAuthenticationSuccessHandler successHandler;

    @Autowired
    private UserDetailsServiceImpl userDetails;

    @Autowired
    RedisAuthenticationFilter redisAuthenticationFilter;
    // 认证用户信息和权限
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetails).passwordEncoder(new BCryptPasswordEncoder());
    }

    // 配置拦截请求资源
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()  //表单登录默认登录页面是/login 默认登录处理路径（form action）也是也是/login
                .loginPage("/login")//配置自定义登录页面
                .successHandler(successHandler) //定义登录成功处理
                .failureHandler(failureHandler).and() //定义登录失败处理
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and() // 不需要session验证，加上token不好使。
                .authorizeRequests().antMatchers("/login").permitAll()//不校验我们配置的登录页面
                .anyRequest().authenticated() //其他页面都校验
                .and().csrf().disable() //不允许csr
                .addFilterBefore(redisAuthenticationFilter, BasicAuthenticationFilter.class); //验证token操作
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**", "/css/**", "/images/**","/register");
    }
}