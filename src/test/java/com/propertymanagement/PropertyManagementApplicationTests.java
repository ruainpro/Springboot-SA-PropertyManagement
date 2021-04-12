package com.propertymanagement;



import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.propertymanagement.Repository.Property_Repository;
import com.propertymanagement.Repository.UserRepository;
import com.propertymanagement.Services.PropertyServices;
import com.propertymanagement.Services.UserService;


@SpringBootTest
class PropertyManagementApplicationTests {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private UserService userService ;
	
	
	@Autowired
	private PropertyServices propertyServices ;

	@Autowired
	private Property_Repository property_Repository ;
	
	@Test
	void contextLoads() {
	}
	
	
	@Test
	public void testTheLogins() {
		
		String returnString=userService.signin("user", "user");
		
	
		
		assertTrue(!returnString.isEmpty());
		
	}
	
	@Test
	public void testTheSearchMethod() {
				
		Assert.notNull(propertyServices.searchPropoerty("11"));
		
	}
	
	@Test
	public void  testThePropertyById() {
		
		Assert.notNull(property_Repository.findById(2));
	}

}
