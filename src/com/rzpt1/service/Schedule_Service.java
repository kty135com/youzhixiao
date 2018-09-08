package com.rzpt1.service;

import java.util.ArrayList;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.rzpt.entity.Schedule;

public class Schedule_Service {
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public int add(Schedule schedule) {
		try {
			System.out.println("schedule=" + schedule);
			hibernateTemplate.save(schedule);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	public Schedule getScheduleById(int id) {
		return (Schedule) hibernateTemplate.find("from Schedule where id =" + id).get(0);
	}

	public ArrayList getScheduleByWatchId(int id) {
		ArrayList list = (ArrayList) hibernateTemplate.find("from Schedule where watch_id=" + id);
		return list;
	}

	public ArrayList getScheduleByWatchIddaoxu(int id) {
		System.out.println("idddd="+id);
		ArrayList list = (ArrayList) hibernateTemplate
				.find("from Schedule where watch_id=" + id + "order by time desc");
		return list;
	}
	
	public void delScheduleById(int id) {
		if(id!=0){
			hibernateTemplate.delete(getScheduleById(id));
		}
	}

}
