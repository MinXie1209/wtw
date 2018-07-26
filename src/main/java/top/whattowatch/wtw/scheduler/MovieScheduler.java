package top.whattowatch.wtw.scheduler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import top.whattowatch.wtw.mapper.MovieMapper;
import top.whattowatch.wtw.po.Movie;
import top.whattowatch.wtw.webmagic.MoviePageProcessor;

import java.util.ArrayList;

/**
 * @author 江南小俊
 * @create 2018-07-26 12:47
 * @desc 任务调度定时爬取电影资源
 **/
@Component
public class MovieScheduler {
    @Autowired
    MovieMapper movieMapper;

    @Scheduled(cron = "10 50 15 26/7 * ?")
    @Transactional(rollbackFor = Exception.class)
    public void start() {
        MoviePageProcessor moviePageProcessor = new MoviePageProcessor();
        ArrayList<Movie> movies = moviePageProcessor.main();
        movieMapper.deleteByExample(null);
        if (movies.size() > 0) {
            movieMapper.insertBatch(movies);
        }

    }
}
