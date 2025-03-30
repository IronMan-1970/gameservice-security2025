package havryliuk.sequrity2025.gameservice.game;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.bson.Document;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/*
  @author   antihetman
  @project   gameservice
  @class  GameService
  @version  1.0.0
  @since 27.03.25 - 18.57
*/

@Service
public class GameService {
    @Autowired
    private MongoConverter mongoConverter;
    @Autowired
    GameRepository gameRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Game> getAll(){
        return gameRepository.findAll();
    }
    public Game get(String id){
        return gameRepository.findById(id).orElse(null);
    }

    public Game create(Game game) {
        return gameRepository.save(game);
    }

    public void deleteOne(String id) {
        gameRepository.deleteById(id);
    }

    public void updateGame(Game game, String id) {
        game.setId(id);
        gameRepository.save(game);
    }

}
