package top.whattowatch.wtw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import top.whattowatch.wtw.enums.ResultEnum;
import top.whattowatch.wtw.mapper.ViewTypeStatisticsMapper;
import top.whattowatch.wtw.po.Result;
import top.whattowatch.wtw.po.ViewTypeStatistics;
import top.whattowatch.wtw.po.ViewTypeStatisticsExample;
import top.whattowatch.wtw.service.ViewTypeStatisticsService;
import top.whattowatch.wtw.utils.ResultUtils;

import java.util.List;

/**
 * @Auther: JNXJ
 * @Date: 2018/8/30 14:49
 * @Description:
 */
@Service
public class ViewTypeStatisticsServiceImpl implements ViewTypeStatisticsService {
    @Autowired
    ViewTypeStatisticsMapper viewTypeStatisticsMapper;

    @Override
    public Result selectByUserId(String userId) {
        System.out.println("未缓存");
        ViewTypeStatisticsExample example=new ViewTypeStatisticsExample();
        ViewTypeStatisticsExample.Criteria criteria=example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<ViewTypeStatistics> viewTypeStatistics=viewTypeStatisticsMapper.selectByExample(example);
        if(viewTypeStatistics.size()==0){
            return ResultUtils.error(ResultEnum.NOT_VIEWMOVIES);
        }
       return ResultUtils.success(viewTypeStatistics);
    }
}
