package top.whattowatch.wtw.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.whattowatch.wtw.enums.ResultEnum;
import top.whattowatch.wtw.mapper.MovieMapper;
import top.whattowatch.wtw.mapper.ViewTypeStatisticsMapper;
import top.whattowatch.wtw.po.*;
import top.whattowatch.wtw.service.MovieService;
import top.whattowatch.wtw.utils.ResultUtils;
import top.whattowatch.wtw.webmagic.CoverPageProcessor;

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
        else {
            if(movie.getIntroduction()==null){
                movie.setIntroduction("");
            }
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
        return ResultUtils.success(movies);
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

    /**
     * 爬取图片链接
     * 1.如果有结果，替换数据库数据
     * 2.返回数据
     * @param mTitle
     * @param movieId
     * @return
     */
    @Override
    public Result getCover(String mTitle, Integer movieId) {
        CoverPageProcessor coverPageProcessor=new CoverPageProcessor();
        String cover= coverPageProcessor.main(mTitle);
        if(cover!=null&&movieId!=null){
            Movie movie=new Movie();
            movie.setMovieId(movieId);
            movie.setCover(cover);
            movieMapper.updateByPrimaryKeySelective(movie);
            return ResultUtils.success(cover);
        }
        return  ResultUtils.error(ResultEnum.NOT_COVER);
    }
}
