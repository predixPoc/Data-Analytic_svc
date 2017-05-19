package com.ge.data.analytic.service;

import java.util.List;

import com.ge.data.analytic.entity.AutomationTrackerData;
import com.ge.data.analytic.entity.UserData;
import com.ge.data.analytic.exception.DataAnalyticException;


public interface IDataAnalyticService {

	UserData createNewUser(UserData user) throws DataAnalyticException;
	UserData findExistingUser(String userName) throws DataAnalyticException;
	List<AutomationTrackerData> getAllTrackerData() throws DataAnalyticException;
}
