package havryliuk.sequrity2025.gameservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

/*
  @author   umaks
  @project   gameservice-security2025
  @class  AuditConfig
  @version 1.0.0
  @since 01.05.2025 - 19:07
*/
@EnableMongoAuditing
@Configuration
public class AuditConfig {

    @Bean
    public AuditorAware<String> auditorAware() {
        return new AuditAwareImpl();
    }

}
