package com.carmanager.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carmanager.daos.impl.FeelDaoImpl;
import com.carmanager.entities.Feel;
import com.carmanager.entities.Page;
import com.carmanager.services.FeelService;

@Service("feelService")
public class FeelServiceImpl extends BaseServiceImpl<Feel> implements
		FeelService {

	@Autowired
	private FeelDaoImpl feelDao;

	@Override
	public Page<Feel> getFeels(int pageNo, int pageSize) {
		Page<Feel> page = feelDao.getFeels(pageNo,pageSize);
		return page;
	}

}
