package com.example.awsiottest.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author InSeok
 * Date : 2019-09-30
 * Remark :
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class AwsIotServiceTest {

    @Autowired
    AwsIotService awsIotService;

    @Test
    public void mqtttest() throws Exception {
        awsIotService.mqtttest();

    }
    @Test
    public void shadowtest() throws Exception{
        awsIotService.shadowtest();
    }

    @Test
    public void mqttnonBlock() throws Exception{
        awsIotService.mqttnonBlock();
    }
    @Test
    public void mqttsubscribe() throws Exception{
        awsIotService.mqttsubscribe();
    }

    @Test
    public void shadownonblocktest() throws Exception{
        awsIotService.shadowNonblockingSend();
    }
}
