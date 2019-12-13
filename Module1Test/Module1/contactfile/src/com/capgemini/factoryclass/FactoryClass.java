package com.capgemini.factoryclass;

import com.capgemini.module1.dao.PhoneApp;
import com.capgemini.module1.dao.PhoneAppDAOImpl;
import com.capgemini.module1.services.PhoneAppSer;
import com.capgemini.module1.services.PhoneAppSerImpli;

public class FactoryClass {
	public static PhoneApp instanceOfDAO()
	{
		return new PhoneAppDAOImpl();
	}
	public static PhoneAppSer instanceOfServ()
	{
		return new PhoneAppSerImpli();
	}

}
