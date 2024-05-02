package palaczjustyna.EmailSander.email.application;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import palaczjustyna.EmailSander.email.domain.Email;
import palaczjustyna.EmailSander.email.domain.EmailService;

import java.util.List;

@Service
public class EmailApplication {

    @Autowired
    private EmailService emailService;

    public String createEmail(Email email){
        return emailService.createEmail(email);
    }

    public List<Email> getAllEmails() {
        return emailService.getAllEmails();
    }
}
