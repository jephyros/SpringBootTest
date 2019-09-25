package kr.co.broadwave.dynamodbtest.controller;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.document.internal.InternalUtils;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * @author InSeok
 * Date : 2019-09-24
 * Remark :
 */
@Controller
public class Maincontroller {
    @Autowired
    AmazonDynamoDB amazonDynamoDB;

    @RequestMapping("/")
    public String index(){

        ScanRequest scanRequest = new ScanRequest()
                .withTableName("USERS");

        ScanResult scan = amazonDynamoDB.scan(scanRequest);

        for(Map<String, AttributeValue> item: scan.getItems()){
            System.out.println(item.toString());
            AttributeValue username = item.get("username");
            System.out.println( "USER name : " + username.toString());
            //InternalUtils.toAttributeValues;

        }


        return "index";
    }
}
