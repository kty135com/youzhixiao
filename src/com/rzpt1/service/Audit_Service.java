package com.rzpt1.service;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.rzpt.entity.Audit;

public class Audit_Service {
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void add(Audit audit) {
		hibernateTemplate.save(audit);
	}

	public Audit getAuditByWatch_id(int id) {
		Audit a = null;
		List list = hibernateTemplate.find("from Audit where watch_id=" + id);
		for (int i = 0; i < list.size(); i++) {
			if (i < list.size()-1) {
				Audit audit = (Audit) list.get(i);
				Audit audit2 = (Audit) list.get(i + 1);
				if (audit.getId() < audit2.getId()) {
					a = audit2;
				} else {
					a = audit;
				}
			} else {
				a = (Audit) list.get(i);
			}
		}
		return a;
	}

}
