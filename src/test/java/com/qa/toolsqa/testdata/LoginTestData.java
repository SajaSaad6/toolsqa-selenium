package com.qa.toolsqa.testdata;

public class LoginTestData {

	public static class ValidCredential {
		public static final String USERNAME = "SallyBrown";
		public static final String PASSWORD = "1234Abc$";
	}
	
	public static class InvalidCredential { 
		public static final String USERNAME = "InvalidName";
		public static final String PASSWORD = "InvalidPassword";
	}
	
	public static class CaseSensitiveCredential {
		public static final String USERNAME = "SALLYBROWN";
		public static final String PASSWORD = "1234abc$";
	}
	
	public static class ErrorMessages {
		public static final String INVALID_CREDENTIALS = "Invalid username or password!";
	}
}
