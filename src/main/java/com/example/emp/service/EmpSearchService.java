package com.example.emp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Emp;
import com.example.mapper.EmpMapper;
import com.example.util.Pagination;

@Service
public class EmpSearchService {
	static Log log = LogFactory.getLog(EmpSearchService.class);
	
	@Autowired
	EmpMapper empMapper;
	
	public List<Emp> getListAll(){
		log.info("getListAll()");
		return getListAll(false);
	}
	
	public List<Emp> getListAll(boolean withDept){
		log.info("getListAll(" + withDept + ")");
		List<Emp> list = null;
		if(withDept)
			list = empMapper.selectAllWithDept();
		else
			list = empMapper.selectAll();
		
		return list;
	}
	
	public Map<String, Object> getPage(int pageNo){
		return getPage(pageNo, false);
	}
	
	public Map<String, Object> getPage(int pageNo, boolean withDept){
		Pagination paging = new Pagination();
		paging.setTotalItem(empMapper.selectTotalCount());
		paging.setPageNo(pageNo);
		
		List<Emp> list = null;
		if(withDept)
			list = empMapper.selectPageWithDept(paging);
		else
			list = empMapper.selectPage(paging);
		
		Map<String, Object> map = new HashMap<>();
		map.put("emps", list);
		map.put("paging", paging);
		
		return map;
	}
	
	public Emp getEmpByEmpno(int empno){
		log.info("getEmpByEmpno(" + empno + ")");
		return getEmpByEmpno(empno, false);
	}
	
	public Emp getEmpByEmpno(int empno, boolean withDept){
		log.info("getEmpByEmpno(" + empno + ", " + withDept + ")");
		Emp emp = null;
		
		if(withDept)
			emp = empMapper.selectByEmpnoWithDept(empno);
		else
			emp = empMapper.selectByEmpno(empno);
		
		return emp;
	}
}
