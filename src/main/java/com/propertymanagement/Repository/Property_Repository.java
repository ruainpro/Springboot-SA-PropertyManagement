package com.propertymanagement.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.propertymanagement.Entity.Property;


@Repository
public interface Property_Repository extends CrudRepository<Property, Integer>{

	List<Property> findAllByUsername(String localName);

	List<Property> findByUsername(String localName);
	
	@Transactional
	@Modifying
	@Query("update Property u set u.propertyTypes = :propertyTypes, u.propertyName = :propertyName , u.propertyDescription = :propertyDescription, u.conddtionText = :conddtionText, u.totalCost = :totalCost, u.monthlyCost = :monthlyCost , u.extraAmount = :extraAmount where u.id = :id")
	void updateTheProperty(@Param(value = "propertyTypes") String propertyTypes, @Param(value = "propertyName") String propertyName, @Param(value = "propertyDescription")  String propertyDescription, @Param(value = "conddtionText") String conddtionText,
			@Param(value = "totalCost") int totalCost,@Param(value = "monthlyCost") int monthlyCost,@Param(value = "extraAmount") int extraAmount,@Param(value = "id") int id);

	
//	 @Query("Select u from Property where u.propertyTypes like %?1% or u.propertyName like %?2% ")
	    @Query("SELECT p FROM Property p WHERE p.propertyTypes LIKE %:propertyTypes% or p.propertyName LIKE %:propertyName% or p.propertyDescription LIKE %:propertyDescription% or p.conddtionText LIKE %:conddtionText%")
     List<Property> searchWithJPQLQuery(@Param("propertyTypes")   String propertyTypes,@Param("propertyName")   String propertyName ,@Param("propertyDescription")   String propertyDescription ,@Param("conddtionText")   String conddtionText);
}
