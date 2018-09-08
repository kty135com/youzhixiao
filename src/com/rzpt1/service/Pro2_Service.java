package com.rzpt1.service;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.rzpt.entity.Pro2;

public class Pro2_Service {
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public Pro2 getProject2ByPro3(int id) {
		Pro2 p = hibernateTemplate.get(Pro2.class, id);
		return p;
	}
	
	public void update(Pro2 p) {
		hibernateTemplate.update(p);
	}

	public Pro2 getProject2ById(int id) {
		Pro2 project2 = hibernateTemplate.get(Pro2.class, id);
		return project2;
	}
}
