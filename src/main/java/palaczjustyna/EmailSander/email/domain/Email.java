package palaczjustyna.EmailSander.email.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("emails")
public class Email {

    @Id
    public String id;
    public String to;
    public String from;
    public String body;
    public String subject;
}
