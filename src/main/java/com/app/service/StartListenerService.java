package com.app.service;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

/**
 * Created by mosl on 16/9/7.
 */
@Service
public class StartListenerService implements ApplicationListener<ContextRefreshedEvent> {


    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("=======>started");
    }


}
