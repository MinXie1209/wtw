package top.whattowatch.wtw.service;

import org.springframework.cache.annotation.Cacheable;
import top.whattowatch.wtw.po.Result;

/**
 * @Auther: JNXJ
 * @Date: 2018/8/30 14:49
 * @Description:
 */
public interface ViewTypeStatisticsService {
    @Cacheable(value = "user",key = "#root.targetClass+'_'+#userId",unless = "#result eq null ")
    Result selectByUserId(String userId);
}
