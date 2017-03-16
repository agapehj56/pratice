package com.example.form;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeptFormTests {

	@Autowired
	Validator validator;
	
	@Test
	public void test00_cirfirmValidator(){
		System.out.println("validator = " + validator);
	}
	
	@Test
	public void test01_getDname(){
		DeptForm deptForm = new DeptForm();
		deptForm.setDname("총무부");
		
		BindingResult errors = new BeanPropertyBindingResult(deptForm, "deptForm");
		
		validator.validate(deptForm, errors);
		
		if(errors.hasErrors()){
			System.out.println("errors = " + errors);
			return;
		}
		System.out.println("deptForm는 유효합니다.");
	}
}
