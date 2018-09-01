package top.whattowatch.wtw.scheduler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import top.whattowatch.wtw.mapper.MovieMapper;
import top.whattowatch.wtw.mapper.TypesMapper;
import top.whattowatch.wtw.po.Movie;
import top.whattowatch.wtw.po.Types;
import top.whattowatch.wtw.webmagic.MoviePageProcessor;

import java.util.*;

/**
 * @author 江南小俊
 * @create 2018-07-26 12:47
 * @desc 任务调度定时爬取电影资源
 **/
@Component
public class MovieScheduler {
    @Autowired
    MovieMapper movieMapper;
    @Autowired
    TypesMapper typesMapper;
    private static Set<String> types = new HashSet<>();

    /**
     * 1.定时爬取电影资源
     * 2.清空movie表内容
     * 3.插入爬取的资源
     * 4.遍历movie-types,更新redis中存储的电影类别
     */
    @Scheduled(cron = "00 00 04 1 * ?")
    @Transactional(rollbackFor = Exception.class)
    public void start() {
        MoviePageProcessor moviePageProcessor = new MoviePageProcessor();
        ArrayList<Movie> movies = moviePageProcessor.main();
        movieMapper.deleteByExample(null);
        typesMapper.deleteByExample(null);
        if (movies.size() > 0) {
            movieMapper.insertBatch(movies);
        }
        for (Movie movie : movies) {
            if(movie.getTypes()!=null){
                for (String type : movie.getTypes().split("/") ) {
                    if (type!=null&&!type.trim().equals("")) {
                        types.add(type.trim());
                    }

                }
            }

        }
        for (String realType : types) {
              typesMapper.insert(new Types(realType));
        }


    }
}
