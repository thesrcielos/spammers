package com.spammers.AlertsAndNotifications.controller;


import com.spammers.AlertsAndNotifications.exceptions.SpammersPrivateExceptions;
import com.spammers.AlertsAndNotifications.model.*;
import com.spammers.AlertsAndNotifications.model.dto.LoanDTO;
import com.spammers.AlertsAndNotifications.service.interfaces.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notifications")
public class SpammersController {


    private final NotificationService notificationService;

    /**
     * This method returns the notifications of a given user
     * @param userId The user id
     * @return the notifications associated to the user.
     */
    @GetMapping("/users/{userId}/notifications")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> getNotifications(@RequestParam String userId, @RequestParam int page, @RequestParam int size) {
        return notificationService.getNotifications(userId, page, size);
    }

    /**
     * This method returns the fines of a given user.
     * @param userId The user id
     * @return the fines of the user.
     */
    @GetMapping("/users/{userId}/fines")
    @ResponseStatus(HttpStatus.OK)
    public List<FineModel> getFines(@PathVariable String userId){
        return notificationService.getFines(userId);
    }

    /**
     * This method sends a notification of a loan created.
     * @param loanDTO the information required to send the notification:
     *                (userId, bookId, email of the Parent, book name and the
     *                return date)
     * @return A message of successfully sent notification.
     */
    @PostMapping("/notify-create-loan")
    @ResponseStatus(HttpStatus.OK)
    public String notifyLoan(@RequestBody LoanDTO loanDTO){
        notificationService.notifyLoan(loanDTO);
        return "Notification Sent!";
    }

    /**
     * This method handles the creation of a return notification.
     * It sends a notification to the parent of the student when a book is returned,
     * indicating whether the book was returned in good or bad condition.
     *
     * @param bookId the ID of the book being returned.
     * @param returnedInBadCondition a flag indicating whether the book was returned in bad condition.
     * @return A message confirming that the book return notification was sent.
     * @throws SpammersPrivateExceptions if the loan record is not found for the given bookId.
     */
    @PostMapping("/notify-return-loan")
    @ResponseStatus(HttpStatus.OK)
    public String returnBook(@RequestParam String bookId, @RequestParam boolean returnedInBadCondition) {
        notificationService.returnBook(bookId, returnedInBadCondition);
        return "Book Returned";
    }

    /**
     * This method handles the creation of a fine for a given user.
     * It creates a fine based on the provided information in the request body.
     *
     * @param fineDTO The data transfer object (DTO) containing the information for the fine (description, amount, expired date, etc.).
     * @param userId The user ID for whom the fine is being created.
     * @return A message indicating that the fine has been successfully created.
     */
    @PostMapping("/users/{userId}/fines/create")
    @ResponseStatus(HttpStatus.OK)
    public String openFine(@RequestBody FineInputDTO fineDTO, @PathVariable String userId) {
        notificationService.openFine(fineDTO);
        return "Fine Created";
    }

    /**
     * This method handles the closing of a fine for a given user.
     * It marks the fine as closed based on the provided fine ID.
     *
     * @param userId The ID of the user whose fine is being closed.
     * @param fineId The ID of the fine that is being closed.
     * @return A message indicating that the fine has been successfully closed.
     */
    @PutMapping("/users/{userId}/fines/{fineId}/close")
    @ResponseStatus(HttpStatus.OK)
    public String closeFine(@PathVariable String userId, @PathVariable String fineId) {
        notificationService.closeFine(fineId);
        return "Fine Closed";
    }


}