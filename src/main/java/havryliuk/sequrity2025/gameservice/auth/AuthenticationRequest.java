package havryliuk.sequrity2025.gameservice.auth;

import lombok.Data;
import lombok.NonNull;

/*
  @author   umaks
  @project   gameservice-security2025
  @class  AuthenticationRequest
  @version 1.0.0
  @since 03.05.2025 - 17:10
*/
@Data
public class AuthenticationRequest {
    @NonNull
    private String  email;
    @NonNull
    private String password;
}
