package com.rzpt.entity;

public class Schedule {
	private int id;
	private String path;
	private String name;
	private String content;
	private String time;
	private int watch_id;
	private String name2;

	@Override
	public String toString() {
		return "Schedule [id=" + id + ", path=" + path + ", name=" + name + ", content=" + content + ", time=" + time
				+ ", watch_id=" + watch_id + "]";
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public int getId() {
		return id;
	}

	public String getPath() {
		return path;
	}

	public String getName() {
		return name;
	}

	public String getContent() {
		return content;
	}

	public String getTime() {
		return time;
	}

	public int getWatch_id() {
		return watch_id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setWatch_id(int watch_id) {
		this.watch_id = watch_id;
	}

}
