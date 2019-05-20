package Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.reactive.CorsConfigurationSource;


@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    private final SecurityServicesConfiguration securityServicesConfiguration;
    private final CorsConfigurationSource corsConfigurationSource;
    private final AuthNFilter authNFilter;

    @Autowired
    public SecurityConfiguration(final SecurityServicesConfiguration securityServicesConfiguration,
                                 final CorsConfigurationSource corsConfigurationSource,
                                 final AuthNFilter authNFilter) {
        super();
        this.securityServicesConfiguration = securityServicesConfiguration;
        this.corsConfigurationSource = corsConfigurationSource;
        this.authNFilter=authNFilter;
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .httpBasic()
                .disable()
                .headers()
                .cacheControl().disable()
                .and()
                .cors()
                .configurationSource(corsConfigurationSource); // so it doesn't mess with the ShallowEtagHeaderFilter filter
        if (!securityServicesConfiguration.getEnabled()) {
            http.authorizeRequests().anyRequest().permitAll();
            return;
        }
        http.antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/login/**").permitAll()
                .antMatchers("/swagger-ui.html/**", "/v2/**", "/swagger-resources/**").permitAll()
                .antMatchers("/webjars/springfox-swagger-ui/**").permitAll()
                .antMatchers("/version").permitAll()
                .antMatchers("/health").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(authNFilter, UsernamePasswordAuthenticationFilter.class);
    }
}


