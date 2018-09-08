package com.rzpt.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.rzpt.entity.Pro1;
import com.rzpt.entity.Pro2;
import com.rzpt.entity.Pro3;
import com.rzpt.entity.Task;
import com.rzpt.entity.Watch;

@Transactional
public class Pro3_Service {

	@Resource(name = "hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	public int insertProject3(Pro3 p3) {
		Integer i;
		try {
			if (p3.getSchedule() == null) {
				p3.setSchedule("0%");
			}
			i = (Integer) hibernateTemplate.save(p3);
			return i;
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	/**
	 * 通过查询三级项目下所有观测点的实际投入，获取三级项目的总实际投入
	 */
	public double getAllRealMoneyByPro3Id(int id) {
		double money = 0;
		if (id != 0) {
			try {
				List<Watch> ws = (List<Watch>) hibernateTemplate.find("from Watch where pro3_id=" + id);
				for (Watch w : ws) {
					try{
						money = money + w.getRealMoney();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			} catch (Exception e) {
				if (e instanceof IndexOutOfBoundsException) {
					System.out.println("数组越界");
				} else {
					e.printStackTrace();
				}
			} finally {
				return money;
			}
		} else {
			return 0;
		}
	}

	/**
	 * 通过pro3_id获取其下所有已验收观测点的个数
	 * 
	 * @param id
	 * @return
	 */
	public int getAllfenziByPro3_id(int id) {
		try {
			Pro3 p3 = (Pro3) hibernateTemplate.find("from Pro3 where id =" + id).get(0);
			return (int) hibernateTemplate.find("from Watch where state = 5 and no like '" + p3.getNo() + "%'").size();
		} catch (Exception e) {
			if (e instanceof IndexOutOfBoundsException) {
				System.out.println("数组越界，可能没有数据");
			} else {
				e.printStackTrace();
			}
			return 0;
		}
	}

	/**
	 * 通过pro3_id获取其下所有观测点的个数
	 * 
	 * @param id
	 * @return
	 */
	public int getAllfenmuByPro3_id(int id) {
		try {
			Pro3 p3 = (Pro3) hibernateTemplate.find("from Pro3 where id =" + id).get(0);
			return (int) hibernateTemplate.find("from Watch where no like '" + p3.getNo() + "%'").size();
		} catch (Exception e) {
			if (e instanceof IndexOutOfBoundsException) {
				System.out.println("数组越界，可能没有数据");
			} else {
				e.printStackTrace();
			}
			return 0;
		}
	}

	public ArrayList getAllProject3s() {
		ArrayList list = (ArrayList) hibernateTemplate.find("from Pro3");
		return list;
	}

	public Pro3 getProject3ById(int id) {
		Pro3 project3 = hibernateTemplate.get(Pro3.class, id);
		return project3;
	}

	public void deleteProject3ById(int id) {
		Pro3 project3 = hibernateTemplate.get(Pro3.class, id);
		hibernateTemplate.delete(project3);
	}

	public void updataProject3(Pro3 p3) {
		try {
			hibernateTemplate.update(p3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList getProject3sByPro2_id(int id) {
		ArrayList list = (ArrayList) hibernateTemplate.find("from Pro3 where pro2_id=" + id);
		return list;
	}

	public ArrayList getUsersByState3() {
		ArrayList list = (ArrayList) hibernateTemplate.find("from User where state=3");
		return list;
	}

	public ArrayList getTasksByPro3_id(int id) {
		ArrayList list = (ArrayList) hibernateTemplate.find("from Task where pro3_id=" + id);
		return list;
	}

	public ArrayList getWatchsByTask_id(int id) {
		ArrayList list = (ArrayList) hibernateTemplate.find("from Watch where task_id=" + id);
		return list;
	}

	public int getWatchByPro3_idAndState(int id) {
		ArrayList list = (ArrayList) hibernateTemplate
				.find("select count(*) from Watch where pro3_id=" + id + " and state !=2");
		String n = "" + list.get(0);
		int nn = Integer.parseInt(n);
		return nn;
	}

	public int getWatchByPro3_id(int id) {
		ArrayList list = (ArrayList) hibernateTemplate.find("select count(*) from Watch where pro3_id=" + id);
		String n = "" + list.get(0);
		int nn = Integer.parseInt(n);
		return nn;
	}

	public int getWatchByPro3_idAndState2(int id) {
		ArrayList list = (ArrayList) hibernateTemplate
				.find("select count(*) from Watch where pro3_id=" + id + " and state =2");
		String n = "" + list.get(0);
		int nn = Integer.parseInt(n);
		return nn;
	}

	public int getAllCountByPro2_id(Integer id) {
		List list = hibernateTemplate.find("select count(*) from Pro3 where pro2_id=?", id);
		String s = list.get(0).toString();
		return Integer.parseInt(s);
	}

	public int getMaxNo(Integer id) {
		List list = hibernateTemplate.find("select max(substring(no,5,2)) from Pro3 where pro2_id=?", id);
		String a = (String) list.get(0);
		return Integer.parseInt(a);
	}

	public List getProject3ByNo(String no, Integer id) {
		List list = hibernateTemplate.find("from Pro3 where no=? and pro2_id=?", new Object[] { no, id });
		return list;
	}

	public ArrayList getWatchspendByPro(int id) {
		ArrayList list = (ArrayList) hibernateTemplate
				.find("from Watch where pro3_id in (select id from Pro3 where pro2_id in (select id from Pro2 where pro1_id="
						+ id + ")) and state=4");
		return list;
	}

	public ArrayList getWatchspendByPro11(int id) { // 按项目统计
		ArrayList list = (ArrayList) hibernateTemplate
				.find("from Watch where pro3_id in (select id from Pro3 where pro2_id in (select id from Pro2 where pro1_id="
						+ id + ")) and state in(2,4)");
		return list;
	}

	public ArrayList getWatchspendByPro22(int id) {
		ArrayList list = (ArrayList) hibernateTemplate
				.find("from Watch where pro3_id in (select id from Pro3 where pro2_id=" + id + ") and state in(2,4)");
		return list;
	}

	public ArrayList getWatchspendByPro33(int id) {
		ArrayList list = (ArrayList) hibernateTemplate.find("from Watch where pro3_id=" + id + " and state in(2,4)");
		return list;
	}

	public ArrayList getWatchspendByPro1(Integer pro2_id) {
		ArrayList list = (ArrayList) hibernateTemplate
				.find("from Watch where pro3_id in (select id from Pro3 where pro2_id=" + pro2_id + ") and state=4 order by no");
		return list;
	}
	
	public ArrayList getWatchspendByPro1State3(Integer pro2_id) {
		ArrayList list = (ArrayList) hibernateTemplate
				.find("from Watch where pro3_id in (select id from Pro3 where pro2_id=" + pro2_id + ") and state=3 order by no");
		return list;
	}
	
	public ArrayList getWatchspendByPro1State2(Integer pro2_id) {
		ArrayList list = (ArrayList) hibernateTemplate
				.find("from Watch where pro3_id in (select id from Pro3 where pro2_id=" + pro2_id + ") and state=2 order by no");
		return list;
	}

	public ArrayList getWatchspendByPro2(int id) {
		ArrayList list = (ArrayList) hibernateTemplate.find("from Watch where pro3_id =" + id + " and state=4 order by no");
		return list;
	}
	
	public ArrayList getWatchspendByPro2State3(int id) {
		ArrayList list = (ArrayList) hibernateTemplate.find("from Watch where pro3_id =" + id + " and state=3 order by no");
		return list;
	}
	
	public ArrayList getWatchspendByPro2State2(int id) {
		ArrayList list = (ArrayList) hibernateTemplate.find("from Watch where pro3_id =" + id + " and state=2 order by no");
		return list;
	}

	public ArrayList getWatchspendByPro3(int id) {
		ArrayList list = (ArrayList) hibernateTemplate.find("from Watch where task_id=" + id + " and state=4 order by no");
		return list;
	}
	
	public ArrayList getWatchspendByPro3State3(int id) {
		ArrayList list = (ArrayList) hibernateTemplate.find("from Watch where task_id=" + id + " and state=3 order by no");
		return list;
	}
	
	public ArrayList getWatchspendByPro3State2(int id) {
		ArrayList list = (ArrayList) hibernateTemplate.find("from Watch where task_id=" + id + " and state=2 order by no");
		return list;
	}
}
