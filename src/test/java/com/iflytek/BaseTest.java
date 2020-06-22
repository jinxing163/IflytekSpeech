package com.iflytek;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author JinXing
 * @date 2020/6/18 21:15
 */

@RunWith(SpringRunner.class)
@SpringBootTest// 指定启动类
public class BaseTest {

    @Before
    @Test
    public void before() {
        System.out.println("before");
        System.out.println();
    }

    @Before
    public void after() {
        System.out.println("after");
        System.out.println();
    }

    @Test
    public void func() {

    }
}
