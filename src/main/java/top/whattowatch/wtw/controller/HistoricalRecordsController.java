package top.whattowatch.wtw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.whattowatch.wtw.service.HistoricalRecordsService;
import top.whattowatch.wtw.utils.TokenValid;

/**
 * @Auther: JNXJ
 * @Date: 2018/8/30 14:04
 * @Description:
 */
@RestController
@RequestMapping("/api")
public class HistoricalRecordsController {
    @Autowired
    HistoricalRecordsService historicalRecordsService;

    /**
     * 查询用户观影记录
     * @param userId
     * @return
     */
    @TokenValid
    @RequestMapping("/historical_records")
    public Object selectByUserId(@RequestParam(value = "userId",required = true)String userId) throws Exception{
            return historicalRecordsService.selectByUserId(userId);
    }

    /**
     * 添加观影历史记录，观影类型记录
     * /api/ historical_records POST parameter(userId,mTitle,types)
     * @param userId
     * @return
     */
    @TokenValid
    @RequestMapping(value = "/historical_records",method = RequestMethod.POST)
    public Object addHistoricalRecord(@RequestParam(value = "userId",required = true)String userId,
                                      @RequestParam(value = "mTitle",required = true)String mTitle,
                                      @RequestParam(value = "types",required = true)String types) throws Exception{
        return historicalRecordsService.addHistoricalRecord(userId,mTitle,types);
    }
}
