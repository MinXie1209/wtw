package top.whattowatch.wtw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.whattowatch.wtw.service.ViewTypeStatisticsService;
import top.whattowatch.wtw.utils.TokenValid;

/**
 * @Auther: JNXJ
 * @Date: 2018/8/30 14:45
 * @Description:
 */
@RestController
@RequestMapping("/api")
public class ViewTypeStatisticsController {
    @Autowired
    ViewTypeStatisticsService viewTypeStatisticsService;

    /**
     * /api/view_type_statistics  GET parameter(userId)
     */
    @TokenValid
    @RequestMapping("/view_type_statistics")
    public Object selectByUserId(@RequestParam(required = true)String userId)  throws Exception{
            return viewTypeStatisticsService.selectByUserId(userId);
    }
}
