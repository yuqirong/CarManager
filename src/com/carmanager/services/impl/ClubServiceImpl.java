package com.carmanager.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carmanager.daos.impl.ClubDaoImpl;
import com.carmanager.entities.Club;
import com.carmanager.services.ClubService;

@Service("clubService")
public class ClubServiceImpl extends BaseServiceImpl<Club> implements
		ClubService {

	@Autowired
	private ClubDaoImpl clubDao;

}
