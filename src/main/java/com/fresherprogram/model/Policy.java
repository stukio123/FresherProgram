package com.fresherprogram.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import net.bytebuddy.utility.RandomString;

@Entity
@Table(name="Policy")
public class Policy {
	
	@Id
	@Column(name="Id")
	private int id;
	
	@Column(name="policyNo")
	private String policyNo;
	
	@Column(name="inceptionDate")
	private Date inceptionDate;
	
	@Column(name="expiryDate")
	private Date expiryDate;
	
	@Column(name="renewDate")
	private Date renewDate;
	
	@Column(name="policyOwner")
	private Client policyOwner;
	
	@Column(name="sumInsured")
	private double sumInsured;
	
	@Column(name="rate")
	private float rate;
	
	@Column(name="statusPolicy")
	private String statusPolicy;
	
	@Column(name="annualPremium")
	private double annualPremium;
	
	@Column(name="postedPremium")
	private double postedPremium;
	
	@Column(name="billingCurrency")
	private String billingCurrency;
	
	@Column(name="vehicleRegistrationNo")
	private Motor motor;
	
	@Column(name="engineNo")
	private String engineNo;
	
	@Column(name="chassisNo")
	private String chassisNo;
	
	
	public Policy() {
		super();
		this.policyNo = RandomString.make(8);
		this.inceptionDate = null;
		this.expiryDate = null;
		this.renewDate = null;
		this.policyOwner = null;
		this.sumInsured = 0;
		this.rate = 0;
		this.statusPolicy = "";
		this.annualPremium = 0;
		this.postedPremium = 0;
		this.billingCurrency = "";
		this.motor = null;
		this.engineNo = "";
		this.chassisNo = "";
	}
	
	

	@Override
	public String toString() {
		return "Policy [id=" + id + ", policyNo=" + policyNo + ", inceptionDate=" + inceptionDate + ", expiryDate="
				+ expiryDate + ", renewDate=" + renewDate + ", policyOwner=" + policyOwner + ", sumInsured="
				+ sumInsured + ", rate=" + rate + ", statusPolicy=" + statusPolicy + ", annualPremium=" + annualPremium
				+ ", postedPremium=" + postedPremium + ", billingCurrency=" + billingCurrency + ", motor=" + motor
				+ ", engineNo=" + engineNo + ", chassisNo=" + chassisNo + "]";
	}



	public Policy(String policyNo, Date inceptionDate, Date expiryDate, Date renewDate, Client policyOwner,
			double sumInsured, float rate, String statusPolicy, double annualPremium, double postedPremium,
			String billingCurrency, Motor motor, String engineNo, String chassisNo) {
		super();
		this.policyNo = RandomString.make(8);
		this.inceptionDate = inceptionDate;
		this.expiryDate = expiryDate;
		this.renewDate = renewDate;
		this.policyOwner = policyOwner;
		this.sumInsured = sumInsured;
		this.rate = rate;
		this.statusPolicy = statusPolicy;
		this.annualPremium = annualPremium;
		this.postedPremium = postedPremium;
		this.billingCurrency = billingCurrency;
		this.motor = motor;
		this.engineNo = engineNo;
		this.chassisNo = chassisNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public Date getInceptionDate() {
		return inceptionDate;
	}

	public void setInceptionDate(Date inceptionDate) {
		this.inceptionDate = inceptionDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Date getRenewDate() {
		return renewDate;
	}

	public void setRenewDate(Date renewDate) {
		this.renewDate = renewDate;
	}

	public Client getPolicyOwner() {
		return policyOwner;
	}

	public void setPolicyOwner(Client policyOwner) {
		this.policyOwner = policyOwner;
	}

	public double getSumInsured() {
		return sumInsured;
	}

	public void setSumInsured(double sumInsured) {
		this.sumInsured = sumInsured;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public String getStatusPolicy() {
		return statusPolicy;
	}

	public void setStatusPolicy(String statusPolicy) {
		this.statusPolicy = statusPolicy;
	}

	public double getAnnualPremium() {
		return annualPremium;
	}

	public void setAnnualPremium(double annualPremium) {
		this.annualPremium = annualPremium;
	}

	public double getPostedPremium() {
		return postedPremium;
	}

	public void setPostedPremium(double postedPremium) {
		this.postedPremium = postedPremium;
	}

	public String getBillingCurrency() {
		return billingCurrency;
	}

	public void setBillingCurrency(String billingCurrency) {
		this.billingCurrency = billingCurrency;
	}

	public Motor getMotor() {
		return motor;
	}

	public void setMotor(Motor motor) {
		this.motor = motor;
	}

	public String getEngineNo() {
		return engineNo;
	}

	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}

	public String getChassisNo() {
		return chassisNo;
	}

	public void setChassisNo(String chassisNo) {
		this.chassisNo = chassisNo;
	}
	
	
}
