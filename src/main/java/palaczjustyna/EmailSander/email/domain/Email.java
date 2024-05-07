package palaczjustyna.EmailSander.email.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document("emails")
public class Email {

    @Id
    public String id;
    public String to;
    public String from;
    public String body;
    public String subject;
    public EmailStatus status;
    public LocalDateTime sentDate;
    public LocalDateTime lastAttempt;
    public Integer retry;
    public String error;

}
