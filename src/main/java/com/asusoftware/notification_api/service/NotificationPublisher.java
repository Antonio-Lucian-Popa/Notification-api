package com.asusoftware.notification_api.service;

import com.asusoftware.notification_api.model.Notification;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NotificationPublisher {

    private final AmqpTemplate amqpTemplate;

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.routingkey}")
    private String routingKey;

    public NotificationPublisher(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void sendNotification(Notification notification) {
        amqpTemplate.convertAndSend(exchange, routingKey, notification);
    }
}