package com.carmanager.daos.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.carmanager.entities.News;
import com.carmanager.entities.Page;

@Repository("newsDao")
public class NewsDaoImpl extends BaseDaoImpl<News> {

	public List<News> getAllNewsByNewsType(Integer typeId) {
		String hql = "FROM News n WHERE n.newsType.id = ?";
		return this.findEntityByHQL(hql, typeId);
	}

	public Page<News> getNews(Integer id, int pageNo, int pageSize) {
		String hql = "FROM News n WHERE n.newsType.id = " + id
				+ " ORDER BY n.createTime DESC";
		String hql2 = "SELECT count(*) FROM News n WHERE n.newsType.id = " + id;
		return this.listPage(hql, hql2, pageNo, pageSize);
	}

	public List<News> geHotNews(int maxNum) {
		String hql = "FROM News n WHERE ORDER BY n.count DESC, n.createTime DESC";
		return this.findLimitEntityByHQL(hql, 0, maxNum);
	}

	public List<News> getRecentNews(int id, int maxResult) {
		String hql = "FROM News n where n.newsType.id = ? ORDER BY n.createTime DESC";
		return this.findLimitEntityByHQL(hql, 0, maxResult, id);
	}

	public Page<News> listAllNewsPage(int pageNo, int pageSize) {
		String hql = "FROM News n ORDER BY n.createTime desc";
		String hql2 = "SELECT count(*) FROM News";
		return this.listPage(hql, hql2, pageNo, pageSize);
	}

	public void deleteNewsByNewsTypeId(int id) {
		String hql = "FROM News n WHERE n.newsType.id = ?";
		List<News> news = this.findEntityByHQL(hql, id);
		for (News n : news) {
			this.deleteEntity(n);
		}
	}

}
