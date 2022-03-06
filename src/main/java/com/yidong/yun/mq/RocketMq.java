package com.yidong.yun.mq;

import org.apache.rocketmq.client.consumer.DefaultLitePullConsumer;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListener;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.common.protocol.body.ClusterInfo;
import org.apache.rocketmq.common.protocol.body.TopicList;
import org.apache.rocketmq.common.protocol.route.BrokerData;
import org.apache.rocketmq.tools.admin.DefaultMQAdminExt;
import org.junit.jupiter.api.Test;

import java.util.*;

public class RocketMq {



    @Test
    public void producer()throws Exception{

        DefaultMQProducer producer
                = new DefaultMQProducer("ooxx");

        producer.setNamesrvAddr("192.168.248.130:9876");
        producer.start();

        Message message = new Message();
        message.setTopic("wula");
        message.setTags("TagA");
        message.setBody("wula".getBytes());
        message.setWaitStoreMsgOK(true);

        SendResult send = producer.send(message);
        System.out.println(send);

        producer.send(message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println(sendResult);
            }
            @Override
            public void onException(Throwable throwable) {
            }
        });

        SendResult send1 = producer.send(message, new MessageQueue("wula", "rocket01", 0));
        System.out.println(send1);
    }

    @Test
    public void consumerPull()throws Exception{

        DefaultLitePullConsumer consumer = new DefaultLitePullConsumer("consumer_mq");
        consumer.setNamesrvAddr("192.168.248.130:9876");

        Collection<MessageQueue> mqs = consumer.fetchMessageQueues("wula");

        mqs.forEach(messageQueue -> System.out.println(messageQueue));

        System.out.println("-----------------");

        ArrayList<MessageQueue> objects = new ArrayList<>();

        MessageQueue messageQueue = new MessageQueue("wula", "brocket01", 0);
        objects.add(messageQueue);

        consumer.assign(objects);

        List<MessageExt> poll = consumer.poll();

        poll.forEach(s -> System.out.println(s));


    }

    @Test
    public void consumerPush()throws Exception{

        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumer_push");
        consumer.setNamesrvAddr("192.168.248.130:9876");
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

        consumer.subscribe("wula","*");

        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        } );


        consumer.start();

    }

    @Test
    public void admin()throws Exception{

        DefaultMQAdminExt admin = new DefaultMQAdminExt();
        admin.setNamesrvAddr("192.168.248.130:9876");
        admin.start();

        /**
         * BrokerData
         */
        ClusterInfo clusterInfo = admin.examineBrokerClusterInfo();
        HashMap<String, BrokerData> brokerAddrTable = clusterInfo.getBrokerAddrTable();

        Set<Map.Entry<String, BrokerData>> entries = brokerAddrTable.entrySet();
        Iterator<Map.Entry<String, BrokerData>> iterator = entries.iterator();

        if (iterator.hasNext()){
            Map.Entry<String, BrokerData> next = iterator.next();
            System.out.println(next);
        }

        /**
         * Topic
         */

        TopicList wula = admin.fetchTopicsByCLuster("wula");


    }

    @Test
    public void clusterPushMessage()throws Exception{

        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer();
        consumer.setNamesrvAddr("192.168.248.130:9876");

        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.setConsumeThreadMax(1);
        consumer.subscribe("wula","*");

        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {

                MessageExt messageExt = list.get(0);
                System.out.println(messageExt.getBody());
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });


        consumer.start();

    }


}
