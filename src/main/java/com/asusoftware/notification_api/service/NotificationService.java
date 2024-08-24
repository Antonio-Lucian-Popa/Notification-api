package com.asusoftware.notification_api.service;

import com.asusoftware.notification_api.model.Notification;
import com.asusoftware.notification_api.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.UUID;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public Notification createNotification(Notification notification) {
        notification.setCreatedAt(LocalDateTime.now(ZoneOffset.UTC));
        return notificationRepository.save(notification);
    }

    public List<Notification> getNotificationsForUser(UUID userId) {
        return notificationRepository.findByRecipientId(userId);
    }

    public List<Notification> getNotificationsForPlace(UUID placeId) {
        return notificationRepository.findByRelatedPlaceId(placeId);
    }

    public void markNotificationAsRead(UUID notificationId) {
        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new RuntimeException("Notification not found"));
        notification.setRead(true);
        notificationRepository.save(notification);
    }
}
