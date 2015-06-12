package com.carmanager.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carmanager.daos.impl.ClubActivityDaoImpl;
import com.carmanager.entities.ClubActivity;
import com.carmanager.services.ClubActivityService;

@Service("clubActivityService")
public class ClubActivityServiceImpl extends BaseServiceImpl<ClubActivity>
		implements ClubActivityService {

	@Autowired
	private ClubActivityDaoImpl clubActivityDao;

	@Override
	public List<ClubActivity> getWeekClubActivities(int maxResult) {
		return clubActivityDao.getWeekClubActivities(maxResult);
	}

}
