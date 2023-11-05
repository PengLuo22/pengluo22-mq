package io.pengluo22.mq.example.simple.consume;

import io.pengluo22.mq.example.simple.producer.SyncProducer;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

/**
 * 消息消费者
 *
 * @author PengLuo22
 * @date 2023/11/5
 * @since 0.0.1
 */
public class Consumer {

    public static void main(String[] args) throws MQClientException {
        //1.创建消费者Consumer，制定消费者组名
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("group1");
        //2.指定Nameserver地址
        consumer.setNamesrvAddr("172.21.240.1:9876");
        //3.订阅主题Topic和Tag
        consumer.subscribe(SyncProducer.TOPIC, "*");

        //设定消费模式：负载均衡|广播模式
        consumer.setMessageModel(MessageModel.CLUSTERING);

        //4.设置回调函数，处理消息
        consumer.registerMessageListener(new MessageListenerConcurrently() {

            //接受消息内容
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                for (MessageExt msg : msgs) {
                    System.out.println("consumeThread=" + Thread.currentThread().getName() + "," + new String(msg.getBody()));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        //5.启动消费者consumer
        consumer.start();


    }

}
