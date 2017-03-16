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
public class EmpFormTests  {
	
	@Autowired
	Validator validator;
	
	@Test
	public void test00_cirfirmValidator(){
		System.out.println("validator = " + validator);
	}
	
	@Test
	public void test01_getEname(){
		EmpForm empForm = new EmpForm();
		
		empForm.setEname("jungang");
		
		BindingResult errors = new BeanPropertyBindingResult(empForm, "empForm");
		
		validator.validate(empForm, errors);
		
		if(errors.hasErrors()){
			System.out.println("errors = " + errors);
			return;
		}
		System.out.println("empForm은 유효합니다.");
	}
}
