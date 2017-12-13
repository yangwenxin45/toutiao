package com.nowcoder.async.handler;

import com.nowcoder.async.EventHandler;
import com.nowcoder.async.EventModel;
import com.nowcoder.async.EventType;
import com.nowcoder.model.Message;
import com.nowcoder.model.User;
import com.nowcoder.service.MessageService;
import com.nowcoder.service.UserService;
import com.nowcoder.util.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by 杨文鑫 on 2017/12/2.
 */
@Component
public class LoginExceptionHandler implements EventHandler{
    @Autowired
    MessageService messageService;
    @Autowired
    UserService userService;
    @Autowired
    MailSender mailSender;

    public void doHandle(EventModel model) {
        //判断是否有异常登录
        Message message = new Message();
        User user = userService.getUser(model.getActorId());
        message.setToId(model.getActorId());
        message.setContent("你上次的登陆ip异常");
        message.setFromId(2);
        message.setCreatedDate(new Date());
        message.setConversationId("2_"+user.getId());
        //发送站内信
        //messageService.addMessage(message);

        Map<String,Object> map  = new HashMap<String,Object>();
        map.put("username",model.getExt("username"));
        //发送邮件
        //mailSender.sendWithHTMLTemplate(model.getExt("email"),"登陆异常","mails/welcome.html",map);
    }

    @Override
    public List<EventType> getSupportEventTypes() {
        return Arrays.asList(EventType.LOGIN);
    }
}
