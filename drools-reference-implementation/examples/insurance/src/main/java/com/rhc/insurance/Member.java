package com.rhc.insurance;

import java.math.BigDecimal;
import java.util.Map;
import java.util.HashMap;

public class Member {

	// all *Rating variables measured on 0.0-10.0 scale
	// in all cases, 0.0 is most healthy, 10.0 is least healthy
	// physical health factors
	public BigDecimal asthmaRating;
	public BigDecimal diabetesRating;
	public BigDecimal cardiovascularRating;
	// behavioral health factors
	public BigDecimal depressionRating;
	public BigDecimal anxietyRating;
	public BigDecimal eatingDisorderRating;
	
	public String asthmaDegree;
	public String diabetesDegree;
	public String cardiovascularDegree;
	// behavioral health factors
	public String depressionDegree;
	public String anxietyDegree;
	public String eatingDisorderDegree;
	
	HashMap<String, String> conditions;
	
	// PH and BH values
	public BigDecimal physicalHealth;
	public BigDecimal behavioralHealth;
	
	public Policy policy;
	public int quadrant;
	

	public int memberID;
	
	public Member()
	{
		conditions = new HashMap<String, String>();
		
		physicalHealth = new BigDecimal(0);
		behavioralHealth = new BigDecimal(0);
	}
	
	public int getQuadrant() {
		return quadrant;
	}

	public String getAsthmaDegree() {
		return asthmaDegree;
	}

	public void setAsthmaDegree(String asthmaDegree) {
		this.asthmaDegree = asthmaDegree;
	}

	public String getDiabetesDegree() {
		return diabetesDegree;
	}

	public void setDiabetesDegree(String diabetesDegree) {
		this.diabetesDegree = diabetesDegree;
	}

	public String getCardiovascularDegree() {
		return cardiovascularDegree;
	}

	public void setCardiovascularDegree(String cardiovascularDegree) {
		this.cardiovascularDegree = cardiovascularDegree;
	}

	public String getDepressionDegree() {
		return depressionDegree;
	}

	public void setDepressionDegree(String depressionDegree) {
		this.depressionDegree = depressionDegree;
	}

	public String getAnxietyDegree() {
		return anxietyDegree;
	}

	public void setAnxietyDegree(String anxietyDegree) {
		this.anxietyDegree = anxietyDegree;
	}

	public String getEatingDisorderDegree() {
		return eatingDisorderDegree;
	}

	public void setEatingDisorderDegree(String eatingDisorderDegree) {
		this.eatingDisorderDegree = eatingDisorderDegree;
	}

	public void setQuadrant(int quadrant) {
		this.quadrant = quadrant;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public BigDecimal getAsthmaRating() {
		return asthmaRating;
	}

	public int getMemberID() {
		return memberID;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}

	public void setAsthmaRating(BigDecimal asthmaRating) {
		this.asthmaRating = asthmaRating;
	}

	public BigDecimal getDiabetesRating() {
		return diabetesRating;
	}

	public void setDiabetesRating(BigDecimal diabetesRating) {
		this.diabetesRating = diabetesRating;
	}

	public BigDecimal getCardiovascularRating() {
		return cardiovascularRating;
	}

	public void setCardiovascularRating(BigDecimal cardiovascularRating) {
		this.cardiovascularRating = cardiovascularRating;
	}

	public BigDecimal getDepressionRating() {
		return depressionRating;
	}

	public void setDepressionRating(BigDecimal depressionRating) {
		this.depressionRating = depressionRating;
	}

	public BigDecimal getAnxietyRating() {
		return anxietyRating;
	}

	public void setAnxietyRating(BigDecimal anxietyRating) {
		this.anxietyRating = anxietyRating;
	}

	public BigDecimal getEatingDisorderRating() {
		return eatingDisorderRating;
	}

	public void setEatingDisorderRating(BigDecimal eatingDisorderRating) {
		this.eatingDisorderRating = eatingDisorderRating;
	}

	public BigDecimal getPhysicalHealth() {
		return physicalHealth;
	}

	public void setPhysicalHealth(BigDecimal physicalHealth) {
		this.physicalHealth = physicalHealth;
	}

	public BigDecimal getBehavioralHealth() {
		return behavioralHealth;
	}

	public void setBehavioralHealth(BigDecimal behavioralHealth) {
		this.behavioralHealth = behavioralHealth;
	}

	public void print()
	{
		System.out.println("member, with id="+memberID+" quadrant: "+quadrant+" diabetesRating:"+diabetesRating+"  depressionRating:"+depressionRating);
	}
	
}
