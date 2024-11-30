package com.spammers.AlertsAndNotifications.service.interfaces;

import com.spammers.AlertsAndNotifications.exceptions.SpammersPrivateExceptions;
import com.spammers.AlertsAndNotifications.exceptions.SpammersPublicExceptions;
import com.spammers.AlertsAndNotifications.model.*;
import java.time.LocalDate;
import java.util.List;

public interface NotificationService {
    void notifyLoan(LoanDTO loanDTO);
    void closeLoan(String bookId, String userId)throws SpammersPublicExceptions, SpammersPrivateExceptions ;
    List<FineModel> getFines(String userId);
    List<NotificationDTO> getNotifications(String userId);
    void returnBook(String bookId, boolean returnedInBadCondition);
    void openFine(FineDTO fineDTO);
    void closeFine(String loanId);
    List<FineModel> returnAllActiveFines(int pageSize, int pageNumber);
    List<FineModel> returnAllActiveFinesBetweenDate(LocalDate date, int pageSize, int pageNumber);
}
