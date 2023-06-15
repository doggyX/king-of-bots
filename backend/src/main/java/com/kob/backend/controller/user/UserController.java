package com.kob.backend.controller.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kob.backend.mapper.UserMapper;
import com.kob.backend.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// rest 就是不返回页面了
@RestController
public class UserController {

     @Autowired  // 这个必须加
     UserMapper userMapper;
  //  @RequestMapping 全面一点
    @GetMapping("/user/all/")
    public List<User> getAll() {
        return userMapper.selectList(null); // 选择所有
    }

     @GetMapping("/user/{userId}/")
     public User getUser(@PathVariable int userId) { // pathv..来获取路径里的变量
         QueryWrapper<User> queryWrapper=new QueryWrapper<>();
         // 条件查询对象
         queryWrapper.eq("id",userId);
        //return userMapper.selectById(userId);
         return userMapper.selectOne(queryWrapper);
     }
    @GetMapping("/users/{userId}/")
    public List<User> getUsers(@PathVariable int userId) { // path..来获取路径里的变量
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        // 条件查询对象
        queryWrapper.ge("id",userId).lt ("id",userId+2);
        //return userMapper.selectById(userId);
        return userMapper.selectList(queryWrapper);
    }

    @GetMapping("/user/add/{userId}/{username}/{password}/")
    public String addUser(@PathVariable int userId,
                          @PathVariable String username,
                          @PathVariable String password) {
        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String encodePassword=passwordEncoder.encode(password);
        User user=new User(userId,username,encodePassword);
        userMapper.insert(user);
        return "Add user successfully";
    }

    @GetMapping("/user/delete/{userId}/")
    public String deleteUser(@PathVariable int userId) {
        userMapper.deleteById(userId);
        return "Delete user successfully";
    }

}
