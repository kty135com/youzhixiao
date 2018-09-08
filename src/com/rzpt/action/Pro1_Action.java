package com.rzpt.action;

import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.rzpt.dto.Pro1s;
import com.rzpt.entity.Dept;
import com.rzpt.entity.Pro1;
import com.rzpt.entity.Pro2;
import com.rzpt.entity.Pro3;
import com.rzpt.entity.Task;
import com.rzpt.entity.User;
import com.rzpt.entity.Watch;
import com.rzpt.entity.Wenjian;
import com.rzpt.entity.WenjianFile;
import com.rzpt.service.Dept_Service;
import com.rzpt.service.Pro1_Service;
import com.rzpt.service.Pro2_Service;
import com.rzpt.service.Pro3_Service;
import com.rzpt.service.User_Service;
import com.rzpt1.service.Chengguo_Service;
import com.rzpt1.service.Task_Service;
import com.rzpt1.service.Watch_Service;

public class Pro1_Action extends ActionSupport implements SessionAware {

	@Resource(name = "project1_Service")
	private Pro1_Service project1_Service;

	@Resource(name = "project1")
	private Pro1 project1;

	@Resource(name = "project2")
	private Pro2 project2;

	@Resource(name = "project2_Service")
	private Pro2_Service project2_Service;

	@Resource(name = "user")
	private User user;

	@Resource(name = "project3_Service")
	private Pro3_Service project3_Service;

	@Resource(name = "ChengguoService")
	private Chengguo_Service chengguoService;

	@Resource(name = "watchService")
	private Watch_Service watchService;

	@Resource(name = "taskService")
	private Task_Service taskService;

	@Resource(name = "user_Service")
	private User_Service user_Service;

	@Resource(name = "department_Service")
	private Dept_Service department_Service;

	@Resource(name = "hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	@Resource(name = "department")
	private Dept department;

	private int qqq;
	NumberFormat num;
	private ArrayList list;
	private ArrayList list2;
	private ArrayList list3;
	private ArrayList list4;
	private ArrayList list5;
	private ArrayList list6;
	private ArrayList p1list;
	private Map<String, Object> session;
	private String error;
	private Pro1 p1;
	private Pro1 p2;
	private Pro1 p3;
	private Pro1 p4;
	private Pro1 p5;
	private Pro1 p6;
	private Pro1 p7;
	private Pro1 p8;
	private Pro1 p9;
	private Pro1 p10;
	private Pro1 p11;
	private Pro1 p12;
	private Pro1 p13;
	private Pro1 p14;
	private Pro1 p15;

	public String view() {
		double watchsum = 0;
		double finishsum = 0;
		list = project1_Service.getAllProject1s(); // 一级项目集合
		System.out.println("list=" + list.size());
		for (int i = 0; i < list.size(); i++) {
			Pro1 p1 = (Pro1) list.get(i);
			p1list = project2_Service.getPro2sByPro1_id(p1.getId()); // 二级项目集合
			ArrayList llist = project3_Service.getWatchspendByPro11(p1.getId()); // pro1下watch的完成的总数
			double ratesum4 = 0;
			for (int i2 = 0; i2 < p1list.size(); i2++) {
				Pro2 p2 = (Pro2) p1list.get(i2);
				list2 = project3_Service.getProject3sByPro2_id(p2.getId());
				int ratesum3 = 0;
				for (int i3 = 0; i3 < list2.size(); i3++) {
					Pro3 p3 = (Pro3) list2.get(i3);
					list3 = taskService.getTasksByPro3_id(p3.getId());
					int ratesum2 = 0;
					for (int i4 = 0; i4 < list3.size(); i4++) {
						Task t = (Task) list3.get(i4);
						list4 = watchService.getWatchByTask_id(t.getId());
						watchsum = list4.size() + watchsum;
						list5 = watchService.getWatchByTask_idAndState(t.getId());
						finishsum = list5.size() + finishsum;
						int ratesum = 0;
						for (int i5 = 0; i5 < list4.size(); i5++) {
							Watch w = (Watch) list4.get(i5);
							try {
								int n = watchService.getWatchRate(w.getPlan_time(), w.getFinish_time());
								w.setRate(n);
								if (n <= 0) {
									ratesum = ratesum + 1;
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						try {
							t.setRate(ratesum / list5.size());
							ratesum2 = ratesum + ratesum2;
						} catch (Exception e) {
							t.setRate(0);
						}
					}
					try {
						ratesum3 = ratesum2 + ratesum3;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				try {
					ratesum4 = ratesum3 + ratesum4;
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			num = NumberFormat.getPercentInstance();
			num.setMaximumIntegerDigits(3);
			num.setMaximumFractionDigits(2);
			if (llist.size() != 0) {
				String ss = num.format((ratesum4 / (double) llist.size()));
				p1.setRate(ss);
			} else {
				p1.setRate("0%");
			}
			p1.setWatchsum((int) watchsum);
			p1.setFinishsum((int) finishsum);
			if (watchsum != 0) {
				String ss = num.format(finishsum / watchsum);
				p1.setFinishratio(ss);
			} else {
				p1.setFinishratio("0%");
			}
			watchsum = finishsum = 0;
		}
		for (int i = 0; i < list.size(); i++) {
			Pro1 p = (Pro1) list.get(i);
			if (p.getId() == id) {
				project1 = p;
			}
		}
		return "p1";
	}

	public String view2() {
		double watchsum = 0;
		double finishsum = 0;
		project2 = project2_Service.getProject2ById(id);
		list = project2_Service.getPro2sByPro1_id(project2.getPro1_id());
		for (int i2 = 0; i2 < list.size(); i2++) {
			Pro2 p2 = (Pro2) list.get(i2);
			list2 = project3_Service.getProject3sByPro2_id(p2.getId());
			ArrayList llist = project3_Service.getWatchspendByPro22(p2.getId());
			double ratesum3 = 0;
			for (int i3 = 0; i3 < list2.size(); i3++) {
				Pro3 p3 = (Pro3) list2.get(i3);
				list3 = taskService.getTasksByPro3_id(p3.getId());
				int ratesum2 = 0;
				for (int i4 = 0; i4 < list3.size(); i4++) {
					Task t = (Task) list3.get(i4);
					list4 = watchService.getWatchByTask_id(t.getId());
					watchsum = list4.size() + watchsum;
					list5 = watchService.getWatchByTask_idAndState(t.getId());
					int ratesum = 0;
					for (int i5 = 0; i5 < list4.size(); i5++) {
						Watch w = (Watch) list4.get(i5);
						try {
							int n = watchService.getWatchRate(w.getPlan_time(), w.getFinish_time());
							w.setRate(n);
							if (n <= 0) {
								ratesum = ratesum + 1;
							}
						} catch (Exception e) {

						}
					}
					try {
						t.setRate(ratesum / list5.size());
						ratesum2 = ratesum + ratesum2;
					} catch (Exception e) {
						t.setRate(0);
					}
					finishsum = list5.size() + finishsum;
				}
				try {
					ratesum3 = ratesum2 + ratesum3;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			num = NumberFormat.getPercentInstance();
			num.setMaximumIntegerDigits(3);
			num.setMaximumFractionDigits(2);
			if (llist.size() != 0) {
				String ss = num.format((ratesum3 / (double) llist.size()));
				p2.setRate(ss);
			} else {
				p2.setRate("0%");
			}
			p2.setWatchsum((int) watchsum);
			p2.setFinishsum((int) finishsum);
			if (watchsum != 0) {
				String ss = num.format(finishsum / watchsum);
				p2.setFinishratio(ss);
			} else {
				p2.setFinishratio("0%");
			}
			watchsum = finishsum = 0;
		}
		for (int i = 0; i < list.size(); i++) {
			Pro2 p = (Pro2) list.get(i);
			if (p.getId() == id) {
				project2 = p;
			}
		}
		return "p2";
	}

	public String zonglan() throws DataAccessException, ClassNotFoundException {
		HttpServletRequest req = ServletActionContext.getRequest();
		ArrayList<Wenjian> listt = (ArrayList<Wenjian>) chengguoService.getWenjianList();
		if (listt == null) {
			req.setAttribute("wenjianList", null);
		}
		List<Wenjian> wenjianList = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			try {
				wenjianList.add(listt.get(i));
			} catch (IndexOutOfBoundsException e) {
				System.out.println("数组越界");
			}
		}
		req.setAttribute("wenjianList", wenjianList);
		ArrayList<Wenjian> lists = chengguoService.querywnFile();
		if (lists == null) {
			req.setAttribute("wjFileList", null);
		}
		List<Wenjian> wjFileList = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			try {
				wjFileList.add(lists.get(i));
			} catch (IndexOutOfBoundsException e) {
				System.out.println("数组越界");
			}
		}
		req.setAttribute("wjFileList", wjFileList);
		if (ActionContext.getContext().getSession().get("p1") != null) {
			return "zonglan";
		}
		num = NumberFormat.getPercentInstance();
		num.setMaximumIntegerDigits(3);
		num.setMaximumFractionDigits(2);
		List<Pro1> pro1list = project1_Service.getAllProject1s();
		// list控制接收pro1的集合，再赋值给控制器中的实体pro1
		list = new ArrayList<Pro1>();
		for (int i = 0; i < pro1list.size(); i++) {
			Pro1 pp1 = pro1list.get(i);
			int fenzi = 0;
			int fenmu = 0;
			List<Pro2> pro2List = (List<Pro2>) project2_Service.getPro2sByPro1_id(pro1list.get(i).getId());
			for (int j = 0; j < pro2List.size(); j++) {
				List<Pro3> pro3List = project3_Service.getProject3sByPro2_id(pro2List.get(j).getId());
				for (int k = 0; k < pro3List.size(); k++) {
					List<Watch> watchList = watchService.getWatchListByPro3Id(pro3List.get(k).getId());
					fenmu = fenmu + watchList.size();
					List<Watch> watchList2 = watchService.getFinishWatchListByPro3Id(pro3List.get(k).getId());
					fenzi = fenzi + watchList2.size();
				}
			}
			pp1.setFinishsum(fenzi);
			pp1.setWatchsum(fenmu);
			String fenz = "" + fenzi;
			String fenm = "" + fenmu;
			System.out.println(fenz + "--" + fenm);
			double fenzi2 = Double.parseDouble(fenz);
			double fenmu2 = Double.parseDouble(fenm);
			System.out.println(fenzi2 + "--" + fenmu2);
			double fenshu = fenzi2 / fenmu2;
			int q = ("" + fenshu).indexOf(".");
			System.out.println(q);
			System.out.println(fenshu);
			String fenshu2 = "";
			try {
				fenshu2 = ("" + fenshu).substring(0, q + 5);
			} catch (StringIndexOutOfBoundsException e) {
				try {
					fenshu2 = ("" + fenshu).substring(0, q + 4);
				} catch (StringIndexOutOfBoundsException e2) {
					try {
						fenshu2 = ("" + fenshu).substring(0, q + 3);
					} catch (StringIndexOutOfBoundsException e3) {
						fenshu2 = ("" + fenshu).substring(0, q + 2);
					}
				}
			}
			System.out.println(fenshu2);
			pp1.setFinishratio("" + fenshu2);
			if (i == 0) {
				p1 = pp1;
				ActionContext.getContext().getSession().put("p1", pp1);
			}
			if (i == 1) {
				p2 = pp1;
				ActionContext.getContext().getSession().put("p2", pp1);
			}
			if (i == 2) {
				p3 = pp1;
				ActionContext.getContext().getSession().put("p3", pp1);
			}
			if (i == 3) {
				p4 = pp1;
				ActionContext.getContext().getSession().put("p4", pp1);
			}
			if (i == 4) {
				p5 = pp1;
				ActionContext.getContext().getSession().put("p5", pp1);
			}
			if (i == 5) {
				p6 = pp1;
				ActionContext.getContext().getSession().put("p6", pp1);
			}
			if (i == 6) {
				p7 = pp1;
				ActionContext.getContext().getSession().put("p7", pp1);
			}
			if (i == 7) {
				p8 = pp1;
				ActionContext.getContext().getSession().put("p8", pp1);
			}
			if (i == 8) {
				p9 = pp1;
				ActionContext.getContext().getSession().put("p9", pp1);
			}
			if (i == 9) {
				p10 = pp1;
				ActionContext.getContext().getSession().put("p10", pp1);
			}
			if (i == 10) {
				p11 = pp1;
				ActionContext.getContext().getSession().put("p11", pp1);
			}
			if (i == 11) {
				p12 = pp1;
				ActionContext.getContext().getSession().put("p12", pp1);
			}
			if (i == 12) {
				p13 = pp1;
				ActionContext.getContext().getSession().put("p13", pp1);
			}
			if (i == 13) {
				p14 = pp1;
				ActionContext.getContext().getSession().put("p14", pp1);
			}
			if (i == 14) {
				p15 = pp1;
				ActionContext.getContext().getSession().put("p15", pp1);
			}
		}
		return "zonglan";
	}

	public String add0() {
		p1list = project1_Service.getUsersByState1AndNoPro1();
		return "add0";
	}

	public String add() {
		int i = project1_Service.insertProject1(project1);
		if (i > 0) {
			id = project1.getUser_id();
			p1list = project1_Service.getUsersByState1AndNoPro1();
			return "add0";
		} else {
			error = "插入失败";
			return "error";
		}
	}

	public String list() {
		p1list = project1_Service.getAllProject1s();
		for (int i = 0; i < p1list.size(); i++) {
			Pro1 p = (Pro1) p1list.get(i);
			User u = user_Service.getUserById(p.getUser_id());
			p.setFinishratio(u.getRealName());
		}
		return "list";
	}

	public String del1() {
		try {
			project1_Service.deleteProject1ById(id);
			p1list = project1_Service.getAllProject1s();
			return "list";
		} catch (Exception e) {
			return Action.ERROR;
		}
	}

	public String lookup() {
		project1 = project1_Service.getProject1ById(id);
		list = project2_Service.getProject2sByPro1_id(id);
		return "lookup";
	}

	public String lookup2() {
		project1 = project1_Service.getProject1ById(id);
		list = project2_Service.getProject2sByPro1_id(id);
		for (int i = 0; i < list.size(); i++) {
			Pro2 p2 = (Pro2) list.get(i);
			p1list = project3_Service.getWatchspendByPro1(p2.getId());
			p2.setNum(p1list.size());
		}
		return "lookup2";
	}

	public String updata() {
		int i = project1_Service.updataProject1(project1);
		if (i > 0) {
			p1list = project1_Service.getAllProject1s();
			return Action.SUCCESS;
		} else {
			return Action.ERROR;
		}
	}

	public String list2() {
		list = project1_Service.getAllProject1sByState0();
		for (int i = 0; i < list.size(); i++) {
			Pro1 p1 = (Pro1) list.get(i);
			p1list = project3_Service.getWatchspendByPro(p1.getId());
			p1.setNum(p1list.size());
		}
		return "list2";
	}

	public String list3() {
		list = project1_Service.getAllProject1sByState1();
		return "list3";
	}

	public String shenhe() {
		project1 = project1_Service.getProject1ById(id);
		project1.setState(1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nn = sdf.format(new Date());
		project1.setFinish_time(nn);
		project1_Service.updataProject1(project1);
		return Action.SUCCESS;
	}

	public String shenhe2() {
		project1 = project1_Service.getProject1ById(id);
		project1.setState(0);
		project1.setFinish_time(null);
		project1_Service.updataProject1(project1);
		return Action.SUCCESS;
	}

	public String tongjiByPro1() {
		if (ActionContext.getContext().getSession().get("tongjipro1list") != null) {
			return "tongjiByPro1";
		}
		double watchsum = 0;
		double finishsum = 0;
		list = project1_Service.getAllProject1s(); // 一级项目集合
		Collections.sort(list, new Comparator<Pro1>() {
			/*
			 * int compare(Person p1, Person p2) 返回一个基本类型的整型， 返回负数表示：p1 小于p2，
			 * 返回0 表示：p1和p2相等， 返回正数表示：p1大于p2
			 */
			public int compare(Pro1 p1, Pro1 p2) {
				// 按照Pro1的序号no进行升序排列
				if (Integer.parseInt(p1.getNo()) > Integer.parseInt(p2.getNo())) {
					return 1;
				} else {
					return -1;
				}
			}
		});
		System.out.println("list=" + list.size());
		for (int i = 0; i < list.size(); i++) {
			Pro1 p1 = (Pro1) list.get(i);
			p1list = project2_Service.getPro2sByPro1_id(p1.getId()); // 二级项目集合
			ArrayList llist = project3_Service.getWatchspendByPro11(p1.getId()); // pro1下watch的完成的总数
			double ratesum4 = 0;
			for (int i2 = 0; i2 < p1list.size(); i2++) {
				Pro2 p2 = (Pro2) p1list.get(i2);
				list2 = project3_Service.getProject3sByPro2_id(p2.getId());
				int ratesum3 = 0;
				for (int i3 = 0; i3 < list2.size(); i3++) {
					Pro3 p3 = (Pro3) list2.get(i3);
					list3 = taskService.getTasksByPro3_id(p3.getId());
					int ratesum2 = 0;
					for (int i4 = 0; i4 < list3.size(); i4++) {
						Task t = (Task) list3.get(i4);
						list4 = watchService.getWatchByTask_id(t.getId());
						watchsum = list4.size() + watchsum;
						list5 = watchService.getWatchByTask_idAndState(t.getId());
						finishsum = list5.size() + finishsum;
						int ratesum = 0;
						for (int i5 = 0; i5 < list4.size(); i5++) {
							Watch w = (Watch) list4.get(i5);
							try {
								int n = watchService.getWatchRate(w.getPlan_time(), w.getFinish_time());
								w.setRate(n);
								if (n <= 0) {
									ratesum = ratesum + 1;
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						try {
							t.setRate(ratesum / list5.size());
							ratesum2 = ratesum + ratesum2;
						} catch (Exception e) {
							t.setRate(0);
						}
					}
					try {
						ratesum3 = ratesum2 + ratesum3;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				try {
					ratesum4 = ratesum3 + ratesum4;
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			num = NumberFormat.getPercentInstance();
			num.setMaximumIntegerDigits(3);
			num.setMaximumFractionDigits(2);
			if (llist.size() != 0) {
				String ss = num.format((ratesum4 / (double) llist.size()));
				p1.setRate(ss);
			} else {
				p1.setRate("0%");
			}
			p1.setWatchsum((int) watchsum);
			p1.setFinishsum((int) finishsum);
			if (watchsum != 0) {
				String ss = num.format(finishsum / watchsum);
				p1.setFinishratio(ss);
			} else {
				p1.setFinishratio("0%");
			}
			watchsum = finishsum = 0;
		}
		ActionContext.getContext().getSession().put("tongjipro1list", list);
		return "tongjiByPro1";
	}

	public String tongjiByPro2() {
		double watchsum = 0;
		double finishsum = 0;
		list = project2_Service.getPro2sByPro1_id(id);
		Collections.sort(list, new Comparator<Pro2>() {
			/*
			 * int compare(Person p1, Person p2) 返回一个基本类型的整型， 返回负数表示：p1 小于p2，
			 * 返回0 表示：p1和p2相等， 返回正数表示：p1大于p2
			 */
			public int compare(Pro2 p1, Pro2 p2) {
				// 按照Pro1的序号no进行升序排列
				if (Integer.parseInt(p1.getNo()) > Integer.parseInt(p2.getNo())) {
					return 1;
				} else {
					return -1;
				}
			}
		});
		for (int i2 = 0; i2 < list.size(); i2++) {
			Pro2 p2 = (Pro2) list.get(i2);
			list2 = project3_Service.getProject3sByPro2_id(p2.getId());
			ArrayList llist = project3_Service.getWatchspendByPro22(p2.getId());
			double ratesum3 = 0;
			for (int i3 = 0; i3 < list2.size(); i3++) {
				Pro3 p3 = (Pro3) list2.get(i3);
				list3 = taskService.getTasksByPro3_id(p3.getId());
				int ratesum2 = 0;
				for (int i4 = 0; i4 < list3.size(); i4++) {
					Task t = (Task) list3.get(i4);
					list4 = watchService.getWatchByTask_id(t.getId());
					watchsum = list4.size() + watchsum;
					list5 = watchService.getWatchByTask_idAndState(t.getId());
					int ratesum = 0;
					for (int i5 = 0; i5 < list4.size(); i5++) {
						Watch w = (Watch) list4.get(i5);
						try {
							int n = watchService.getWatchRate(w.getPlan_time(), w.getFinish_time());
							w.setRate(n);
							if (n <= 0) {
								ratesum = ratesum + 1;
							}
						} catch (Exception e) {

						}
					}
					try {
						t.setRate(ratesum / list5.size());
						ratesum2 = ratesum + ratesum2;
					} catch (Exception e) {
						t.setRate(0);
					}
					System.out.println("list5=" + list5);
					finishsum = list5.size() + finishsum;
				}
				try {
					ratesum3 = ratesum2 + ratesum3;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			num = NumberFormat.getPercentInstance();
			num.setMaximumIntegerDigits(3);
			num.setMaximumFractionDigits(2);
			if (llist.size() != 0) {
				String ss = num.format((ratesum3 / (double) llist.size()));
				p2.setRate(ss);
			} else {
				p2.setRate("0%");
			}
			p2.setWatchsum((int) watchsum);
			p2.setFinishsum((int) finishsum);
			if (watchsum != 0) {
				String ss = num.format(finishsum / watchsum);
				p2.setFinishratio(ss);
			} else {
				p2.setFinishratio("0%");
			}
			watchsum = finishsum = 0;
		}
		return "tongjiByPro2";
	}

	public String tongjiByPro3() {
		double watchsum = 0;
		double finishsum = 0;
		list = project3_Service.getProject3sByPro2_id(id);
		Collections.sort(list, new Comparator<Pro3>() {
			/*
			 * int compare(Person p1, Person p2) 返回一个基本类型的整型， 返回负数表示：p1 小于p2，
			 * 返回0 表示：p1和p2相等， 返回正数表示：p1大于p2
			 */
			public int compare(Pro3 p1, Pro3 p2) {
				// 按照Pro1的序号no进行升序排列
				if (Integer.parseInt(p1.getNo()) > Integer.parseInt(p2.getNo())) {
					return 1;
				} else {
					return -1;
				}
			}
		});
		for (int i3 = 0; i3 < list.size(); i3++) {
			Pro3 p3 = (Pro3) list.get(i3);
			list3 = taskService.getTasksByPro3_id(p3.getId());
			ArrayList llist = project3_Service.getWatchspendByPro33(p3.getId());
			System.out.println("llist================" + llist.size());
			double ratesum2 = 0;
			for (int i4 = 0; i4 < list3.size(); i4++) {
				Task t = (Task) list3.get(i4);
				list4 = watchService.getWatchByTask_id(t.getId());
				watchsum = list4.size() + watchsum;
				System.out.println("list4=" + list4.size());
				list5 = watchService.getWatchByTask_idAndState(t.getId());
				System.out.println("list5=" + list5.size());
				finishsum = list5.size() + finishsum;
				int ratesum = 0;
				for (int i5 = 0; i5 < list4.size(); i5++) {
					Watch w = (Watch) list4.get(i5);
					try {
						int n = watchService.getWatchRate(w.getPlan_time(), w.getFinish_time());
						w.setRate(n);
						if (n <= 0) {
							ratesum = ratesum + 1;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				try {
					ratesum2 = ratesum + ratesum2;
				} catch (Exception e) {
					t.setRate(0);
				}
			}
			num = NumberFormat.getPercentInstance();
			num.setMaximumIntegerDigits(3);
			num.setMaximumFractionDigits(2);
			if (llist.size() != 0) {
				System.out.println("执行到这里了");
				String ss = num.format((ratesum2 / (double) llist.size()));
				p3.setRate(ss);
				System.out.println(p3.getRate());
			} else {
				System.out.println("在这在这");
				p3.setRate("0%");
			}
			p3.setWatchsum((int) watchsum);
			p3.setFinishsum((int) finishsum);
			if (watchsum != 0) {
				String ss = num.format(finishsum / watchsum);
				p3.setFinishratio(ss);
			} else {
				p3.setFinishratio("0%");
			}
			watchsum = finishsum = 0;
		}
		return "tongjiByPro3";
	}

	public String tongjiByDept1() {
		if (ActionContext.getContext().getSession().get("tongjideptlist") != null) {
			return "tongjiByDept1";
		}
		list = department_Service.getAllDepartments();
		for (int i = 0; i < list.size(); i++) {
			Dept d = (Dept) list.get(i);
			double n = (double) watchService.getWatchByDept(d.getId());
			d.setWatchsum(n);
			double q = (double) watchService.getFinishWatchByDept(d.getId());
			d.setFinishsum(q);
			ArrayList llist = watchService.getFinishWatchByDept2(d.getId());
			num = NumberFormat.getPercentInstance();
			num.setMaximumIntegerDigits(3);
			num.setMaximumFractionDigits(2);
			if (q != 0 && n != 0) {
				double w = q / n;
				d.setFinishratio(num.format(w));
			} else {
				double w = 0;
				d.setFinishratio("0%");
			}
			if (q != 0) {
				double qq = watchService.getFinishWatchByDept(d.getId()); // 已完成个数
				double ww = watchService.getRatesum(d.getId()); // 如期完成个数
				String ee = num.format(ww / qq);
				d.setRate(ee);
			} else {
				d.setRate("0%");
			}

		}
		ActionContext.getContext().getSession().put("tongjideptlist", list);
		return "tongjiByDept1";
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList getList2() {
		return list2;
	}

	public void setList2(ArrayList list2) {
		this.list2 = list2;
	}

	public ArrayList getList3() {
		return list3;
	}

	public void setList3(ArrayList list3) {
		this.list3 = list3;
	}

	public ArrayList getList4() {
		return list4;
	}

	public ArrayList getList5() {
		return list5;
	}

	public void setList5(ArrayList list5) {
		this.list5 = list5;
	}

	public ArrayList getList6() {
		return list6;
	}

	public void setList6(ArrayList list6) {
		this.list6 = list6;
	}

	public void setList4(ArrayList list4) {
		this.list4 = list4;
	}

	private int id;

	public ArrayList getList() {
		return list;
	}

	public void setList(ArrayList list) {
		this.list = list;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList getP1list() {
		return p1list;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public Dept getDepartment() {
		return department;
	}

	public void setDepartment(Dept department) {
		this.department = department;
	}

	public Pro2 getProject2() {
		return project2;
	}

	public void setProject2(Pro2 project2) {
		this.project2 = project2;
	}

	public Pro1 getProject1() {
		return project1;
	}

	public void setProject1(Pro1 project1) {
		this.project1 = project1;
	}

	public Pro1 getP1() {
		return p1;
	}

	public void setP1(Pro1 p1) {
		this.p1 = p1;
	}

	public Pro1 getP2() {
		return p2;
	}

	public void setP2(Pro1 p2) {
		this.p2 = p2;
	}

	public Pro1 getP3() {
		return p3;
	}

	public void setP3(Pro1 p3) {
		this.p3 = p3;
	}

	public Pro1 getP4() {
		return p4;
	}

	public void setP4(Pro1 p4) {
		this.p4 = p4;
	}

	public Pro1 getP5() {
		return p5;
	}

	public void setP5(Pro1 p5) {
		this.p5 = p5;
	}

	public Pro1 getP6() {
		return p6;
	}

	public void setP6(Pro1 p6) {
		this.p6 = p6;
	}

	public Pro1 getP7() {
		return p7;
	}

	public void setP7(Pro1 p7) {
		this.p7 = p7;
	}

	public Pro1 getP8() {
		return p8;
	}

	public void setP8(Pro1 p8) {
		this.p8 = p8;
	}

	public Pro1 getP9() {
		return p9;
	}

	public void setP9(Pro1 p9) {
		this.p9 = p9;
	}

	public Pro1 getP10() {
		return p10;
	}

	public void setP10(Pro1 p10) {
		this.p10 = p10;
	}

	public Pro1 getP11() {
		return p11;
	}

	public void setP11(Pro1 p11) {
		this.p11 = p11;
	}

	public Pro1 getP12() {
		return p12;
	}

	public void setP12(Pro1 p12) {
		this.p12 = p12;
	}

	public Pro1 getP13() {
		return p13;
	}

	public void setP13(Pro1 p13) {
		this.p13 = p13;
	}

	public Pro1 getP14() {
		return p14;
	}

	public void setP14(Pro1 p14) {
		this.p14 = p14;
	}

	public Pro1 getP15() {
		return p15;
	}

	public void setP15(Pro1 p15) {
		this.p15 = p15;
	}

	public void setP1list(ArrayList p1list) {
		this.p1list = p1list;
	}

	public int getQqq() {
		return qqq;
	}

	public void setQqq(int qqq) {
		this.qqq = qqq;
	}

}
