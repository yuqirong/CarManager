package com.carmanager.services;

import java.util.List;

import com.carmanager.entities.News;
import com.carmanager.entities.Page;

public interface NewsService extends BaseService<News> {

	public News getViewNews(Integer id);

	public Page<News> getNews(Integer id, int pageNo, int pageSize);

	public List<News> getHotNews(int maxNum);

	public List<News> getRecentNews(int id, int MaxResult);

	public Page<News> listAllNewsPage(int i, int pageSize);

}
