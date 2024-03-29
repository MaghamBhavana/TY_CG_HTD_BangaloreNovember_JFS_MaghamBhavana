package com.capgemini.module1.dao;

import java.util.List;
import com.capgemini.module1.dto.Mobile;

public interface PhoneApp {
	public List<Mobile> getAllContacts();
	public Mobile singleContact(String name);
	public boolean addContact(Mobile user);
	public boolean deleteContact(String name);
	public boolean editContact(String name,long number);
}
