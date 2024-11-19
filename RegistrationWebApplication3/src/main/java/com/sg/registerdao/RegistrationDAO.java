package com.sg.registerdao;

import java.util.ArrayList;
import java.util.List;

import com.sg.registrationmodelclass.Registration;

public interface RegistrationDAO {
	
	int insertData(Registration r);
	ArrayList<Registration> fetchAll();
	int updateData(Registration r);
	int deleteData(int id);
	Registration fetchAllId(int id);

}
