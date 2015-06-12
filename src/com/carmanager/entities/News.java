package com.carmanager.entities;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 新闻
 */
public class News extends BaseEntity {

	private static final long serialVersionUID = 6136633977314509659L;
	// 标题
	@NotEmpty
	private String title;
	// 作者
	private String author;
	// 来源
	private String source;
	// 正文
	@NotEmpty
	private String content;
	// 创建时间
	private Date createTime = new Date();
	// 新闻栏目
	private NewsType newsType;
	// 访问次数
	private Integer count = 0;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public NewsType getNewsType() {
		return newsType;
	}

	public void setNewsType(NewsType newsType) {
		this.newsType = newsType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

}
