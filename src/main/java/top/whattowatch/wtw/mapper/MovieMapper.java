package top.whattowatch.wtw.mapper;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.whattowatch.wtw.po.Movie;
import top.whattowatch.wtw.po.MovieExample;
import top.whattowatch.wtw.po.ViewTypeStatistics;

public interface MovieMapper {
    int countByExample(MovieExample example);

    int deleteByExample(MovieExample example);

    int deleteByPrimaryKey(Integer movieId);

    int insert(Movie record);

    int insertSelective(Movie record);

    List<Movie> selectByExample(MovieExample example);

    Movie selectByPrimaryKey(Integer movieId);

    int updateByExampleSelective(@Param("record") Movie record, @Param("example") MovieExample example);

    int updateByExample(@Param("record") Movie record, @Param("example") MovieExample example);

    int updateByPrimaryKeySelective(Movie record);

    int updateByPrimaryKey(Movie record);

    int insertBatch(ArrayList<Movie> movies);
    Movie selectByTypesOrRand(String types);

    List<Movie> recommendMovieByUserId(@Param("userId")String userId, @Param("pageSize")int pageSize,@Param("viewTypeStatistics") List<ViewTypeStatistics> viewTypeStatistics);
}