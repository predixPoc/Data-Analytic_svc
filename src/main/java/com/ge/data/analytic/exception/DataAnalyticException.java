package com.ge.data.analytic.exception;

public class DataAnalyticException extends Exception {
	public DataAnalyticException(String message) {
		super(message);
	}

	public DataAnalyticException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public DataAnalyticException(Throwable throwable) {
		super(throwable);
	}

}
