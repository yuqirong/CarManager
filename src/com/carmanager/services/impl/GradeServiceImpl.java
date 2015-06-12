package com.carmanager.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carmanager.daos.impl.GradeDaoImpl;
import com.carmanager.entities.Grade;
import com.carmanager.services.GradeService;

@Service("gradeService")
public class GradeServiceImpl extends BaseServiceImpl<Grade> implements
		GradeService {
	
	@Autowired
	private GradeDaoImpl gradeDao;

}
