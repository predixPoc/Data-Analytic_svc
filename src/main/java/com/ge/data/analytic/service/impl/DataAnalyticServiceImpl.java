package com.ge.data.analytic.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ge.data.analytic.entity.AutomationTrackerData;
import com.ge.data.analytic.entity.UserData;
import com.ge.data.analytic.exception.DataAnalyticException;
import com.ge.data.analytic.repository.AutomationTrackerRepo;
import com.ge.data.analytic.repository.DataAnalyticRepository;
import com.ge.data.analytic.service.IDataAnalyticService;

@Component
public class DataAnalyticServiceImpl implements IDataAnalyticService {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(DataAnalyticServiceImpl.class);

	
	@Autowired
	private DataAnalyticRepository aircraftRepo;
	
	@Autowired
	private AutomationTrackerRepo trackerRepo;

	@Override
	public UserData createNewUser(UserData user)
			throws DataAnalyticException {
		UserData current;
		try {
			current = aircraftRepo.save(user);
			LOGGER.debug("User created: " + current.getUserId());
		} catch (Exception e) {
			throw new DataAnalyticException("Error while creating User", e);
		}
		return current;
	}
	@Override
	public UserData findExistingUser(String userName) throws DataAnalyticException{
		UserData existUser;
		try {
			existUser = aircraftRepo.findUser(userName);
		} catch (Exception e) {
			throw new DataAnalyticException("Error while creating User", e);
		}
		return existUser;
	}
	@Override
	public List<AutomationTrackerData> getAllTrackerData() throws DataAnalyticException{
		List<AutomationTrackerData> dataList= null;
		try {
			dataList = trackerRepo.findAll();
		} catch (Exception e) {
			throw new DataAnalyticException("Error while creating User", e);
		}
		return dataList;
	}
}
