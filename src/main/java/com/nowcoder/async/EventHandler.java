package com.nowcoder.async;

import java.util.List;

/**
 * Created by 杨文鑫 on 2017/12/2.
 */
public interface EventHandler {
    void doHandle(EventModel model);
    List<EventType> getSupportEventTypes();
}
