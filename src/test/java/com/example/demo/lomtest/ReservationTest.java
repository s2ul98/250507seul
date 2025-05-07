package com.example.demo.lomtest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Reservation;
import com.example.demo.repository.ReservationRepository;

@SpringBootTest
public class ReservationTest {

    @Autowired
    ReservationRepository repository;

    @Test
    public void 리파지토리확인() {
        System.out.println("repository: " + repository);
    }
    
    @Test
    public void 등록() {
        Reservation reservation = Reservation.builder()
                .checkInDate("2024-09-05")
                .guestName("둘리")
                .guestPhone("010-1111-2222")
                .roomNo(201)
                .build();

        repository.save(reservation);
        
        Reservation reservation2 = Reservation.builder()
                .checkInDate("2024-09-05")
                .guestName("또치")
                .guestPhone("010-3333-4444")
                .roomNo(202)
                .build();

        repository.save(reservation2);
        
        Reservation reservation3 = Reservation.builder()
                .checkInDate("2024-09-10")
                .guestName("도우너")
                .guestPhone(null)
                .roomNo(202)
                .build();

        repository.save(reservation3);
        
    }
    
    @Test
	public void 게시물수정() {
    	int no = 3;
        List<Reservation> list = repository.findAll();
       
        for (Reservation r : list) {
            if (r.getNo() == no) {
                r.setRoomNo(201);
    	
                repository.save(r);
            }
        }
    }
    
    @Test
	public void 게시물삭제() {
    	List<Reservation> list = repository.findAll();
    	
    	for (Reservation r : list) {
            if ("또치".equals(r.getGuestName())) {
                repository.delete(r); 
                System.out.println("또치 삭제 완료");
            }
        }
	}
    
    @Test
    public void 등록또치() {
    	 Reservation reservation2 = Reservation.builder()
                 .checkInDate("2024-09-05")
                 .guestName("또치")
                 .guestPhone("010-3333-4444")
                 .roomNo(202)
                 .build();

         repository.save(reservation2);
	}
   

    
}
