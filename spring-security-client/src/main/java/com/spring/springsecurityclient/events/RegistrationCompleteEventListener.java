package com.spring.springsecurityclient.events;

import com.spring.springsecurityclient.entity.User;
import com.spring.springsecurityclient.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {
    @Autowired
    private UserService userService;
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationToken(user,token);
        String url = event.getApplicationUrl()+"/verifyRegistration?token="+token;
        log.info("Click the link to verify account: {}",url);
    }
}
