package havryliuk.sequrity2025.gameservice.game;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/*
  @author   antihetman
  @project   gameservice
  @class  GameRepository
  @version  1.0.0
  @since 27.03.25 - 18.57
*/

@Repository
public interface GameRepository extends MongoRepository<Game, String> {
}
