package Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "ArtExperience.security")
public class SecurityServicesConfiguration {

    private String cookieServiceUrl;
    private List<String> cookieServiceCookieList;
    private String accountServiceUrl;
    private List<String> accountServiceCookieList;
    private List<String> sessionCookieList;
    private String tokenServiceUrl;
    private String applicationKey;
    private String applicationSecret;
    private Boolean enabled;
    private RestTemplate restTemplate;

    @Autowired
    public securityServicesConfiguration(final RestTemplate restTemplate){this.restTemplate = restTemplate;}

    @Bean
    public CookieClienService getCookieService(){
        return new CookieClientService(cookieServiceUrl,restTemplate,accountServiceCookieList);
    }

    @Bean
    public TokenClientService getTokenClientService(){
        return new TokenClientService(cookieServiceUrl,restTemplate,accountServiceCookieList, new RestTemplate(), new ObjectMapper());
    }

    @Bean
    public PermissionService getPermissionService(){
        return new PermissionService(enabled);
    }


    @Bean
    public AccountClientService getAccountClientService(){
        return new AccountClientService(accountServiceUrl,restTemplate,accountServiceCookieList);
    }

    public String getCookieServiceUrl(){
        return cookieServiceUrl;
    }

    public void setCookieServiceUrl(String cookieServiceUrl) {
        this.cookieServiceUrl = cookieServiceUrl;
    }

    public List<String> getCookieServiceCookieList() {
        return cookieServiceCookieList;
    }

    public void setCookieServiceCookieList(List<String> cookieServiceCookieList) {
        this.cookieServiceCookieList = cookieServiceCookieList;
    }

    public String getAccountServiceUrl() {
        return accountServiceUrl;
    }

    public void setAccountServiceUrl(String accountServiceUrl) {
        this.accountServiceUrl = accountServiceUrl;
    }

    public List<String> getAccountServiceCookieList() {
        return accountServiceCookieList;
    }

    public void setAccountServiceCookieList(List<String> accountServiceCookieList) {
        this.accountServiceCookieList = accountServiceCookieList;
    }

    public List<String> getSessionCookieList() {
        return sessionCookieList;
    }

    public void setSessionCookieList(List<String> sessionCookieList) {
        this.sessionCookieList = sessionCookieList;
    }

    public String getTokenServiceUrl() {
        return tokenServiceUrl;
    }

    public void setTokenServiceUrl(String tokenServiceUrl) {
        this.tokenServiceUrl = tokenServiceUrl;
    }

    public String getApplicationKey() {
        return applicationKey;
    }

    public void setApplicationKey(String applicationKey) {
        this.applicationKey = applicationKey;
    }

    public String getApplicationSecret() {
        return applicationSecret;
    }

    public void setApplicationSecret(String applicationSecret) {
        this.applicationSecret = applicationSecret;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


}
