package com.carmanager.services;

import java.util.List;

import com.carmanager.entities.ClubActivity;

public interface ClubActivityService extends BaseService<ClubActivity> {

	public List<ClubActivity> getWeekClubActivities(int maxResult);

}
