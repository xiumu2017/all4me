package com.paradise.all4me.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.util.StringUtils;
import com.paradise.all4me.sleep.domain.SleepRecord;
import com.paradise.all4me.sleep.service.SleepRecordService;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class SleepRecordListener extends AnalysisEventListener<SleepRecordExcel> {

    private final List<SleepRecord> recordList = new ArrayList<>();
    private final SleepRecordService sleepRecordService;
    private final Integer uid;

    public SleepRecordListener(SleepRecordService sleepRecordService, Integer uid) {
        this.sleepRecordService = sleepRecordService;
        this.uid = uid;
    }

    public SleepRecordListener() {
        this.sleepRecordService = null;
        this.uid = 0;
    }

    @Override
    public void invoke(SleepRecordExcel sleepRecordExcel, AnalysisContext analysisContext) {
        try {
            if (StringUtils.isEmpty(sleepRecordExcel.getDate())) {
                return;
            }
            recordList.add(sleepRecordExcel.toSleepRecord(uid));
        } catch (ParseException e) {
            log.error("Excel 数据转换异常", e);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        if (this.sleepRecordService == null) {
            log.info("总数量：{}", recordList.size());
            return;
        }
        int count = sleepRecordService.batchInsert(recordList);
        log.info("Excel批量导入{}行", count);
    }
}
