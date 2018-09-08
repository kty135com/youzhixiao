package com.rzpt.action;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.rzpt.entity.Dept;
import com.rzpt.entity.Pro1;
import com.rzpt.entity.Pro2;
import com.rzpt.entity.Pro3;
import com.rzpt.entity.Task;
import com.rzpt.entity.User;
import com.rzpt.entity.Watch;
import com.rzpt.service.Pro1_Service;
import com.rzpt.service.Pro2_Service;
import com.rzpt.service.Pro3_Service;
import com.rzpt.service.User_Service;
import com.rzpt.util.UploadDownUtil;
import com.rzpt1.service.Dept_Service;
import com.rzpt1.service.Task_Service;
import com.rzpt1.service.Watch_Service;

public class Pro2_Action extends ActionSupport implements SessionAware {

	@Resource(name = "user_Service")
	private User_Service user_Service;

	@Resource(name = "project2_Service")
	private Pro2_Service project2_Service;

	@Resource(name = "project1_Service")
	private Pro1_Service project1_Service;

	@Resource(name = "project3_Service")
	private Pro3_Service project3_Service;

	@Resource(name = "taskService")
	private Task_Service taskService;

	@Resource(name = "watchService")
	private Watch_Service watchService;

	@Resource(name = "project1")
	private Pro1 project1;

	@Resource(name = "project2")
	private Pro2 project2;

	@Resource(name = "project3")
	private Pro3 project3;

	@Resource(name = "deptService")
	private Dept_Service ds;

	@Resource(name = "watch")
	private Watch watch;

	@Resource(name = "task")
	private Task task;

	private int pro1_id;
	private int qqq;
	private List<java.io.File> upload;
	private List uploadFileName;
	private List uploadContentType;
	private ArrayList p1s;
	private ArrayList p2s;
	private ArrayList p3s;
	private ArrayList list;
	private ArrayList number;
	private Map<String, Object> session;

	public String add1() {
		p1s = project1_Service.getAllProject1s();
		p2s = project2_Service.getUsersByState2();
		return "add1";
	}

	public String add2() {
		int n = project2_Service.insertProject2(project2);
		if (n > 0) {
			p1s = project1_Service.getAllProject1s();
			p2s = project2_Service.getUsersByState2();
			qqq = 1;
			return "add1";
		} else {
			return "error";
		}
	}

	public String addExcel() {
		try {
			UploadDownUtil util = new UploadDownUtil(upload, uploadFileName, uploadContentType);
			String path = "/excelFiles";
			ArrayList<Pro2> pro2List = util.realExcelPro2(path);
			for (Pro2 p : pro2List) {
				System.out.println("p========" + p);
				Pro1 p1 = (Pro1) project1_Service.getProject1ByNo("" + p.getPro1_no()).get(0);
				p.setPro1_id(p1.getId());
				p.setUser_id(user_Service.getUserByName(p.getDepter()).getId());
				System.out.println("p=========" + p);
				try {
					project2_Service.insertProject2(p);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String list() {
		p2s = project2_Service.getAllProject2s();
		return "list";
	}

	public String del() {
		try {
			project2_Service.deleteProject2ById(id);
			p2s = project2_Service.getAllProject2s();
			return "list";
		} catch (Exception e) {
			return Action.ERROR;
		}
	}

	public String lookup() {
		project2 = project2_Service.getProject2ById(id);
		p2s = project3_Service.getProject3sByPro2_id(id);
		return "lookup";
	}

	public String lookup2() {
		project2 = project2_Service.getProject2ById(id);
		p2s = project3_Service.getProject3sByPro2_id(id);
		for (int i = 0; i < p2s.size(); i++) {
			Pro3 p3 = (Pro3) p2s.get(i);
			list = project3_Service.getWatchspendByPro2(p3.getId());
			p3.setNum(list.size());
		}
		return "lookup2";
	}

	public String updata() {
		project2_Service.updataProject2(project2);
		p2s = project2_Service.getAllProject2s();
		return Action.SUCCESS;
	}

	public String allot0() {
		p2s = project2_Service.getPro2ByUser_id0AndPro1_id(project2.getPro1_id());
		return "allot0";
	}

	public String allot1() {
		project2 = project2_Service.getProject2ById(id);
		p2s = project2_Service.getUsersByState2();
		return "allot1_1";
	}

	public String allot1_2() {
		project2_Service.updataProject2(project2);
		p2s = project2_Service.getPro2ByUser_id0AndPro1_id(project2.getPro1_id());
		return "allot0";
	}

	public String allot4() {
		p2s = project2_Service.getPro2ByUser_idAndPro1_id(project2.getPro1_id());
		for (int i = 0; i < p2s.size(); i++) {
			Pro2 p2 = (Pro2) p2s.get(i);
			User u = user_Service.getUserById(p2.getUser_id());
			p2.setUser(u.getRealName());
		}
		return "allot4";
	}

	public String allot5() {
		project2 = project2_Service.getProject2ById(id);
		p2s = project2_Service.getUsersByState2();
		return "allot5";
	}

	public String allot6() {
		project2_Service.updataProject2(project2);
		p2s = project2_Service.getPro2ByUser_idAndPro1_id(project2.getPro1_id());
		for (int i = 0; i < p2s.size(); i++) {
			Pro2 p2 = (Pro2) p2s.get(i);
			User u = user_Service.getUserById(p2.getUser_id());
			p2.setUser(u.getRealName());
		}
		return "allot4";
	}

	public String pendBypro1admin() {
		p2s = project2_Service.getPro2sByPro1_id(project2.getPro1_id());
		for (int i = 0; i < p2s.size(); i++) {
			project2 = (Pro2) p2s.get(i);
			list = project3_Service.getWatchspendByPro1State2(project2.getId());
			project2.setNum(list.size());
		}
		qqq = 2;
		return "pend";
	}

	public String pend() {
		p2s = project2_Service.getPro2sByPro1_id(project2.getPro1_id());
		for (int i = 0; i < p2s.size(); i++) {
			project2 = (Pro2) p2s.get(i);
			list = project3_Service.getWatchspendByPro1State3(project2.getId());
			project2.setNum(list.size());
		}
		return "pend";
	}

	public String pend2() {
		p2s = project3_Service.getProject3sByPro2_id(id);
		for (int i = 0; i < p2s.size(); i++) {
			project3 = (Pro3) p2s.get(i);
			list = project3_Service.getWatchspendByPro2State3(project3.getId());
			project3.setNum(list.size());
		}
		return "pend2";
	}

	public String pend2Bypro1admin() {
		p2s = project3_Service.getProject3sByPro2_id(id);
		for (int i = 0; i < p2s.size(); i++) {
			project3 = (Pro3) p2s.get(i);
			list = project3_Service.getWatchspendByPro2State2(project3.getId());
			project3.setNum(list.size());
		}
		qqq = 2;
		return "pend2";
	}

	public String pend3Bypro1admin() {
		p2s = project3_Service.getTasksByPro3_id(id);
		for (int i = 0; i < p2s.size(); i++) {
			task = (Task) p2s.get(i);
			list = project3_Service.getWatchspendByPro3State2(task.getId());
			task.setNum(list.size());
		}
		qqq = 2;
		return "pend3";
	}

	public String pend3() {
		p2s = project3_Service.getTasksByPro3_id(id);
		for (int i = 0; i < p2s.size(); i++) {
			task = (Task) p2s.get(i);
			list = project3_Service.getWatchspendByPro3State3(task.getId());
			task.setNum(list.size());
		}
		return "pend3";
	}

	public String pend4() {
		p2s = project3_Service.getWatchsByTask_id(id);
		return "pend4";
	}

	public String dmlook() {
		list = project2_Service.getPro2sByUser_id(id);
		return "dmlook";
	}

	public String dmlook2() {
		list = project3_Service.getProject3sByPro2_id(id);
		return "dmlook2";
	}

	public String dmlook3() {
		list = taskService.getTasksByPro3_id(id);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		return "dmlook3";
	}

	public String dmlook4() {
		list = watchService.getWatchByTask_id(id);
		return "dmlook4";
	}

	public int getQqq() {
		return qqq;
	}

	public void setQqq(int qqq) {
		this.qqq = qqq;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Watch getWatch() {
		return watch;
	}

	public void setWatch(Watch watch) {
		this.watch = watch;
	}

	public Pro3 getProject3() {
		return project3;
	}

	public void setProject3(Pro3 project3) {
		this.project3 = project3;
	}

	public ArrayList getNumber() {
		return number;
	}

	public void setNumber(ArrayList number) {
		this.number = number;
	}

	public ArrayList getP3s() {
		return p3s;
	}

	public void setP3s(ArrayList p3s) {
		this.p3s = p3s;
	}

	private int id;

	public ArrayList getList() {
		return list;
	}

	public void setList(ArrayList list) {
		this.list = list;
	}

	public int getPro1_id() {
		return pro1_id;
	}

	public void setPro1_id(int pro1_id) {
		this.pro1_id = pro1_id;
	}

	public Pro1 getProject1() {
		return project1;
	}

	public void setProject1(Pro1 project1) {
		this.project1 = project1;
	}

	public void setProject2(Pro2 project2) {
		this.project2 = project2;
	}

	public Pro2 getProject2() {
		return project2;
	}

	public ArrayList getP1s() {
		return p1s;
	}

	public void setP1s(ArrayList p1s) {
		this.p1s = p1s;
	}

	public ArrayList getP2s() {
		return p2s;
	}

	public void setP2s(ArrayList p2s) {
		this.p2s = p2s;
	}

	public List<java.io.File> getUpload() {
		return upload;
	}

	public void setUpload(List<java.io.File> upload) {
		this.upload = upload;
	}

	public List getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(List uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public List getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(List uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
