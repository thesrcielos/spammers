package com.spammers.AlertsAndNotifications.model;

import com.spammers.AlertsAndNotifications.model.enums.NotificationType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name="Notifications")
@RequiredArgsConstructor
@Getter
public class NotificationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idNotification;

    @Column(name="studentId", nullable = false)
    private String studentId;

    @Column(name="emailGuardian", nullable = false)
    private String emailGuardian;

    @Column(name="sentDate", nullable = true)
    private LocalDate sentDate;
    @Column(name="type", nullable = false)
    private NotificationType notificationType;
    public NotificationModel(String studentId, String emailGuardian, LocalDate sendDate, NotificationType type) {
        this.studentId = studentId;
        this.emailGuardian = emailGuardian;
        this.sentDate = sendDate;
        this.notificationType = type;
    }
}
