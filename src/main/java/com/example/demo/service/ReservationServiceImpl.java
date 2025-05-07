package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ReservationDTO;
import com.example.demo.entity.Reservation;
import com.example.demo.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	ReservationRepository repository;

	// 등록
	@Override
	public int register(ReservationDTO dto) {
		
		Reservation entity = dtoToEntity(dto);
		Reservation saved = repository.save(entity);
		
		 return saved.getNo();
		
	}

	private Reservation dtoToEntity(ReservationDTO dto) {
		return Reservation.builder()
				.no(dto.getNo()) 
				.checkInDate(dto.getCheckInDate())
				.guestName(dto.getGuestName())
				.guestPhone(dto.getGuestPhone())
				.roomNo(dto.getRoomNo())
				.build();
	}

	// 전체 목록
	@Override
	public List<ReservationDTO> getList() {
		
		return repository.findAll().stream()
							.map(reservation -> this.toDTO(reservation))
							.collect(Collectors.toList());
		
		
	}

	 // 단건 조회
	@Override
	public ReservationDTO getOne(int no) {
		
		return repository.findById(no).map(reservation -> this.toDTO(reservation)).orElse(null);
	}
	
	   private ReservationDTO toDTO(Reservation r) {
	        return ReservationDTO.builder()
	                .no(r.getNo())
	                .checkInDate(r.getCheckInDate())
	                .guestName(r.getGuestName())
	                .guestPhone(r.getGuestPhone())
	                .roomNo(r.getRoomNo())
	                .build();
	    }






}
