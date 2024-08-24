package com.asusoftware.notification_api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "recipient_id", nullable = false)
    private UUID recipientId; // ID-ul utilizatorului sau locului care primește notificarea

    @Column(name = "sender_id")
    private UUID senderId; // ID-ul utilizatorului sau locului care trimite notificarea (poate fi null)

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private NotificationType type; // Tipul notificării (ex: FOLLOW, OFFER, ANNOUNCEMENT, etc.)

    @Column(name = "message", nullable = false)
    private String message; // Mesajul notificării

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt; // Momentul în care a fost creată notificarea

    @Column(name = "is_read", nullable = false)
    private boolean isRead = false; // Indicator dacă notificarea a fost citită sau nu

    @Column(name = "related_post_id")
    private UUID relatedPostId; // ID-ul postării legate de notificare (dacă este cazul)

    @Column(name = "related_place_id")
    private UUID relatedPlaceId; // ID-ul locului legat de notificare (dacă este cazul)

}

