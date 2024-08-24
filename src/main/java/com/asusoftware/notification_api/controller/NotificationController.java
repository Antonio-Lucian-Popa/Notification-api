package com.asusoftware.notification_api.controller;

import com.asusoftware.notification_api.model.Notification;
import com.asusoftware.notification_api.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    // Endpoint pentru a crea o notificare nouă
    @PostMapping
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {
        Notification createdNotification = notificationService.createNotification(notification);
        return ResponseEntity.ok(createdNotification);
    }

    // Endpoint pentru a obține toate notificările pentru un utilizator specificat
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Notification>> getNotificationsForUser(@PathVariable UUID userId) {
        List<Notification> notifications = notificationService.getNotificationsForUser(userId);
        return ResponseEntity.ok(notifications);
    }

    // Endpoint pentru a obține toate notificările pentru un loc (Place) specificat
    @GetMapping("/place/{placeId}")
    public ResponseEntity<List<Notification>> getNotificationsForPlace(@PathVariable UUID placeId) {
        List<Notification> notifications = notificationService.getNotificationsForPlace(placeId);
        return ResponseEntity.ok(notifications);
    }
}
