package top.whattowatch.wtw.service;

import org.springframework.cache.annotation.Cacheable;
import top.whattowatch.wtw.po.Result;
import top.whattowatch.wtw.po.WeChatApplet;

/**
 * @Auther: JNXJ
 * @Date: 2018/8/30 21:46
 * @Description:
 */
public interface UserService {
    Result login(String code);


}
