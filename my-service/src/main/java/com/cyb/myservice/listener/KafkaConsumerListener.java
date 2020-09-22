package com.cyb.myservice.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

//@Component
public class KafkaConsumerListener  {
    @KafkaListener(topics = "${kafka.topic}")
    public void onMessage(String message){
        System.out.println("kafka receive mes:"+message);
    }
}
