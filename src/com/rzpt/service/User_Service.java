package com.rzpt.service;

import java.util.ArrayList;
import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.rzpt.entity.User;

@Transactional
public class User_Service {

	@Resource(name = "hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	public User getUserByNameAndPwd(String name, String pwd) {
		try {
			ArrayList list = (ArrayList) hibernateTemplate
					.find("from User where name='" + name + "' and pwd='" + pwd + "'");
			User user = (User) list.get(0);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public User getUserByUserame(String username) throws ArrayIndexOutOfBoundsException {
		return (User) hibernateTemplate.find("from User where name='" + username + "'").get(0);
	}

	public User getUserByName(String name) {
		return (User) hibernateTemplate.find("from User where name='" + name + "'").get(0);
	}

	public User getme(int id) {
		User u = hibernateTemplate.get(User.class, id);
		return u;
	}

	public ArrayList getDept() {
		ArrayList list = (ArrayList) hibernateTemplate.find("from Dept");
		return list;
	}

	public int insertUser(User u) {
		Integer n;
		n = (Integer) hibernateTemplate.save(u);
		return n;
	}

	public ArrayList getAllUsers() {
		ArrayList list = (ArrayList) hibernateTemplate.find("from User");
		return list;
	}

	public User getUserById(int id) {
		System.out.println("id=" + id);
		User u = hibernateTemplate.get(User.class, id);
		return u;
	}

	public void delUser(User u) {
		hibernateTemplate.delete(u);
	}

	public void update(User u) {
		hibernateTemplate.update(u);
	}

	public ArrayList getUsersByState(int state) {
		ArrayList list = (ArrayList) hibernateTemplate.find("from User where state=" + state);
		return list;
	}

}
