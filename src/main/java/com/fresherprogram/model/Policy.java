package com.fresherprogram.model;

import java.math.BigDecimal;
import java.util.Date;

import net.bytebuddy.utility.RandomString;

public class Policy {
	private int id;
	private String policyNo;
	private Date inceptionDate;
	private Date expiryDate;
	private Date renewDate;
	private Client policyOwner;
	private BigDecimal sumInsured;
	private float rate;
	private Status statusPolicy;
	private BigDecimal annualPremium;
	private BigDecimal postedPremium;
	private Status billingCurrency;
	private Motor vehicleRegistrationNo;
	
	public Policy() {
		super();
		this.policyNo = RandomString.make(8);
		this.inceptionDate = null;
		this.expiryDate = null;
		this.renewDate = null;
		this.policyOwner = null;
		this.sumInsured = new BigDecimal(0);
		this.rate = 0;
		this.statusPolicy = null;
		this.annualPremium = new BigDecimal(0);
		this.postedPremium = new BigDecimal(0);
		this.billingCurrency = null;
		this.vehicleRegistrationNo = null;
	}
	
	public Policy( Date inceptionDate, Date expiryDate, Date renewDate, Client policyOwner,
			BigDecimal sumInsured, float rate, Status statusPolicy, BigDecimal annualPremium, BigDecimal postedPremium,
			Status billingCurrency, Motor vehicleRegistrationNo) {
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
		this.vehicleRegistrationNo = vehicleRegistrationNo;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((annualPremium == null) ? 0 : annualPremium.hashCode());
		result = prime * result + ((billingCurrency == null) ? 0 : billingCurrency.hashCode());
		result = prime * result + ((expiryDate == null) ? 0 : expiryDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((inceptionDate == null) ? 0 : inceptionDate.hashCode());
		result = prime * result + ((policyNo == null) ? 0 : policyNo.hashCode());
		result = prime * result + ((policyOwner == null) ? 0 : policyOwner.hashCode());
		result = prime * result + ((postedPremium == null) ? 0 : postedPremium.hashCode());
		result = prime * result + Float.floatToIntBits(rate);
		result = prime * result + ((renewDate == null) ? 0 : renewDate.hashCode());
		result = prime * result + ((statusPolicy == null) ? 0 : statusPolicy.hashCode());
		result = prime * result + ((sumInsured == null) ? 0 : sumInsured.hashCode());
		result = prime * result + ((vehicleRegistrationNo == null) ? 0 : vehicleRegistrationNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Policy other = (Policy) obj;
		if (annualPremium == null) {
			if (other.annualPremium != null)
				return false;
		} else if (!annualPremium.equals(other.annualPremium))
			return false;
		if (billingCurrency == null) {
			if (other.billingCurrency != null)
				return false;
		} else if (!billingCurrency.equals(other.billingCurrency))
			return false;
		if (expiryDate == null) {
			if (other.expiryDate != null)
				return false;
		} else if (!expiryDate.equals(other.expiryDate))
			return false;
		if (id != other.id)
			return false;
		if (inceptionDate == null) {
			if (other.inceptionDate != null)
				return false;
		} else if (!inceptionDate.equals(other.inceptionDate))
			return false;
		if (policyNo == null) {
			if (other.policyNo != null)
				return false;
		} else if (!policyNo.equals(other.policyNo))
			return false;
		if (policyOwner == null) {
			if (other.policyOwner != null)
				return false;
		} else if (!policyOwner.equals(other.policyOwner))
			return false;
		if (postedPremium == null) {
			if (other.postedPremium != null)
				return false;
		} else if (!postedPremium.equals(other.postedPremium))
			return false;
		if (Float.floatToIntBits(rate) != Float.floatToIntBits(other.rate))
			return false;
		if (renewDate == null) {
			if (other.renewDate != null)
				return false;
		} else if (!renewDate.equals(other.renewDate))
			return false;
		if (statusPolicy == null) {
			if (other.statusPolicy != null)
				return false;
		} else if (!statusPolicy.equals(other.statusPolicy))
			return false;
		if (sumInsured == null) {
			if (other.sumInsured != null)
				return false;
		} else if (!sumInsured.equals(other.sumInsured))
			return false;
		if (vehicleRegistrationNo == null) {
			if (other.vehicleRegistrationNo != null)
				return false;
		} else if (!vehicleRegistrationNo.equals(other.vehicleRegistrationNo))
			return false;
		return true;
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
	public BigDecimal getSumInsured() {
		return sumInsured;
	}
	public void setSumInsured(BigDecimal sumInsured) {
		this.sumInsured = sumInsured;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public Status getStatusPolicy() {
		return statusPolicy;
	}
	public void setStatusPolicy(Status statusPolicy) {
		this.statusPolicy = statusPolicy;
	}
	public BigDecimal getAnnualPremium() {
		return annualPremium;
	}
	public void setAnnualPremium(BigDecimal annualPremium) {
		this.annualPremium = annualPremium;
	}
	public BigDecimal getPostedPremium() {
		return postedPremium;
	}
	public void setPostedPremium(BigDecimal postedPremium) {
		this.postedPremium = postedPremium;
	}
	public Status getBillingCurrency() {
		return billingCurrency;
	}
	public void setBillingCurrency(Status billingCurrency) {
		this.billingCurrency = billingCurrency;
	}
	public Motor getVehicleRegistrationNo() {
		return vehicleRegistrationNo;
	}
	public void setVehicleRegistrationNo(Motor vehicleRegistrationNo) {
		this.vehicleRegistrationNo = vehicleRegistrationNo;
	}
	
	
}
