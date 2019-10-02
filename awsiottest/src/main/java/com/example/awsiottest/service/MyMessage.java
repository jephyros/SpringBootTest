package com.example.awsiottest.service;

import com.amazonaws.services.iot.client.AWSIotMessage;
import com.amazonaws.services.iot.client.AWSIotQos;

/**
 * @author InSeok
 * Date : 2019-10-01
 * Remark :
 */
public class MyMessage extends AWSIotMessage {

    public MyMessage(String topic, AWSIotQos qos, String payload) {
        super(topic, qos, payload);
    }

    @Override
    public void onSuccess() {
        //super.onSuccess();
        System.out.println("success nonBlocking Topic publish " );
    }
}
