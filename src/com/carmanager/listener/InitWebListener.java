package com.carmanager.listener;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import com.carmanager.entities.CarType;
import com.carmanager.services.CarTypeService;

@SuppressWarnings("rawtypes")
@Component
public class InitWebListener implements ApplicationListener,
		ServletContextAware {

	private ServletContext servletContext;
	@Autowired
	private CarTypeService carTypeService;

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	@Override
	public void onApplicationEvent(ApplicationEvent arg0) {
		if (arg0 instanceof ContextRefreshedEvent) {
			List<CarType> carTypes = carTypeService.findAllEntities();
			if (servletContext != null) {
				servletContext.setAttribute("initCarTypes",carTypes);
			}
		}

	}

}
