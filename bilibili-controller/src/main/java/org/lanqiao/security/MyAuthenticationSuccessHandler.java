package org.lanqiao.security;




import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.lanqiao.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


// 认证成功
@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    RedisUtil redisUtil;

    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        //生成token
        String username = ((User) authentication.getPrincipal()).getUsername();
        String token = BCrypt.hashpw(username, BCrypt.gensalt());
        //将token存入redis
        redisUtil.set(token,username,20*60*1000);//有效期20分钟
        //将token返回
        response.setContentType("application/json;charset=UTF-8");
        response.addHeader("Authorization", "Bearer " + token);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", username);
        jsonObject.put("token",token);
        String jsonStr = JSONObject.toJSONString(jsonObject);
        response.getWriter().print(jsonStr);

    }

}