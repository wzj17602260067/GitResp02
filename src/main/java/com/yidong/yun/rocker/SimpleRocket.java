package com.yidong.yun.rocker;


import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.common.protocol.body.ConsumerConnection;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SimpleRocket {

    @Test
    public void producer()throws Exception{

        DefaultMQProducer producer = new DefaultMQProducer("ooxx");

        producer.setNamesrvAddr("192.168.248.130:9876");

        producer.start();

        for (int i=0;i<10;i++){

            Message message = new Message();
            message.setTopic("wula");
            message.setTags("TagA");
            message.setBody(("ooxx"+i).getBytes());
            message.setWaitStoreMsgOK(true);

            // 阻塞
            SendResult send = producer.send(message);
            System.out.println(send);

            System.out.println("------------------");
//
//            //非阻塞
//            producer.send(message, new SendCallback() {
//                @Override
//                public void onSuccess(SendResult sendResult) {
//                    System.out.println(sendResult);
//                }
//                @Override
//                public void onException(Throwable throwable) {
//                }
//            });
//
//            producer.sendOneway(message);


//            MessageQueue mq = new MessageQueue("wula","node01",0);
//
//            SendResult sendQ = producer.send(message, mq);
//
//            System.out.println(sendQ);

        }




    }

    @Test
    public void consumerPush(){


        ArrayList<Object> objects = new ArrayList<>();


        for (int i=0;i<10;i++){
              objects.add(i);
        }

        objects.forEach(s -> System.out.println(s));




    }


    @Test
    public void consumerPull() throws MQClientException {

        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("ooxx");
        consumer.setNamesrvAddr("192.168.248.130:9876");
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.subscribe("wula","*");
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {


                System.out.println(list);


                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });






    }

    @Test
    public void consumerPoll(){


        System.out.println(" consumer %n");

    }









}
