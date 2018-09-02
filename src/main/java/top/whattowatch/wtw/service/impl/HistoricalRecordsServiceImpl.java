package top.whattowatch.wtw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.whattowatch.wtw.enums.ResultEnum;
import top.whattowatch.wtw.mapper.HistoricalRecordsMapper;
import top.whattowatch.wtw.mapper.ViewTypeStatisticsMapper;
import top.whattowatch.wtw.po.*;
import top.whattowatch.wtw.service.HistoricalRecordsService;
import top.whattowatch.wtw.utils.ResultUtils;

import java.util.List;

/**
 * @Auther: JNXJ
 * @Date: 2018/8/30 14:08
 * @Description:
 */
@Service
public class HistoricalRecordsServiceImpl implements HistoricalRecordsService {
    @Autowired
    HistoricalRecordsMapper historicalRecordsMapper;
    @Autowired
    ViewTypeStatisticsMapper viewTypeStatisticsMapper;

    @Override
    public Result listHistoricalRecordsByUserId(String userId) {
        System.out.println("未缓存");
        HistoricalRecordsExample historicalRecordsExample = new HistoricalRecordsExample();
        HistoricalRecordsExample.Criteria criteria = historicalRecordsExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<HistoricalRecords> historicalRecords=historicalRecordsMapper.selectByExample(historicalRecordsExample);
        if(historicalRecords.size()==0){
            return ResultUtils.error(ResultEnum.NOT_VIEWMOVIES);
        }
        else{
            return ResultUtils.success(historicalRecords);
        }

    }

    @Transactional
    @Override
    public Result saveHistoricalRecord(String userId, String mTitle, String types) {
        historicalRecordsMapper.insertSelective(new HistoricalRecords(userId, mTitle));
        for (String type : types.split("/")) {
            ViewTypeStatisticsExample example = new ViewTypeStatisticsExample();
            ViewTypeStatisticsExample.Criteria criteria = example.createCriteria();
            criteria.andMTypeEqualTo(type).andUserIdEqualTo(userId);
            List<ViewTypeStatistics> viewTypeStatistics = viewTypeStatisticsMapper.selectByExample(example);
            //已有记录
            if (viewTypeStatistics.size() > 0) {
                viewTypeStatistics.get(0).setTimes(viewTypeStatistics.get(0).getTimes() + 1);
                viewTypeStatisticsMapper.updateByPrimaryKeySelective(viewTypeStatistics.get(0));
            } else {
                viewTypeStatisticsMapper.insertSelective(new ViewTypeStatistics(userId, type));
            }

        }
        return ResultUtils.success();

    }
}
