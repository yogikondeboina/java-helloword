package com.rhc.insurance;

import java.math.BigDecimal;

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
	// PH and BH values
	public BigDecimal physicalHealth;
	public BigDecimal behavioralHealth;
	
	public int memberID;

	public Member() {
		physicalHealth = new BigDecimal(0);
		behavioralHealth = new BigDecimal(0);
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
		System.out.println("member, with id="+memberID+" diabetesRating:"+diabetesRating+"  depressionRating:"+depressionRating);
	}
	
}
