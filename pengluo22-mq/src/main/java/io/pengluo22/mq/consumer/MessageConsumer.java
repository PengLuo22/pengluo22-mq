package io.pengluo22.mq.consumer;

import io.pengluo22.mq.ApplicationMessage;
import io.pengluo22.mq.publisher.MessagePublisher;

/**
 * 消费消息接口
 *
 * @author PengLuo22
 * @date 2023/11/2
 * @see MessagePublisher
 * @since 0.0.1
 */
public interface MessageConsumer {
    /**
     * 消费应用内消息
     *
     * @param message 应用内消息
     */
    void consume(ApplicationMessage message);
}
