package com.hospitalmanagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospitalmanagement.serviceImp.NotificationService;
import com.hospitalmangement.bean.PushNotification;

@RestController
@RequestMapping("/notification")
public class NotificationController {
        
	   @Autowired
        private NotificationService notificationService;
        
        @PostMapping("/topic")
        public String sendPnsToTopic(@RequestBody PushNotification notificationRequestDto) {
            return notificationService.sendPnsToTopic(notificationRequestDto);
        }
     }