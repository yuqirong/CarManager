package com.carmanager.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carmanager.daos.impl.NewsDaoImpl;
import com.carmanager.entities.News;
import com.carmanager.entities.Page;
import com.carmanager.services.NewsService;

@Service("newsService")
public class NewsServiceImpl extends BaseServiceImpl<News> implements
		NewsService {

	@Autowired
	private NewsDaoImpl newsDao;
	
	private News news = null;
	private Page<News> page = null;

	@Override
	public Page<News> getNews(Integer id, int pageNo, int pageSize) {
		page = newsDao.getNews(id, pageNo, pageSize);
		return page;
	}

	@Override
	public News getViewNews(Integer id) {
		news = newsDao.getEntity(id);
		return news;
	}

	@Override
	public List<News> getHotNews(int maxNum) {
		return newsDao.geHotNews(maxNum);
	}

	@Override
	public List<News> getRecentNews(int id, int maxResult) {
		return newsDao.getRecentNews(id, maxResult);
	}

	@Override
	public Page<News> listAllNewsPage(int pageNo, int pageSize) {
		page = newsDao.listAllNewsPage(pageNo, pageSize);
		if (page.getList() != null && page.getList().size() > 0) {
			for (News news : page.getList()) {
				news.getNewsType().getTypeName();
			}
		}
		return page;
	}

}
