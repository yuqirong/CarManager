package com.carmanager.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carmanager.daos.impl.CompanyDaoImpl;
import com.carmanager.entities.Company;
import com.carmanager.services.CompanyService;

@Service("companyService")
public class CompanyServiceImpl extends BaseServiceImpl<Company> implements
		CompanyService {

	@Autowired
	private CompanyDaoImpl companyDao;

}
