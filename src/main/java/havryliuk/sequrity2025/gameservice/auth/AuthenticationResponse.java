package havryliuk.sequrity2025.gameservice.auth;

/*
  @author   umaks
  @project   gameservice-security2025
  @class  AuthenticationResponse
  @version 1.0.0
  @since 03.05.2025 - 17:12
*/

import lombok.*;

@Builder
@Getter
@Setter
public class AuthenticationResponse {
    private String token;
}
