package com.rzpt.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.rzpt.entity.Task;

@Transactional
public class Task_Service {

	@Resource(name = "hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	public int insertTask(Task t) {
		Integer i;
		try {
			i = (Integer) hibernateTemplate.save(t);
			return i;
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public ArrayList getAllProject3s() {
		ArrayList list = (ArrayList) hibernateTemplate.find("find Task");
		return list;
	}

	public Task getTaskById(int id) {
		Task t = hibernateTemplate.get(Task.class, id);
		return t;
	}

	public void deleteTaskById(int id) {
		Task t = hibernateTemplate.get(Task.class, id);
		hibernateTemplate.delete(t);
	}

	public void updataTask(Task t) {
		try {
			hibernateTemplate.update(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
