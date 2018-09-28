package top.whattowatch.wtw.service;

import org.springframework.cache.annotation.Cacheable;
import top.whattowatch.wtw.po.Result;

/**
 * @Auther: JNXJ
 * @Date: 2018/8/30 14:49
 * @Description:
 */
public interface ViewTypeStatisticsService {
    /**
     * 根据用户id查询用户的观影类型记录
     * @param userId
     * @return
     */

    Result listByUserId(String userId);
}
