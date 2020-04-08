package com.paradise.all4me.service;

import com.paradise.all4me.sleep.domain.SleepRecord;
import com.paradise.all4me.sleep.mapper.SleepRecordMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;

@Service
@Slf4j
public class LogService {

    @Resource
    private SleepRecordMapper sleepRecordMapper;

    @Transactional(rollbackFor = Exception.class)
    public int rollback(String val) {
        SleepRecord sleepRecord = SleepRecord.builder()
                .date("2020-03-29")
                .uid(99)
                .wakeTime(1)
                .bedTime(1)
                .fallTime(1)
                .wakeTime(1)
                .upTime(1)
                .build();
        sleepRecordMapper.insertSelective(sleepRecord);
        if (val == null) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
        return 1;
    }

}
