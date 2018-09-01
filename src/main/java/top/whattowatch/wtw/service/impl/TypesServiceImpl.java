package top.whattowatch.wtw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.whattowatch.wtw.mapper.TypesMapper;
import top.whattowatch.wtw.po.Result;
import top.whattowatch.wtw.service.TypesService;
import top.whattowatch.wtw.utils.ResultUtils;

/**
 * @Auther: JNXJ
 * @Date: 2018/8/30 13:53
 * @Description:
 */
@Service
public class TypesServiceImpl implements TypesService {
    @Autowired
    TypesMapper typesMapper;
    @Override
    public Result listTypes() {
        System.out.println("未缓存");
        return ResultUtils.success(typesMapper.selectByExample(null));
    }
}
