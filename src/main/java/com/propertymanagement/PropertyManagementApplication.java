package com.propertymanagement;

import java.util.ArrayList;
import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.propertymanagement.Entity.Role;
import com.propertymanagement.Entity.User;
import com.propertymanagement.Security.JwtTokenProvider;
import com.propertymanagement.Services.UserService;





@SpringBootApplication
public class PropertyManagementApplication {
	
		@Autowired
		 private static UserService userService;
	
	  @Autowired
	  private PasswordEncoder passwordEncoder;

	  @Autowired
	  private JwtTokenProvider jwtTokenProvider;

	  @Autowired
	  private AuthenticationManager authenticationManager;
	  

	public static void main(String[] args) {
		SpringApplication.run(PropertyManagementApplication.class, args);
		
//		User admin = new User();
//	    admin.setUsername("admin");
//	    admin.setPassword("admin");
//	    admin.setEmail("admin@email.com");
//	    admin.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_ADMIN)));
//	    userService.signup(admin);
//
//
//	    User client = new User();
//	    client.setUsername("client");
//	    client.setPassword("client");
//	    client.setEmail("client@email.com");
//	    client.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_CLIENT)));
//
//	    userService.signup(client);
//	    
	}
	
	
	@Bean
	public ModelMapper modelMapper() {
	 return new ModelMapper();
	}


}
