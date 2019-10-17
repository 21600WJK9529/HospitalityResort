package Resort.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class HospitalityResortSecurity extends WebSecurityConfigurerAdapter {
//    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//    String userName=auth.getPrincipal().toString();
//    String userRole=auth.getAuthorities().toString();
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password(encoder().encode("password")).roles("USER")
                .and()
                .withUser("admin").password(encoder().encode("password")).roles("USER", "ADMIN");

    }

    // Secure the endpoints with HTTP Basic authentication

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                //HTTP Basic authentication
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/login").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/HospitalityResort/**/create/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/HospitalityResort/**/read/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/HospitalityResort/**/update/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/HospitalityResort/**/delete/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .formLogin().defaultSuccessUrl("http://localhost/practice/PHP")
                .and()
                .logout().permitAll()
                .invalidateHttpSession(true).permitAll()
                .logoutSuccessUrl("/login")
        ;
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

}
