package com.rzpt.entity;

public class Pro2 {

	private Integer id;
	private String name;
	private String no;
	private double money;
	private String schedule;
	private String plan_time;
	private String finish_time;
	private int state;
	private Integer pro1_id;
	private Integer user_id;
	private int num; // 待审核文件个数
	private int watchsum;// 要点总数
	private int finishsum;// 完成个数
	private String finishratio;// 完成比率
	private String rate;// 按期完成率
	private String user;
	private int pro1_no;
	private String depter;

	public String getDepter() {
		return depter;
	}

	public void setDepter(String depter) {
		this.depter = depter;
	}

	public int getPro1_no() {
		return pro1_no;
	}

	public void setPro1_no(int pro1_no) {
		this.pro1_no = pro1_no;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
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

	public String getFinishratio() {
		return finishratio;
	}

	public void setFinishratio(String finishratio) {
		this.finishratio = finishratio;
	}

	@Override
	public String toString() {
		return "Pro2 [id=" + id + ", name=" + name + ", no=" + no + ", money=" + money + ", schedule=" + schedule
				+ ", plan_time=" + plan_time + ", finish_time=" + finish_time + ", state=" + state + ", pro1_id="
				+ pro1_id + ", user_id=" + user_id + ", num=" + num + ", watchsum=" + watchsum + ", finishsum="
				+ finishsum + ", finishratio=" + finishratio + ", rate=" + rate + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getPlan_time() {
		return plan_time;
	}

	public void setPlan_time(String plan_time) {
		this.plan_time = plan_time;
	}

	public String getFinish_time() {
		return finish_time;
	}

	public void setFinish_time(String finish_time) {
		this.finish_time = finish_time;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Integer getPro1_id() {
		return pro1_id;
	}

	public void setPro1_id(Integer pro1_id) {
		this.pro1_id = pro1_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
