package com.carmanager.daos.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.carmanager.entities.Record;

@Repository("recordDao")
public class RecordDaoImpl extends BaseDaoImpl<Record> {

	public List<Record> findScoreHistoryById(Integer id) {
		String hql = "FROM Record r where r.user.id = ?";
		return this.findEntityByHQL(hql, id);
	}

}
