package com.capgemini.module1.services;

import java.util.List;

import com.capgemini.factoryclass.FactoryClass;
import com.capgemini.module1.dao.PhoneApp;
import com.capgemini.module1.dto.Mobile;

public class PhoneAppSerImpli implements PhoneAppSer{
	PhoneApp phone= FactoryClass.instanceOfDAO();
	@Override
	public List<Mobile> getAllContacts() {
		
		return phone.getAllContacts();
	}

	@Override
	public Mobile singleContact(String name) {
		
		return phone.singleContact(name);
	}

	@Override
	public boolean addContact(Mobile user) {
		
		return phone.addContact(user);
	}

	@Override
	public boolean deleteContact(String name) {
		
		return phone.deleteContact(name);
	}

	@Override
	public boolean editContact(String name,long number) {
		
		return phone.editContact(name,number);
	}

}
