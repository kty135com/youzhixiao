package com.rzpt.entity;

public class Dept {

	private int id;
	private String name;
	private double watchsum;// 要点总数
	private double finishsum;// 完成个数
	private String finishratio;//
	private String rate;// 按期完成率

	@Override
	public String toString() {
		return "Dept [id=" + id + ", name=" + name + ", watchsum=" + watchsum + ", finishsum=" + finishsum
				+ ", finishratio=" + finishratio + ", rate=" + rate + "]";
	}
	public Dept() {
		// TODO Auto-generated constructor stub
	}
	
	public Dept(int id, String name, double watchsum, double finishsum, String finishratio, String rate) {
		super();
		this.id = id;
		this.name = name;
		this.watchsum = watchsum;
		this.finishsum = finishsum;
		this.finishratio = finishratio;
		this.rate = rate;
	}
	public String getFinishratio() {
		return finishratio;
	}

	public void setFinishratio(String finishratio) {
		this.finishratio = finishratio;
	}

	public double getWatchsum() {
		return watchsum;
	}

	public void setWatchsum(double watchsum) {
		this.watchsum = watchsum;
	}

	public double getFinishsum() {
		return finishsum;
	}

	public void setFinishsum(double finishsum) {
		this.finishsum = finishsum;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
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

}
