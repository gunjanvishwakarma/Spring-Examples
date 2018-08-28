package com.gunjan;

public class PhoneNumber {

	String countryCode;

	String phNumber;

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getPhNumber() {
		return phNumber;
	}

	public void setPhNumber(String phNumber) {
		this.phNumber = phNumber;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PhoneNumber [countryCode=");
		builder.append(countryCode);
		builder.append(", phNumber=");
		builder.append(phNumber);
		builder.append("]");
		return builder.toString();
	}
}
