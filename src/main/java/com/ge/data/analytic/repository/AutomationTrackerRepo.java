package com.ge.data.analytic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ge.data.analytic.entity.AutomationTrackerData;

public interface AutomationTrackerRepo extends JpaRepository<AutomationTrackerData, Long>{
	
	@Override
	List<AutomationTrackerData> findAll();

}
