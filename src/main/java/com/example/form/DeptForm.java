package com.example.form;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.domain.Dept;

public class DeptForm extends Dept{

	@NotNull
	@Digits(integer=3, fraction=0)
	@Override
	public Integer getDeptno() {
		// TODO Auto-generated method stub
		return super.getDeptno();
	}

	@Override
	public void setDeptno(Integer deptno) {
		// TODO Auto-generated method stub
		super.setDeptno(deptno);
	}

	@NotNull
	@Size(max=14)
	@Override
	public String getDname() {
		// TODO Auto-generated method stub
		return super.getDname();
	}

	@Override
	public void setDname(String dname) {
		// TODO Auto-generated method stub
		super.setDname(dname);
	}

	@Size(max=13)
	@Override
	public String getLoc() {
		// TODO Auto-generated method stub
		return super.getLoc();
	}

	@Override
	public void setLoc(String loc) {
		// TODO Auto-generated method stub
		super.setLoc(loc);
	}
	
}
