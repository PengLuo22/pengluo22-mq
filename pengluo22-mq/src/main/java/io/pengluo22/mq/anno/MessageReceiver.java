package io.pengluo22.mq.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author PengLuo22
 * @date 2023/11/2
 * @since 0.0.1
 */
@Documented
@Retention(RUNTIME)
@Target(METHOD)
public @interface MessageReceiver {
    /**
     * 交换机
     *
     * @return 交换机
     */
    String exchange();

    /**
     * key
     *
     * @return 交换机
     */
    String key();
}
