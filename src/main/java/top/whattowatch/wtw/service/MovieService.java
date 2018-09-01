package top.whattowatch.wtw.service;

import org.springframework.cache.annotation.Cacheable;
import top.whattowatch.wtw.po.Result;

/**
 * @auther 江南小俊
 * @Date: 2018/8/30 12:55
 * @Description:
 */
public interface MovieService {
    /**
     * 通过选定类型或随机获取一条电影记录
     * @param types
     * @return
     */
    Result getByTypesOrRand(String types);

    /**
     * 通过电影id获取电影详细信息
     * @param movieId
     * @return
     */
    @Cacheable(value = "movie",key = "#root.targetClass+'_'+#movieId",unless = "#result eq null ")
    Result getByMovieId(Integer movieId);

    /**
     * 通过电影名模糊查询电影
     * @param mTitle
     * @param pageSize
     * @param pageNum
     * @return
     */
    @Cacheable(value = "movie",key = "#root.targetClass+#mTitle+'_'+#pageSize+'_'+#pageNum",unless = "#result eq null ")
    Result listByTitle(String mTitle, Integer pageSize, Integer pageNum);

    /**
     * 根据用户的习惯去个性化推荐电影
     * @param userId
     * @param pageSize
     * @param pageNum
     * @return
     */
    Result listRecommendMovieByUserId(String userId, int pageSize, int pageNum);
}
