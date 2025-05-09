package havryliuk.sequrity2025.gameservice.game;

import lombok.*;
import org.springframework.data.annotation.Id;

/*
  @author   antihetman
  @project   gameservice
  @class  Game
  @version  1.0.0
  @since 27.03.25 - 18.57
*/

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
@Setter
public class Game {

    @Id
    String id;
    String name;
    String description;
    int sells;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Game(String name, String description, int sells) {
        this.name = name;
        this.description = description;
        this.sells = sells;
    }
}
