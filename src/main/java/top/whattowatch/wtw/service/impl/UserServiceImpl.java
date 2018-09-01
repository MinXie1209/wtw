package top.whattowatch.wtw.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import top.whattowatch.wtw.app.App;
import top.whattowatch.wtw.enums.ResultEnum;
import top.whattowatch.wtw.mapper.UserMapper;
import top.whattowatch.wtw.po.Result;
import top.whattowatch.wtw.po.User;
import top.whattowatch.wtw.po.WeChatApplet;
import top.whattowatch.wtw.service.UserService;
import top.whattowatch.wtw.utils.ResultUtils;

/**
 * @Auther: JNXJ
 * @Date: 2018/8/30 21:48
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    RestTemplate restTemplate=new RestTemplate();
    @Autowired
    UserMapper userMapper;
    @Override
    public Result login(String code) {
        String uri = App.URL+"?appid=" +
                App.APPID + "&secret=" +
                App.APPSECRET + "&js_code=" +
                code + "&grant_type=authorization_code";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        String weChatAppletString = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class).getBody();
        System.out.println(weChatAppletString.toString());
        WeChatApplet weChatApplet=JSONObject.parseObject(weChatAppletString,WeChatApplet.class);
        if(weChatApplet.getErrcode()!=null){
            return ResultUtils.error(ResultEnum.ERROR_CODE);
        }
        else{
            if(userMapper.selectByPrimaryKey(weChatApplet.getOpenid())==null){
                userMapper.insertSelective(new User(weChatApplet.getOpenid()));
            }
            return ResultUtils.success(weChatApplet.getOpenid());
        }
    }
}
