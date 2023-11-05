package io.pengluo22.mq.example.simple.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.util.concurrent.TimeUnit;

/**
 * 发送异步消息
 *
 * @author PengLuo22
 * @date 2023/11/5
 * @since 0.0.1
 */
public class AsyncProducer {
    public static final String TOPIC = "simple-mq";

    public static void main(String[] args) throws Exception {
        //1.创建消息生产者producer，并制定生产者组名
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        //2.指定Nameserver地址
        producer.setNamesrvAddr("172.21.240.1:9876");
        //3.启动producer
        producer.start();

        for (int i = 0; i < 5; i++) {
            //4.创建消息对象，指定主题Topic、Tag和消息体
            /**
             * 参数一：消息主题Topic
             * 参数二：消息Tag
             * 参数三：消息内容
             */
            Message msg = new Message(TOPIC, "ASYNC", ("Hello World 异步消息" + i).getBytes());
            //5.发送消息
            producer.send(msg, new SendCallback() {
                /**
                 * 发送成功回调函数
                 * @param sendResult
                 */
                public void onSuccess(SendResult sendResult) {
                    System.out.println("发送结果：" + sendResult);
                }

                /**
                 * 发送失败回调函数
                 * @param e
                 */
                public void onException(Throwable e) {
                    System.out.println("发送异常：" + e);
                }
            });

            //线程睡1秒
            TimeUnit.SECONDS.sleep(1);
        }

        //6.关闭生产者producer
        producer.shutdown();
    }
}
