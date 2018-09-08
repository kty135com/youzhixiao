package com.rzpt1.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.rzpt.entity.Dept;
import com.rzpt.util.UploadDownUtil;
import com.rzpt1.service.Dept_Service;

public class Dept_Action extends ActionSupport {
	private Dept dept;
	private List depts;
	private Dept_Service deptService;
	private List<java.io.File> upload;
	private List uploadFileName;
	private List uploadContentType;

	public String add() {
		int i = deptService.add(dept);
		if (i == 1) {
			depts = deptService.getAllDepts();
			return "list";
		} else {
			return ERROR;
		}
	}

	public String list() {
		depts = deptService.getAllDepts();
		return "list";
	}

	public String update1() {
		dept = deptService.getDept(dept.getId());
		return "update";
	}

	public String update2() {
		int i = deptService.update(dept);
		if (i == 1) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String delete() {
		int i = deptService.delete(dept);
		if (i == 1) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String addExcel() {
		try {
			UploadDownUtil util = new UploadDownUtil(upload, uploadFileName, uploadContentType);
			String path = "/excelFiles";
			ArrayList<Dept> deptList = util.readExceldept(path);
			for (Dept d : deptList) {
				System.out.println("dd.name=="+d.getName());
				deptService.add(d);
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public List getDepts() {
		return depts;
	}

	public void setDepts(List depts) {
		this.depts = depts;
	}

	public Dept_Service getDeptService() {
		return deptService;
	}

	public void setDeptService(Dept_Service deptService) {
		this.deptService = deptService;
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

}
