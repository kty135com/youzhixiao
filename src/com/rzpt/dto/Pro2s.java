package com.rzpt.dto;

import java.util.List;

import com.rzpt.entity.Pro2;
import com.rzpt.entity.Pro3;

public class Pro2s {
	private Pro2 pro2;
	private List<Pro3s> pro3List;
	private int p2fenzi;
	private int p2fenmu;
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
		return "Pro2s [pro2=" + pro2 + ", pro3List=" + pro3List + ", p2fenzi=" + p2fenzi + ", p2fenmu=" + p2fenmu
				+ ", bili=" + bili + "]";
	}

	public int getP2fenzi() {
		return p2fenzi;
	}

	public void setP2fenzi(int p2fenzi) {
		this.p2fenzi = p2fenzi;
	}

	public int getP2fenmu() {
		return p2fenmu;
	}

	public void setP2fenmu(int p2fenmu) {
		this.p2fenmu = p2fenmu;
	}

	public Pro2 getPro2() {
		return pro2;
	}

	public void setPro2(Pro2 pro2) {
		this.pro2 = pro2;
	}

	public List<Pro3s> getPro3List() {
		return pro3List;
	}

	public void setPro3List(List<Pro3s> pro3List) {
		this.pro3List = pro3List;
	}

}
