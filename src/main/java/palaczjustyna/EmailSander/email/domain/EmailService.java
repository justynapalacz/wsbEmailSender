package palaczjustyna.EmailSander.email.domain;

import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import palaczjustyna.EmailSander.email.repository.EmailRepository;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class EmailService {
    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Value("${email.max.retry}")
    private Integer maxRetry;

    public String createEmail(Email email) {
        email.setStatus(EmailStatus.TO_SEND);
        emailRepository.save(email);
        return "Email created sucessfuly";
    }

    public List<Email> getAllEmails() {
        return emailRepository.findAll();
    }

    // Cron expression for running every minute
    @Scheduled(cron = "0 * * * * *")
    public void sendEmail() {
        sendEmailsToUser(emailRepository.findByStatus(EmailStatus.TO_SEND));
    }

    // Cron expression for running every minute
    @Scheduled(cron = "0 * * * * *")
    public void reSendEmail() {
        sendEmailsToUser(emailRepository.findByStatus(EmailStatus.TO_RETRY));
    }

    private void sendEmailsToUser(List<Email> emailsToSend) {
        emailsToSend.forEach(email -> {
            log.info("Email to send: {}", email);

            try {
                sendNewMail(email.getTo(), email.getFrom(), email.getSubject(), email.getBody());
                email.setStatus(EmailStatus.SENT);
                email.setLastAttempt(LocalDateTime.now());
                email.setSentDate(LocalDateTime.now());
                emailRepository.save(email);
                log.info("Email to sent: {}", email);
            } catch (Exception e) {
                log.error("Problem with sending email. Email: {}, error {}", email, e.getMessage());
                email.setRetry(email.getRetry() == null ? 1 : email.getRetry() + 1);
                email.setError(e.getMessage());
                email.setLastAttempt(LocalDateTime.now());

                if (email.getRetry() < maxRetry) {
                    email.setStatus(EmailStatus.TO_RETRY);
                } else {
                    email.setStatus(EmailStatus.ERROR);
                }

                emailRepository.save(email);
            }
        });
    }

    public void sendNewMail(String to, String from, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }
}
