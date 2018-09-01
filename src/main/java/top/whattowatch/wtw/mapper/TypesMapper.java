package top.whattowatch.wtw.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.whattowatch.wtw.po.Types;
import top.whattowatch.wtw.po.TypesExample;

public interface TypesMapper {
    int countByExample(TypesExample example);

    int deleteByExample(TypesExample example);

    int deleteByPrimaryKey(Integer typesId);

    int insert(Types record);

    int insertSelective(Types record);

    List<Types> selectByExample(TypesExample example);

    Types selectByPrimaryKey(Integer typesId);

    int updateByExampleSelective(@Param("record") Types record, @Param("example") TypesExample example);

    int updateByExample(@Param("record") Types record, @Param("example") TypesExample example);

    int updateByPrimaryKeySelective(Types record);

    int updateByPrimaryKey(Types record);
}