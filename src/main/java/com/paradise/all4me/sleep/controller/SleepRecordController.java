package com.paradise.all4me.sleep.controller;

import com.alibaba.excel.EasyExcel;
import com.github.pagehelper.PageInfo;
import com.paradise.all4me.domain.User;
import com.paradise.all4me.excel.SleepRecordExcel;
import com.paradise.all4me.excel.SleepRecordListener;
import com.paradise.all4me.query.SleepRecordQuery;
import com.paradise.all4me.restful.R;
import com.paradise.all4me.restful.Rx;
import com.paradise.all4me.sleep.domain.SleepRecord;
import com.paradise.all4me.sleep.service.SleepRecordService;
import com.paradise.all4me.utils.CommonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;
import java.security.Principal;

@Api("睡眠管理")
@Slf4j(topic = "【睡眠管理】")
@RestController
@RequestMapping("/sleep")
public class SleepRecordController {
    private final SleepRecordService sleepRecordService;

    public SleepRecordController(SleepRecordService sleepRecordService) {
        this.sleepRecordService = sleepRecordService;
    }

    @ApiOperation("分页查询")
    @GetMapping("/page")
    public R<PageInfo<SleepRecord>> page(SleepRecordQuery query, @ApiIgnore Principal principal) {
        log.info("分页查询");
        User user = CommonUtils.getUser(principal);
        query.setUid(user.getId());
        return Rx.success(sleepRecordService.selectByPage(query));
    }

    @ApiOperation("保存")
    @PostMapping("/save")
    public R<String> save(@RequestBody @Validated SleepRecord record, @ApiIgnore Principal principal) {
        record.setUid(CommonUtils.getUserId(principal));
        if (record.getId() == null) {
            sleepRecordService.insert(record);
        } else {
            sleepRecordService.updateByPrimaryKey(record);
        }
        return Rx.success();
    }

    @ApiOperation("详情")
    @GetMapping("/detail/{id}")
    public R<SleepRecord> detail(@PathVariable Long id) {
        Assert.notNull(id, "参数为空异常");
        return Rx.success(sleepRecordService.selectByPrimaryKey(id));
    }

    @ApiOperation("删除")
    @DeleteMapping("/delete/{id}")
    public R<String> delete(@PathVariable Long id) {
        Assert.notNull(id, "参数为空异常");
        if (sleepRecordService.deleteByPrimaryKey(id) == 1) {
            return Rx.success();
        } else {
            return Rx.fail();
        }
    }

    @ApiOperation("Excel导入")
    @RequestMapping(value = "/excel", method = RequestMethod.POST)
    public R<String> excel(MultipartFile excel,
                           @ApiIgnore Principal principal) {
        Integer uid = CommonUtils.getUserId(principal);
        if (excel == null) {
            return Rx.fail("文件为空");
        } else {
            try {
                EasyExcel.read(excel.getInputStream(), SleepRecordExcel.class,
                        new SleepRecordListener(sleepRecordService, uid)).sheet().doRead();
            } catch (IOException e) {
                log.error("Excel导入异常");
                log.error(e.getLocalizedMessage(), e);
            }
            return Rx.success();
        }
    }
}

