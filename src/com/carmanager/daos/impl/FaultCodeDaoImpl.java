package com.carmanager.daos.impl;

import org.springframework.stereotype.Repository;

import com.carmanager.entities.FaultCode;
import com.carmanager.entities.Page;

@Repository("faultCodeDao")
public class FaultCodeDaoImpl extends BaseDaoImpl<FaultCode> {

	public Page<FaultCode> listFaultCodePage(int pageNo, int pageSize) {
		String hql = "From FaultCode";
		String hql2 = "SELECT count(*) FROM FaultCode";
		return this.listPage(hql, hql2, pageNo, pageSize);
	}

}
