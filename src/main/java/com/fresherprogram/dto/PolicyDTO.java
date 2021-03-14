package com.fresherprogram.dto;

public class PolicyDTO {
	private String policyNo;
	private String renewalDate;
	private String expiryDate;
	private String engineNo;
	private String policyOwner;
	private String chassisNo;
	private String vehicleRegistrationNo;
	private String billingCurrency;
	private String sumInsured;
	private String rate;
	private String annualPremium;
	private String postedPremium;
	
	public PolicyDTO() {
		super();
	}
	public PolicyDTO(String policyNo, String renewalDate, String expiryDate, String engineNo, String policyOwner,
			String chassisNo, String vehicleRegistrationNo, String billingCurrency, String sumInsured, String rate,
			String annualPremium, String postedPremium) {
		super();
		this.policyNo = policyNo;
		this.renewalDate = renewalDate;
		this.expiryDate = expiryDate;
		this.engineNo = engineNo;
		this.policyOwner = policyOwner;
		this.chassisNo = chassisNo;
		this.vehicleRegistrationNo = vehicleRegistrationNo;
		this.billingCurrency = billingCurrency;
		this.sumInsured = sumInsured;
		this.rate = rate;
		this.annualPremium = annualPremium;
		this.postedPremium = postedPremium;
	}
	
	
	@Override
	public String toString() {
		return "PolicyDTO [policyNo=" + policyNo + ", renewalDate=" + renewalDate + ", expiryDate=" + expiryDate
				+ ", engineNo=" + engineNo + ", policyOwner=" + policyOwner + ", chassisNo=" + chassisNo
				+ ", vehicleRegistrationNo=" + vehicleRegistrationNo + ", billingCurrency=" + billingCurrency
				+ ", sumInsured=" + sumInsured + ", rate=" + rate + ", annualPremium=" + annualPremium
				+ ", postedPremium=" + postedPremium + "]";
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getRenewalDate() {
		return renewalDate;
	}
	public void setRenewalDate(String renewalDate) {
		this.renewalDate = renewalDate;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getEngineNo() {
		return engineNo;
	}
	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}
	public String getPolicyOwner() {
		return policyOwner;
	}
	public void setPolicyOwner(String policyOwner) {
		this.policyOwner = policyOwner;
	}
	public String getChassisNo() {
		return chassisNo;
	}
	public void setChassisNo(String chassisNo) {
		this.chassisNo = chassisNo;
	}
	public String getVehicleRegistrationNo() {
		return vehicleRegistrationNo;
	}
	public void setVehicleRegistrationNo(String vehicleRegistrationNo) {
		this.vehicleRegistrationNo = vehicleRegistrationNo;
	}
	public String getBillingCurrency() {
		return billingCurrency;
	}
	public void setBillingCurrency(String billingCurrency) {
		this.billingCurrency = billingCurrency;
	}
	public String getSumInsured() {
		return sumInsured;
	}
	public void setSumInsured(String sumInsured) {
		this.sumInsured = sumInsured;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getAnnualPremium() {
		return annualPremium;
	}
	public void setAnnualPremium(String annualPremium) {
		this.annualPremium = annualPremium;
	}
	public String getPostedPremium() {
		return postedPremium;
	}
	public void setPostedPremium(String postedPremium) {
		this.postedPremium = postedPremium;
	}
	
	
}
