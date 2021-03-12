package com.fresherprogram.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Motor")
public class Motor {
	@Id
	@Column(name="vehicleRegistration")
	private String vehicleRegistration;
	
	@Column(name="chassisNo")
	private String chassisNo;
	
	@Column(name="engineNo")
	private String engineNo;
	
	public Motor() {
		this.vehicleRegistration = "";
		this.chassisNo = "";
		this.engineNo = "";
	}
	public Motor(String vehicleRegistration, String chassisNo, String engineNo) {
		this.vehicleRegistration = vehicleRegistration;
		this.chassisNo = chassisNo;
		this.engineNo = engineNo;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[MotorEntity] - ");
		builder.append("Id: " + this.vehicleRegistration);
		builder.append(", " + this.chassisNo);
		builder.append(" " + this.engineNo);
		return super.toString();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chassisNo == null) ? 0 : chassisNo.hashCode());
		result = prime * result + ((engineNo == null) ? 0 : engineNo.hashCode());
		result = prime * result + ((vehicleRegistration == null) ? 0 : vehicleRegistration.hashCode());
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
		Motor other = (Motor) obj;
		if (chassisNo == null) {
			if (other.chassisNo != null)
				return false;
		} else if (!chassisNo.equals(other.chassisNo))
			return false;
		if (engineNo == null) {
			if (other.engineNo != null)
				return false;
		} else if (!engineNo.equals(other.engineNo))
			return false;
		if (vehicleRegistration == null) {
			if (other.vehicleRegistration != null)
				return false;
		} else if (!vehicleRegistration.equals(other.vehicleRegistration))
			return false;
		return true;
	}
	
	public String getVehicleRegistration() {
		return vehicleRegistration;
	}
	public void setVehicleRegistration(String vehicleRegistration) {
		this.vehicleRegistration = vehicleRegistration;
	}
	public String getchassisNo() {
		return chassisNo;
	}
	public void setchassisNo(String chassisNo) {
		this.chassisNo = chassisNo;
	}
	public String getengineNo() {
		return engineNo;
	}
	public void setengineNo(String engineNo) {
		this.engineNo = engineNo;
	}
	
	
}
