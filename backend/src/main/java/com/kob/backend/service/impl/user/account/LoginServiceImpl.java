package com.kob.backend.service.impl.user.account;

import com.kob.backend.pojo.User;
import com.kob.backend.service.impl.utils.UserDetailsImpl;
import com.kob.backend.service.user.account.LoginService;
import com.kob.backend.utils.JwtUtil;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager; // 验证用户的api

    @Override
    public Map<String, String> getToken(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken=
                new UsernamePasswordAuthenticationToken(username,password);
        // 生成加密之后的字符串 因为username ，pass 是明文
        val authenticate = authenticationManager.authenticate(authenticationToken); // 如果登陆失败 报异常 自动处理

        // 登陆成功
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticate.getPrincipal();
        User user=loginUser.getUser();

        // 取出user 封装成token
        String jwt = JwtUtil.createJWT(user.getId().toString());

        Map<String,String> map=new HashMap<>();
        map.put("error_message","success");
        map.put("token",jwt);

        return map;
    }
}
