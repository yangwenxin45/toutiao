package com.nowcoder.async;

import com.alibaba.fastjson.JSONObject;
import com.nowcoder.util.JedisAdapter;
import com.nowcoder.util.RedisKeyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 杨文鑫 on 2017/12/2.
 */
@Service
public class EventProducer {
    private static final Logger logger  = LoggerFactory.getLogger(EventProducer.class);
    @Autowired
    JedisAdapter jedisAdapter;

    /**
     * 把事件放到队列里面
     * @param model
     * @return
     */
    public boolean fireEvent(EventModel model){
        try{
            String json = JSONObject.toJSONString(model);
            String key = RedisKeyUtil.getEventQueueKey();
            jedisAdapter.lpush(key,json);
            return true;
        }catch (Exception e){
            logger.error("fireEvent发生异常"+e.getMessage());
            return false;
        }

    }
}
