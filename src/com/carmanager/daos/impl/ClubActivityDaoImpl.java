package com.carmanager.daos.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.carmanager.entities.ClubActivity;

@Repository("clubActivityDao")
public class ClubActivityDaoImpl extends BaseDaoImpl<ClubActivity> {

	public List<ClubActivity> getWeekClubActivities(int maxResult) {
			String sql = "SELECT * FROM clubactivities n WHERE n.createtime>DATE_SUB(CURDATE(), INTERVAL 1 WEEK) limit 0,?";
			return this.executeSQLQuery(ClubActivity.class, sql, maxResult);
		}


}
