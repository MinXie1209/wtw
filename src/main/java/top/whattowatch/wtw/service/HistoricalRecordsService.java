package top.whattowatch.wtw.service;

import org.springframework.cache.annotation.Cacheable;
import top.whattowatch.wtw.po.Result;

/**
 * @Auther: JNXJ
 * @Date: 2018/8/30 14:07
 * @Description:
 */
public interface HistoricalRecordsService {
    @Cacheable(value = "movie",key = "#root.targetClass+#root.methodName+#userId",unless = "#result eq null ")
    Result selectByUserId(String userId);

    Result addHistoricalRecord(String userId, String mTitle, String types);
}
