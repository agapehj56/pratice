package com.example.bookstate.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Bookstate;
import com.example.mapper.BookstateMapper;
import com.example.util.Pagination;

@Service
public class BookstateSearchService {
	
	@Autowired
	BookstateMapper bookstateMapper;
	
	public List<Bookstate> getListAll(){
		return getListAll(false);
	}
	
	public List<Bookstate> getListAll(boolean withBook){
		List<Bookstate> list = null;
		if(withBook)
			list = bookstateMapper.selectAllWithBook();
		else
			list = bookstateMapper.selectAll();
		
		return list;
	}
	
	public Map<String, Object> getPage(int pageNo) {
		return getPage(pageNo, false);
	}
	
	public Map<String, Object> getPage(int pageNo, boolean withBook) {
		Pagination paging = new Pagination();
		paging.setTotalItem(bookstateMapper.selectTotalCount());
		paging.setPageNo(pageNo);
		
		List<Bookstate> list = null;
		if(withBook)
			list = bookstateMapper.selectPageWithBook(paging);
		else
			list = bookstateMapper.selectPage(paging);
		
		Map<String, Object> map = new HashMap<>();
		map.put("members", list);
		map.put("paging", paging);
		
		return map;
	}
	
	public Bookstate getBookstateByMembercode(int memberCode){
		return getBookstateByMembercode(memberCode, false);
	}
	
	public Bookstate getBookstateByMembercode(int memberCode, boolean withBook){
		Bookstate bookstate = null;
		if(withBook)
			bookstate = bookstateMapper.selectBymemberCodeWithBook(memberCode);
		else
			bookstate = bookstateMapper.selectBymemberCode(memberCode);
		
		return bookstate;
	}
}
