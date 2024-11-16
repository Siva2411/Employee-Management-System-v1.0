package com.shankar.util;

import com.shankar.model.RegisterModel;

public class RegisterUtil {
	public static RegisterModel mapToRegisterModel(String username,String email,String password) {
		RegisterModel registerModel = new RegisterModel();
		registerModel.setUsername(username);
		registerModel.setEmail(password);
		return registerModel;
	}
}
