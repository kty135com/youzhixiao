package com.rzpt1.service;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.rzpt.entity.Dept;

@Transactional
public class Dept_Service {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public List getOtherDept(int id) {
		String hql = "from Dept as d where d.id not in (select dept_id from User as u where u.id=" + id + ")";
		List list = hibernateTemplate.find(hql);
		return list;
	}

	public int add(Dept dept) {
		try{
			Session s = sessionFactory.getCurrentSession();
			Transaction t = s.beginTransaction();
			System.out.println("s.save前的一步的dept===="+dept);
			Dept d = new Dept();
			d.setName("大门");
			s.save(d);
			t.commit();
			s.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

	public List getAllDepts() {
		List list = hibernateTemplate.find("from Dept");
		return list;
	}

	public Dept getDept(int id) {
		Dept dept = hibernateTemplate.get(Dept.class, id);
		return dept;
	}

	public int update(Dept dept) {
		hibernateTemplate.update(dept);
		return 1;
	}

	public int delete(Dept dept) {
		System.out.println("ht的地址=" + hibernateTemplate);
		hibernateTemplate.delete(dept);
		return 1;
	}

	public Dept getDeptByName(String name) {
		System.out.println("Dept="+name);
		List d = hibernateTemplate.find("from Dept where name='" + name + "'");
		return (Dept) d.get(0);
	}

}
