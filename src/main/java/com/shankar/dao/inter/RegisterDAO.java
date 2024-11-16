package com.shankar.dao.inter;

import com.shankar.model.RegisterModel;

public interface RegisterDAO {
	public abstract void saveNewUser(RegisterModel model);
}
