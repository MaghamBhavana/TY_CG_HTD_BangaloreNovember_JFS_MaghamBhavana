package com.capgemini.stockmanagement.dao;

import java.util.List;

import com.capgemini.stockmanagement.dto.Company;

public interface CompanyDAO {

	boolean addCompany(Company company);

	boolean deleteCompany(int companyId);

	boolean updateCompany(int companyId, Company company);

	List<Company> getAllCompanies();

	Company getCompany(int comapnyId);
}
