package com.rzpt.entity;

public class Task {

	private int id;
	private String name;
	private String no;
	private String content;
	private int pro3_id;
	private int num;
	private int moment; //0是18，1是19年
	private int watchsum;// 要点总数
	private int finishsum;// 完成个数
	private int finishratio;// 完成比率
	private int rate;// 按期完成率
	private String mo;

	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", no=" + no + ", content=" + content + ", pro3_id=" + pro3_id
				+ ", num=" + num + ", moment=" + moment + "]";
	}

	public String getMo() {
		return mo;
	}

	public void setMo(String mo) {
		this.mo = mo;
	}

	public int getMoment() {
		return moment;
	}

	public void setMoment(int moment) {
		this.moment = moment;
	}

	public int getWatchsum() {
		return watchsum;
	}

	public void setWatchsum(int watchsum) {
		this.watchsum = watchsum;
	}

	public int getFinishsum() {
		return finishsum;
	}

	public void setFinishsum(int finishsum) {
		this.finishsum = finishsum;
	}

	public int getFinishratio() {
		return finishratio;
	}

	public void setFinishratio(int finishratio) {
		this.finishratio = finishratio;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPro3_id() {
		return pro3_id;
	}

	public void setPro3_id(int pro3_id) {
		this.pro3_id = pro3_id;
	}
}
