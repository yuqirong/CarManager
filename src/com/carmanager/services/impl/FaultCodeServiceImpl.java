package com.carmanager.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carmanager.daos.impl.FaultCodeDaoImpl;
import com.carmanager.entities.FaultCode;
import com.carmanager.entities.Page;
import com.carmanager.services.FaultCodeService;

@Service("faultCodeService")
public class FaultCodeServiceImpl extends BaseServiceImpl<FaultCode> implements
		FaultCodeService {

	@Autowired
	private FaultCodeDaoImpl faultCodeDao;

	@Override
	public Page<FaultCode> listFaultCodePage(int pageNo, int pageSize) {
		return faultCodeDao.listFaultCodePage(pageNo,pageSize);
	}

}
