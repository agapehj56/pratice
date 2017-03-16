package com.example.city.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import com.example.form.CityForm;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityRegisterServiceTests {
	
	@Autowired
	CitySearchService citySearchService;
	
	@Autowired
	CityRegisterService cityRegisterService;
	
	@Autowired
	Validator validator;
	
	@Test
	public void test00_confirmCitySearchService() {
		System.out.println("citySearchService=" + citySearchService);		
	}
	
	@Test
	public void test00_confirmCityRegisterService() {
		System.out.println("cityRegisterService=" + cityRegisterService);		
	}
	
	@Test
	public void test00_confirmValidator() {
		System.out.println("validator=" + validator);	
	}
	
	@Test
	public void test01_register(){
		CityForm cityForm = new CityForm();
		BindingResult errors = new BeanPropertyBindingResult(cityForm, "cityForm");
		
		cityForm.setName("xxx");
		cityForm.setCountryCode("KOR");
		
		validator.validate(cityForm, errors);				// 자리수랑 null 체크(입력양식) - 유효성 검사
		if(errors.hasErrors()){
			System.out.println("errors = " + errors);
			return;
		}
		
		cityRegisterService.register(cityForm, errors);		// country code가 유효한지 확인
		if(errors.hasErrors()){
			System.out.println("errors = " + errors);
			return;
		}						// error 체크 구문.
		
		System.out.println("city = " + citySearchService.getCityById(cityForm.getId()));
	}
}
