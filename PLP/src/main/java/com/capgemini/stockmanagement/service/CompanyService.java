package com.capgemini.stockmanagement.service;

import java.util.List;

import com.capgemini.stockmanagement.dto.Company;

public interface CompanyService {

	boolean addCompany(Company company);

	boolean deleteCompany(int companyId);

	boolean updateCompany(int companyId, Company company);

	List<Company> getAllCompanies();

	Company searchCompany(int companyId);
}
