package havryliuk.sequrity2025.gameservice.security;

/*
  @author   umaks
  @project   gameservice-security2025
  @class  UserDetailsServiceImpl
  @version 1.0.0
  @since 05.05.2025 - 02:14
*/

import havryliuk.sequrity2025.gameservice.user.Role;
import havryliuk.sequrity2025.gameservice.user.User;
import havryliuk.sequrity2025.gameservice.user.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository repository;

        private final PasswordEncoder passwordEncoder;

//     @PostConstruct
//      void init() {
//          User user = User.builder()
//                  .firstName("Nolan")
//                  .lastName("Grayson")
//                  .email("omniman@mail.com")
//                  .password(passwordEncoder.encode("password"))
//                  .enabled(true)
//                  .accountLocked(false)
//                  .roles(List.of(Role.USER))
//                  .build();
//         repository.save(user);
//      }
    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        return repository.findByEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
