package com.example.awsiottest.service;

import com.amazonaws.services.iot.client.AWSIotDevice;
import com.amazonaws.services.iot.client.AWSIotDeviceProperty;

/**
 * @author InSeok
 * Date : 2019-10-01
 * Remark :
 */
public class MyDevice extends AWSIotDevice {
    public MyDevice(String thingName) {
        super(thingName);
    }
    @AWSIotDeviceProperty
    private String someValue;


    @Override
    public void onShadowUpdate(String jsonState) {
        //super.onShadowUpdate(jsonState);
        //To-do code
        System.out.println("onShadowUpdate Event : " + jsonState.toString());

    }
}
