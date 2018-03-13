package com.xiao.web.async;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

/**
 * 〈异步线程〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/3 12:57
 * @since 1.0.0
 */
@RestController
public class AsyncController {

    private Logger logger = LoggerFactory.getLogger(AsyncController.class);

    @Autowired
    private MockQueue queue;

    @Autowired
    private DeferfedResultHolder deferfedResultHolder;

    @GetMapping("/order")
    public Callable<String> order() throws Exception {
        logger.info("主线程开始");

        Callable<String> result = new Callable<String>() {
            @Override
            public String call() throws Exception {
                logger.info("副线程开始");
                Thread.sleep(1000);
                logger.info("副线程结束");
                return "success";
            }
        };

        logger.info("主线程结束");
        return result;
    }

    @GetMapping("/getOder")
    public DeferredResult<String> getOder() throws Exception {
        logger.info("主线程开始");

        // 生成订单号
        String orderNumber = RandomStringUtils.randomNumeric(8);
        // 放入消息队列
        queue.setPlaceOrder(orderNumber);

        DeferredResult<String> result = new DeferredResult<>();
        deferfedResultHolder.getMap().put(orderNumber,result);
        logger.info("主线程结束");
        return result;
    }
}
