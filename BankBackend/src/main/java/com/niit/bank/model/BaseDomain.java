package com.niit.bank.model;

import javax.persistence.Transient;

import org.springframework.stereotype.Component;
@Component
public class BaseDomain {

	@Transient
	public String errorcode;
	@Transient
	public String errormessage;
	public String getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}
	public String getErrormessage() {
		return errormessage;
	}
	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}
}
