package com.paradise.all4me.excel;

import com.alibaba.excel.EasyExcel;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;

@Ignore
public class ExcelTest {

    @Test
    public void test() {
        String filePath = "E:\\test.xlsx";
        EasyExcel.read(filePath, SleepRecordExcel.class,
                new SleepRecordListener()).sheet().doRead();

    }
}
