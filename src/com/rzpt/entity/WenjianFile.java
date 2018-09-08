package com.rzpt.entity;

public class WenjianFile {
	private Integer id;
	private String pathname;
	private String tname;
	private Integer wenjian_id;
	private Wenjian wenjian;

	public Wenjian getWenjian() {
		return wenjian;
	}

	public void setWenjian(Wenjian wenjian) {
		this.wenjian = wenjian;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getPathname() {
		return pathname;
	}

	public void setPathname(String pathname) {
		this.pathname = pathname;
	}

	public Integer getWenjian_id() {
		return wenjian_id;
	}

	public void setWenjian_id(Integer wenjian_id) {
		this.wenjian_id = wenjian_id;
	}

	@Override
	public String toString() {
		return "WenjianFile [id=" + id + ", pathname=" + pathname + ", tname=" + tname + ", wenjian_id=" + wenjian_id
				+ "]";
	}

}
