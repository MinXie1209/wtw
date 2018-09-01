package top.whattowatch.wtw.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.whattowatch.wtw.app.App;

import top.whattowatch.wtw.enums.ResultEnum;
import top.whattowatch.wtw.po.Result;
import top.whattowatch.wtw.po.WeChatApplet;
import top.whattowatch.wtw.service.UserService;
import top.whattowatch.wtw.utils.ResultUtils;
import top.whattowatch.wtw.utils.TokenCreated;

import java.lang.reflect.Type;

/**
 * @author 江南小俊
 * @create 2018-07-27 12:19
 * @desc 用户控制层-user表
 **/
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @TokenCreated
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestParam String code)  throws Exception{
        System.out.println("code:" + code);

        return userService.login(code);
    }
}
