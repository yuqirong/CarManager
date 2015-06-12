package com.carmanager.entities;

public class Permission extends BaseEntity{
	
	private static final long serialVersionUID = 5092176352477554939L;
	private String name; //资源名称
	private String permission; //权限字符串
    private String url; //资源路径
    private Boolean available = Boolean.FALSE;
    private String description; //描述,UI界面显示使用

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
