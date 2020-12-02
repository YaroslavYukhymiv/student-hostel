package ua.yaroslav.student.hostel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ua.yaroslav.student.hostel.dao.services.UserService;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        // @formatter:off
        auth.authenticationProvider(userService);

//        auth.inMemoryAuthentication()
//                .withUser("entrant").password(passwordEncoder().encode("entrantPass")).roles("ENTRANT")
//                .and()
//                .withUser("student").password(passwordEncoder().encode("studentPass")).roles("STUDENT")
//                .and()
//                .withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN");
//        // @formatter:on
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // @formatter:off
        http
//                .csrf()
//                    .disable()
                .authorizeRequests()
                    .antMatchers("/registration").not().fullyAuthenticated()
                    .antMatchers( "/hostels").hasAnyRole("USER", "ADMIN", "SUPERADMIN", "PASSWORD")
                    .antMatchers( "/students").hasAnyRole("ADMIN", "SUPERADMIN", "PASSWORD")
//                    .antMatchers(http.).hasRole("PASSWORD")
                    .antMatchers("/login*").permitAll()
                .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
//                  .loginProcessingUrl("/perform_login")
                    .defaultSuccessUrl("/hostels", true);
                  //.failureUrl("/login.html?error=true")

        //.and()
        //.exceptionHandling().accessDeniedPage("/accessDenied");
        //.exceptionHandling().accessDeniedHandler(accessDeniedHandler());
        // @formatter:on
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
