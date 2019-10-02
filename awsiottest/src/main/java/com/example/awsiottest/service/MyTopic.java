package com.example.awsiottest.service;

import com.amazonaws.services.iot.client.AWSIotMessage;
import com.amazonaws.services.iot.client.AWSIotQos;
import com.amazonaws.services.iot.client.AWSIotTopic;

/**
 * @author InSeok
 * Date : 2019-09-30
 * Remark :
 */
public class MyTopic extends AWSIotTopic {
    public MyTopic(String topic, AWSIotQos qos) {
        super(topic, qos);
    }

    @Override
    public void onMessage(AWSIotMessage message) {

        System.out.println("Subscribe topic :"+ message.getTopic() +"    Message : "+ message.getStringPayload());
    }






}
