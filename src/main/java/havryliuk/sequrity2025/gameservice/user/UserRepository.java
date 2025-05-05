package havryliuk.sequrity2025.gameservice.user;

import java.util.Optional;

/*
  @author   umaks
  @project   gameservice-security2025
  @class  UserRepository
  @version 1.0.0
  @since 05.05.2025 - 13:49
*/
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);

    @Override
    <S extends User> S save(S entity);
}
