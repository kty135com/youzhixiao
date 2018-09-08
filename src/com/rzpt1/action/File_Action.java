package com.rzpt1.action;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.rzpt.entity.*;
import com.rzpt.service.Pro1_Service;
import com.rzpt1.service.User_Service;
import com.rzpt1.service.Pro2_Service;
import com.rzpt1.service.Pro3_Service;
import com.rzpt1.service.Schedule_Service;
import com.rzpt.util.UploadDownUtil;
import com.rzpt1.service.Chengguo_Service;
import com.rzpt1.service.File_Service;
import com.rzpt1.service.Watch_Service;
import com.zhuozhengsoft.pageoffice.OpenModeType;
import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;

public class File_Action extends ActionSupport {

	private int id;
	private File file;
	private WenjianFile wjFile;
	private CgFile cgFile;
	private Watch watch;
	private Pro3 pro3;
	private Pro2 pro2;
	private Pro1 pro1;
	private String error;
	private int warn;
	private String imgurl;
	private String fileName;
	private List<File> files;
	private Double money;
	private File_Service fileService;
	private Watch_Service watchService;
	private Schedule_Service scheduleService;
	private Pro3_Service pro3Service;
	private Pro2_Service pro2Service;
	private Pro1_Service pro1Service;
	private Chengguo_Service cs;
	private String finename;
	private ArrayList watchs;
	private List<Watch> watchList;
	private User user;
	private User_Service userService;
	private String urlll;

	private List<java.io.File> uploads;
	private List uploadsFileName;
	private List uploadsContentType;
	private InputStream inputStream;

	public String down() throws UnsupportedEncodingException {
		System.out.println(fileName);
		try {
			System.out.println(fileName);
			try {
				System.out.println(file.getPath());
			} catch (Exception e) {

			}
			UploadDownUtil util = new UploadDownUtil();
			try {
				util.down(file.getPath(), fileName);
				inputStream = util.getInputStream();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (fileName.equals("示范用例.xls")) {
				finename = fileName;
				finename = new String(finename.getBytes(), "ISO-8859-1");
			} else {
				finename = fileName.substring(36, fileName.length()); // 36为uuid位数
				finename = new String(finename.getBytes(), "ISO-8859-1");
			}
		} catch (Exception e) {
			error = "此处尚无文件！";
			return this.ERROR;
		}
		return "down";
	}

	public String wjdown() throws UnsupportedEncodingException {
		System.out.println(fileName);
		try {
			System.out.println(fileName);
			try {
				System.out.println(wjFile.getPathname());
			} catch (Exception e) {
				e.printStackTrace();
			}
			UploadDownUtil util = new UploadDownUtil();
			try {
				util.down(wjFile.getPathname(), fileName, 1);
				inputStream = util.getInputStream();
			} catch (IOException e) {
				e.printStackTrace();
			}
			finename = new String(fileName.getBytes(), "ISO-8859-1");
		} catch (Exception e) {
			error = "此处尚无文件！";
			return this.ERROR;
		}
		return "down";
	}

	public String cgdown() throws UnsupportedEncodingException {
		try {
			System.out.println("fileName=" + fileName);
			try {
			} catch (Exception e) {
				e.printStackTrace();
			}
			UploadDownUtil util = new UploadDownUtil();
			try {
				System.out.println("cgFile.getPath()=" + cgFile.getPath() + "fileName=" + fileName);
				util.down(cgFile.getPath(), fileName);
				inputStream = util.getInputStream();
			} catch (IOException e) {
				e.printStackTrace();
			}
			finename = fileName.substring(36, fileName.length()); // 36为uuid位数
			finename = new String(finename.getBytes(), "ISO-8859-1");

		} catch (Exception e) {
			error = "此处尚无文件！";
			e.printStackTrace();
			return this.ERROR;
		}
		return "down";
	}

	public String look() throws ServletException, IOException {
		String path = "";
		if (warn == 9) {
			Schedule f = scheduleService.getScheduleById(file.getId());
			path = f.getPath();
		} else {
			File f = fileService.getFileById(file.getId());
			path = f.getPath();
		}
		System.out.println("fileName= " + fileName);
		String url = path + "/" + fileName;
		System.out.println(url);
		String str = url.substring(url.lastIndexOf("."), url.length());
		if (str.contains("pdf")) {
			url = url.substring(4, url.length());
		//	String u2 = "/zx1.pdf";
		//	String u = "/pdf/files/wenjianFIle/2/80ed840e-1ce7-41f2-81a7-b1d21bc1f126文档1.pdf";
			urlll = "/pdf/"+url;
			System.out.println("urlll="+urlll);
			return "pdf";
		}
		/*
		 * if (str.contains("jpg") || str.contains("jpeg") ||
		 * str.contains("png") || str.contains("gif")) { imgurl = url; return
		 * "img"; }
		 */
		HttpServletRequest request = ServletActionContext.getRequest();
		PageOfficeCtrl poCtrl1 = new PageOfficeCtrl(request);
		poCtrl1.setServerPage(request.getContextPath() + "/poserver.zz"); // 此行必须
		// Create custom toolbar

		/*
		 * poCtrl1.addCustomToolButton("保存", "SaveDocument()", 1);
		 * poCtrl1.addCustomToolButton("-", "", 0);
		 * poCtrl1.addCustomToolButton("打印", "ShowPrintDlg()", 6);
		 * poCtrl1.addCustomToolButton("-", "", 0);
		 * poCtrl1.addCustomToolButton("全屏切换", "SetFullScreen()", 4);
		 * poCtrl1.addCustomToolButton("-", "", 0);
		 * poCtrl1.addCustomToolButton("加盖印章", "AddSeal()", 5);
		 * poCtrl1.addCustomToolButton("手写签批", "AddHandSign()", 5);
		 * poCtrl1.addCustomToolButton("验证印章", "VerifySeal()", 5);
		 */

		poCtrl1.setTitlebar(false); // 隐藏标题栏
		poCtrl1.setMenubar(false); // 隐藏菜单栏
		poCtrl1.setOfficeToolbars(false);// 隐藏Office工具条
		poCtrl1.setCustomToolbar(false);// 隐藏自定义工具栏
		// poCtrl1.setSaveFilePage("saveword.action");
		url = url.replace("//", "\\\\");
		url = url.replace("/", "\\\\");
		System.out.println("url=" + url);
		if (str.contains("do")) {
			System.out.println("进入word");
			poCtrl1.webOpen(url, OpenModeType.docReadOnly, "用户");
		} else if (str.contains("xl")) {
			System.out.println("进入excel");
			poCtrl1.webOpen(url, OpenModeType.xlsReadOnly, "用户");
		}
		poCtrl1.setTagId("PageOfficeCtrl1"); // 此行必须
		fileName = null;
		return "look";
	}

	public String wjlook() throws ServletException, IOException {
		wjFile = cs.getwfFileById(wjFile.getId());
		String pathname = wjFile.getPathname();
		System.out.println("fileName= " + fileName);
		String url = pathname;
		System.out.println(url);
		String str = wjFile.getTname();
		if (str.contains("pdf")) {
			url = url.substring(4, url.length());
		//	String u2 = "/zx1.pdf";
		//	String u = "/pdf/files/wenjianFIle/2/80ed840e-1ce7-41f2-81a7-b1d21bc1f126文档1.pdf";
			urlll = "/pdf/"+url;
			System.out.println("urlll="+urlll);
			return "pdf";
		}
		/*
		 * if (str.contains("jpg") || str.contains("jpeg") ||
		 * str.contains("png") || str.contains("gif")) { imgurl = url; return
		 * "img"; }
		 */
		HttpServletRequest request = ServletActionContext.getRequest();
		PageOfficeCtrl poCtrl1 = new PageOfficeCtrl(request);
		poCtrl1.setServerPage(request.getContextPath() + "/poserver.zz"); // 此行必须
		// Create custom toolbar

		/*
		 * poCtrl1.addCustomToolButton("保存", "SaveDocument()", 1);
		 * poCtrl1.addCustomToolButton("-", "", 0);
		 * poCtrl1.addCustomToolButton("打印", "ShowPrintDlg()", 6);
		 * poCtrl1.addCustomToolButton("-", "", 0);
		 * poCtrl1.addCustomToolButton("全屏切换", "SetFullScreen()", 4);
		 * poCtrl1.addCustomToolButton("-", "", 0);
		 * poCtrl1.addCustomToolButton("加盖印章", "AddSeal()", 5);
		 * poCtrl1.addCustomToolButton("手写签批", "AddHandSign()", 5);
		 * poCtrl1.addCustomToolButton("验证印章", "VerifySeal()", 5);
		 */

		poCtrl1.setTitlebar(false); // 隐藏标题栏
		poCtrl1.setMenubar(false); // 隐藏菜单栏
		poCtrl1.setOfficeToolbars(false);// 隐藏Office工具条
		poCtrl1.setCustomToolbar(false);// 隐藏自定义工具栏
		// poCtrl1.setSaveFilePage("saveword.action");
		url = url.replace("//", "\\\\");
		url = url.replace("/", "\\\\");
		System.out.println("url=" + url);
		if (str.contains("do")) {
			System.out.println("进入word");
			poCtrl1.webOpen(url, OpenModeType.docReadOnly, "用户");
		} else if (str.contains("xl")) {
			System.out.println("进入excel");
			poCtrl1.webOpen(url, OpenModeType.xlsReadOnly, "用户");
		}
		poCtrl1.setTagId("PageOfficeCtrl1"); // 此行必须
		fileName = null;
		return "look";
	}

	public String add1() {
		watch = watchService.getWatch(watch.getId());
		user = userService.getUserById(user.getId());
		return "add";
	}

	public String add2() throws IOException {
		System.out.println(".....");
		try{
			if (watch.getRealMoney() == null) {
				error = "输入实际经费支出格式错误，如10.5万元，则输入10.5，没有则填0";
				return this.ERROR;
			}
			Double realMoney = watch.getRealMoney();
		}catch (Exception e) {
			error = "输入实际经费支出格式错误，如10.5万元，则输入10.5,没有则填0";
			return this.ERROR;
		}
		Double realMoney = watch.getRealMoney();
		watch = watchService.getWatch(file.getWatch_id());
		watch.setRealMoney(realMoney);
		watchService.updatee(watch);
		pro3 = pro3Service.getPro3ById(watch.getPro3_id());
		pro2 = pro2Service.getProject2ById(pro3.getPro2_id());
		pro1 = pro1Service.getProject1ById(pro2.getPro1_id());
		file.setPath("D://files/" + pro1.getId() + "/" + pro2.getId() + "/" + pro3.getId() + "/" + watch.getId() + "/"
				+ user.getId());
		file.setUser_id(user.getId());
		UploadDownUtil util = new UploadDownUtil(uploads, uploadsFileName, uploadsContentType);
		List list = util.upload(file.getPath());
		// if (list.get(0).equals("nofile")) {
		// error = "上传文件为空";
		// return this.ERROR;
		// }
		if (1 <= list.size()) {
			file.setName1((String) list.get(0));
		}
		if (2 <= list.size()) {
			file.setName2((String) list.get(1));
		}
		if (3 <= list.size()) {
			file.setName3((String) list.get(2));
		}
		if (4 <= list.size()) {
			file.setName4((String) list.get(3));
		}
		if (5 <= list.size()) {
			file.setName5((String) list.get(4));
		}
		if (6 <= list.size()) {
			file.setName6((String) list.get(5));
		}
		if (7 <= list.size()) {
			file.setName7((String) list.get(6));
		}
		int i = fileService.add(file);
		if (i == 1) {
			watchList = watchService.getUnfinishByTeacher(user.getId());
			for (int u = 0; u < watchList.size(); u++) {
				int j = fileService.getFileByWatchIdAndUserId(watchList.get(u).getId(), user.getId());
				watchList.get(u).setNum(j);
			}
			return "unfinishByTeacher";
		} else {
			return "error";
		}
	}

	public String wjupload() throws IOException {
		if (wjFile.getWenjian_id() == null && wjFile.getWenjian_id() == 0) {
			error = "所属文档未选择，请先选择所属文档再上传附件";
			return "error";
		}
		Integer id = wjFile.getWenjian_id();
		UploadDownUtil util = new UploadDownUtil(uploads, uploadsFileName, uploadsContentType);
		System.out.println(util.toString());
		wjFile = new WenjianFile();
		wjFile.setWenjian_id(id);
		wjFile.setPathname("D://files/wenjianFIle/" + wjFile.getWenjian_id() + "/");
		List fileNameList = util.upload(wjFile.getPathname());
		wjFile.setPathname(wjFile.getPathname() + fileNameList.get(0));
		wjFile.setTname("" + uploadsFileName.get(0));
		cs.addwnFile(wjFile);
		return "success";
	}

	public String updateState() {
		try {
			File f = fileService.getFileByWatch_id(watch.getId());
		} catch (Exception e) {
			error = "该要点未检测到任何上传文件，请上传文件";
			return "error";
		}
		watchService.updateState(watch.getId(), 1);
		return SUCCESS;
	}

	public String cg_Add() throws IOException {
		cgFile.setPath("/cg_file/" + cgFile.getCg_id());
		UploadDownUtil util = new UploadDownUtil(uploads, uploadsFileName, uploadsContentType);
		List list = util.upload(cgFile.getPath());
		if (list.get(0).equals("nofileawefdcdsfwrffdsczxwer")) {
			error = "上传文件为空";
			return this.ERROR;
		}
		if (1 <= list.size()) {
			cgFile.setName1((String) list.get(0));
		}
		if (2 <= list.size()) {
			cgFile.setName2((String) list.get(1));
		}
		if (3 <= list.size()) {
			cgFile.setName3((String) list.get(2));
		}
		if (4 <= list.size()) {
			cgFile.setName4((String) list.get(3));
		}
		if (5 <= list.size()) {
			cgFile.setName5((String) list.get(4));
		}
		if (6 <= list.size()) {
			cgFile.setName6((String) list.get(5));
		}
		if (7 <= list.size()) {
			cgFile.setName7((String) list.get(6));
		}
		int i = cs.add(cgFile);
		if (i == 1) {
			return "success";
		} else {
			return ERROR;
		}
	}

	public String lookup() {
		try {
			System.out.println("id = " + id);
			watch = watchService.getWatch(id);
			List<File> fileList = fileService.getFileListByWatchId(watch.getId());
			System.out.println("fileList=" + fileList);
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
			System.out.println("id=" + id);
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
			try {
				money = watch.getRealMoney() - watch.getMoney();
			} catch (Exception e) {

			}
			return "lookup";
		} catch (Exception e) {
			e.printStackTrace();
			error = "该验收要点负责人还没有上传文件";
			return Action.ERROR;
		}
	}

	public void addActionError(String anErrorMessage) {
		// 这里要先判断一下，是我们要替换的错误，才处理
		if (anErrorMessage.startsWith("the request was rejected because its size")) {
			Matcher m = Pattern.compile("//d+").matcher(anErrorMessage);
			String s1 = "";
			if (m.find())
				s1 = m.group();
			String s2 = "";
			if (m.find())
				s2 = m.group();
			// 偷梁换柱，将信息替换掉
			super.addActionError("你上传的文件大小（" + s1 + "）超过允许的大小（" + s2 + "）");
			// 也可以改为在Field级别的错误
			// super.addFieldError("file","你上传的文件大小（" + s1 + "）超过允许的大小（" + s2 +
			// "）");
		} else {// 否则按原来的方法处理
			super.addActionError(anErrorMessage);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Watch getWatch() {
		return watch;
	}

	public void setWatch(Watch watch) {
		this.watch = watch;
	}

	public Pro3 getPro3() {
		return pro3;
	}

	public void setPro3(Pro3 pro3) {
		this.pro3 = pro3;
	}

	public Pro2 getPro2() {
		return pro2;
	}

	public void setPro2(Pro2 pro2) {
		this.pro2 = pro2;
	}

	public Pro1 getPro1() {
		return pro1;
	}

	public void setPro1(Pro1 pro1) {
		this.pro1 = pro1;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public File_Service getFileService() {
		return fileService;
	}

	public void setFileService(File_Service fileService) {
		this.fileService = fileService;
	}

	public Watch_Service getWatchService() {
		return watchService;
	}

	public void setWatchService(Watch_Service watchService) {
		this.watchService = watchService;
	}

	public Pro3_Service getPro3Service() {
		return pro3Service;
	}

	public void setPro3Service(Pro3_Service pro3Service) {
		this.pro3Service = pro3Service;
	}

	public Pro2_Service getPro2Service() {
		return pro2Service;
	}

	public void setPro2Service(Pro2_Service pro2Service) {
		this.pro2Service = pro2Service;
	}

	public Pro1_Service getPro1Service() {
		return pro1Service;
	}

	public void setPro1Service(Pro1_Service pro1Service) {
		this.pro1Service = pro1Service;
	}

	public List<java.io.File> getUploads() {
		return uploads;
	}

	public void setUploads(List<java.io.File> uploads) {
		this.uploads = uploads;
	}

	public List getUploadsFileName() {
		return uploadsFileName;
	}

	public void setUploadsFileName(List uploadsFileName) {
		this.uploadsFileName = uploadsFileName;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	public ArrayList getWatchs() {
		return watchs;
	}

	public void setWatchs(ArrayList watchs) {
		this.watchs = watchs;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Watch> getWatchList() {
		return watchList;
	}

	public void setWatchList(List<Watch> watchList) {
		this.watchList = watchList;
	}

	public int getWarn() {
		return warn;
	}

	public void setWarn(int warn) {
		this.warn = warn;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Schedule_Service getScheduleService() {
		return scheduleService;
	}

	public void setScheduleService(Schedule_Service scheduleService) {
		this.scheduleService = scheduleService;
	}

	public Chengguo_Service getCs() {
		return cs;
	}

	public User_Service getUserService() {
		return userService;
	}

	public List getUploadsContentType() {
		return uploadsContentType;
	}

	public void setUploadsContentType(List uploadsContentType) {
		this.uploadsContentType = uploadsContentType;
	}

	public String getUrlll() {
		return urlll;
	}

	public void setUrlll(String urlll) {
		this.urlll = urlll;
	}

	public WenjianFile getWjFile() {
		return wjFile;
	}

	public void setWjFile(WenjianFile wjFile) {
		this.wjFile = wjFile;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public void setUserService(User_Service userService) {
		this.userService = userService;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getFinename() {
		return finename;
	}

	public void setFinename(String finename) {
		this.finename = finename;
	}

	public void setCs(Chengguo_Service cs) {
		this.cs = cs;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public CgFile getCgFile() {
		return cgFile;
	}

	public void setCgFile(CgFile cgFile) {
		this.cgFile = cgFile;
	}

}
