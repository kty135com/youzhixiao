package com.rzpt1.service;



import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.rzpt.entity.User;

public class User_Service {
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public User getUserById(Integer user_id) {
		System.out.println("userid="+user_id+"ht="+hibernateTemplate);
		if(user_id==null){
			return null;
		}else {
			User user=hibernateTemplate.get(User.class, user_id);
			return user;	
		}
	}
	public User getUserByrealName(String name){
		try{
			return (User) hibernateTemplate.find("from User where realName='"+name+"'").get(0);
		}catch (Exception e) {
			return null;
		}
	}

	public List getTeachersByDept(int id) {
		String hql="from User as u where u.dept_id in (select u2.dept_id from User as u2 where u2.id=?) and u.state=3";
		List list=hibernateTemplate.find(hql, id);
		return list;
 		
	}

	public List getTeachersByDept_id(int id) {
		String hql="from User where dept_id=? and state=3";
		List list=hibernateTemplate.find(hql, id);
		return list;
	}

	public User getUser1ById(Integer user1_id) {
		if(user1_id==null){
			return null;
		}else {
			User user=hibernateTemplate.get(User.class, user1_id);
			return user;	
		}
	}
	public User getUser2ById(Integer user2_id) {
		if(user2_id==null){
			return null;
		}else {
			User user=hibernateTemplate.get(User.class, user2_id);
			return user;	
		}
	}

}
