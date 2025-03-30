package havryliuk.sequrity2025.gameservice.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import java.util.List;

/*
  @author   antihetman
  @project   gameservice
  @class  CameController
  @version  1.0.0
  @since 27.03.25 - 18.57
*/

@RestController
@RequestMapping("/api/v1/games/")
public class CameController {
    @Autowired
    GameService gameService;


    @RequestMapping()
    private List<Game> showAll() {
        return gameService.getAll();
    }

    @RequestMapping("{id}")
    private Game showOne(@PathVariable String id) {
        return gameService.get(id);
    }


    @DeleteMapping("{id}")
    private void deleteOne(@PathVariable String id) {
        gameService.deleteOne(id);
    }

    @PostMapping()
    Game create(@RequestBody Game game) {
        return gameService.create(game);
    }

    @PutMapping("{id}")
    private void updateOne(@RequestBody Game game, @PathVariable String id) {
        gameService.updateGame(game, id);

    }

    @GetMapping("/hello/user")
    public String helloUser() {
        return "Hello User!";
    }

    @GetMapping("hello/admin")
    public String helloAdmin() {
        return "Hello Admin!";
    }

    @GetMapping("hello/unknown")
    public String helloUnknown() {
        return "Hello Unknown!";
    }

}
