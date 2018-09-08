package com.rzpt.action;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.rzpt.dto.Files;
import com.rzpt.dto.Pro3s;
import com.rzpt.entity.File;
import com.rzpt.entity.Pro1;
import com.rzpt.entity.Pro2;
import com.rzpt.entity.Pro3;
import com.rzpt.entity.Schedule;
import com.rzpt.entity.Task;
import com.rzpt.entity.User;
import com.rzpt.entity.Watch;
import com.rzpt.service.Pro1_Service;
import com.rzpt.service.Pro2_Service;
import com.rzpt.service.Pro3_Service;
import com.rzpt.service.User_Service;
import com.rzpt.util.FormatUtil;
import com.rzpt.util.UploadDownUtil;
import com.rzpt1.service.File_Service;
import com.rzpt1.service.Schedule_Service;
import com.rzpt1.service.Task_Service;
import com.rzpt1.service.Watch_Service;

import net.sf.json.JSONArray;

public class Pro3_Action extends ActionSupport implements SessionAware {
	@Resource(name = "user_Service")
	private User_Service user_Service;

	@Resource(name = "taskService")
	private Task_Service taskService;

	@Resource(name = "watchService")
	private Watch_Service watchService;

	@Resource(name = "fileService")
	private File_Service fileService;

	@Resource(name = "project3_Service")
	private Pro3_Service project3_Service;

	@Resource(name = "user")
	private User user;

	@Resource(name = "project2")
	private Pro2 project2;

	@Resource(name = "project1")
	private Pro1 project1;

	@Resource(name = "project1_Service")
	private Pro1_Service project1_Service;

	@Resource(name = "project2_Service")
	private Pro2_Service project2_Service;

	@Resource(name = "project3_Service")
	private Pro3_Service Project3_Service;

	@Resource(name = "scheduleService")
	private Schedule_Service scheduleService;

	@Resource(name = "project3")
	private Pro3 project3;

	private JSONArray jsonArray;
	private ArrayList list2;
	private ArrayList list;
	private int id;
	private int qqq;
	private double money;
	private Pro3s p3s = new Pro3s();
	private Task task1 = new Task();
	private Task task2 = new Task();
	private List<Watch> watchList;
	private List<java.io.File> upload;
	private List uploadFileName;
	private List uploadContentType;
	private String error;
	private Map<String, Object> session;

	public String add() {
		project2 = project2_Service.getProject2ById(project3.getPro2_id());
		try {
			user = user_Service.getUserById(project2.getUser_id());
			project3.setUser_id(user.getId());
			int i = Project3_Service.insertProject3(project3);
			if (i > 0) {
				list = project1_Service.getAllProject1s();
				qqq = 1;
				return "add1";
			} else {
				return Action.ERROR;
			}
		} catch (Exception e) {
			error = "请先分配二级项目的二级管理员";
			return Action.ERROR;
		}
	}

	public String pro3Show() {
		try {
			project3.setId(id);
			project3 = project3_Service.getProject3ById(project3.getId());
			money = project3_Service.getAllRealMoneyByPro3Id(project3.getId());
			int fenzi = project3_Service.getAllfenziByPro3_id(project3.getId());
			int fenmu = project3_Service.getAllfenmuByPro3_id(project3.getId());
			p3s.setP3Fenzi(fenzi);
			p3s.setP3Fenmu(fenmu);
			p3s.setBili(FormatUtil.getBiliByFenziAndFenmu(p3s.getP3Fenzi(), p3s.getP3Fenmu()));
			p3s.setJindu(FormatUtil.getjindutiao(p3s.getBili()));
			System.out.println(p3s.getBili() + "  " + p3s.getJindu());
			p3s.setP3(project3);
			project2 = project2_Service.getProject2ById(project3.getPro2_id());
			project1 = project1_Service.getProject1ById(project2.getPro1_id());
			task1 = taskService.get18taskBypro3Id(project3.getId());
			task2 = taskService.get19taskBypro3Id(project3.getId());
			watchList = watchService.getWatchListByPro3Id(project3.getId());
			for (Watch w : watchList) {
				try {
					Files filess = new Files();
					ArrayList<File> fileList = fileService.getFileListByWatchId(w.getId());
					for (int i = fileList.size() - 1; i >= 0; i--) {
						File file = fileList.get(i);
						if (file.getName1() != null && file.getName1() != "") {
							filess.setName1(file.getName1());
							filess.setPath1(file.getPath());
							filess.setFileId1(file.getId());
						}
						if (file.getName2() != null && file.getName2() != "") {
							filess.setName2(file.getName2());
							filess.setPath2(file.getPath());
							filess.setFileId2(file.getId());
						}
						if (file.getName3() != null && file.getName3() != "") {
							filess.setName3(file.getName3());
							filess.setPath3(file.getPath());
							filess.setFileId3(file.getId());
						}
						if (file.getName4() != null && file.getName4() != "") {
							filess.setName4(file.getName4());
							filess.setPath4(file.getPath());
							filess.setFileId4(file.getId());
						}
						if (file.getName5() != null && file.getName5() != "") {
							filess.setName5(file.getName5());
							filess.setPath5(file.getPath());
							filess.setFileId5(file.getId());
						}
						if (file.getName6() != null && file.getName6() != "") {
							filess.setName6(file.getName6());
							filess.setPath6(file.getPath());
							filess.setFileId6(file.getId());
						}
						System.out.println("fileList==="+fileList);

						
						/*
						 * fileService.getFileListByWatchId(w.getId());
						 * w.setFile(FormatUtil.getFilerealNamesToTnames(
						 * fileList. get(0)));
						 * w.setFile2(FormatUtil.getFilerealNamesToTnames(
						 * fileList. get(1)));
						 * w.setFile3(FormatUtil.getFilerealNamesToTnames(
						 * fileList. get(2)));
						 * w.setFile4(FormatUtil.getFilerealNamesToTnames(
						 * fileList. get(3)));
						 * w.setFile5(FormatUtil.getFilerealNamesToTnames(
						 * fileList. get(4)));
						 */

					}
					List<Schedule> scheduleList = scheduleService.getScheduleByWatchIddaoxu(w.getId());
					System.out.println("scheduleList. = "+scheduleList);
					if (scheduleList != null) {
						try {
							Schedule s = scheduleList.get(0);
							if (s.getName().indexOf("无文件") != -1 || s.getName().indexOf("nofile") != -1) {
								throw new IndexOutOfBoundsException();
							}
							filess.setSchePath1(s.getPath());
							filess.setScheId1(s.getId());
							filess.setScheName1(s.getName());
						} catch (IndexOutOfBoundsException e) {
							System.out.println("数组越界");
						}
						try {
							Schedule s = scheduleList.get(1);
							if (s.getName().indexOf("无文件") != -1 || s.getName().indexOf("nofile") != -1) {
								throw new IndexOutOfBoundsException();
							}
							filess.setSchePath2(s.getPath());
							filess.setScheId2(s.getId());
							filess.setScheName2(s.getName());
						} catch (IndexOutOfBoundsException e) {
							System.out.println("数组越界");
						}
						try {
							Schedule s = scheduleList.get(2);
							if (s.getName().indexOf("无文件") != -1 || s.getName().indexOf("nofile") != -1) {
								throw new IndexOutOfBoundsException();
							}
							filess.setSchePath3(s.getPath());
							filess.setScheId3(s.getId());
							filess.setScheName3(s.getName());
						} catch (IndexOutOfBoundsException e) {
							System.out.println("数组越界");
						}
						try {
							Schedule s = scheduleList.get(3);
							if (s.getName().indexOf("无文件") != -1 || s.getName().indexOf("nofile") != -1) {
								throw new IndexOutOfBoundsException();
							}
							filess.setSchePath4(s.getPath());
							filess.setScheId4(s.getId());
							filess.setScheName4(s.getName());
						} catch (IndexOutOfBoundsException e) {
							System.out.println("数组越界");
						}
						try {
							Schedule s = scheduleList.get(4);
							if (s.getName().indexOf("无文件") != -1 || s.getName().indexOf("nofile") != -1) {
								throw new IndexOutOfBoundsException();
							}
							filess.setSchePath5(s.getPath());
							filess.setScheId5(s.getId());
							filess.setScheName5(s.getName());
						} catch (IndexOutOfBoundsException e) {
							System.out.println("数组越界");
						}
						try {
							Schedule s = scheduleList.get(5);
							if (s.getName().indexOf("无文件") != -1 || s.getName().indexOf("nofile") != -1) {
								throw new IndexOutOfBoundsException();
							}
							filess.setSchePath6(s.getPath());
							filess.setScheId6(s.getId());
							filess.setScheName6(s.getName());
						} catch (IndexOutOfBoundsException e) {
							System.out.println("数组越界");
						}
						System.out.println(filess);
						filess = FormatUtil.getFilesRNamesFromScheName(filess);
						w.setFiles(FormatUtil.getFilesrealNamesToTnames(filess));
						System.out.println("Files = " + w.getFiles());
					}

					
				} catch (Exception e) {
					if (e instanceof IndexOutOfBoundsException) {
						e.printStackTrace();
						System.out.println("数组越界");
					} else {
						e.printStackTrace();
					}
				}
				w.setColumn("" + user_Service.getUserById(w.getUser_id()).getRealName());
				try {
					w.setColumn3("" + user_Service.getUserById(w.getUser2_id()).getRealName());
					w.setColumn4("" + user_Service.getUserById(w.getUser3_id()).getRealName());
					w.setColumn5("" + user_Service.getUserById(w.getUser4_id()).getRealName());
					w.setColumn6("" + user_Service.getUserById(w.getUser5_id()).getRealName());
				} catch (Exception e) {
					// TODO: handle exception
				}
				if (watchService.HowAboutFinishByWatchId(w.getId())) {
					w.setColumn2("1");
				} else {
					w.setColumn2("0");
				}
			}
		} catch (Exception e) {
			if (e instanceof IndexOutOfBoundsException) {
				System.out.println("数组越界");
			} else {
				e.printStackTrace();
			}
		}
		System.out.println(p3s);
		return "p3show";
	}

	public String add1() {
		list = project1_Service.getAllProject1s();
		return "add1";
	}

	public String getPro2sJson() {
		list = project2_Service.getPro2sByPro1_id(id);
		jsonArray = new JSONArray();
		for (Object object : list) {
			jsonArray.add(object);
		}
		return "getPro2Json";
	}

	public String list() {
		list = Project3_Service.getAllProject3s();
		return "list";
	}

	public String del() {
		try {
			Project3_Service.deleteProject3ById(id);
			list = Project3_Service.getAllProject3s();
			return "list";
		} catch (Exception e) {
			return Action.ERROR;
		}
	}

	public String lookup() {
		project3 = Project3_Service.getProject3ById(id);
		list = (ArrayList) taskService.getAllTaskByPro3_id(project3.getId());
		return "lookup";
	}

	public String lookup2() {
		project3 = Project3_Service.getProject3ById(id);
		list = taskService.getAllTaskByPro3_id(project3.getId());
		for (int i = 0; i < list.size(); i++) {
			Task task = (Task) list.get(i);
			list2 = project3_Service.getWatchspendByPro3(task.getId());
			task.setNum(list2.size());
		}
		return "lookup2";
	}

	public String updata() {
		try {
			Project3_Service.updataProject3(project3);
			list = Project3_Service.getAllProject3s();
			return Action.SUCCESS;
		} catch (Exception e) {
			return Action.ERROR;
		}
	}

	public String addExcel() {
		try {
			UploadDownUtil util = new UploadDownUtil(upload, uploadFileName, uploadContentType);
			String path = "/excelFiles";
			ArrayList<Pro3> list = util.realExcelPro3(path);
			for (Pro3 p : list) {
				int id = project2_Service.getPro2ByNo2(p.getPro2_id()).getId();
				p.setPro2_id(id);
				p.setUser_id(user_Service.getUserByName(p.getRate()).getId());
				try {
					project3_Service.insertProject3(p);
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

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
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

	public List<Watch> getWatchList() {
		return watchList;
	}

	public void setWatchList(List<Watch> watchList) {
		this.watchList = watchList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public Task getTask1() {
		return task1;
	}

	public void setTask1(Task task1) {
		this.task1 = task1;
	}

	public Task getTask2() {
		return task2;
	}

	public void setTask2(Task task2) {
		this.task2 = task2;
	}

	public JSONArray getJsonArray() {
		return jsonArray;
	}

	public void setJsonArray(JSONArray jsonArray) {
		this.jsonArray = jsonArray;
	}

	public Pro3 getProject3() {
		return project3;
	}

	public Pro1 getProject1() {
		return project1;
	}

	public void setProject1(Pro1 project1) {
		this.project1 = project1;
	}

	public void setProject3(Pro3 project3) {
		this.project3 = project3;
	}

	public Pro2 getProject2() {
		return project2;
	}

	public void setProject2(Pro2 project2) {
		this.project2 = project2;
	}

	public Pro3s getP3s() {
		return p3s;
	}

	public void setP3s(Pro3s p3s) {
		this.p3s = p3s;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getQqq() {
		return qqq;
	}

	public void setQqq(int qqq) {
		this.qqq = qqq;
	}

}
