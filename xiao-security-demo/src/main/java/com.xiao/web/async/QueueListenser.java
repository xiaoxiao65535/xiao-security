package com.xiao.web.async;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 〈队列监听器〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/3 13:31
 * @since 1.0.0
 */
@Component
public class QueueListenser implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private MockQueue queue;
    @Autowired
    private DeferfedResultHolder deferfedResultHolder;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        new Thread(() -> {

            while (true) {

                if (StringUtils.isNotBlank(queue.getCompleteOrder())) {
                    String order = queue.getCompleteOrder();
                    logger.info("订单返回处理结果：" + order);
                    deferfedResultHolder.getMap().get(order).setResult("place order success");
                    queue.setCompleteOrder(null);
                } else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }

        }).start();

    }
}
