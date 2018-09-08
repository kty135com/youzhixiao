package com.rzpt.entity;

import com.rzpt.dto.Files;

public class Watch {

	private int id;
	private String name;
	private String no;
	private String content;
	private String plan_time;
	private String finish_time;
	private Double money;
	private Double realMoney;
	private int state;
	/**
	 * 建设状态 0.未完成 1.待审核 2.待验收 3.审核失败 4.验收通过 5.超管通过
	 */
	private int task_id;
	private Integer user_id;
	private Integer user1_id;
	private Integer user2_id;
	private Integer user3_id;
	private Integer user4_id;
	private Integer user5_id;
	private Integer pro3_id;
	private Integer dept_id;
	private int num;
	private String column; // 备用字段
	private String column2; // 备用字段
	private String column3; // 备用字段
	private String column4; // 备用字段
	private String column5; // 备用字段
	private String column6; // 备用字段
	private int watchsum;// 要点总数
	private int finishsum;// 完成个数
	private int finishratio;// 完成比率
	private int rate;// 按期完成率
	private File file;
	private File file2;
	private File file3;
	private File file4;
	private File file5;

	private Files files;

	public String showState() {
		String str = "未完成";
		if (state == 1) {
			str = "待审核";
		} else if (state == 2) {
			str = "待验收";
		} else if (state == 3) {
			str = "审核失败";
		} else if (state == 4) {
			str = "验收通过";
		} else if (state == 5) {
			str = "超管通过";
		}
		return str;
	}

	public File getFile2() {
		return file2;
	}

	public void setFile2(File file2) {
		this.file2 = file2;
	}

	public File getFile3() {
		return file3;
	}

	public void setFile3(File file3) {
		this.file3 = file3;
	}

	public File getFile4() {
		return file4;
	}

	public void setFile4(File file4) {
		this.file4 = file4;
	}

	public File getFile5() {
		return file5;
	}

	public void setFile5(File file5) {
		this.file5 = file5;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Double getRealMoney() {
		return realMoney;
	}

	public void setRealMoney(Double realMoney) {
		this.realMoney = realMoney;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getColumn3() {
		return column3;
	}

	public void setColumn3(String column3) {
		this.column3 = column3;
	}

	public String getColumn2() {
		return column2;
	}

	public void setColumn2(String column2) {
		this.column2 = column2;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public Integer getUser1_id() {
		return user1_id;
	}

	public void setUser1_id(Integer user1_id) {
		this.user1_id = user1_id;
	}

	public Integer getUser2_id() {
		return user2_id;
	}

	public void setUser2_id(Integer user2_id) {
		this.user2_id = user2_id;
	}

	public Integer getUser3_id() {
		return user3_id;
	}

	public void setUser3_id(Integer user3_id) {
		this.user3_id = user3_id;
	}

	public Integer getUser4_id() {
		return user4_id;
	}

	public void setUser4_id(Integer user4_id) {
		this.user4_id = user4_id;
	}

	public Files getFiles() {
		return files;
	}

	public void setFiles(Files files) {
		this.files = files;
	}

	public Integer getUser5_id() {
		return user5_id;
	}

	public void setUser5_id(Integer user5_id) {
		this.user5_id = user5_id;
	}

	@Override
	public String toString() {
		return "Watch [id=" + id + ", name=" + name + ", no=" + no + ", content=" + content + ", plan_time=" + plan_time
				+ ", finish_time=" + finish_time + ", money=" + money + ", realMoney=" + realMoney + ", state=" + state
				+ ", task_id=" + task_id + ", user_id=" + user_id + ", user1_id=" + user1_id + ", user2_id=" + user2_id
				+ ", user3_id=" + user3_id + ", user4_id=" + user4_id + ", user5_id=" + user5_id + ", pro3_id="
				+ pro3_id + ", dept_id=" + dept_id + ", num=" + num + ", column=" + column + ", column2=" + column2
				+ ", column3=" + column3 + ", column4=" + column4 + ", column5=" + column5 + ", column6=" + column6
				+ ", watchsum=" + watchsum + ", finishsum=" + finishsum + ", finishratio=" + finishratio + ", rate="
				+ rate + ", file=" + file + ", file2=" + file2 + ", file3=" + file3 + ", file4=" + file4 + ", file5="
				+ file5 + ", files=" + files + "]";
	}

	public int getWatchsum() {
		return watchsum;
	}

	public void setWatchsum(int watchsum) {
		this.watchsum = watchsum;
	}

	public int getFinishsum() {
		return finishsum;
	}

	public void setFinishsum(int finishsum) {
		this.finishsum = finishsum;
	}

	public int getFinishratio() {
		return finishratio;
	}

	public void setFinishratio(int finishratio) {
		this.finishratio = finishratio;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPlan_time() {
		return plan_time;
	}

	public void setPlan_time(String plan_time) {
		this.plan_time = plan_time;
	}

	public String getFinish_time() {
		return finish_time;
	}

	public void setFinish_time(String finish_time) {
		this.finish_time = finish_time;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getTask_id() {
		return task_id;
	}

	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getPro3_id() {
		return pro3_id;
	}

	public void setPro3_id(Integer pro3_id) {
		this.pro3_id = pro3_id;
	}

	public Integer getDept_id() {
		return dept_id;
	}

	public void setDept_id(Integer dept_id) {
		this.dept_id = dept_id;
	}

	public String getColumn4() {
		return column4;
	}

	public void setColumn4(String column4) {
		this.column4 = column4;
	}

	public String getColumn5() {
		return column5;
	}

	public void setColumn5(String column5) {
		this.column5 = column5;
	}

	public String getColumn6() {
		return column6;
	}

	public void setColumn6(String column6) {
		this.column6 = column6;
	}

}