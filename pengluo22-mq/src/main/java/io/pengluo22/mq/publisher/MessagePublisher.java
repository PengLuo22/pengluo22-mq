package io.pengluo22.mq.publisher;

import io.pengluo22.mq.exception.MessagePublishException;

/**
 * @author PengLuo22
 * @date 2023/11/2
 * @since 0.0.1
 */
public interface MessagePublisher {
    /**
     * 发布消息
     *
     * @param exchange 交换机
     * @param key      事件key
     * @param message  消息内容
     * @throws MessagePublishException
     */
    void publish(String exchange, String key, Object message) throws MessagePublishException;


}
