package com.capgemini.module1.services;

import java.util.List;
import com.capgemini.module1.dto.Mobile;

public interface PhoneAppSer {
	public List<Mobile> getAllContacts();
	public Mobile singleContact(String name);
	public boolean addContact(Mobile user);
	public boolean deleteContact(String name);
	public boolean editContact(String name,long number);

}
