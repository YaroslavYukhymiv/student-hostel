package ua.yaroslav.student.hostel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ua.yaroslav.student.hostel.services.UserService;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    Logger logger =  LoggerFactory.getLogger(WebSecurityConfig.class);

    @Autowired
    UserService userService;

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        logger.info("User authenficeted");
        auth.userDetailsService(userService);

    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // @formatter:off
        http
//                .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/registration", "/save").permitAll()
                    .antMatchers( "/hostels").hasAnyRole("USER", "ADMIN", "SUPERADMIN", "PASSWORD")
                    .antMatchers( "/students", "/getstudents").hasAnyRole("ADMIN", "SUPERADMIN", "PASSWORD")
//                hasAnyRole("ADMIN", "SUPERADMIN", "PASSWORD")

//                    .antMatchers("/login*").permitAll()

                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                    .formLogin()
                    .loginPage("/login")
//                  .loginProcessingUrl("/perform_login")
                    .defaultSuccessUrl("/hostels")
                .and()
                    .logout().permitAll()
                    .logoutSuccessUrl("/login")
                .and()
                    .exceptionHandling().accessDeniedPage("/403");
                logger.info("Authenfication was called");


        //.and()
        //.exceptionHandling().accessDeniedPage("/accessDenied");
        //.exceptionHandling().accessDeniedHandler(accessDeniedHandler());
        // @formatter:on
    }

//    @Override
//    public void configure(WebSecurity web) {
//        web.ignoring().antMatchers("/images/**");
//    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
