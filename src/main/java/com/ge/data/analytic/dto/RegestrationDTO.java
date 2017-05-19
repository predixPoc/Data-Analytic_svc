/*
 * Copyright (c) 2017 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
 
package com.ge.data.analytic.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author predix -
 */
@XmlRootElement
public class RegestrationDTO {
	
	
	private String resultStr;

	public String getResultStr() {
		return resultStr;
	}

	public void setResultStr(String resultStr) {
		this.resultStr = resultStr;
	}
	


}
