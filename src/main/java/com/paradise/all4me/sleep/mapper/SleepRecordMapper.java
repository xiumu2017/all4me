package com.paradise.all4me.sleep.mapper;

import com.paradise.all4me.query.SleepRecordQuery;
import com.paradise.all4me.sleep.domain.SleepRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Mybatis Generator 2020/03/24
 */
@Mapper
public interface SleepRecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SleepRecord record);

    int insertSelective(SleepRecord record);

    SleepRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SleepRecord record);

    int updateByPrimaryKey(SleepRecord record);

    List<SleepRecord> selectByAll(SleepRecordQuery query);

    int insertList(@Param("list") List<SleepRecord> list);

}