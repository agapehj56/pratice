package com.example.bookstate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bookstate.service.BookstateSearchService;
import com.example.domain.Bookstate;

@Controller
@RequestMapping("/bookmember")
public class BookstateSearchController {
	
	static Log log = LogFactory.getLog(BookstateSearchController.class);
	
	@Autowired
	BookstateSearchService bookstateSearchService;
	
	@GetMapping("/list")
	public String getList(Model model){
		log.info("getListAll()");
		
		List<Bookstate> list = bookstateSearchService.getListAll(true);
		model.addAttribute("bookmembers", list);
		
		return "/bookmember/list";
	}
}
