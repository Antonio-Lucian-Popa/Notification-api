package com.asusoftware.notification_api.service;

import com.asusoftware.notification_api.model.Notification;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class NotificationListener {

    private final SimpMessagingTemplate messagingTemplate;

    public NotificationListener(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void receiveNotification(Notification notification) {
        log.info("Received notification: {}", notification);
        // Trimitere notificare către WebSocket topic-ul corespunzător
        messagingTemplate.convertAndSend("/topic/notifications/" + notification.getRecipientId(), notification);
    }
}
