package com.example.demo.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repo.ReservationRepo;
import com.example.demo.entity.ReservationDetails;

import jakarta.transaction.Transactional;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	private ReservationRepo reserveRepo;

	

	@Override
	public ReservationDetails saveReservationDetails(ReservationDetails reserveDetails) {
		
		Random ran= new Random();
		
	   int randomNumber = ran.nextInt(90000) + 10000;
	   reserveDetails.setPnrNumber(randomNumber);
	
	  return reserveRepo.save(reserveDetails);
	

}



	@Override
	@Transactional
	public void cancelReservation(Integer pnrNumber) {
		 reserveRepo.deleteByPnrNumber(pnrNumber);
		
		}
	
		  
		
		
	
}
