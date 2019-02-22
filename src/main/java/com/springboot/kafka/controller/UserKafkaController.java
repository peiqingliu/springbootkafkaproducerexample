package com.springboot.kafka.controller;

import com.springboot.kafka.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @author liupeqing
 * @date 2019/2/21 20:40
 */
@RestController
@RequestMapping("/kafka")
public class UserKafkaController {

    //普通strng
    private final static String TOPIC = "Kafka_Example";

    //Javabean
    private final static String TOPIC_BEAN = "Kafka_Example_json";

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    @GetMapping("/publish/message")
    public String sendString(@RequestParam("message") String message){
        for (int i=0;i<10;i++){
            kafkaTemplate.send(TOPIC,message+i);
        }
        return "Published successfully";
    }

    @GetMapping("/publish/{name}")
    public String sendBean(@PathVariable("name") String name){
        User user = new User(name,"Technology",12000L);
        kafkaTemplate.send(TOPIC_BEAN,user);
        return "Published successfully";
    }
}
