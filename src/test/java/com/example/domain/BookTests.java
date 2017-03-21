package com.example.domain;

import org.junit.Test;

public class BookTests {

	@Test
	public void test01_toString(){
		Book b = new Book();
		b.setBookCode(8030760);
		b.setBookName("하악하악");
		
		System.out.println(b);
	}
}
