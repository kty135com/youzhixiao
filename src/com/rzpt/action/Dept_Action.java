package com.rzpt.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.rzpt.entity.Dept;
import com.rzpt.entity.User;
import com.rzpt.service.Dept_Service;
import com.rzpt.util.UploadDownUtil;

public class Dept_Action extends ActionSupport implements SessionAware {

	@Resource(name = "department")
	private Dept department;

	@Resource(name = "department_Service")
	private Dept_Service department_Service;

	private Integer page;
	private Integer cPage;
	private ArrayList list;
	private int id;
	private Map<String, Object> session;

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Dept getDepartment() {
		return department;
	}

	public void setDepartment(Dept department) {
		this.department = department;
	}

	public ArrayList getList() {
		return list;
	}

	public void setList(ArrayList list) {
		this.list = list;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String add() {
		int i = department_Service.insertDepartment(department);
		if (i > 0) {
			list = department_Service.getAllDepartments();

			return "list";
		} else {

			return Action.ERROR;
		}
	}

	public String listByPage() {
		list = (ArrayList) department_Service.getDepartmentsByPage(page);
		return "list";
	}

	public String del1() {
		try {
			department_Service.deleteDepartmentById(id);
			list = department_Service.getAllDepartments();
			return "list";
		} catch (Exception e) {
			return Action.ERROR;
		}
	}

	public String lookup() {
		department = department_Service.getDepartmentById(id);
		return "lookup";
	}

	public String updata() {
		try {
			department_Service.updataDepartment(department);
			list = department_Service.getAllDepartments();
			return "list";
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
	}

}
