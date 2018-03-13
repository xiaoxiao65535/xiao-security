package com.xiao.web.async;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/3 13:18
 * @since 1.0.0
 */
@Component
public class DeferfedResultHolder {

    private Map<String, DeferredResult<String>> map = new HashMap<>();

    public Map<String, DeferredResult<String>> getMap() {
        return map;
    }

    public void setMap(Map<String, DeferredResult<String>> map) {
        this.map = map;
    }
}
