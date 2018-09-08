package com.rzpt.entity;

public class File {

	private int id;
	private String path; // 该观测点下所有文件共同的存入路径
	private String name1; // 文件名
	private String name2;
	private String name3;
	private String name4;
	private String name5;
	private String name6;
	private String name7;
	private String content1; // 文件描述
	private String content2;
	private String content3;
	private String content4;
	private String content5;
	private String content6;
	private String content7;
	private int watch_id;
	private Integer user_id;

	private String tname1;
	private String tname2;
	private String tname3;
	private String tname4;
	private String tname5;
	private String tname6;
	private String tname7;

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public int getId() {
		return id;
	}

	public String getPath() {
		return path;
	}

	public String getName1() {
		return name1;
	}

	public String getName2() {
		return name2;
	}

	public String getName3() {
		return name3;
	}

	public String getName4() {
		return name4;
	}

	public String getName5() {
		return name5;
	}

	public String getName6() {
		return name6;
	}

	public String getName7() {
		return name7;
	}

	public String getContent1() {
		return content1;
	}

	public String getContent2() {
		return content2;
	}

	public String getContent3() {
		return content3;
	}

	public String getContent4() {
		return content4;
	}

	public String getContent5() {
		return content5;
	}

	public String getContent6() {
		return content6;
	}

	public String getContent7() {
		return content7;
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

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public void setName3(String name3) {
		this.name3 = name3;
	}

	public void setName4(String name4) {
		this.name4 = name4;
	}

	public void setName5(String name5) {
		this.name5 = name5;
	}

	public void setName6(String name6) {
		this.name6 = name6;
	}

	public void setName7(String name7) {
		this.name7 = name7;
	}

	public void setContent1(String content1) {
		this.content1 = content1;
	}

	public void setContent2(String content2) {
		this.content2 = content2;
	}

	public void setContent3(String content3) {
		this.content3 = content3;
	}

	public void setContent4(String content4) {
		this.content4 = content4;
	}

	public void setContent5(String content5) {
		this.content5 = content5;
	}

	public void setContent6(String content6) {
		this.content6 = content6;
	}

	public void setContent7(String content7) {
		this.content7 = content7;
	}

	public String getTname1() {
		return tname1;
	}

	public void setTname1(String tname1) {
		this.tname1 = tname1;
	}

	public String getTname2() {
		return tname2;
	}

	public void setTname2(String tname2) {
		this.tname2 = tname2;
	}

	public String getTname3() {
		return tname3;
	}

	public void setTname3(String tname3) {
		this.tname3 = tname3;
	}

	public String getTname4() {
		return tname4;
	}

	public void setTname4(String tname4) {
		this.tname4 = tname4;
	}

	public String getTname5() {
		return tname5;
	}

	public void setTname5(String tname5) {
		this.tname5 = tname5;
	}

	public String getTname6() {
		return tname6;
	}

	public void setTname6(String tname6) {
		this.tname6 = tname6;
	}

	public String getTname7() {
		return tname7;
	}

	public void setTname7(String tname7) {
		this.tname7 = tname7;
	}

	public void setWatch_id(int watch_id) {
		this.watch_id = watch_id;
	}

	@Override
	public String toString() {
		return "File [id=" + id + ", path=" + path + ", name1=" + name1 + ", name2=" + name2 + ", name3=" + name3
				+ ", name4=" + name4 + ", name5=" + name5 + ", name6=" + name6 + ", name7=" + name7 + ", content1="
				+ content1 + ", content2=" + content2 + ", content3=" + content3 + ", content4=" + content4
				+ ", content5=" + content5 + ", content6=" + content6 + ", content7=" + content7 + ", watch_id="
				+ watch_id + ", user_id=" + user_id + ", tname1=" + tname1 + ", tname2=" + tname2 + ", tname3=" + tname3
				+ ", tname4=" + tname4 + ", tname5=" + tname5 + ", tname6=" + tname6 + ", tname7=" + tname7 + "]";
	}

}
