package havryliuk.sequrity2025.gameservice.auth;

/*
  @author   umaks
  @project   gameservice-security2025
  @class  AuthenticationController
  @version 1.0.0
  @since 03.05.2025 - 17:17
*/

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth/v1/")
public class AuthenticationController {

    private  final AuthenticationService authenticationService;


    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse>
        authenticate(@RequestBody AuthenticationRequest request) {
        AuthenticationResponse response = authenticationService.authenticate(request);
        return  ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
