package top.whattowatch.wtw.service.impl;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import top.whattowatch.wtw.enums.ResultEnum;
import top.whattowatch.wtw.mapper.MovieMapper;
import top.whattowatch.wtw.mapper.ViewTypeStatisticsMapper;
import top.whattowatch.wtw.po.*;
import top.whattowatch.wtw.service.MovieService;
import top.whattowatch.wtw.utils.ResultUtils;

import java.util.List;

/**
 * @Auther: JNXJ
 * @Date: 2018/8/30 12:56
 * @Description:
 */
@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieMapper movieMapper;
    @Autowired
    ViewTypeStatisticsMapper viewTypeStatisticsMapper;
    @Override
    public Result getByTypesOrRand(String types) {

        return ResultUtils.success(movieMapper.selectByTypesOrRand(types));
    }

    @Override
    public Result getByMovieId(Integer movieId) {
        System.out.println("未缓存");
        Movie movie=movieMapper.selectByPrimaryKey(movieId);
        if (movie==null){
            return ResultUtils.error(ResultEnum.NOT_MOVIE);
        }
        return ResultUtils.success(movie);
    }



    @Override
    public Result listByTitle(String mTitle, Integer pageSize, Integer pageNum) {
        System.out.println("未缓存");
        MovieExample movieExample=new MovieExample();
        MovieExample.Criteria criteria=movieExample.createCriteria();
        criteria.andTitleLike("%"+mTitle+"%");
        PageHelper.offsetPage(pageNum,pageSize);
        List<Movie>movies=movieMapper.selectByExample(movieExample);
        if(movies.size()<=0){
            return ResultUtils.error(ResultEnum.NOT_MOVIEBYTITLE);
        }
        return ResultUtils.success();
    }

    /**
     * 根据用户id查询到所观看过的类型
     * 然后再传入参数
     * @param userId
     * @param pageSize
     * @param pageNum
     * @return
     */
    @Override
    public Result listRecommendMovieByUserId(String userId, int pageSize, int pageNum) {
        ViewTypeStatisticsExample viewTypeStatisticsExample=new ViewTypeStatisticsExample();
        ViewTypeStatisticsExample.Criteria criteria=viewTypeStatisticsExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<ViewTypeStatistics> viewTypeStatistics=viewTypeStatisticsMapper.selectByExample(viewTypeStatisticsExample);
        List<Movie>movies=movieMapper.recommendMovieByUserId( userId,pageSize,viewTypeStatistics);
        if(movies.size()!=0){
            return ResultUtils.success(movies);
        }
        else{
            return ResultUtils.error(ResultEnum.UN_ERROR);
        }

    }
}
