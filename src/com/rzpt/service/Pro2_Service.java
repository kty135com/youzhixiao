package com.rzpt.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.rzpt.entity.Pro1;
import com.rzpt.entity.Pro2;

@Transactional
public class Pro2_Service {

	@Resource(name = "hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	public int insertProject2(Pro2 p2) {
		Integer i;
		try {
			if (p2.getSchedule() == null) {
				p2.setSchedule("0%");
			}
			i = (Integer) hibernateTemplate.save(p2);
			return i;
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public void updatePro2(Pro2 pro2) {
		hibernateTemplate.update(pro2);
	}

	/**
	 * 通过pro2_id获取其下所有已验收观测点的个数
	 * 
	 * @param id
	 * @return
	 */
	public int getAllfenziByPro2_id(int id) {
		try {
			Pro2 p2 = (Pro2) hibernateTemplate.find("from Pro2 where id =" + id).get(0);
			System.out.println("p2====" + p2);
			int i = (int) hibernateTemplate.find("from Watch where state = 5 and no like '" + p2.getNo() + "%'").size();
			System.out.println("i======" + i);
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * 通过pro2_id获取其下所有观测点的个数
	 * 
	 * @param id
	 * @return
	 */
	public int getAllfenmuByPro2_id(int id) {
		try {
			Pro2 p2 = (Pro2) hibernateTemplate.find("from Pro2 where id =" + id).get(0);
			int i = (int) hibernateTemplate.find("from Watch where no like '" + p2.getNo() + "%'").size();
			System.out.println("pro2.no=" + p2.getNo());
			if (p2.getNo() == "0201") {
				System.out.println("-------" + i);
			}
			System.out.println("i=i= " + i);
			return i;
		} catch (Exception e) {
			if (e instanceof IndexOutOfBoundsException) {
				System.out.println("数组越界异常,可能没有值");
			} else {
				e.printStackTrace();
			}
			return 0;
		}
	}

	public Pro2 getPro2ByNo2(int no) {
		return (Pro2) hibernateTemplate.find("from Pro2 where no=" + no).get(0);
	}

	public ArrayList getAllProject2s() {
		ArrayList list = (ArrayList) hibernateTemplate.find("from Pro2");
		return list;
	}

	public Pro2 getProject2ById(int id) {
		Pro2 project2 = hibernateTemplate.get(Pro2.class, id);
		return project2;
	}

	public ArrayList getProject2sByPro1_id(int id) {
		ArrayList list = (ArrayList) hibernateTemplate.find("from Pro2 where pro1_id=" + id);
		return list;
	}

	public void deleteProject2ById(int id) {
		Pro2 project2 = hibernateTemplate.get(Pro2.class, id);
		hibernateTemplate.delete(project2);
	}

	public void updataProject2(Pro2 p2) {
		try {
			hibernateTemplate.update(p2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList getUsersByState2() {
		ArrayList list = (ArrayList) hibernateTemplate.find("from User where state=2");
		return list;
	}

	public ArrayList getPro2ByUser_id0AndPro1_id(int id) {
		ArrayList list = (ArrayList) hibernateTemplate.find("from Pro2 where user_id=null and pro1_id=" + id);
		return list;
	}

	public ArrayList getPro2ByUser_idAndPro1_id(int id) {
		ArrayList list = (ArrayList) hibernateTemplate.find("from Pro2 where user_id !=null and pro1_id=" + id);
		return list;
	}

	public Pro1 getPro1ByUser_id(int id) {
		ArrayList list = (ArrayList) hibernateTemplate.find("from Pro1 where user_id=" + id);
		Pro1 pro1 = (Pro1) list.get(0);
		return pro1;
	}

	public ArrayList getPro2sByPro1_id(int id) {
		ArrayList list = (ArrayList) hibernateTemplate.find("from Pro2 where pro1_id=" + id);
		return list;
	}

	public String getPro2ByUser_id(int id) {
		ArrayList list = (ArrayList) hibernateTemplate.find("from Pro2 where user_id=" + id);
		String s = "";
		for (int i = 0; i < list.size(); i++) {
			Pro2 p = (Pro2) list.get(i);
			s = s + (i + 1) + ":" + p.getName() + "; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
		}
		return s;
	}

	public ArrayList getPro2sByUser_id(int id) {
		ArrayList list = (ArrayList) hibernateTemplate.find("from Pro2 where user_id=" + id);
		return list;
	}

	public int getAllCountByPro1_id(Integer id) {
		List list = hibernateTemplate.find("select count(*) from Pro2 where pro1_id=?", id);
		String s = list.get(0).toString();
		return Integer.parseInt(s);
	}

	public int getMaxNo(Integer id) {
		List list = hibernateTemplate.find("select max(substring(no,3,2)) from Pro2 where pro1_id=?", id);
		String a = (String) list.get(0);
		return Integer.parseInt(a);
	}

	public List getProject2ByNo(String no, Integer id) {
		List list = hibernateTemplate.find("from Pro2 where no=? and pro1_id=?", new Object[] { no, id });
		return list;
	}

	public ArrayList getProject2sByPro1_idAndState(int id) {
		ArrayList list = (ArrayList) hibernateTemplate.find("from Pro2 where pro1_id=" + id + " and state=2");
		return list;
	}

}
