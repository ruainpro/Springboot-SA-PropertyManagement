package com.propertymanagement.Entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Property {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column()
	private int userId;
	
	@Column()
	private String username;
	
	@Column()
	private String propertyTypes;
	
	@Column()
	private String propertyName;
	
	@Column()
	private String propertyDescription;
	
	@Column()
	private String conddtionText;
	
	@Column()
	private int  totalCost;
	
	@Column()
	private int monthlyCost;
	
	@Column()
	private int extraAmount;
	
	@Column()
	private boolean propertyStatus;

	private Date postedDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPropertyTypes() {
		return propertyTypes;
	}

	public void setPropertyTypes(String propertyTypes) {
		this.propertyTypes = propertyTypes;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertyDescription() {
		return propertyDescription;
	}

	public void setPropertyDescription(String propertyDescription) {
		this.propertyDescription = propertyDescription;
	}

	public String getConddtionText() {
		return conddtionText;
	}

	public void setConddtionText(String conddtionText) {
		this.conddtionText = conddtionText;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	public int getMonthlyCost() {
		return monthlyCost;
	}

	public void setMonthlyCost(int monthlyCost) {
		this.monthlyCost = monthlyCost;
	}

	public int getExtraAmount() {
		return extraAmount;
	}

	public void setExtraAmount(int extraAmount) {
		this.extraAmount = extraAmount;
	}

	public boolean isPropertyStatus() {
		return propertyStatus;
	}

	@Override
	public String toString() {
		return "Property [id=" + id + ", userId=" + userId + ", username=" + username + ", propertyTypes="
				+ propertyTypes + ", propertyName=" + propertyName + ", propertyDescription=" + propertyDescription
				+ ", conddtionText=" + conddtionText + ", totalCost=" + totalCost + ", monthlyCost=" + monthlyCost
				+ ", extraAmount=" + extraAmount + ", propertyStatus=" + propertyStatus + ", postedDate=" + postedDate
				+ "]";
	}

	public void setPropertyStatus(boolean propertyStatus) {
		this.propertyStatus = propertyStatus;
	}

	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}
	
	
	
	
	
	
	

}
