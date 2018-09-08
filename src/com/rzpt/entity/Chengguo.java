package com.rzpt.entity;

public class Chengguo {
/**
 * id
 * 序号
 * 类别
 * 成果名称
 * 成果负责人
 * 级别
 * 责任部门
 * 成果总个数
 * 成果完成个数
 * 备注
 */
	private int id;
	private int no;
	private String state;
	private String name;
	private String person;
	private String jibie;
	private String dept;
	private String beizhu;
	private int fenmu;
	private int fenzi;
	private double fenshu;
	
	public double getFenshu() {
		return fenshu;
	}
	public void setFenshu(double fenshu) {
		this.fenshu = fenshu;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getJibie() {
		return jibie;
	}
	public void setJibie(String jibie) {
		this.jibie = jibie;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getFenmu() {
		return fenmu;
	}
	public void setFenmu(int fenmu) {
		this.fenmu = fenmu;
	}
	public int getFenzi() {
		return fenzi;
	}
	public void setFenzi(int fenzi) {
		this.fenzi = fenzi;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	@Override
	public String toString() {
		return "Chengguo [id=" + id + ", no=" + no + ", state=" + state + ", name=" + name + ", person=" + person
				+ ", jibie=" + jibie + ", dept=" + dept + ", beizhu=" + beizhu + ", fenmu=" + fenmu + ", fenzi=" + fenzi
				+ "]";
	}
	
}
