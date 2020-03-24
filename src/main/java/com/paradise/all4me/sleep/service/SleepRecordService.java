package com.paradise.all4me.sleep.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.paradise.all4me.query.SleepRecordQuery;
import com.paradise.all4me.sleep.domain.SleepRecord;
import com.paradise.all4me.sleep.mapper.SleepRecordMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SleepRecordService {

    @Resource
    private SleepRecordMapper sleepRecordMapper;

    public int deleteByPrimaryKey(Long id) {
        return sleepRecordMapper.deleteByPrimaryKey(id);
    }

    public int insert(SleepRecord record) {
        return sleepRecordMapper.insert(record);
    }

    public int insertSelective(SleepRecord record) {
        return sleepRecordMapper.insertSelective(record);
    }

    public SleepRecord selectByPrimaryKey(Long id) {
        return sleepRecordMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(SleepRecord record) {
        return sleepRecordMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(SleepRecord record) {
        return sleepRecordMapper.updateByPrimaryKey(record);
    }

    public int batchInsert(List<SleepRecord> sleepRecordList){
        return sleepRecordMapper.insertList(sleepRecordList);
    }

    public PageInfo<SleepRecord> selectByPage(SleepRecordQuery query) {
        PageHelper.startPage(query.getPageNum(),query.getPageSize());
        List<SleepRecord> sleepRecordList = sleepRecordMapper.selectByAll(query);
        return new PageInfo<>(sleepRecordList);
    }
}
