package com.paradise.all4me.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.paradise.all4me.sleep.domain.SleepRecord;
import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class SleepRecordExcel {
    @ExcelProperty(value = "日期")
    private String date;
    @ExcelProperty(value = "入睡时间")
    private String sleepTime;
    @ExcelProperty(value = "醒来时间")
    private String wakeTime;
    @ExcelProperty(value = "起床时间")
    private String upTime;
    @ExcelProperty(value = "睡眠时长")
    private String sleepDuration;
    @ExcelProperty(index = 5)
    private String quality;
    @ExcelProperty(value = "屏幕记录")
    private String screenTime;
    @ExcelProperty(index = 7)
    private String remark;
    @ExcelProperty(index = 8)
    private String remark1;
    @ExcelProperty(index = 9)
    private String remark2;

    SleepRecord toSleepRecord(Integer uid) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        String sleepTimeStr = this.date + " " + this.sleepTime;
        int sleepTimeInt = Math.toIntExact(sdf.parse(sleepTimeStr).getTime() / 1000);
        String prefix = this.sleepTime.split(":")[0];
        if (Integer.parseInt(prefix) > 20) {
            sleepTimeInt = sleepTimeInt - 24 * 3600;
        }
        String wakeTimeStr = this.date + " " + this.wakeTime;
        Integer wakeTimeInt = Math.toIntExact(sdf.parse(wakeTimeStr).getTime() / 1000);
        String upTimeStr = this.date + " " + this.upTime;
        Integer upTimeInt = Math.toIntExact(sdf.parse(upTimeStr).getTime() / 1000);
        Integer qualityInt = this.quality == null ? 0 : this.quality.length();
        String remark = getRemarkStr();
        System.out.print(this.date);
        System.out.println(remark);
        return SleepRecord.builder()
                .date(this.date)
                .bedTime(sleepTimeInt)
                .createTime(new Date())
                .fallTime(sleepTimeInt)
                .haveDream(0)
                .remark(remark)
                .sleepQuality(qualityInt)
                .uid(uid)
                .upTime(upTimeInt)
                .wakeTime(wakeTimeInt)
                .build();
    }

    private String getRemarkStr() {
        if (isNull(this.sleepDuration)) {
            this.sleepDuration = "";
        }
        if (isNull(this.remark)) {
            this.remark = "";
        }
        if (isNull(this.remark1)) {
            this.remark1 = "";
        }
        if (isNull(this.remark2)) {
            this.remark2 = "";
        }
        return this.sleepDuration + ";" + this.remark + ";" + this.remark1 + ";" + this.remark2;
    }

    private boolean isNull(String target) {
        return target == null || "null".equals(target);
    }
}
