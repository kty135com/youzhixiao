package com.rzpt.entity;

public class Pro1 {
	private Integer id;
	private String name;
	private String no;
	private double money;
	private String schedule;
	private String start_time;
	private String plan_time;
	private String finish_time;
	private int state;
	private Integer user_id;
	private String user; // ������
	private int num; // ������ļ�����
	private int watchsum;// Ҫ������
	private int finishsum;// ��ɸ���
	private String finishratio;//
	private String rate;// ���������

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

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "Pro1 [id=" + id + ", name=" + name + ", no=" + no + ", money=" + money + ", schedule=" + schedule
				+ ", start_time=" + start_time + ", plan_time=" + plan_time + ", finish_time=" + finish_time
				+ ", state=" + state + ", user_id=" + user_id + ", user=" + user + ", num=" + num + ", watchsum="
				+ watchsum + ", finishsum=" + finishsum + ", finishratio=" + finishratio + ", rate=" + rate + "]";
	}


}
