package com.example.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Bookstate;
import com.example.util.Pagination;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookstateMapperTests {
	
	@Autowired
	BookstateMapper bookstatemapper;
	
	@Test
	public void test00_cinfirmMapper(){
		System.out.println("bookstatemapper = " + bookstatemapper);
	}
	
	@Test
	public void test00_selectTotalCount(){
		System.out.println("totalCount = " + bookstatemapper.selectTotalCount());
	}
	
	@Test
	public void test01_selectAll(){
		List<Bookstate> list = bookstatemapper.selectAll();
		
		for(Bookstate bs : list)
			System.out.println(bs);
	}
	
	@Test
	public void test01_selectAllWithBook(){
		List<Bookstate> list = bookstatemapper.selectAllWithBook();
		
		for(Bookstate bs : list)
			System.out.println(bs);
	}
	
	@Test
	public void test02_selectPage(){
		Pagination paging = new Pagination();
		paging.setTotalItem(bookstatemapper.selectTotalCount());
		paging.setPageNo(1);
		
		List<Bookstate> list = bookstatemapper.selectPage(paging);
		for(Bookstate bs : list)
			System.out.println(bs);
	}
	
	@Test
	public void test02_selectPageWithBook(){
		Pagination paging = new Pagination();
		paging.setTotalItem(bookstatemapper.selectTotalCount());
		paging.setPageNo(1);
		
		List<Bookstate> list = bookstatemapper.selectPageWithBook(paging);
		for(Bookstate bs : list)
			System.out.println(bs);
	}
	
	@Test
	public void test03_selectBymemberCode(){
		Bookstate bookstate = bookstatemapper.selectBymemberCode(201601320);
		
		System.out.println("bookstate = " + bookstate);
	}
	
	@Test
	public void test03_selectBymemberCodeWithBook(){
		Bookstate bookstate = bookstatemapper.selectBymemberCodeWithBook(201601320);
		
		System.out.println("bookstate = " + bookstate);
	}
}
