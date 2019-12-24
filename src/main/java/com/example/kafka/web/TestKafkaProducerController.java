package com.example.kafka.web;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ly
 * @date 2019/12/24
 */
@RestController
public class TestKafkaProducerController {

    @Resource
    private KafkaTemplate<String,String> kafkaTemplate;

    @GetMapping("send")
    public String send(String msg){
        //.\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test_topic
        kafkaTemplate.send("test_topic",msg);
        return "success";
    }
}
