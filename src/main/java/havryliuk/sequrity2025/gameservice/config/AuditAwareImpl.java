package havryliuk.sequrity2025.gameservice.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/*
  @author   umaks
  @project   gameservice-security2025
  @class  AuditAwareImpl
  @version 1.0.0
  @since 01.05.2025 - 19:00
*/
public class AuditAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(System.getProperty("user.name"));
    }
}
