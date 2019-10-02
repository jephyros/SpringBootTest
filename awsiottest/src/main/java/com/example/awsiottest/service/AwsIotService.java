package com.example.awsiottest.service;

import com.amazonaws.services.iot.client.AWSIotDevice;
import com.amazonaws.services.iot.client.AWSIotMqttClient;
import com.amazonaws.services.iot.client.AWSIotQos;
import org.springframework.stereotype.Service;

/**
 * @author InSeok
 * Date : 2019-09-30
 * Remark :
 */
@Service
public class AwsIotService {

    private String clientEndpoint = "XXXXXX.iot.ap-XXXXXX-2.amazonaws.com";       // replace <prefix> and <region> with your own
    private String clientId = "springthing"; // 고유이름 아무거나?

    //AWSIotMqttClient iam 에서 AWSIoTDataAccess 권한을주면됨
    private AWSIotMqttClient client = new AWSIotMqttClient(clientEndpoint, clientId, "XXXXX", "XXXXXX");

    public AwsIotService() {
        try {
            this.client.connect();
            System.out.println("Connect in  constructor.");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void mqtttest() {

        try{


            String topic = "/mqttTest/outTopic";
            String payload = "Send mqtt from SpringBoot!";


            client.publish(topic, AWSIotQos.QOS1, payload);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void mqttsubscribe() {

        try{
            String topicName = "/mqttTest/outTopic";
            //String topicName = "/mqttTest/#";
            AWSIotQos qos = AWSIotQos.QOS0;

            MyTopic myTopic = new MyTopic(topicName, qos);

            client.subscribe(myTopic,2000);

            System.out.println("Starting subscribe : "+ topicName);
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public void mqttsubscribe2() {

        try{

            String topicName = "/mqttTest/#";
            AWSIotQos qos = AWSIotQos.QOS0;

            MyTopic myTopic = new MyTopic(topicName, qos);
            client.subscribe(myTopic);
            System.out.println("Starting subscribe : "+ topicName);
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public void mqttnonBlock() throws Exception{


        String topic = "/mqttTest/outTopic";
        AWSIotQos qos = AWSIotQos.QOS0;
        String payload = " Non-block send payload";
        long timeout = 3000;

        MyMessage message = new MyMessage(topic,qos,payload);
        client.publish(message,timeout);

    }

    public void shadowtest() throws Exception{



        AWSIotMqttClient shadowClient = new AWSIotMqttClient(clientEndpoint, clientId, "XXXX", "XXXXXX");
        String thingName = "mqttTest2";                    // replace with your AWS IoT Thing name
        AWSIotDevice device = new AWSIotDevice(thingName);

        shadowClient.attach(device);
        shadowClient.connect();
        System.out.println("Shadow connect");

        // Delete existing shadow document
        //device.delete();

        // Update shadow document
        String state = "{\"state\":{\"desired\":{\"sensor\":3.2}}}";

        device.update(state);
        System.out.println("shadowupdate");

        // Get the entire shadow document
        String returnstate = device.get();
        System.out.println("sadowDoc : "+returnstate);

        shadowClient.disconnect();



    }
}
