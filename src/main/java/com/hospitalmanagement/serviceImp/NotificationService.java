package com.hospitalmanagement.serviceImp;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.hospitalmangement.bean.PushNotification;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;

import io.jsonwebtoken.io.IOException;

@Service
public class NotificationService {
	    @Value("${app.firebase-configuration-file}")
        private String firebaseConfig;
        
        @PostConstruct
        public void initialize() throws java.io.IOException {
            try {
                FirebaseOptions options = new FirebaseOptions.Builder()
                        .setCredentials(GoogleCredentials.fromStream(new ClassPathResource(firebaseConfig).getInputStream())).build();
                if (FirebaseApp.getApps().isEmpty()) {
                    FirebaseApp.initializeApp(options);
                   
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        
        public String sendPnsToTopic(PushNotification notificationRequestDto) {
            @SuppressWarnings("deprecation")
			Message message = Message.builder()
                    .setTopic(notificationRequestDto.getTarget())
                    
                   .setNotification(new Notification(notificationRequestDto.getTitle(), notificationRequestDto.getBody()))
                    
                    .putData("content", notificationRequestDto.getTitle()) .putData("body", notificationRequestDto.getBody())
                    .build();
            String response = null;
            try {
                response = FirebaseMessaging.getInstance().send(message);
                System.out.println(response);
                System.out.println("msg is send");
            } catch (FirebaseMessagingException e) {
                System.out.println("Fail to send firebase notification"+e);
            }
            return response;
        }
}
