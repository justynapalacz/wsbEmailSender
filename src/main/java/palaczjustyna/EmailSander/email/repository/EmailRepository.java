package palaczjustyna.EmailSander.email.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import palaczjustyna.EmailSander.email.domain.Email;
import palaczjustyna.EmailSander.email.domain.EmailStatus;

import java.util.List;

@Repository
public interface EmailRepository extends MongoRepository<Email, String> {

    List<Email> findByStatus(EmailStatus status);

}
