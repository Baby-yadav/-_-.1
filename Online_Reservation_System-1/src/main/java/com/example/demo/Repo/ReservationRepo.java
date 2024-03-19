package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ReservationDetails;

public interface ReservationRepo extends JpaRepository<ReservationDetails, Integer> {
	
	
	public void deleteByPnrNumber(Integer pnrNumber);

}
