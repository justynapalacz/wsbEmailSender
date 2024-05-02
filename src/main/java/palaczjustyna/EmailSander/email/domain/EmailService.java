package palaczjustyna.EmailSander.email.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import palaczjustyna.EmailSander.email.repository.EmailRepository;

import java.util.List;

@Slf4j
@Service
public class EmailService {
    @Autowired
    private EmailRepository emailRepository;

    public String createEmail( Email email){
        emailRepository.save(email);
        return "Email created sucessfuly";
    }

    public List<Email> getAllEmails() {
        return emailRepository.findAll();
    }
}
