package com.propertymanagement.Services;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.propertymanagement.Entity.Property;
import com.propertymanagement.Repository.Property_Repository;

@Service
public class PropertyServices {

	@Autowired
	private Property_Repository property_Repository;
	
	
	public void updateTheProperty(Property property) {
		
		
		property_Repository.updateTheProperty(property.getPropertyTypes(), property.getPropertyName(), property.getPropertyDescription(),
				property.getConddtionText(), property.getTotalCost(), property.getMonthlyCost(), property.getExtraAmount(), property.getId());
	}

//	
	public List<Property> searchPropoerty(String Stringtext){
		
	return 	property_Repository.searchWithJPQLQuery(Stringtext, Stringtext, Stringtext, Stringtext);
//		return 	property_Repository.searchWithJPQLQuery(Stringtext);
		
//		return null;

		
	}

//	@Override
//	public Predicate toPredicate(Root<Property> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	
}
