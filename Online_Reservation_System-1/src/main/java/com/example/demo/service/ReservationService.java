package com.example.demo.service;

import com.example.demo.entity.ReservationDetails;

public interface ReservationService {
	
	public ReservationDetails saveReservationDetails(ReservationDetails reserveDetails);
	
	public void cancelReservation(Integer pnrNumber);
	
	
}
