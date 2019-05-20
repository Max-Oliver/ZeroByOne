package Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthNFilterConfiguration {

    private final AuthenticationService authService;
    private final TokenAuthenticationService tokenAuthenticationService;

    @Autowired
    public AuthNFilterConfiguration(final AuthenticationService authService,final TokenAuthenticationService tokenAuthenticationService) {
        this.authService = authService;
        this.tokenAuthenticationService=tokenAuthenticationService;
    }

    @Bean
    public AuthNFilter getAuthNFilter() {
        return new AuthNFilter(authService,tokenAuthenticationService);
    }
}
