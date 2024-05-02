package palaczjustyna.EmailSander.email.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import palaczjustyna.EmailSander.email.domain.Email;

@Repository
public interface EmailRepository extends MongoRepository<Email, String> {

}
