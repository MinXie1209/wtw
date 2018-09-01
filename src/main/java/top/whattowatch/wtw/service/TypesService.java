package top.whattowatch.wtw.service;

import org.springframework.cache.annotation.Cacheable;
import top.whattowatch.wtw.po.Result;

/**
 * @Auther: JNXJ
 * @Date: 2018/8/30 13:53
 * @Description:
 */
public interface TypesService {
    /**
     * 获取电影所有类型
     * @return
     */
    @Cacheable(value = "movie",key = "#root.targetClass+#root.methodName",unless = "#result eq null ")
    Result listTypes();
}
