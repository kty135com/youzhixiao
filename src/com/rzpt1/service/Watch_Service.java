package com.rzpt1.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.rzpt.entity.Pro3;
import com.rzpt.entity.Watch;

public class Watch_Service {
	private HibernateTemplate hibernateTemplate;
	private SessionFactory sessionFactory;
	private Session session;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public int add(Watch watch) {
		hibernateTemplate.save(watch);
		return 1;
	}

	/**
	 * 判断观测点是否完成
	 * 
	 * @param watch_id
	 * @return
	 */
	public boolean HowAboutFinishByWatchId(int watch_id) {
		Watch w = getWatch(watch_id);
		if (w.getFinish_time() == "" || w.getFinish_time() == null) {
			return false;
		} else {
			return true;
		}
	}

	public List<Watch> getWatchListByPro3Id(int pro3_id) {
		try {
			return (List<Watch>) hibernateTemplate.find("from Watch where pro3_id =" + pro3_id);
		} catch (Exception e) {
			if (e instanceof IndexOutOfBoundsException) {
				System.out.println("数组越界，可能无查询值");
			} else {
				e.printStackTrace();
			}
			return null;
		}
	}

	public List<Watch> getFinishWatchListByPro3Id(int pro3_id) {
		try {
			return (List<Watch>) hibernateTemplate.find("from Watch where pro3_id =" + pro3_id + " and state = 5");
		} catch (Exception e) {
			if (e instanceof IndexOutOfBoundsException) {
				System.out.println("数组越界，可能无查询值");
			} else {
				e.printStackTrace();
			}
			return null;
		}
	}

	public List getUnfinishWatchs() {
		List list = hibernateTemplate.find("from Watch where state!=2 and state!=4 and state!=5");
		return list;
	}

	public List getFinishWatchs() {
		List list = hibernateTemplate.find("from Watch where state=2 and state = 4 and state = 5");
		return list;
	}

	public Watch getWatch(int id) {
		List list = hibernateTemplate.find("from Watch where id=" + id);
		return (Watch) list.get(0);
	}

	public void deleteWatch(Watch watch) {
		hibernateTemplate.delete(watch);
	}

	public int update(Watch watch) {
		Watch w = hibernateTemplate.get(Watch.class, watch.getId());
		w.setName(watch.getName());
		w.setNo(watch.getNo());
		w.setPlan_time(watch.getPlan_time());
		w.setContent(watch.getContent());
		w.setTask_id(watch.getTask_id());
		hibernateTemplate.update(w);
		return 1;
	}

	public int updata(Watch watch) {
		Watch w = hibernateTemplate.get(Watch.class, watch.getId());
		w.setName(watch.getName());
		w.setNo(watch.getNo());
		w.setPlan_time(watch.getPlan_time());
		w.setContent(watch.getContent());
		w.setTask_id(watch.getTask_id());
		w.setState(watch.getState());
		w.setFinish_time(watch.getFinish_time());
		hibernateTemplate.update(w);
		return 1;
	}

	public void updatee(Watch w) {
		hibernateTemplate.update(w);
	}

	public List otherUnallocated(int id) {
		String hql = "from Watch as w where w.dept_id in ( select u.dept_id from User as"
				+ " u where u.id=?) and w.user_id=null";
		List list = hibernateTemplate.find(hql, id);
		return list;
	}

	public List unallocated(int id) {
		String hql = "from Watch as w where w.pro3_id in ( select pro3.id from Pro3 as"
				+ " pro3 where pro3.user_id=?) and w.user_id=null";
		List list = hibernateTemplate.find(hql, id);
		return list;
	}

	public int allocate(Watch watch) {
		Watch w = hibernateTemplate.get(Watch.class, watch.getId());
		if (watch.getUser_id() != null) {
			w.setUser_id(watch.getUser_id());
		}
		if (watch.getUser1_id() != null) {
			w.setUser1_id(watch.getUser1_id());
		}
		if (watch.getUser2_id() != null) {
			w.setUser2_id(watch.getUser2_id());
		}
		if (watch.getDept_id() != null) {
			w.setDept_id(watch.getDept_id());
		}
		hibernateTemplate.update(w);
		return 1;
	}

	// 院部管理员查看未完成的观测点
	public List getUnfinishWatchsByDept(int id) {
		String hql = "from Watch where pro3_id in (select id from Pro3 where user_id=?) and state!=2 and state!=4 and state!=5 and user_id!=null";
		List list = hibernateTemplate.find(hql, id);
		return list;
	}

	// 院部管理员查看待验收的观测点
	public List getFinishWatchsByDept(int id) {
		String hql = "from Watch where pro3_id in (select id from Pro3 where user_id=?) and state=2";
		List list = hibernateTemplate.find(hql, id);
		return list;
	}

	// 院部管理员查看待审核的观测点
	public List getUnpend(int id) {
		String hql = "from Watch where pro3_id in (select id from Pro3 where user_id=?) and state=1";
		List list = hibernateTemplate.find(hql, id);
		System.out.println("list = " + list);
		return list;
	}

	// 院部管理员查看已验收的观测点
	public List getFinishWatchsByDept2(int id) {
		String hql = "from Watch where pro3_id in (select id from Pro3 where user_id=?) and state in (4,5)";
		List list = hibernateTemplate.find(hql, id);
		return list;
	}

	public List getUnfinishByTeacher(int id) {
		String hql = "from Watch where user_id=? and state in (0,3)";
		List list = hibernateTemplate.find(hql, id);
		return list;
	}

	public List getWatchsByState(int id, int state) {
		String hql = "from Watch where user_id=? and state=?";
		List list = hibernateTemplate.find(hql, new Object[] { id, state });
		return list;
	}

	public int getWatchByDept(int id) {
		ArrayList list = (ArrayList) hibernateTemplate.find("from Watch where dept_id=" + id);
		int i = list.size();
		return i;
	}

	public int getFinishWatchByDept(int id) {
		ArrayList list = (ArrayList) hibernateTemplate.find("from Watch where dept_id=" + id + " and state in(5)");
		int i = list.size();
		return i;
	}

	public ArrayList getFinishWatchByDept2(int id) {
		ArrayList list = (ArrayList) hibernateTemplate.find("from Watch where dept_id=" + id + " and state in(5)");
		return list;
	}

	public void updateState(int watch_id, int state) {
		Watch w = hibernateTemplate.get(Watch.class, watch_id);
		w.setState(state);
		hibernateTemplate.update(w);
	}

	public int pass(int id) {
		Watch w = hibernateTemplate.get(Watch.class, id);
		w.setState(2);
		hibernateTemplate.update(w);
		return 1;
	}

	public List queryUnAllocated(int id, String pro3Name) {
		String hql = "from Watch as w where w.pro3_id in ( select pro3.id from Pro3 as"
				+ " pro3 where pro3.user_id=? and pro3.name=?) and w.user_id=null";
		List list = hibernateTemplate.find(hql, new Object[] { id, pro3Name });
		return list;
	}

	public List queryUnpend(int id, String name) {
		String hql = "from Watch where pro3_id in (select id from Pro3 where user_id=?" + " and name=?) and state=1";
		List list = hibernateTemplate.find(hql, new Object[] { id, name });
		return list;
	}

	public List queryUnfinishWatchsByDept(int id, String name) {
		String hql = "from Watch where pro3_id in (select id from Pro3 where user_id=? and name=?) and state!=2 and user_id!=null";
		List list = hibernateTemplate.find(hql, new Object[] { id, name });
		return list;
	}

	public List queryFinishByDept(int id, String name) {
		String hql = "from Watch where pro3_id in (select id from Pro3 where user_id=? and name=?) and state=2";
		List list = hibernateTemplate.find(hql, new Object[] { id, name });
		return list;
	}

	public ArrayList getWatchByTask_id(int id) {
		ArrayList list = (ArrayList) hibernateTemplate.find("from Watch where task_id=" + id);
		return list;
	}

	public ArrayList getWatchByTask_idAndState(int id) {
		ArrayList list = (ArrayList) hibernateTemplate.find("from Watch where task_id=" + id + " and state =5");
		System.out.println("list=" + list);
		return list;
	}

	public int getWatchRate(String date1, String date2) throws ParseException {
		int dayss;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date d = sdf.parse(date1);
			Date d2 = sdf.parse(date2);
			dayss = (int) ((d2.getTime() - d.getTime()) / (1000 * 3600 * 24));
		} catch (Exception e) {
			dayss = 1;
		}
		return dayss;
	}

	public Pro3 getPro3ByPro3_id(int id) {
		Pro3 p = hibernateTemplate.get(Pro3.class, id);
		return p;
	}

	// 除数
	public int chushu(int id) {
		ArrayList list = (ArrayList) hibernateTemplate
				.find("select count(*) from Watch where pro3_id=" + id + " and state =5");
		String e = "" + list.get(0);
		int ee = Integer.parseInt(e);
		return ee;
	}

	// 被除数
	public int beichushu(int id) {
		ArrayList list = (ArrayList) hibernateTemplate.find("select count(*) from Watch where pro3_id=" + id);
		String e = "" + list.get(0);
		int ee = Integer.parseInt(e);
		return ee;
	}

	public void updataa(Pro3 pro3) {
		hibernateTemplate.update(pro3);
	}

	public int getAllCountByTask_id(int id) {
		List list = hibernateTemplate.find("select count(*) from Watch where task_id=?", id);
		String s = list.get(0).toString();
		return Integer.parseInt(s);
	}

	public int getMaxNo(int id) {
		List list = hibernateTemplate.find("select max(substring(no,9,2)) from Watch where task_id=?", id);
		String a = (String) list.get(0);
		return Integer.parseInt(a);
	}

	public List getWatchByNo(String no, int id) {
		List list = hibernateTemplate.find("from Watch where no=?", no);
		return list;
	}

	public int getRatesum(int id) {
		ArrayList list = (ArrayList) hibernateTemplate
				.find("select count(*) from Watch where finish_time < plan_time and state in (5) and dept_id=" + id);
		String sss = "" + list.get(0);
		return Integer.parseInt(sss);
	}

	public List getJoinWatch_id(Integer id) {
		String hql = "select id from Watch where (user1_id <> null or user2_id <> null) and (user1_id=? or user2_id=?) and state in (0,3)";
		List list = hibernateTemplate.find(hql, new Object[] { id, id });
		return list;
	}

	public List getJoinName(Integer id) {
		String hql = "select name from Watch where (user1_id <> null or user2_id <> null) and (user1_id=? or user2_id=?)  and state in (0,3)";
		List list = hibernateTemplate.find(hql, new Object[] { id, id });
		return list;
	}

	public List getJoinUser_name(Integer id) {
		Session session = getSession();
		System.out.println("session="+session);
		List list = session
				.createSQLQuery(
						"select user.realName from user right join watch on watch.user_id=user.id where (user1_id is not null or user2_id is not null) and (user1_id=?1 or user2_id=?2) group by watch.id")
				.setInteger("1", id).setInteger("2", id).list();
		// String hql="select user.name from User as user right join user.watch
		// as watch with watch.user_id=user.id where (watch.user1_id <> null or
		// watch.user2_id <> null) and (watch.user1_id=? or watch.user2_id=?)
		// group by watch.id";
		// List list=hibernateTemplate.find(hql,new Object[]{id,id});
		System.out.println("session是否关闭="+session);
		return list;
	}

	public List getJoinUser1_name(Integer id) {
		List list = getSession()
				.createSQLQuery("select user.realName from user right join watch on watch.user1_id=user.id where ("
						+ "user1_id is not null or user2_id is not null or user3_id is not null or user4_id is not null or user5_id is not null) and (user1_id=?1 or user2_id=?2 or user3_id=?3 or user4_id=?4 or user5_id=?5) group by watch.id")
				.setInteger("1", id).setInteger("2", id).setInteger("3", id).setInteger("4", id).setInteger("5", id)
				.list();
		// String hql="select user.name from User as user right join user.watch
		// as watch with watch.user1_id=user.id where (user1_id <> null or
		// user2_id <> null) and (user1_id=? or user2_id=?) group by watch.id";
		// List list=hibernateTemplate.find(hql,new Object[]{id,id});
		return list;
	}

	public List getJoinUser2_name(Integer id) {
		List list = getSession()
				.createSQLQuery("select user.realName from user right join watch on watch.user2_id=user.id where ("
						+ "user1_id is not null or user2_id is not null or user3_id is not null or user4_id is not null or user5_id is not null) and (user1_id=?1 or user2_id=?2 or user3_id=?3 or user4_id=?4 or user5_id=?5) group by watch.id")
				.setInteger("1", id).setInteger("2", id).setInteger("3", id).setInteger("4", id).setInteger("5", id)
				.list();

		// String hql="select user.name from User as user right join user.watch
		// as watch with watch.user2_id=user.id where (user1_id <> null or
		// user2_id <> null) and (user1_id=? or user2_id=?) group by watch.id";
		// List list=hibernateTemplate.find(hql,new Object[]{id,id});
		return list;
	}

	public List getJoinUser3_name(Integer id) {
		List list = getSession()
				.createSQLQuery("select user.realName from user right join watch on watch.user3_id=user.id where ("
						+ "user1_id is not null or user2_id is not null or user3_id is not null or user4_id is not null or user5_id is not null) and (user1_id=?1 or user2_id=?2 or user3_id=?3 or user4_id=?4 or user5_id=?5) group by watch.id")
				.setInteger("1", id).setInteger("2", id).setInteger("3", id).setInteger("4", id).setInteger("5", id)
				.list();

		// String hql="select user.name from User as user right join user.watch
		// as watch with watch.user2_id=user.id where (user1_id <> null or
		// user2_id <> null) and (user1_id=? or user2_id=?) group by watch.id";
		// List list=hibernateTemplate.find(hql,new Object[]{id,id});
		return list;
	}

	public List getJoinUser4_name(Integer id) {
		List list = getSession()
				.createSQLQuery("select user.realName from user right join watch on watch.user4_id=user.id where ("
						+ "user1_id is not null or user2_id is not null or user3_id is not null or user4_id is not null or user5_id is not null) and (user1_id=?1 or user2_id=?2 or user3_id=?3 or user4_id=?4 or user5_id=?5) group by watch.id")
				.setInteger("1", id).setInteger("2", id).setInteger("3", id).setInteger("4", id).setInteger("5", id)
				.list();

		// String hql="select user.name from User as user right join user.watch
		// as watch with watch.user2_id=user.id where (user1_id <> null or
		// user2_id <> null) and (user1_id=? or user2_id=?) group by watch.id";
		// List list=hibernateTemplate.find(hql,new Object[]{id,id});
		return list;
	}

	public List getJoinUser5_name(Integer id) {
		List list = getSession()
				.createSQLQuery("select user.realName from user right join watch on watch.user5_id=user.id where ("
						+ "user1_id is not null or user2_id is not null or user3_id is not null or user4_id is not null or user5_id is not null) and (user1_id=?1 or user2_id=?2 or user3_id=?3 or user4_id=?4 or user5_id=?5) group by watch.id")
				.setInteger("1", id).setInteger("2", id).setInteger("3", id).setInteger("4", id).setInteger("5", id)
				.list();

		// String hql="select user.name from User as user right join user.watch
		// as watch with watch.user2_id=user.id where (user1_id <> null or
		// user2_id <> null) and (user1_id=? or user2_id=?) group by watch.id";
		// List list=hibernateTemplate.find(hql,new Object[]{id,id});
		return list;
	}

	public List getJoinTask_name(Integer id) {
		List list = getSession()
				.createSQLQuery(
						"select task.name from task right join watch on watch.task_id=task.id where (user1_id is not null or user2_id is not null) and (user1_id=?1 or user2_id=?2) group by watch.id")
				.setInteger("1", id).setInteger("2", id).list();
		// String hql="select task.name from Task as task right join task.watch
		// as watch with watch.task_id=task.id where (user1_id <> null or
		// user2_id <> null) and (user1_id=? or user2_id=?) group by watch.id";
		// List list=hibernateTemplate.find(hql,new Object[]{id,id});
		return list;
	}
}
