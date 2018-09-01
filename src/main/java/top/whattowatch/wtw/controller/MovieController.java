package top.whattowatch.wtw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.whattowatch.wtw.po.Result;
import top.whattowatch.wtw.service.MovieService;
import top.whattowatch.wtw.utils.TokenValid;

/**
 * @Auther: JNXJ
 * @Date: 2018/8/30 08:55
 * @Description:
 */
@RestController
@RequestMapping("/api")
public class MovieController {
    @Autowired
    MovieService movieService;
    /**
     * 随机获取一条电影记录
     */
    @TokenValid
    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public Object selectByTypesOrRand(@RequestParam(value = "types",required = false) String types)  throws Exception{
        return movieService.getByTypesOrRand(types);
    }
    /**
     * 根据id获取电影信息
     */
    @TokenValid
    @RequestMapping(value = "/movies/{movieId}", method = RequestMethod.GET)
    public Object selectByTypesOrRand(@PathVariable(value = "movieId",required = true) Integer movieId)  throws Exception{
        return movieService.getByMovieId(movieId);
    }

    /**
     * 根据电影名获取电影资源
     * /api/title/movies GET parameter: pageSize(记录数),pageNum(页数)
     * @param mTitle
     * @return
     */
    @TokenValid
    @RequestMapping(value = "/title/movies", method = RequestMethod.GET)
    public  Object selectByTitle(@RequestParam(value = "mTitle",required = true) String mTitle,@RequestParam(value ="pageSize",defaultValue ="5")int pageSize
            ,@RequestParam(value ="pageNum",defaultValue ="1")int pageNum) throws Exception{
        return movieService.listByTitle(mTitle,pageSize,pageNum);
    }

    /**
     *  根据电影名获取电影资源
     *  /api/recommend/movies  GET  parameter: userId,pageSize(记录数)
     * @param userId
     * @param pageSize
     * @param pageNum
     * @return
     * @throws Exception
     */
    @TokenValid
    @RequestMapping(value = "/recommend/movies", method = RequestMethod.GET)
    public Result recommendMovieByUserId(@RequestParam(value = "userId",required = true) String userId, @RequestParam(value ="pageSize",defaultValue ="5")int pageSize
            , @RequestParam(value ="pageNum",defaultValue ="1")int pageNum) throws Exception{
        return movieService.listRecommendMovieByUserId(userId,pageSize,pageNum);
    }
}
