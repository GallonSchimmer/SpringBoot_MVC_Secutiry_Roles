package com.luve2code.springboot.demosecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemosecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemosecurityApplication.class, args);
	}

	//use:
		//go to login endpoint
		//write user mary or susan or john plus the password fun123
		//it will send each one to the correspondant department
		//employees, admin or manager depending on the configuration in MySQL


	//plugin access
	//http://localhost:8080/login


	//develop controller

	//it will create a default password and user as usename
	//localhost:8080 redirects to /login to promt username and password

	//will jump to http://localhost:8080/?continue when succesfull logged in

	//user stays logged on, which is not great

	//make small change in home page, and reload. user is still logged
	//because of web broser session, it is linked to an instanz- need to customuize
	//new web browser gives a new session forced to loggin


	//using private window to test login page

	//with @Configuration class the deafault is bypassed


	//now custom security config for login and logout
	//now controller
	//Create view template login ---> plain-login.html

	//test, should redirect to my custom login page

	//break it, bad username and bad password
	//http://localhost:8080/showMyLoginPage?error but no error message

	//need to modify form to display error message

	//add support to error message in plain-login

	//add css to add color to error message

	//bootstrap login page
	//copy paste in templates directory the fancy login

	//paste the namespace
	//login form update

	//update controller to use bootstrap login form
	//test wrong and right user details

	//add logout support, in security config, in home.html and in fancy login html add the div
	//test login, logout
	//redirected to http://localhost:8080/showMyLoginPage?logout and theres a message param.logout

	//user roles in thymeleaf, spring security support
	//spring security uses ROLE_ role underscore prefix


	//create controller code and view pages for restricted roles
	//add link in home.html to /leaders
	//controller code add @RequestMapping for /leaders
	//in leader write a / link to home
	//restrict --> Access based on Roles
	// so /leaders will be accesed only by managers
	// write /systems view and add to controller


	//access denied in SecurityConfig
	//Controller mapping in LoginController


	//security based on Roles, show content based on roles
	// home.html and add security tagas sec authorize has role
	// test


	//JDBC auto spring security configre
	//mysql to pom file and JPA
	//application properties jdbc config
	//DemoSecurity config comment the hard code stuff, datasource injection
	//test
	//change password in database for testing

	//setup bycript sql scripts for mysql
	//for later here is the encrypter : https://www.luv2code.com/generate-bcrypt-password
	//new passwords are fun123 for the bcrypt
	//tests

	//custom tables
	//run scripts in sql
	//update Config to use custom tables
	//use fun123 for john to test, careful with queries and typos






}
