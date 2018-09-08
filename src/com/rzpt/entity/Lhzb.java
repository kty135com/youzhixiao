package com.rzpt.entity;

public class Lhzb {

	private Integer id;
	private Integer num;
	private String content;
	private String desc;
	private String base;
	private String zb;
	private String mid;
	private Integer midFenMu;
	private Integer midFenZi;
	private String last;
	private Integer lastFenZi;
	private Integer lastFenMu;
	private String dept;
	private Double midfenshu;
	private Double lastfenshu;

	@Override
	public String toString() {
		return "Lhzb [id=" + id + ", num=" + num + ", content=" + content + ", desc=" + desc + ", base=" + base
				+ ", zb=" + zb + ", mid=" + mid + ", midFenMu=" + midFenMu + ", midFenZi=" + midFenZi + ", last=" + last
				+ ", lastFenZi=" + lastFenZi + ", lastFenMu=" + lastFenMu + ", dept=" + dept + "]";
	}

	public Double getMidfenshu() {
		return midfenshu;
	}

	public void setMidfenshu(Double midfenshu) {
		this.midfenshu = midfenshu;
	}

	public Double getLastfenshu() {
		return lastfenshu;
	}

	public void setLastfenshu(Double lastfenshu) {
		this.lastfenshu = lastfenshu;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getMidFenMu() {
		return midFenMu;
	}

	public void setMidFenMu(Integer midFenMu) {
		this.midFenMu = midFenMu;
	}

	public Integer getMidFenZi() {
		return midFenZi;
	}

	public void setMidFenZi(Integer midFenZi) {
		this.midFenZi = midFenZi;
	}

	public Integer getLastFenZi() {
		return lastFenZi;
	}

	public void setLastFenZi(Integer lastFenZi) {
		this.lastFenZi = lastFenZi;
	}

	public Integer getLastFenMu() {
		return lastFenMu;
	}

	public void setLastFenMu(Integer lastFenMu) {
		this.lastFenMu = lastFenMu;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getZb() {
		return zb;
	}

	public void setZb(String zb) {
		this.zb = zb;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

}
