package com.rzpt1.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.rzpt.entity.Dept;
import com.rzpt.entity.Pro3;
import com.rzpt.entity.Task;
import com.rzpt.service.Pro1_Service;
import com.rzpt.service.Pro2_Service;
import com.rzpt.util.UploadDownUtil;
import com.rzpt1.service.Pro3_Service;
import com.rzpt1.service.Task_Service;
import com.rzpt1.service.Watch_Service;

import net.sf.json.JSONArray;

public class Task_Action extends ActionSupport {
	private Task task;
	private List tasks;
	private List pro3s;
	private Pro3 pro3;
	private List<java.io.File> upload;
	private List uploadFileName;
	private List uploadContentType;
	private Task_Service taskService;
	private Watch_Service watchService;
	private int id;
	private int qqq;
	private ArrayList list, list1, list2;
	private Pro3_Service pro3Service;
	private JSONArray jsonArray;

	@Resource(name = "project1_Service")
	private Pro1_Service project1_Service;

	@Resource(name = "project2_Service")
	private Pro2_Service project2_Service;

	public String addExcel() {
		try {
			UploadDownUtil util = new UploadDownUtil(upload, uploadFileName, uploadContentType);
			String path = "/excelFiles";
			ArrayList<Task> taskList = util.readExcelTask(path);
			for (Task t : taskList) {
				t.setPro3_id(pro3Service.getPro3ByNo(t.getPro3_id()).getId());
				try{
					taskService.add(t);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String add1() {
		list = project1_Service.getAllProject1s();
		return "add";
	}

	public String add2() {
		pro3 = pro3Service.getPro3ById(pro3.getId());
		String no;
		if (task.getMoment() == 0) {
			no = "18";
		} else {
			no = "19";
		}
		task.setNo(pro3.getNo() + no);
		task.setPro3_id(pro3.getId());
		int i = taskService.add(task);
		if (i == 1) {
			list = project1_Service.getAllProject1s();
			qqq = 1;
			return "add";
		} else {
			return ERROR;
		}
	}

	public String list() {
		tasks = taskService.getAllTask();
		return "list";
	}

	public String getPro3sJson() {
		pro3s = pro3Service.getPro3sByPro2_id(id);
		jsonArray = new JSONArray();
		for (Object object : pro3s) {
			jsonArray.add(object);
		}
		return "getPro2Json";
	}

	public String show() {
		task = taskService.getTask(task.getId());
		return "show";
	}

	public String update1() {
		pro3s = pro3Service.getAllPro3s();
		task = taskService.getTask(task.getId());
		return "update";
	}

	public String update2() {
		int i = taskService.update(task);
		if (i == 1) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String delete() {
		int i = taskService.delete(task);
		if (i == 1) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String lookup() {
		task = taskService.getTask(id);
		tasks = watchService.getWatchByTask_id(task.getId()); // 获得观测点集合
		return "lookup";
	}

	public String lookup2() {
		task = taskService.getTask(id);
		tasks = watchService.getWatchByTask_id(task.getId()); // 获得观测点集合
		return "lookup2";
	}

	public String updata() {
		try {
			taskService.update(task);
			return Action.SUCCESS;
		} catch (Exception e) {
			return Action.ERROR;
		}
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public List getPro3s() {
		return pro3s;
	}

	public void setPro3s(List pro3s) {
		this.pro3s = pro3s;
	}

	public Pro3_Service getPro3Service() {
		return pro3Service;
	}

	public void setPro3Service(Pro3_Service pro3Service) {
		this.pro3Service = pro3Service;
	}

	public Task_Service getTaskService() {
		return taskService;
	}

	public void setTaskService(Task_Service taskService) {
		this.taskService = taskService;
	}

	public List getTasks() {
		return tasks;
	}

	public void setTasks(List tasks) {
		this.tasks = tasks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Watch_Service getWatchService() {
		return watchService;
	}

	public ArrayList getList() {
		return list;
	}

	public void setList(ArrayList list) {
		this.list = list;
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

	public ArrayList getList1() {
		return list1;
	}

	public void setList1(ArrayList list1) {
		this.list1 = list1;
	}

	public JSONArray getJsonArray() {
		return jsonArray;
	}

	public void setJsonArray(JSONArray jsonArray) {
		this.jsonArray = jsonArray;
	}

	public ArrayList getList2() {
		return list2;
	}

	public void setList2(ArrayList list2) {
		this.list2 = list2;
	}

	public void setWatchService(Watch_Service watchService) {
		this.watchService = watchService;
	}

	public Pro3 getPro3() {
		return pro3;
	}

	public void setPro3(Pro3 pro3) {
		this.pro3 = pro3;
	}

	public int getQqq() {
		return qqq;
	}

	public void setQqq(int qqq) {
		this.qqq = qqq;
	}

}
