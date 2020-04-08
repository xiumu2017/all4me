package com.paradise.all4me.transaction;

import com.paradise.all4me.service.UserService;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@Ignore
@SpringBootTest
public class RollbackTest {

    @Resource
    private UserService userService;

    @Test
    public void test() {
        int x = userService.rollbackTest(null);
        System.out.println(x);
    }
}
