package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.domain.Bookstate;
import com.example.util.Pagination;

@Mapper
public interface BookstateMapper {

	/*
	 * Select
	 */
	@Select("select count(*) from bookState")
	int selectTotalCount();
	
	@Select("select * from bookState")
	List<Bookstate> selectAll();
	List<Bookstate> selectAllWithBook();
	
	@Select({
		"select *							",
		"  from bookState					",
		" order by member_code				",
		"offset #{firstItem}-1 rows			",
		" fetch next #{itemsPerPage} rows only"
		})
	List<Bookstate> selectPage(Pagination paging);
	List<Bookstate> selectPageWithBook(Pagination paging);
	
	@Select("select * from bookState where member_code=#{member_code}")
	Bookstate selectBymemberCode(int memberCode);
	Bookstate selectBymemberCodeWithBook(int memberCode);
	
	/*
	 * Insert
	 */
	int insert(Bookstate bookstate);
	
	/*
	 * Update
	 */
	int updateByMemberCode(Bookstate bookstate);
	
	/*
	 * Delete
	 */
	@Delete("delete from bookState where member_code=#{member_code}")
	int deleteByMemberCode(int memberCode);
}
