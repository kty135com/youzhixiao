package com.rzpt1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.rzpt.entity.Pro2;
import com.rzpt.entity.Pro3;

public class Pro3_Service {
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public List getAllPro3s() {
		String hql = "from Pro3 where schedule!='100%'";
		List list = hibernateTemplate.find(hql);
		return list;
	}
	
	public void updatePro3(Pro3 pro3) {
		hibernateTemplate.update(pro3);
	}

	public Pro3 getPro3ByNo(int no){
		return (Pro3) hibernateTemplate.find("from Pro3 where no="+no).get(0);
	}
	
	public ArrayList getPro3sByPro2_id(int id) {
		ArrayList list = (ArrayList) hibernateTemplate
				.find("from Pro3 where pro2_id=" + id);
		return list;
	}

	public int getProject3sByPro2_id(int id) {
		ArrayList list = (ArrayList) hibernateTemplate
				.find("select count(*) from Pro3 where pro2_id=" + id);
		String e=""+list.get(0);
		int ee=Integer.parseInt(e);
		return ee;
	}
	
	public int getProject3sByPro2_idAndState(int id) {
		ArrayList list = (ArrayList) hibernateTemplate
				.find("select count(*) from Pro3 where pro2_id=" + id+" and state=2");
		String e=""+list.get(0);
		int ee=Integer.parseInt(e);
		return ee;
	}

	public Pro3 getPro3ById(int pro3_id) {
		Pro3 pro3=hibernateTemplate.get(Pro3.class, pro3_id);
		return pro3;
	}
}
