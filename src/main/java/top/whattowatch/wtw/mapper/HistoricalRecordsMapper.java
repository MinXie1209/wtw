package top.whattowatch.wtw.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.whattowatch.wtw.po.HistoricalRecords;
import top.whattowatch.wtw.po.HistoricalRecordsExample;

public interface HistoricalRecordsMapper {
    int countByExample(HistoricalRecordsExample example);

    int deleteByExample(HistoricalRecordsExample example);

    int deleteByPrimaryKey(Integer hrid);

    int insert(HistoricalRecords record);

    int insertSelective(HistoricalRecords record);

    List<HistoricalRecords> selectByExampleWithBLOBs(HistoricalRecordsExample example);

    List<HistoricalRecords> selectByExample(HistoricalRecordsExample example);

    HistoricalRecords selectByPrimaryKey(Integer hrid);

    int updateByExampleSelective(@Param("record") HistoricalRecords record, @Param("example") HistoricalRecordsExample example);

    int updateByExampleWithBLOBs(@Param("record") HistoricalRecords record, @Param("example") HistoricalRecordsExample example);

    int updateByExample(@Param("record") HistoricalRecords record, @Param("example") HistoricalRecordsExample example);

    int updateByPrimaryKeySelective(HistoricalRecords record);

    int updateByPrimaryKeyWithBLOBs(HistoricalRecords record);

    int updateByPrimaryKey(HistoricalRecords record);
}