package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ReservationDTO;

public interface ReservationService {

	   int register(ReservationDTO dto);
	   List<ReservationDTO> getList();
	   ReservationDTO getOne(int no);

	    
}
