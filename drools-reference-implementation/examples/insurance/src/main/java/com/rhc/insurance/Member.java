package com.rhc.insurance;

public class Member {

	// all *Rating variables measured on 0.0-10.0 scale
	// in all cases, 0.0 is most healthy, 10.0 is least healthy
	// physical health factors
	public float asthmaRating;
	public float diabetesRating;
	public float cardiovascularRating;
	// behavioral health factors
	public float depressionRating;
	public float anxietyRating;
	public float eatingDisorderRating;
	// PH and BH values
	public float physicalHealth;
	public float behavioralHealth;

	public Member() {
		physicalHealth = 0;
		behavioralHealth = 0;
	}

	public float getAsthmaRating() {
		return asthmaRating;
	}

	public void setAsthmaRating(float asthmaRating) {
		this.asthmaRating = asthmaRating;
	}

	public float getDiabetesRating() {
		return diabetesRating;
	}

	public void setDiabetesRating(float diabetesRating) {
		this.diabetesRating = diabetesRating;
	}

	public float getCardiovascularRating() {
		return cardiovascularRating;
	}

	public void setCardiovascularRating(float cardiovascularRating) {
		this.cardiovascularRating = cardiovascularRating;
	}

	public float getDepressionRating() {
		return depressionRating;
	}

	public void setDepressionRating(float depressionRating) {
		this.depressionRating = depressionRating;
	}

	public float getAnxietyRating() {
		return anxietyRating;
	}

	public void setAnxietyRating(float anxietyRating) {
		this.anxietyRating = anxietyRating;
	}

	public float getEatingDisorderRating() {
		return eatingDisorderRating;
	}

	public void setEatingDisorderRating(float eatingDisorderRating) {
		this.eatingDisorderRating = eatingDisorderRating;
	}

	public float getPhysicalHealth() {
		return physicalHealth;
	}

	public void setPhysicalHealth(float physicalHealth) {
		this.physicalHealth = physicalHealth;
	}

	public float getBehavioralHealth() {
		return behavioralHealth;
	}

	public void setBehavioralHealth(float behavioralHealth) {
		this.behavioralHealth = behavioralHealth;
	}

}
