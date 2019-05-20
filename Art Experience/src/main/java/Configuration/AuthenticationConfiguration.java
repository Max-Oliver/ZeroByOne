package Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthenticationConfiguration {

    private final SecurityServicesConfiguration securityConfig;
    private final AccountClientService accountClient;
    private final CookieClientService cookieClient;
    private final TokenClientService tokenClientService;

    @Autowired
    public AuthenticationConfiguration(final SecurityServicesConfiguration securityConfig, final AccountClientService accountClient, final CookieClientService cookieClient,final TokenClientService tokenClient) {
        this.securityConfig = securityConfig;
        this.accountClient = accountClient;
        this.cookieClient = cookieClient;
        this.tokenClientService=tokenClient;
    }

    @Bean
    public AuthenticationService getAuthenticationService(){
        return new AuthenticationService(accountClient,cookieClient,securityConfig.getSessionCookieList());
    }

    @Bean
    public TokenAuthenticationService getTokenAuthenticationService(){
        return new TokenAuthenticationService(tokenClientService);
    }
}
