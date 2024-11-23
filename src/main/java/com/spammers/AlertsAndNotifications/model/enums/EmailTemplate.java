package com.spammers.AlertsAndNotifications.model.enums;

import lombok.Getter;

@Getter
public enum EmailTemplate {
    /**
     * This Notification Alert Template Gets 1 argument and refers to the notification type might be loan return, or loan created.
     */
    NOTIFICATION_ALERT(
            "Nueva Notificación - BibloSoft.",
            """
            Hola!,
                    
            Tienes una nueva notificación:
            %s
                    
            Para más detalles, ingresa a tu cuenta.
                    
            Saludos,
            El equipo de BibloSoft.
            
            Este es un mensaje automático. No responder a este mensaje.
            """
    ),

    /**
     * This Fine alert template receives 3 args, according to the amount, date and description of the fine.
     */
    FINE_ALERT(
            "Alerta de Multa - BibloSoft.",
            """
            Hola!,
                    
            Se ha registrado una nueva multa:
            Monto: %s
            Fecha: %s
            Descripción: %s
                    
            Por favor, revisa los detalles en tu cuenta.
                    
            Atentamente,
            El equipo de BibloSoft.
            
            Este es un mensaje automático. No responder a este mensaje.
            """
    );

    private final String subject;
    private final String template;

    EmailTemplate(String subject, String template) {
        this.subject = subject;
        this.template = template;
    }

    public String formatBody(Object... args) {
        return String.format(template, args);
    }
}