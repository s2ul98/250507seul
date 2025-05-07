package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.ReservationDTO;
import com.example.demo.service.ReservationService;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
	
	  @Autowired
	  ReservationService service;
	  
	  @GetMapping("/register")
	    public String register() {
	        return "register"; 
	    }

	  // 등록
	  @PostMapping("/register")
	  public String registerPost(ReservationDTO dto, RedirectAttributes redirectAttributes) {
		  
		  int newNo = service.register(dto);
		  redirectAttributes.addFlashAttribute("newNo", newNo);
		  
		  return "redirect:/reservation/list";
	  }
	  
	  // 목록 조회
	  @GetMapping("/list")
	    public String list(Model model) {
	        List<ReservationDTO> list = service.getList();
	        model.addAttribute("list", list);
	        return "list";
	    }

	  // 상세 조회
	   @GetMapping("/read")
	    public String read(@RequestParam("no") int no, Model model) {
	        ReservationDTO dto = service.getOne(no);
	        model.addAttribute("dto", dto);
	        return "read"; 
	    }
	  
}
