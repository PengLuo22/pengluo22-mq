package io.pengluo22.mq;

/**
 * 应用内消息
 *
 * @author PengLuo22
 * @date 2023/11/2
 * @since 0.0.1
 */
public class ApplicationMessage extends AbstractMessage<Object> {

    private Object message;


    @Override
    protected Object getMessage() {
        return message;
    }
}
