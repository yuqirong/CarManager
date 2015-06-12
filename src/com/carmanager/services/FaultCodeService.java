package com.carmanager.services;

import com.carmanager.entities.FaultCode;
import com.carmanager.entities.Page;

public interface FaultCodeService extends BaseService<FaultCode> {

	public Page<FaultCode> listFaultCodePage(int pageNo, int pageSize);

}
