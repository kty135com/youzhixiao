package com.rzpt1.action;

import java.io.InputStream;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.rzpt.entity.Audit;
import com.rzpt.entity.Dept;
import com.rzpt.entity.File;
import com.rzpt.entity.Pro1;
import com.rzpt.entity.Pro2;
import com.rzpt.entity.Pro3;
import com.rzpt.entity.Task;
import com.rzpt.entity.User;
import com.rzpt.entity.Watch;
import com.rzpt.entity.Watch_join;
import com.rzpt.service.Pro1_Service;
import com.rzpt.util.FormatUtil;
import com.rzpt.util.UploadDownUtil;
import com.rzpt1.service.Audit_Service;
import com.rzpt1.service.Dept_Service;
import com.rzpt1.service.File_Service;
import com.rzpt1.service.Pro2_Service;
import com.rzpt1.service.Pro3_Service;
import com.rzpt1.service.Task_Service;
import com.rzpt1.service.User_Service;
import com.rzpt1.service.Watch_Service;

import net.sf.json.JSONArray;

public class Watch_Action extends ActionSupport {
	private JSONArray jsonArray;
	private String showState;
	private String warn;
	private int qqq;
	private Double money;
	private Watch watch;
	private Dept dept;
	private Pro3 pro3;
	private Pro2 pro2;
	private Pro1 pro1;
	private Task task;
	private User user, user1, user2, user3, user4, user5;
	private File file;
	private Audit audit;
	private List<Watch> watchList;
	private List<File> files;
	private List watchs;
	private List tasks;
	private List users;
	private List depts;
	private List deptss;
	private List list0, list1, list2, list3, list4, list5, list6, list7, list8;
	private ArrayList list;
	private ArrayList p2s;
	private Watch_Service watchService;
	private Task_Service taskService;
	private User_Service userService;
	private Dept_Service deptService;
	private File_Service fileService;
	private Audit_Service auditService;

	private List<java.io.File> upload;
	private List uploadFileName;
	private List uploadContentType;
	private InputStream inputStream;

	@Resource(name = "pro1Service")
	private Pro1_Service pro1Service;
	private Pro2_Service pro2Service;

	@Resource(name = "project2_Service")
	private com.rzpt.service.Pro2_Service project2_Service;
	private Pro3_Service pro3Service;

	@Resource(name = "project1_Service")
	private Pro1_Service project1_Service;

	@Resource(name = "project3_Service")
	private com.rzpt.service.Pro3_Service project3_Service;
	private int id;
	private String error;

	public String add1() {
		list = pro1Service.getAllProject1s();
		return "add";
	}

	public String add2() {
		int pro3_id = taskService.getPro3_idById(watch.getTask_id());
		watch.setState(0);
		watch.setUser_id(null);
		watch.setFinish_time(null);
		watch.setUser1_id(null);
		watch.setUser2_id(null);
		watch.setPro3_id(pro3_id);
		task = taskService.getTaskById(watch.getTask_id());
		int i = watchService.add(watch);
		if (i == 1) {
			list = pro1Service.getAllProject1s();
			qqq = 1;
			return "add";
		} else {
			return ERROR;
		}
	}

	public String addExcel() {
		try {
			UploadDownUtil util = new UploadDownUtil(upload, uploadFileName, uploadContentType);
			String path = "/excelFiles";
			ArrayList<Watch> watchList = util.readExcelwatch(path);
			for (Watch w : watchList) {
				w.setTask_id(taskService.getTaskByNo2(w.getTask_id()).getId());
				w.setDept_id(deptService.getDeptByName(w.getFinish_time()).getId());
				w.setFinish_time(null);
				Task t = taskService.getTask(w.getTask_id());
				w.setPro3_id(t.getPro3_id());
				w.setUser_id(userService.getUserByrealName(w.getColumn()).getId());
				try {
					w.setUser1_id(userService.getUserByrealName(w.getColumn2()).getId());
					w.setUser2_id(userService.getUserByrealName(w.getColumn3()).getId());
					w.setUser3_id(userService.getUserByrealName(w.getColumn4()).getId());
					w.setUser4_id(userService.getUserByrealName(w.getColumn5()).getId());
					w.setUser5_id(userService.getUserByrealName(w.getColumn6()).getId());
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					watchService.add(w);
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

	// 超管查看未完成的观测点
	public String unfinish() {
		watchs = watchService.getUnfinishWatchs();
		return "unfinish";
	}

	public String finish() {
		watchs = watchService.getFinishWatchs();
		return "finish";
	}

	public String show() {
		watch = watchService.getWatch(watch.getId());
		task = taskService.getTaskById(watch.getTask_id());
		user = userService.getUserById(watch.getUser_id());
		user1 = userService.getUser1ById(watch.getUser1_id());
		try {
			user2 = userService.getUser2ById(watch.getUser2_id());
		} catch (Exception e) {

		}
		try {
			user3 = userService.getUserById(watch.getUser3_id());
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			user4 = userService.getUserById(watch.getUser4_id());
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			user5 = userService.getUserById(watch.getUser5_id());
		} catch (Exception e) {
			// TODO: handle exception
		}
		showState = watch.showState();
		return "show";
	}

	public String update1() {
		watch = watchService.getWatch(watch.getId());
		tasks = taskService.getAllTask();
		return "update";
	}

	public String update2() {
		int i = watchService.update(watch);
		if (i == 1) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String delete() {
		watch = watchService.getWatch(id);
		watchService.deleteWatch(watch);
		return this.SUCCESS;
	}

	// 未分配的列表
	public String unallocated() {
		watchs = watchService.unallocated(user.getId());
		return "unallocated";
	}

	// 未分配的列表
	public String queryUnAllocated() {
		watchs = watchService.queryUnAllocated(user.getId(), pro3.getName());
		if (watchs.size() == 0) {
			return "noResult";
		}
		return "unallocated";
	}

	// 辅助观测点未分配的列表
	public String otherUnallocated() {
		watchs = watchService.otherUnallocated(user.getId());
		return "otherUnallocated";
	}

	public String otherAllocate1() {
		// 获得本院部的老师
		users = userService.getTeachersByDept(user.getId());
		return "otherAllocate";
	}

	public String otherAllocate2() {
		int i = watchService.allocate(watch);
		if (i == 1) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String getTasksJson() {
		list = taskService.getMomentByPro3_id(id);
		jsonArray = new JSONArray();
		for (Object object : list) {
			jsonArray.add(object);
		}
		System.out.println("json=" + jsonArray.toString());
		return "getPro2Json";
	}

	public String getUsersJson() {
		users = userService.getTeachersByDept_id(dept.getId());
		jsonArray = new JSONArray();
		for (Object object : users) {
			jsonArray.add(object);
		}
		return "getUserJson";
	}

	public String allocate1() {
		// 获得所有院部
		deptss = deptService.getAllDepts();
		// 获取除本院部的其它院部
		// depts = deptService.getOtherDept(user.getId());
		return "allocate";
	}

	public String allocate2() {
		if (watch.getDept_id() == null) {
			user = userService.getUserById(user.getId());
			watch.setDept_id(user.getDept_id());
		}
		int i = watchService.allocate(watch);
		if (i == 1) {
			watchs = watchService.unallocated(user.getId());
			return "unallocated";
		} else {
			return ERROR;
		}
	}

	// 院部管理员查看未完成的观测点
	public String unfinishByDept() {
		watchs = watchService.getUnfinishWatchsByDept(user.getId());
		return "unfinishByDept";
	}

	public String queryUnfinishByDept() {
		watchs = watchService.queryUnfinishWatchsByDept(user.getId(), pro3.getName());
		if (watchs.size() == 0) {
			return "noResult";
		}
		return "unfinishByDept";
	}

	// 院部管理员查看待验收的观测点
	public String finishByDept() {
		watchs = watchService.getFinishWatchsByDept(user.getId());
		return "finishByDept";
	}

	// 院部管理员查看已验收的观测点
	public String finishByDept2() {
		watchs = watchService.getFinishWatchsByDept2(user.getId());
		return "finishByDept";
	}

	public String queryFinishByDept() {
		watchs = watchService.queryFinishByDept(user.getId(), pro3.getName());
		if (watchs.size() == 0) {
			return "noResult";
		}
		return "finishByDept";
	}

	public String queryUnpend() {
		watchs = watchService.queryUnpend(user.getId(), pro3.getName());
		if (watchs.size() == 0) {
			return "noResult";
		}
		return "unpend";
	}

	// 院部管理员查看待审核的观测点
	public String unpend() {
		watchs = watchService.getUnpend(user.getId());
		return "unpend";
	}

	// 院部点击审核通过
	public String pass() {
		audit = new Audit();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:MM:ss");
		String time = sdf.format(new Date());
		// String finish_time = sdf.format(new Date());
		watch = watchService.getWatch(watch.getId());
		// watch.setFinish_time(finish_time);
		watchService.updata(watch);
		audit.setTime(time);
		audit.setResult(0);
		audit.setWatch_id(watch.getId());
		audit.setUser_id(user.getId());
		auditService.add(audit);
		watchService.pass(watch.getId());
		pro3 = watchService.getPro3ByPro3_id(watch.getPro3_id());
		double n = watchService.chushu(pro3.getId());
		double nn = watchService.beichushu(pro3.getId());
		double i = n / nn;
		// if (i == 1) {
		// finish_time = sdf.format(new Date());
		// pro3.setFinish_time(finish_time);
		// }
		watchService.updataa(pro3);
		watchs = watchService.getUnpend(user.getId());
		return "unpend";
	}

	public String unpass() {
		auditService.add(audit);
		watchService.updateState(watch.getId(), 3);
		user = userService.getUserById(audit.getUser_id());
		watchs = watchService.getUnpend(user.getId());
		ArrayList<File> fileList = fileService.getFileListByWatchId(watch.getId());
		for (File file : fileList) {
			// fileService.deleteFileById(file);
		}
		return "unpend";
	}

	// 教师下载审核失败的文件
	public String downloadunpassfile() {
		file = fileService.getAFileByWatchIdAndUserId(watch.getId(), user.getId());
		System.out.println(file);
		file = FormatUtil.getFilerealNamesToTnames(file);
		System.out.println(file);
		return "downloadunpassfile";
	}

	// 未审核观测点的可以撤回
	public String chehui() {
		Watch w = watchService.getWatch(watch.getId());
		w.setState(0);
		watchService.updata(w);
		watchs = watchService.getWatchsByState(w.getUser_id(), 1);
		return "unpendByTeacher";
	}

	public String failShow() {
		watch = watchService.getWatch(watch.getId());
		task = taskService.getTaskById(watch.getTask_id());
		user = userService.getUserById(watch.getUser_id());
		audit = auditService.getAuditByWatch_id(watch.getId());
		user1 = userService.getUser1ById(watch.getUser1_id());
		user2 = userService.getUser2ById(watch.getUser2_id());
		showState = watch.showState();
		return "failShow";
	}

	// 院部审核
	public String pend() {
		watch = watchService.getWatch(watch.getId());
		System.out.println("watch=" + watch);
		try {
			money = watch.getRealMoney() - watch.getMoney();
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<File> fileList = fileService.getFileListByWatchId(watch.getId());
		System.out.println("fileList=" + fileList);
		int[] arr = new int[fileList.size()];
		for (int i = 0; i < fileList.size(); i++) {
			arr[i] = fileList.get(i).getUser_id();
			System.out.println("arr=" + Arrays.toString(arr));
		}
		List<Integer> list = new ArrayList<Integer>();
		try {
			list.add(arr[0]);
			for (int i = 1; i < arr.length; i++) {
				if (list.indexOf(arr[i]) == -1) {
					list.add(arr[i]);
				}
				System.out.println("listlist==" + list);
			}
			System.out.println("list.size()=" + list.size());
			files = new ArrayList<File>();
			for (int i = 0; i < list.size(); i++) {
				File f = fileService.getAFileByWatchIdAndUserId(watch.getId(), list.get(i));
				files.add(f);
			}
			for (File f : files) {
				f.setTname1(f.getName1().substring(36, f.getName1().length()));
				if (f.getName2() != null) {
					f.setTname2(f.getName2().substring(36, f.getName2().length()));
				}
				if (f.getName3() != null) {
					f.setTname3(f.getName3().substring(36, f.getName3().length()));
				}
				if (f.getName4() != null) {
					f.setTname4(f.getName4().substring(36, f.getName4().length()));
				}
				if (f.getName5() != null) {
					f.setTname5(f.getName5().substring(36, f.getName5().length()));
				}
				if (f.getName6() != null) {
					f.setTname6(f.getName6().substring(36, f.getName6().length()));
				}
				if (f.getName7() != null) {
					f.setTname7(f.getName7().substring(36, f.getName7().length()));
				}
			}
			System.out.println("files=====" + files);
			return "pend";
		} catch (IndexOutOfBoundsException aioobe) {
			warn = "该要点无文件，也无文字描述";
			return "pend";
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	// admin审核通过
	public String adminshenhe() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String finish_time = sdf.format(new Date());
		watch = watchService.getWatch(watch.getId());
		watch.setFinish_time(finish_time);
		watch.setState(5);
		watchService.updata(watch);
		Pro3 pro3 = watchService.getPro3ByPro3_id(watch.getPro3_id());
		double n = watchService.chushu(pro3.getId());
		double nn = watchService.beichushu(pro3.getId());
		double i = n / nn;
		NumberFormat num = NumberFormat.getPercentInstance();
		num.setMaximumIntegerDigits(3);
		num.setMaximumFractionDigits(2);
		pro3.setSchedule(num.format(i));
		if (i == 1) {
			pro3.setState(2);
		}
		pro3Service.updatePro3(pro3);

		pro2 = pro2Service.getProject2ByPro3(pro3.getPro2_id());
		double fenzi = 0;
		double fenmu = 0;
		List<Pro3> pro3List = pro3Service.getPro3sByPro2_id(pro2.getId());
		for (int j = 0; j < pro3List.size(); j++) {
			Pro3 p3 = pro3List.get(j);
			fenzi = fenzi + watchService.chushu(p3.getId());
			fenmu = fenmu + watchService.beichushu(p3.getId());
		}

		double eeee = fenzi / fenmu;
		num.setMaximumIntegerDigits(3);
		num.setMaximumFractionDigits(2);
		pro2.setSchedule(num.format(eeee));
		if (eeee == 1) {
			pro2.setState(2);
			String s1 = sdf.format(new Date());
			pro2.setFinish_time(s1);
		}
		pro2Service.update(pro2);

		pro1 = pro1Service.getProject1ById(pro2.getPro1_id());
		list = project2_Service.getPro2sByPro1_id(pro1.getId());
		double q = list.size();
		list = project2_Service.getProject2sByPro1_idAndState(pro1.getId());
		double qq = list.size();
		double qqq = qq / q;
		num.setMaximumIntegerDigits(3);
		num.setMaximumFractionDigits(2);
		pro1.setSchedule(num.format(qqq));
		pro1Service.updataProject1(pro1);

		return "success";
	}

	// admin审核不通过
	public String admintuihui() {
		watch = watchService.getWatch(watch.getId());
		watch.setFinish_time(null);
		watch.setState(3);
		watchService.updata(watch);
		return "success";
	}

	// 查看附件
	public String fujianlook() {
		watch = watchService.getWatch(watch.getId());
		try {
			List<File> fileList = fileService.getFileListByWatchId(watch.getId());
			System.out.println("fileList.size()-1=" + (fileList.size() - 1));
			int[] arr = new int[fileList.size()];
			for (int i = 0; i < fileList.size(); i++) {
				arr[i] = fileList.get(i).getUser_id();
				System.out.println("arr=" + Arrays.toString(arr));
			}
			List<Integer> list = new ArrayList<Integer>();
			list.add(arr[0]);
			for (int i = 1; i < arr.length; i++) {
				if (list.indexOf(arr[i]) == -1) {
					list.add(arr[i]);
				}
				System.out.println("listlist==" + list);
			}
			System.out.println("list.size()=" + list.size());
			files = new ArrayList<File>();
			for (int i = 0; i < list.size(); i++) {
				File f = fileService.getAFileByWatchIdAndUserId(watch.getId(), list.get(i));
				files.add(f);
			}
			for (File file : files) {
				file.setTname1(file.getName1().substring(36, file.getName1().length()));
				if (file.getName2() != null) {
					file.setTname2(file.getName2().substring(36, file.getName2().length()));
				}
				if (file.getName3() != null) {
					file.setTname3(file.getName3().substring(36, file.getName3().length()));
				}
				if (file.getName4() != null) {
					file.setTname4(file.getName4().substring(36, file.getName4().length()));
				}
				if (file.getName5() != null) {
					file.setTname5(file.getName5().substring(36, file.getName5().length()));
				}
				if (file.getName6() != null) {
					file.setTname6(file.getName6().substring(36, file.getName6().length()));
				}
				if (file.getName7() != null) {
					file.setTname7(file.getName7().substring(36, file.getName7().length()));
				}
			}
			System.out.println("files=" + files);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "file_look";
	}

	// 教师查看未完成的观测点
	public String unfinishByTeacher() {
		watchList = watchService.getUnfinishByTeacher(user.getId());
		for (int i = 0; i < watchList.size(); i++) {
			int j = fileService.getFileByWatchIdAndUserId(watchList.get(i).getId(), user.getId());
			watchList.get(i).setNum(j);
		}
		return "unfinishByTeacher";
	}

	// 教师查看待审核的观测点
	public String unpendByTeacher() {
		watchs = watchService.getWatchsByState(user.getId(), 1);
		return "unpendByTeacher";
	}

	// 教师查看审核失败的观测点
	public String pendFail() {
		watchs = watchService.getWatchsByState(user.getId(), 3);
		return "pendFail";
	}

	// 教师查看审核成功的观测点
	public String pendSuccess() {
		watchs = watchService.getWatchsByState(user.getId(), 2);
		return "unpendByTeacher3";
	}

	// 教师查看验收成功的观测点
	public String pendSuccess2() {
		List<Watch> watchss = watchService.getWatchsByState(user.getId(), 4);
		List<Watch> watchsss = watchService.getWatchsByState(user.getId(), 5);
		for (int i = 0; i < watchsss.size(); i++) {
			watchss.add(watchsss.get(i));
		}
		watchs = watchss;
		return "unpendByTeacher2";
	}

	public String lookup() {
		watch = watchService.getWatch(id);
		return "lookup";
	}

	public String look() {
		watch = watchService.getWatch(id);
		return "look";
	}

	// 验收通过
	public String pend5() {
		watch = watchService.getWatch(id);
		watch.setState(4);
		watchService.updata(watch);
		pro3 = watchService.getPro3ByPro3_id(watch.getPro3_id());
		double n = watchService.chushu(pro3.getId());
		double nn = watchService.beichushu(pro3.getId());
		double i = n / nn;
		NumberFormat num = NumberFormat.getPercentInstance();
		num.setMaximumIntegerDigits(3);
		num.setMaximumFractionDigits(2);
		// pro3.setSchedule(num.format(i));
		if (i == 1) {
			pro3.setState(2);
		}
		watchService.updataa(pro3);

		Task t = taskService.getTask(watch.getTask_id());
		p2s = watchService.getWatchByTask_id(t.getId());
		return "pend4";
	}

	// 验收不通过
	public String pend6() {
		watch = watchService.getWatch(id);
		watch.setState(3);
		watch.setFinish_time(null);
		watchService.updata(watch);
		Task t = taskService.getTask(watch.getTask_id());
		p2s = watchService.getWatchByTask_id(t.getId());
		return "pend4";
	}

	public String updata() {
		try {
			watchService.update(watch);
			return this.SUCCESS;
		} catch (Exception e) {
			return this.ERROR;
		}
	}

	public String joinList() {
		try {
			// 参与的验收点 watch的id和name
			try {
				list0 = watchService.getJoinWatch_id(user.getId());
			} catch (Exception e) {
				list0 = null;
			}
			try {
				list1 = watchService.getJoinName(user.getId());
			} catch (Exception e) {
				list1 = null;
			}
			try {
				list2 = watchService.getJoinUser_name(user.getId());
			} catch (Exception e) {
				list2 = null;
			}
			try {
				list3 = watchService.getJoinUser1_name(user.getId());
			} catch (Exception e) {
				list3 = null;
			}
			try {
				list4 = watchService.getJoinUser2_name(user.getId());
			} catch (Exception e) {
				list4 = null;
			}
			try {
				list6 = watchService.getJoinUser3_name(user.getId());
			} catch (Exception e) {
				list6 = null;
			}
			try {
				list7 = watchService.getJoinUser4_name(user.getId());
			} catch (Exception e) {
				list7 = null;
			}
			try {
				list8 = watchService.getJoinUser5_name(user.getId());
			} catch (Exception e) {
				list8 = null;
			}
			try {
				list5 = watchService.getJoinTask_name(user.getId());
			} catch (Exception e) {
				list5 = null;
			}
			if (list0.size() > 0) {
				Watch_join watch_join;
				watchs = new ArrayList();
				for (int i = 0; i < list0.size(); i++) {
					watch_join = new Watch_join();
					watch_join.setWatch_id((Integer) list0.get(i));
					watch_join.setWatch_name((String) list1.get(i));
					watch_join.setUser_name((String) list2.get(i));
					if (list3.get(i) == null) {
						watch_join.setUser1_name("无");
					} else {
						watch_join.setUser1_name((String) list3.get(i));
					}
					if (list4.get(i) == null) {
						watch_join.setUser2_name("无");
					} else {
						watch_join.setUser2_name((String) list4.get(i));
					}
					if (list6.get(i) == null) {
						watch_join.setUser3_name("无");
					} else {
						watch_join.setUser3_name((String) list6.get(i));
					}
					if (list7.get(i) == null) {
						watch_join.setUser4_name("无");
					} else {
						watch_join.setUser4_name((String) list7.get(i));
					}
					if (list8.get(i) == null) {
						watch_join.setUser5_name("无");
					} else {
						watch_join.setUser5_name((String) list8.get(i));
					}
					watch_join.setTask_name((String) list5.get(i));
					watchs.add(watch_join);
				}
			}
			return "joinList";
		} catch (Exception e) {
			e.printStackTrace();
			error = "参与的验收点列表为空";
			return this.ERROR;
		}
	}

	public Pro2 getPro2() {
		return pro2;
	}

	public void setPro2(Pro2 pro2) {
		this.pro2 = pro2;
	}

	public Watch_Service getWatchService() {
		return watchService;
	}

	public void setWatchService(Watch_Service watchService) {
		this.watchService = watchService;
	}

	public User_Service getUserService() {
		return userService;
	}

	public void setUserService(User_Service userService) {
		this.userService = userService;
	}

	public Watch getWatch() {
		return watch;
	}

	public void setWatch(Watch watch) {
		this.watch = watch;
	}

	public List getWatchs() {
		return watchs;
	}

	public void setWatchs(List watchs) {
		this.watchs = watchs;
	}

	public List getTasks() {
		return tasks;
	}

	public void setTasks(List tasks) {
		this.tasks = tasks;
	}

	public List getUsers() {
		return users;
	}

	public void setUsers(List users) {
		this.users = users;
	}

	public Task_Service getTaskService() {
		return taskService;
	}

	public void setTaskService(Task_Service taskService) {
		this.taskService = taskService;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public File_Service getFileService() {
		return fileService;
	}

	public void setFileService(File_Service fileService) {
		this.fileService = fileService;
	}

	public Audit_Service getAuditService() {
		return auditService;
	}

	public void setAuditService(Audit_Service auditService) {
		this.auditService = auditService;
	}

	public Audit getAudit() {
		return audit;
	}

	public void setAudit(Audit audit) {
		this.audit = audit;
	}

	public Pro3 getPro3() {
		return pro3;
	}

	public void setPro3(Pro3 pro3) {
		this.pro3 = pro3;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPro2Service(Pro2_Service pro2Service) {
		this.pro2Service = pro2Service;
	}

	public ArrayList getList() {
		return list;
	}

	public void setList(ArrayList list) {
		this.list = list;
	}

	public void setPro3Service(Pro3_Service pro3Service) {
		this.pro3Service = pro3Service;
	}

	public String getShowState() {
		return showState;
	}

	public void setShowState(String showState) {
		this.showState = showState;
	}

	public Pro1 getPro1() {
		return pro1;
	}

	public void setPro1(Pro1 pro1) {
		this.pro1 = pro1;
	}

	public JSONArray getJsonArray() {
		return jsonArray;
	}

	public void setJsonArray(JSONArray jsonArray) {
		this.jsonArray = jsonArray;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public List getList0() {
		return list0;
	}

	public void setList0(List list0) {
		this.list0 = list0;
	}

	public List getList1() {
		return list1;
	}

	public void setList1(List list1) {
		this.list1 = list1;
	}

	public List getList2() {
		return list2;
	}

	public void setList2(List list2) {
		this.list2 = list2;
	}

	public List getList3() {
		return list3;
	}

	public void setList3(List list3) {
		this.list3 = list3;
	}

	public List getDeptss() {
		return deptss;
	}

	public void setDeptss(List deptss) {
		this.deptss = deptss;
	}

	public List getList4() {
		return list4;
	}

	public void setList4(List list4) {
		this.list4 = list4;
	}

	public List<Watch> getWatchList() {
		return watchList;
	}

	public void setWatchList(List<Watch> watchList) {
		this.watchList = watchList;
	}

	public User getUser3() {
		return user3;
	}

	public void setUser3(User user3) {
		this.user3 = user3;
	}

	public User getUser4() {
		return user4;
	}

	public void setUser4(User user4) {
		this.user4 = user4;
	}

	public User getUser5() {
		return user5;
	}

	public void setUser5(User user5) {
		this.user5 = user5;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public List getList5() {
		return list5;
	}

	public void setList5(List list5) {
		this.list5 = list5;
	}

	public ArrayList getP2s() {
		return p2s;
	}

	public void setP2s(ArrayList p2s) {
		this.p2s = p2s;
	}

	public User getUser1() {
		return user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public User getUser2() {
		return user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

	public int getQqq() {
		return qqq;
	}

	public void setQqq(int qqq) {
		this.qqq = qqq;
	}

	public String getWarn() {
		return warn;
	}

	public void setWarn(String warn) {
		this.warn = warn;
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

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

}
