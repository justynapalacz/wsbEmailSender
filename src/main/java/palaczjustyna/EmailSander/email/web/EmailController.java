package palaczjustyna.EmailSander.email.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import palaczjustyna.EmailSander.email.application.EmailApplication;
import palaczjustyna.EmailSander.email.domain.Email;

import java.util.List;

@RestController
public class EmailController
{
    @Autowired
    private EmailApplication emailApplication;

    @PostMapping("/createEmail")
    public String createEmail(@RequestBody Email email){
        return emailApplication.createEmail(email);
    }

    @GetMapping("/getAllEmails")
    public List<Email> getAllEmails (){
        return emailApplication.getAllEmails();
    }

}
