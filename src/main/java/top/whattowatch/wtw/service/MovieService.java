package top.whattowatch.wtw.service;

import org.springframework.cache.annotation.Cacheable;
import top.whattowatch.wtw.po.Result;

/**
 * @Auther: JNXJ
 * @Date: 2018/8/30 12:55
 * @Description:
 */
public interface MovieService {
    Result selectByTypesOrRand(String types);
    @Cacheable(value = "movie",key = "#root.targetClass+'_'+#movieId",unless = "#result eq null ")
    Result selectByMovieId(Integer movieId);
    @Cacheable(value = "movie",key = "#root.targetClass+#mTitle+'_'+#pageSize+'_'+#pageNum",unless = "#result eq null ")
    Result selectByTitle(String mTitle,Integer pageSize,Integer pageNum);

    Result recommendMovieByUserId(String userId, int pageSize, int pageNum);
}
