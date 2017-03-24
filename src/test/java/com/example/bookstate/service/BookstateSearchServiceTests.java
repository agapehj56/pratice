package com.example.bookstate.service;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Bookstate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookstateSearchServiceTests {

	@Autowired
	BookstateSearchService bookstateSearchService;
	
	@Test
	public void test00_confirmService(){
		System.out.println("bookstateSearchService = " + bookstateSearchService);
	}
	
	@Test
	public void test01_getListAll(){
		List<Bookstate> list = bookstateSearchService.getListAll();
		for(Bookstate bs : list)
			System.out.println(bs);
	}
	
	@Test
	public void test01_getListAll_withBook(){
		List<Bookstate> list = bookstateSearchService.getListAll(true);
		for(Bookstate bs : list)
			System.out.println(bs);
	}
	
	@Test
	public void test02_getPage(){
		Map<String, Object> map = bookstateSearchService.getPage(1);
		System.out.println(map.get("members"));
		System.out.println(map.get("paging"));
	}
	
	@Test
	public void test02_getPage_withBook(){
		Map<String, Object> map = bookstateSearchService.getPage(1, true);
		System.out.println(map.get("members"));
		System.out.println(map.get("paging"));
	}
	
	@Test
	public void test03_getBookstateByMembercode(){
		Bookstate bs = bookstateSearchService.getBookstateByMembercode(201700056);
		System.out.println(bs);
	}
	
	@Test
	public void test03_getBookstateByMembercode_withBook(){
		Bookstate bs = bookstateSearchService.getBookstateByMembercode(201700056, true);
		System.out.println(bs);
	}
}
