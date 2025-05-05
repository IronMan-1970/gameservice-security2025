package havryliuk.sequrity2025.gameservice.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.security.auth.Subject;
import java.security.Principal;
import java.util.Collection;
import java.util.List;

/*
  @author   umaks
  @project   gameservice-security2025
  @class  User
  @version 1.0.0
  @since 03.05.2025 - 17:44
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class User  implements UserDetails, Principal {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean accountLocked;
    private boolean enabled;
    private List<Role> roles;

    @Override
    public String getName() {
        return this.email;
    }

    @Override
    public boolean implies(Subject subject) {
        return Principal.super.implies(subject);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles
                .stream()
                .map( role -> new SimpleGrantedAuthority(role.name()))
                .toList()
                ;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !accountLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public Object getFullName() {
        return firstName + " " + lastName;
    }
}
