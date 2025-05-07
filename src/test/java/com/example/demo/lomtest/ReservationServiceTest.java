package com.example.demo.lomtest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.ReservationDTO;
import com.example.demo.service.ReservationService;

@SpringBootTest
public class ReservationServiceTest {

	@Autowired
	ReservationService service;
	
	@Test
	public void 서비스확인() {
		System.out.println("service: " + service);
	}
	
	   @Test
	    public void 예약정보등록() {
	        ReservationDTO dto = ReservationDTO.builder()
	                .checkInDate("2024-09-10")
	                .guestName("도우너")
	                .guestPhone(null)
	                .roomNo(301)
	                .build();

	        service.register(dto);
	        System.out.println("예약 등록 완료");
	    }
	   
	   @Test
	    public void 예약정보목록조회() {
	        List<ReservationDTO> list = service.getList();
	        System.out.println("예약 목록 조회 결과 : ");
	    }
	   

	    @Test
	    public void 예약정보단건조회() {
	        
	    	 ReservationDTO dto = service.getOne(4);
	        System.out.println(dto);
	    }

	
}
