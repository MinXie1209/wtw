package top.whattowatch.wtw.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.whattowatch.wtw.po.ViewTypeStatistics;
import top.whattowatch.wtw.po.ViewTypeStatisticsExample;

public interface ViewTypeStatisticsMapper {
    int countByExample(ViewTypeStatisticsExample example);

    int deleteByExample(ViewTypeStatisticsExample example);

    int deleteByPrimaryKey(Integer vtsId);

    int insert(ViewTypeStatistics record);

    int insertSelective(ViewTypeStatistics record);

    List<ViewTypeStatistics> selectByExampleWithBLOBs(ViewTypeStatisticsExample example);

    List<ViewTypeStatistics> selectByExample(ViewTypeStatisticsExample example);

    ViewTypeStatistics selectByPrimaryKey(Integer vtsId);

    int updateByExampleSelective(@Param("record") ViewTypeStatistics record, @Param("example") ViewTypeStatisticsExample example);

    int updateByExampleWithBLOBs(@Param("record") ViewTypeStatistics record, @Param("example") ViewTypeStatisticsExample example);

    int updateByExample(@Param("record") ViewTypeStatistics record, @Param("example") ViewTypeStatisticsExample example);

    int updateByPrimaryKeySelective(ViewTypeStatistics record);

    int updateByPrimaryKeyWithBLOBs(ViewTypeStatistics record);

    int updateByPrimaryKey(ViewTypeStatistics record);
}