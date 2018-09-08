package com.rzpt.entity;

public class Audit {

	private int id;
	private String time;
	private String opinion;
	private int result;
	private int watch_id;
	private int user_id;

	@Override
	public String toString() {
		return "Audit [id=" + id + ", time=" + time + ", opinion=" + opinion + ", result=" + result + ", watch_id="
				+ watch_id + ", user_id=" + user_id + "]";
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getWatch_id() {
		return watch_id;
	}

	public void setWatch_id(int watch_id) {
		this.watch_id = watch_id;
	}

}