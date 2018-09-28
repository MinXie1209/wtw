package top.whattowatch.wtw.service;

import org.springframework.cache.annotation.Cacheable;
import top.whattowatch.wtw.po.Result;

/**
 * @Auther: JNXJ
 * @Date: 2018/8/30 14:07
 * @Description:
 */
public interface HistoricalRecordsService {
    /**
     * 通过用户id获取观影历史记录(多条)
     * @param userId
     * @return
     */

    Result listHistoricalRecordsByUserId(String userId);

    /**
     * 保存用户的观影记录
     * @param userId
     * @param mTitle
     * @param types
     * @return
     */
    Result saveHistoricalRecord(String userId, String mTitle, String types);
}
