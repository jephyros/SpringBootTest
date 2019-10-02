package com.example.awsiottest.service;

import com.amazonaws.services.iot.client.AWSIotMessage;
import com.amazonaws.services.iot.client.AWSIotQos;

/**
 * @author InSeok
 * Date : 2019-10-02
 * Remark :
 */
public class MyShadowMessage extends AWSIotMessage {
    public MyShadowMessage(String topic, AWSIotQos qos) {
        super(topic, qos);
    }

    @Override
    public void onSuccess() {
        super.onSuccess();
    }
}
