package com.capgemini.stockmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.stockmanagement.dao.CompanyDAO;
import com.capgemini.stockmanagement.dto.Company;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDAO dao;
	
	@Override
	public boolean addCompany(Company company) {
		
		return dao.addCompany(company);
	}

	@Override
	public boolean deleteCompany(int companyId) {
		
		return dao.deleteCompany(companyId);
	}

	@Override
	public boolean updateCompany(int companyId, Company company) {
		
		return dao.updateCompany(companyId, company);
	}

	@Override
	public List<Company> getAllCompanies() {
		
		return dao.getAllCompanies();
	}

	@Override
	public Company searchCompany(int companyId) {
		
		return dao.getCompany(companyId);
	}

}
