package com.carmanager.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carmanager.daos.impl.NewsDaoImpl;
import com.carmanager.daos.impl.NewsTypeDaoImpl;
import com.carmanager.entities.NewsType;
import com.carmanager.services.NewsTypeService;

@Service("newsTypeService")
public class NewsTypeServiceImpl extends BaseServiceImpl<NewsType> implements
		NewsTypeService {

	@Autowired
	private NewsTypeDaoImpl newsTypeDao;
	@Autowired
	private NewsDaoImpl newsDao;

	@Override
	public void deleteNewsType(int id) {
		newsDao.deleteNewsByNewsTypeId(id);
		newsTypeDao.deleteEntityById(id);
	}

}
