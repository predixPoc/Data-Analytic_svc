package com.ge.data.analytic.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ge.data.analytic.entity.UserData;
import com.ge.data.analytic.entity.AutomationTrackerData;
import com.ge.data.analytic.exception.DataAnalyticException;
import com.ge.data.analytic.service.IDataAnalyticService;
import com.ge.data.analytic.util.RestResponse;

//@RestController
@Controller
@RequestMapping(value = "/data-analytic")
@Configuration
@ComponentScan("com.ge.data.analytic.service")
public class DataAnalyticController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(DataAnalyticController.class);
	@Autowired
	private IDataAnalyticService iDataAnalyticService;

	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String test() {

		return "Testing";
	}

	@RequestMapping(value = "/saveUserRegistration", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public RestResponse createNewUser(@RequestBody @Valid final UserData user)
			throws DataAnalyticException {
		System.out.println("Inside createNewUser method--");
		RestResponse response = new RestResponse();
		try {

			UserData checkUser = iDataAnalyticService.findExistingUser(user
					.getUserName().toUpperCase());

			if (null != checkUser) {
				response.setStatus(201);
				response.setMessage("Exists");
				// response.setObject(checkUser);
				return response;
			} else {
				//
				checkUser = new UserData();
				// TtUser user = new TtUser();
				checkUser.setUserName(user.getUserName().toUpperCase());
				// checkUser.setLastName(user.getLastName());
				checkUser.setEmail(user.getEmail());
				checkUser.setPassword(user.getPassword().toUpperCase());
				checkUser.setConfirmPassword(user.getConfirmPassword()
						.toUpperCase());
				checkUser.setPhone(user.getPhone());
				iDataAnalyticService.createNewUser(checkUser);
				response.setStatus(200);
				response.setMessage("Success");
				// response.setObject(checkUser);
				return response;
			}

		}

		catch (Exception ex) {
			System.out.println("DataAnalyticController.createNewUser()");
			response.setStatus(201);
			response.setMessage("Failure");
			return response;

		}

		// return status;

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public RestResponse login(@RequestBody @Valid final UserData user) {
		RestResponse response = new RestResponse();
		try {

			UserData checkUser = iDataAnalyticService.findExistingUser(user
					.getUserName().toUpperCase());
			System.out.println("checkUser" + checkUser);

			if (null != checkUser) {

				if ((checkUser.getUserName().equalsIgnoreCase(user
						.getUserName()))
						&& (checkUser.getPassword().equalsIgnoreCase(user
								.getPassword()))) {
					// response.setObject(checkUser);
					response.setStatus(200);
					response.setMessage("Success");
					System.out.println("checkUser" + response);

				} else {
					response.setMessage("Failure");
					response.setStatus(201);

				}
				System.out.println("Response: " + response);
			} else {
				response.setMessage("NotExist");
				response.setStatus(201);

			}

		}

		catch (Exception ex) {
			System.out.println("Data-Analytic.login()");
			response.setStatus(201);
			return response;

		}
		// return status;
		return response;

	}

	@RequestMapping(value = "/getAllTrackerData", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public RestResponse getAllTrackerData() throws DataAnalyticException {
		RestResponse response = new RestResponse();
		try {

			List<AutomationTrackerData> dataList = iDataAnalyticService
					.getAllTrackerData();

			if (CollectionUtils.isEmpty(dataList)) {
				response.setMessage("No Data Found");
				response.setStatus(200);
				return response;
			}
			response.setMessage("Success");
			response.setStatus(200);
			response.setObject(dataList);
			return response;
		} catch (Exception e) {
			throw new DataAnalyticException("Error while fetching Automation Tracker data.");
		}

	}

}
