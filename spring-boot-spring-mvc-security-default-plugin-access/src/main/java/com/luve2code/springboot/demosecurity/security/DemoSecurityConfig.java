package com.luve2code.springboot.demosecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {


    //updating the new JdbcUserDetailsManager(dataSource) to use it as a local variable  --> refactor
    //to use members and roles tables
    //refactor and introduce variable -> jdbcUserDetailsManager

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){


        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        //define query to retrieve a user by username - find users

        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from members where user_id=?" //this is regular sql
        );

        //define query to retrieve the authorities/roles by username - find roles using username with ?

        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from roles where user_id=?"
        );


        return jdbcUserDetailsManager; //reads info from Database users (members) and authorities (roles)
    }




    /*

    //no more hard coded stuff -- JDBC datasource injectiion - Reading Table Schema
    // to use users and authorites tables

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){

        return new JdbcUserDetailsManager(dataSource); //reads info from Database users and authorities (roles)
    }

*/

    /*
    //create noop encodedpassword --> plain text

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        //create 3 users
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();


        //return new instanz and pass the user details
        return new InMemoryUserDetailsManager(john,mary,susan);
    }


*/






    //custom login without restriction

    /*
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(configurer ->
                configurer
                        .anyRequest().authenticated() //must login
                )
                .formLogin(form ->
                        form
                                .loginPage("/showMyLoginPage") //coded
                                .loginProcessingUrl("/authenticateTheUser") //no code mapping, ist free
                                .permitAll()

                )
                .logout(logout -> logout.permitAll() //add logut button to home.html
                );
        return http.build();
    }
*/
    //add logout support -- its emplicit


    /*
    //add roles restriction

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers("/").hasRole("EMPLOYEE")
                                .requestMatchers("/leaders/**").hasRole("MANAGER") //** all subdirectories recursively
                                .requestMatchers("/systems/**").hasRole("ADMIN")
                                .anyRequest().authenticated() //must login
                )
                .formLogin(form ->
                        form
                                .loginPage("/showMyLoginPage") //coded
                                .loginProcessingUrl("/authenticateTheUser") //no code mapping, ist free
                                .permitAll()

                )
                .logout(logout -> logout.permitAll() //add logut button to home.html
                );
        return http.build();
    }

    */

    //plus access denied

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers("/").hasRole("EMPLOYEE")
                                .requestMatchers("/leaders/**").hasRole("MANAGER") //** all subdirectories recursively
                                .requestMatchers("/systems/**").hasRole("ADMIN")
                                .anyRequest().authenticated() //must login
                )


                .formLogin(form ->
                        form
                                .loginPage("/showMyLoginPage") //coded
                                .loginProcessingUrl("/authenticateTheUser") //no code mapping, ist free
                                .permitAll()

                )


                .logout(logout -> logout.permitAll() //add logut button to home.html
                )


                .exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/access-denied") //request mapping path
                );
        return http.build();
    }





}
