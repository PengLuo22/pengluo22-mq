package io.pengluo22.mq;

import java.io.Serializable;

/**
 * 顶级的消息定义
 *
 * @author PengLuo22
 * @date 2023/11/2
 * @since 0.0.1
 */
public abstract class AbstractMessage<M> implements Serializable {
    /**
     * 交换机
     */
    private String exchange;

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    /**
     * 获取消息
     *
     * @return 消息
     */
    protected abstract M getMessage();
}
