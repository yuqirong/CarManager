package com.carmanager.services;

import java.util.List;

import com.carmanager.entities.Record;

public interface RecordService extends BaseService<Record> {

	public List<Record> findScoreHistoryById(Integer id);

}
