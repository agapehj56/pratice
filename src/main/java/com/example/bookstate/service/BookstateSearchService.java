package com.example.bookstate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Bookstate;
import com.example.mapper.BookstateMapper;

@Service
public class BookstateSearchService {
	
	@Autowired
	BookstateMapper bookstateMapper;
	
	public List<Bookstate> getList(){
		return getList(false);
	}
	
	public List<Bookstate> getList(boolean withBook){
		List<Bookstate> list = null;
		if(withBook)
			list = bookstateMapper.selectAllWithBook();
		else
			list = bookstateMapper.selectAll();
		
		return list;
	}
}
