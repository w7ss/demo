package com.cyb.myconsumer.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Source.class)
public class MessageProducer {
    @Autowired
    @Qualifier(Source.OUTPUT)
    private MessageChannel messageChannel;

    public void sendMessage(String message){
        boolean res=messageChannel.send(MessageBuilder.withPayload(message).build());
        System.out.println(res);
    }
}
