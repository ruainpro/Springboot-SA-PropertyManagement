package com.propertymanagement.Controller;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.propertymanagement.DTO.UserDataDTO;
import com.propertymanagement.Entity.Property;
import com.propertymanagement.Entity.User;
import com.propertymanagement.Repository.Property_Repository;
import com.propertymanagement.Repository.UserRepository;
import com.propertymanagement.Security.JwtTokenProvider;
import com.propertymanagement.Services.PropertyServices;
import com.sipios.springsearch.anotation.SearchSpec;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/property")
@Api(tags = "property")
public class PropertyController {
	
	
	@Autowired
	private Property_Repository property_Repository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	private PropertyServices propertyServices ;
	
	
	




//	@RequestMapping(value = { "/addProperty" }, method = RequestMethod.POST)
////	@PreAuthorize("hasRole('ROLE_USERS')")
//	public ResponseEntity<String> addCustomer()  {
//	
//		System.out.println("!");
//		System.out.println(req);
//
//		return ResponseEntity.ok("dsfsd");
//		
//
//	}
	



	@PostMapping("/addProperty")
	  @PreAuthorize("hasRole('ROLE_USERS')")
	  @ApiOperation(value = "${UserController.addProperty}")
	  @ApiResponses(value = {//
	      @ApiResponse(code = 400, message = "Something went wrong"), //
	      @ApiResponse(code = 403, message = "Access denied"), //
	      @ApiResponse(code = 422, message = "Username is already in use")})
	  public ResponseEntity<HttpStatus> addProperty(HttpServletRequest req,@RequestBody Property property) {

			if (property !=null) {
				

				System.out.println(req);
				int id=userRepository.findByUsername(req.getUserPrincipal().getName()).getId();
				property.setUserId(id);
				property.setUsername(req.getUserPrincipal().getName());
				
				Calendar calendar = Calendar.getInstance();
			    java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
			    
			    
				property.setPostedDate(ourJavaDateObject);
				property_Repository.save(property);
				
				
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);

		}else {
			
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}

	 }


	
	@RequestMapping(value = { "/getProperty" }, method = RequestMethod.GET)
	  @PreAuthorize("hasRole('ROLE_USERS')")
	  @ApiOperation(value = "${UserController.getProperty}")
	  @ApiResponses(value = {//
	      @ApiResponse(code = 400, message = "Something went wrong"), //
	      @ApiResponse(code = 403, message = "Access denied"), //
	      @ApiResponse(code = 422, message = "Username is already in use")})
	public ResponseEntity<List<Property>> getProperty(HttpServletRequest req )  {
	
		System.out.println(req.getUserPrincipal().getName());

		List<Property> propertyList=property_Repository.findAllByUsername(req.getUserPrincipal().getName());
//	
		if (propertyList !=null) {			
			
			System.out.println(propertyList.toString());
			return ResponseEntity.ok(propertyList);

		}else {
			
			return (ResponseEntity<List<Property>>) ResponseEntity.notFound();
		}
		
	
		

	}
	
	
	@RequestMapping(value = { "/getPropertyById" }, method = RequestMethod.GET)
	  @PreAuthorize("hasRole('ROLE_USERS')")
	  @ApiOperation(value = "${UserController.getPropertyById}")
	  @ApiResponses(value = {//
	      @ApiResponse(code = 400, message = "Something went wrong"), //
	      @ApiResponse(code = 403, message = "Access denied"), //
	      @ApiResponse(code = 422, message = "Username is already in use")})
	public ResponseEntity<Property> getPropertyById(HttpServletRequest req 
			,@RequestParam(name="Id", required = true) int Id)  {
	

		Property property=property_Repository.findById(Id).get();
//	
		if (property !=null) {			
			
			
			return ResponseEntity.ok(property);

		}else {
			
			return (ResponseEntity<Property>) ResponseEntity.noContent();
		}
		
	
		

	}
	
	
	
	@RequestMapping(value = { "/searchProperty" }, method = RequestMethod.GET)
	  @PreAuthorize("hasRole('ROLE_USERS')")
	  @ApiOperation(value = "${UserController.searchProperty}")
	  @ApiResponses(value = {//
	      @ApiResponse(code = 400, message = "Something went wrong"), //
	      @ApiResponse(code = 403, message = "Access denied"), //
	      @ApiResponse(code = 422, message = "Username is already in use")})
	public ResponseEntity<List<Property>> searchProperty(HttpServletRequest req 
			,@RequestParam(name="textSearch", required = true) String textSearch	)  {
	

//	
		if (textSearch.isEmpty()) {			
			
			return (ResponseEntity<List<Property>>) ResponseEntity.noContent();



		}else {
			
			return ResponseEntity.ok(propertyServices.searchPropoerty(textSearch));


		}
		
	
		

	}
	
	
	
	
	@RequestMapping(value = { "/deletePropertyById" }, method = RequestMethod.DELETE)
	  @PreAuthorize("hasRole('ROLE_USERS')")
	  @ApiOperation(value = "${UserController.deletePropertyById}")
	  @ApiResponses(value = {//
	      @ApiResponse(code = 400, message = "Something went wrong"), //
	      @ApiResponse(code = 403, message = "Access denied"), //
	      @ApiResponse(code = 422, message = "Username is already in use")})
	public ResponseEntity<HttpStatus> deletePropertyById(HttpServletRequest req 
			,@RequestParam(name="Id", required = true) int Id)  {

		if (Id >=1) {			
			
			property_Repository.deleteById(Id);

			return new ResponseEntity<HttpStatus>(HttpStatus.OK);

		}else {
			
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}
		
	
		

	}
	
	
	@RequestMapping(value = { "/updatePropertyById" }, method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	  @PreAuthorize("hasRole('ROLE_USERS')")
	  @ApiOperation(value = "${UserController.updatePropertyById}")
	  @ApiResponses(value = {//
	      @ApiResponse(code = 400, message = "Something went wrong"), //
	      @ApiResponse(code = 403, message = "Access denied"), //
	      @ApiResponse(code = 422, message = "Username is already in use")})
	
	public ResponseEntity<HttpStatus> updatePropertyById(HttpServletRequest req 
			,@RequestParam(name="Id", required = true) int Id, @RequestBody Property property)  {

		if (Id >=1 && property !=null) {		
			property.setId(Id);
			propertyServices.updateTheProperty(property);
			
		

			return new ResponseEntity<HttpStatus>(HttpStatus.OK);

		}else {
			
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}
		
	
		

	}
}
