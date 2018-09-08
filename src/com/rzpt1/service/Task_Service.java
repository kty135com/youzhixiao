package com.rzpt1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.rzpt.entity.Task;

public class Task_Service {
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public int add(Task task) {
		hibernateTemplate.save(task);
		return 1;
	}

	public List getAllTask() {
		List list = hibernateTemplate.find("from Task");
		return list;
	}

	public Task getTask(int id) {
		List list = hibernateTemplate.find("from Task where id=" + id);
		Task task = (Task) list.get(0);
		return task;
	}

	public int update(Task task) {
		hibernateTemplate.saveOrUpdate(task);
		return 1;
	}

	public int delete(Task task) {
		hibernateTemplate.delete(task);
		return 1;
	}

	public Task getTaskByNo2(int no) {
		return (Task) hibernateTemplate.find("from Task where no=" + no).get(0);
	}

	public Task getTaskById(int task_id) {
		Task task = hibernateTemplate.get(Task.class, task_id);
		return task;
	}

	public int getPro3_idById(int task_id) {
		List list = hibernateTemplate.find("select t.pro3_id from Task as t where id=?", task_id);
		return (Integer) list.get(0);
	}

	public ArrayList getAllTaskByPro3_id(int id) {
		try {
			ArrayList list = (ArrayList) hibernateTemplate.find("from Task where pro3_id=" + id);
			return list;
		} catch (Exception e) {
			if (e instanceof IndexOutOfBoundsException) {
				System.out.println("数组越界");
			} else {
				e.printStackTrace();
			}
			return null;
		}
	}

	public Task get18taskBypro3Id(int id) {
		try {
			return (Task) hibernateTemplate.find("from Task where pro3_id=" + id + "and moment = 0").get(0);
		} catch (Exception e) {
			if (e instanceof IndexOutOfBoundsException) {
				System.out.println("数组越界");
			} else {
				e.printStackTrace();
			}
			return null;
		}
	}
	
	public Task get19taskBypro3Id(int id) {
		try {
			return (Task) hibernateTemplate.find("from Task where pro3_id=" + id + "and moment = 1").get(0);
		} catch (Exception e) {
			if (e instanceof IndexOutOfBoundsException) {
				System.out.println("数组越界");
			} else {
				e.printStackTrace();
			}
			return null;
		}
	}

	public ArrayList getTasksByPro3_id(int id) {
		ArrayList list = (ArrayList) hibernateTemplate.find("from Task where pro3_id=" + id);
		return list;
	}

	public ArrayList<Task> getMomentByPro3_id(int id) {
		ArrayList<Task> list = (ArrayList<Task>) hibernateTemplate.find("from Task where pro3_id=" + id);
		for (int i = 0; i < list.size(); i++) {
			Task t = (Task) list.get(i);
			if (t.getMoment() == 0) {
				t.setMo("中期(2018)");
			} else {
				t.setMo("验收期(2019)");
			}

		}
		return list;
	}

	public int getAllCountByPro3_id(Integer id) {
		List list = hibernateTemplate.find("select count(*) from Task where pro3_id=?", id);
		String s = list.get(0).toString();
		return Integer.parseInt(s);
	}

	public int getMaxNo(Integer id) {
		List list = hibernateTemplate.find("select max(substring(no,7,2)) from Task where pro3_id=?", id);
		String a = (String) list.get(0);
		return Integer.parseInt(a);
	}

	public List getTaskByNo(String no, Integer id) {
		List list = hibernateTemplate.find("from Task where no=? and pro3_id=?", new Object[] { no, id });
		return list;
	}
}
