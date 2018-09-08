package com.rzpt1.action;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.rzpt.entity.File;
import com.rzpt.entity.Schedule;
import com.rzpt.entity.User;
import com.rzpt.entity.Watch;
import com.rzpt1.service.File_Service;
import com.rzpt1.service.Schedule_Service;
import com.rzpt.util.UploadDownUtil;
import com.rzpt1.service.Watch_Service;

public class Schedule_Action extends ActionSupport {
	private Watch watch;
	private File file;
	private Schedule schedule;
	private ArrayList list;
	private ArrayList<Schedule> list2;
	private ArrayList watchs;
	private User user;
	private List<Watch> watchList;
	private String msg;

	private Schedule_Service scheduleService;
	private Watch_Service watchService;
	private File_Service fileService;

	private List<java.io.File> upload;
	private List uploadFileName;
	private List uploadContentType;
	private InputStream inputStream;

	public String look() {
		list2 = scheduleService.getScheduleByWatchId(watch.getId());
		for (Schedule s : list2) {
			try {
				s.setName2(s.getName().substring(36, s.getName().length()));
			} catch (Exception e) {
				e.printStackTrace();
				s.setName2(s.getName());
			}
		}
		list = list2;
		return "look";
	}

	public String add1() {
		watch = watchService.getWatch(watch.getId());
		return "add";
	}
	
	public String delScheduleById(){
		scheduleService.delScheduleById(schedule.getId());
		return "success";
	}

	public String add2() {
		System.out.println(watch.getId());
		watch = watchService.getWatch(watch.getId());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String now = sdf.format(new Date());
		schedule.setTime(now);
		schedule.setPath("D://scheduleFiles/" + watch.getId() + "/" + watch.getUser_id());
		UploadDownUtil util = new UploadDownUtil(upload, uploadFileName, uploadContentType);
		int i = 0;
		try {
			List list = util.upload(schedule.getPath());
			schedule.setName((String) list.get(0));
			if (schedule.getName() == "nofile") {
				schedule.setName("нчнд╪Ч");
			}
			System.out.println(schedule.getWatch_id());
			schedule.setWatch_id(watch.getId());
			i = scheduleService.add(schedule);
		} catch (IOException e) {
			e.printStackTrace();
			return "error";
		}
		if (i == 1) {

			return "success";
		}
		return "error";
	}

	public Watch getWatch() {
		return watch;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setWatch(Watch watch) {
		this.watch = watch;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public void setScheduleService(Schedule_Service scheduleService) {
		this.scheduleService = scheduleService;
	}

	public ArrayList getList() {
		return list;
	}

	public void setList(ArrayList list) {
		this.list = list;
	}

	public void setWatchService(Watch_Service watchService) {
		this.watchService = watchService;
	}

	public List<java.io.File> getUpload() {
		return upload;
	}

	public List getUploadFileName() {
		return uploadFileName;
	}

	public List getUploadContentType() {
		return uploadContentType;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public File_Service getFileService() {
		return fileService;
	}

	public void setFileService(File_Service fileService) {
		this.fileService = fileService;
	}

	public void setUpload(List<java.io.File> upload) {
		this.upload = upload;
	}

	public void setUploadFileName(List uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUploadContentType(List uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Schedule_Service getScheduleService() {
		return scheduleService;
	}

	public Watch_Service getWatchService() {
		return watchService;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public ArrayList<Schedule> getList2() {
		return list2;
	}

	public void setList2(ArrayList<Schedule> list2) {
		this.list2 = list2;
	}

	public ArrayList getWatchs() {
		return watchs;
	}

	public void setWatchs(ArrayList watchs) {
		this.watchs = watchs;
	}

}
