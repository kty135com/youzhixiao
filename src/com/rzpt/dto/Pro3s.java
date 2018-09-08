package com.rzpt.dto;

import com.rzpt.entity.Pro3;

public class Pro3s {
	private Pro3 p3;
	private int p3Fenzi;
	private int p3Fenmu;
	private String jindu;
	private String bili;

	public String getBili() {
		return bili;
	}

	public void setBili(String bili) {
		this.bili = bili;
	}

	public String getJindu() {
		return jindu;
	}

	public void setJindu(String jindu) {
		this.jindu = jindu;
	}

	public Pro3s() {

	}

	public Pro3s(Pro3 p3, int p3Fenzi, int p3Fenmu) {
		super();
		this.p3 = p3;
		this.p3Fenzi = p3Fenzi;
		this.p3Fenmu = p3Fenmu;
	}

	public Pro3 getP3() {
		return p3;
	}

	public void setP3(Pro3 p3) {
		this.p3 = p3;
	}

	public int getP3Fenzi() {
		return p3Fenzi;
	}

	public void setP3Fenzi(int p3Fenzi) {
		this.p3Fenzi = p3Fenzi;
	}

	public int getP3Fenmu() {
		return p3Fenmu;
	}

	public void setP3Fenmu(int p3Fenmu) {
		this.p3Fenmu = p3Fenmu;
	}

	@Override
	public String toString() {
		return "Pro3s [p3=" + p3 + ", p3Fenzi=" + p3Fenzi + ", p3Fenmu=" + p3Fenmu + ", jindu=" + jindu + ", bili="
				+ bili + "]";
	}

}
