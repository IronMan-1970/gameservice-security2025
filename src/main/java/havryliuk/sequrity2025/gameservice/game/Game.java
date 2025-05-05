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
public class Game extends AuditMetaDate {
    @Id
    private String id;
    private String name;
    private String description;
    private int sells;

}
