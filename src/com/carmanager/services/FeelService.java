package com.carmanager.services;

import com.carmanager.entities.Feel;
import com.carmanager.entities.Page;

public interface FeelService extends BaseService<Feel> {

	public Page<Feel> getFeels(int pageNo, int pageSize);

}
