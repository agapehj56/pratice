package com.example.domain;

import java.sql.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Bookstate {

	private Integer memberCode;
	private String memberName;
	private Integer bookCode;
	private String checkState;
	private Date rentReserveDate;

	public Bookstate() {

	}

	@Override
	public String toString(){
		String str = null;
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			str = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}		
		return str;
	}
	
	public Integer getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(Integer memberCode) {
		this.memberCode = memberCode;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Integer getBookCode() {
		return bookCode;
	}

	public void setBookCode(Integer bookCode) {
		this.bookCode = bookCode;
	}

	public String getCheckState() {
		return checkState;
	}

	public void setCheckState(String checkState) {
		this.checkState = checkState;
	}

	public Date getRentReserveDate() {
		return rentReserveDate;
	}

	public void setRentReserveDate(Date rentReserveDate) {
		this.rentReserveDate = rentReserveDate;
	}
}
