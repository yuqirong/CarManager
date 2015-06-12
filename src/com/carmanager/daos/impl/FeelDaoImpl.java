package com.carmanager.daos.impl;

import org.springframework.stereotype.Repository;

import com.carmanager.entities.Feel;
import com.carmanager.entities.Page;

@Repository("feelDao")
public class FeelDaoImpl extends BaseDaoImpl<Feel> {

	public Page<Feel> getFeels(int pageNo, int pageSize) {
		String hql = "FROM Feel n ORDER BY n.createTime DESC";
		String hql2 = "SELECT count(*) FROM Feel";
		return this.listPage(hql, hql2, pageNo, pageSize);
	}


}
