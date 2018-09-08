package com.rzpt.dto;

import java.text.DecimalFormat;
import java.util.List;

import com.rzpt.entity.Pro1;

public class Pro1s {
	private Pro1 pro1;
	private List<Pro2s> pro2List;
	private int p1Fenzi;
	private int p1Fenmu;
	private String bili;
	private String jindu;

	public String getJindu() {
		return jindu;
	}

	public void setJindu(String jindu) {
		this.jindu = jindu;
	}

	public String getBili() {
		return bili;
	}

	public void setBili(String bili) {
		this.bili = bili;
	}

	@Override
	public String toString() {
		return "Pro1s [pro1=" + pro1 + ", pro2List=" + pro2List + ", p1Fenzi=" + p1Fenzi + ", p1Fenmu=" + p1Fenmu
				+ ", bili=" + bili + "]";
	}

	public Pro1 getPro1() {
		return pro1;
	}

	public void setPro1(Pro1 pro1) {
		this.pro1 = pro1;
	}

	public int getP1Fenzi() {
		return p1Fenzi;
	}

	public void setP1Fenzi(int p1Fenzi) {
		this.p1Fenzi = p1Fenzi;
	}

	public int getP1Fenmu() {
		return p1Fenmu;
	}

	public void setP1Fenmu(int p1Fenmu) {
		this.p1Fenmu = p1Fenmu;
	}

	public List<Pro2s> getPro2List() {
		return pro2List;
	}

	public void setPro2List(List<Pro2s> pro2List) {
		this.pro2List = pro2List;
	}
}
