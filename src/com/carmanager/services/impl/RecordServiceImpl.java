package com.carmanager.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carmanager.daos.impl.RecordDaoImpl;
import com.carmanager.entities.Record;
import com.carmanager.services.RecordService;
import com.carmanager.utils.ValidateUtils;

@Service("recordService")
public class RecordServiceImpl extends BaseServiceImpl<Record> implements
		RecordService {

	@Autowired
	private RecordDaoImpl recordDao;

	@Override
	public List<Record> findScoreHistoryById(Integer id) {
		if(ValidateUtils.isValid(id)){
			return recordDao.findScoreHistoryById(id);
		}
		return null;
	}

}
