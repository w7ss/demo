package com.cyb.myservice.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink.class)
public class MessageConsumer {
    @Autowired
    @Qualifier(Sink.INPUT)
    private MessageChannel messageChannel;

    @StreamListener(Sink.INPUT)
    public void onMessage(String message){
        System.out.println(message);
    }
}
