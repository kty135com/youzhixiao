package com.rzpt.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.rzpt.entity.Pro1;

@Transactional
public class Pro1_Service {

	@Resource(name = "hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/**
	 * 通过pro1_id获取其下所有已验收观测点的个数
	 * 
	 * @param id
	 * @return
	 */
	public int getAllfenziByPro1_id(int id) {
		try {
			Pro1 p1 = (Pro1) hibernateTemplate.find("from Pro1 where id =" + id).get(0);
			int i = (int) hibernateTemplate.find("from Watch where state = 5 and no like '" + p1.getNo() + "%'").size();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * 通过pro1_id获取其下所有观测点的个数
	 * 
	 * @param id
	 * @return
	 */
	public int getAllfenmuByPro1_id(int id) {
		try {
			Pro1 p1 = (Pro1) hibernateTemplate.find("from Pro1 where id =" + id).get(0);
			int i = (int) hibernateTemplate.find("from Watch where no like '" + p1.getNo() + "%'").size();
			System.out.println("-=- fenmui= " + i);
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int insertProject1(Pro1 project1) {
		Integer n = 0;
		try {
			n = (Integer) hibernateTemplate.save(project1);
			return n;
		} catch (Exception ioe) {
			return 0;
		}
	}

	public ArrayList getAllProject1s() {
		ArrayList list = (ArrayList) hibernateTemplate.find("from Pro1 order by no");
		return list;
	}

	// 重点专业
	public ArrayList getAllProject1sBy1() {
		ArrayList list = (ArrayList) hibernateTemplate.find("from Pro1 where no between '21' and '25' order by no");
		return list;
	}

	// 公共项目
	public ArrayList getAllProject1sBy2() {
		ArrayList list = (ArrayList) hibernateTemplate.find("from Pro1 where no between '01' and '08' order by no");
		return list;
	}

	// 特色项目
	public ArrayList getAllProject1sBy3() {
		ArrayList list = (ArrayList) hibernateTemplate.find("from Pro1 where no between '91' and '92' order by no");
		return list;
	}

	public Pro1 getProject1ById(int id) {
		Pro1 project1 = hibernateTemplate.get(Pro1.class, id);
		return project1;
	}

	public void deleteProject1ById(int id) {
		Pro1 project1 = hibernateTemplate.get(Pro1.class, id);
		hibernateTemplate.delete(project1);
	}

	public int updataProject1(Pro1 p1) {
		try {
			hibernateTemplate.update(p1);
		} catch (Exception e) {
			e.getStackTrace();
			return 0;
		} finally {
			return 1;
		}
	}

	public ArrayList getUsersByState1() {
		ArrayList list = (ArrayList) hibernateTemplate.find("from User where state=1");
		return list;
	}

	public ArrayList getUsersByState1AndNoPro1() {
		String hql = "from User where id not in (select user_id from Pro1 where user_id !=null) and state=1";
		ArrayList list = (ArrayList) hibernateTemplate.find(hql);
		return list;
	}

	public Pro1 getPro1ByUser_id(int id) {
		ArrayList list = (ArrayList) hibernateTemplate.find("from Pro1 where user_id=" + id);
		Pro1 pro1 = (Pro1) list.get(0);
		return pro1;
	}

	public ArrayList getAllProject1sByState0() {
		ArrayList list = (ArrayList) hibernateTemplate.find("from Pro1 where state=0");
		return list;
	}

	public ArrayList getAllProject1sByState1() {
		ArrayList list = (ArrayList) hibernateTemplate.find("from Pro1 where state=1");
		return list;
	}

	public int getAllCount() {
		List list = hibernateTemplate.find("select count(*) from Pro1");
		String a = list.get(0).toString();
		return Integer.parseInt(a);
	}

	public int getMaxNo() {
		List list = hibernateTemplate.find("select max(substring(no,1,2)) from Pro1");
		String a = (String) list.get(0);
		return Integer.parseInt(a);
	}

	public List getProject1ByNo(String no) {
		List list = hibernateTemplate.find("from Pro1 where no=" + no + "");
		System.out.println("list======" + list.get(0));
		return list;
	}
}
