package com.rzpt.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.rzpt.entity.Dept;
import com.rzpt.entity.User;

public class Dept_Service {

	@Resource(name = "hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	public int insertDepartment(Dept d) {
		Integer i;
		try {
			i = (Integer) hibernateTemplate.save(d);
			return i;
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public ArrayList getAllDepartments() {
		ArrayList list = (ArrayList) hibernateTemplate.find("from Dept");
		System.out.println("getAllDepartments.list=" + list.size());
		return list;
	}

	public List getDepartmentsByPage(int page) {
		return hibernateTemplate.find("from Dept limit " + (page - 1) + ",10");
	}

	public Dept getDepartmentById(int id) {
		Dept d = hibernateTemplate.get(Dept.class, id);
		return d;
	}

	public void deleteDepartmentById(int id) {
		System.out.println("ht的地址=" + hibernateTemplate);
		Dept d = hibernateTemplate.get(Dept.class, id);
		hibernateTemplate.delete(d);
	}

	public void updataDepartment(Dept d) {
		try {
			hibernateTemplate.update(d);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Dept getDeptByName(String name) {
		System.out.println("ht的地址=" + hibernateTemplate);
		List d = hibernateTemplate.find("from Dept where name='" + name + "'");
		System.out.println("集合=" + d);
		return (Dept) d.get(0);
	}
}
