package com.rzpt.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Wenjian {
	private Integer wenjian_id;
	private String wenjian_name;
	private String wenjian_desc;
	private String create_time;
	private Integer state; // 0 公告 ， 1 资料

	public String getCreateTime() {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}

	public Integer getWenjian_id() {
		return wenjian_id;
	}

	public void setWenjian_id(Integer wenjian_id) {
		this.wenjian_id = wenjian_id;
	}

	public String getWenjian_name() {
		return wenjian_name;
	}

	public void setWenjian_name(String wenjian_name) {
		this.wenjian_name = wenjian_name;
	}

	public String getWenjian_desc() {
		return wenjian_desc;
	}

	public void setWenjian_desc(String wenjian_desc) {
		this.wenjian_desc = wenjian_desc;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Wenjian [wenjian_id=" + wenjian_id + ", wenjian_name=" + wenjian_name + ", wenjian_desc=" + wenjian_desc
				+ ", create_time=" + create_time + ", state=" + state + "]";
	}

}
