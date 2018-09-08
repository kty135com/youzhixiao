package com.rzpt.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.rzpt.dto.Pro1s;
import com.rzpt.dto.Pro2s;
import com.rzpt.dto.Pro3s;
import com.rzpt.entity.Dept;
import com.rzpt.entity.Pro1;
import com.rzpt.entity.Pro2;
import com.rzpt.entity.Pro3;
import com.rzpt.entity.User;
import com.rzpt.entity.Watch;
import com.rzpt.service.Pro1_Service;
import com.rzpt.service.Pro2_Service;
import com.rzpt.service.Pro3_Service;
import com.rzpt.service.User_Service;
import com.rzpt.util.Base64;
import com.rzpt.util.FormatUtil;
import com.rzpt.util.LingdaoFactory;
import com.rzpt.util.UploadDownUtil;
import com.rzpt1.service.Dept_Service;

public class User_Action extends ActionSupport {

	@Resource(name = "user")
	private User user;

	@Resource(name = "user_Service")
	private User_Service user_Service;

	@Resource(name = "project3_Service")
	private Pro3_Service project3_Service;

	@Resource(name = "project2_Service")
	private Pro2_Service project2_Service;

	@Resource(name = "project1_Service")
	private Pro1_Service project1_Service;

	@Resource(name = "deptService")
	private Dept_Service deptService;

	@Resource(name = "project1")
	private Pro1 project1;

	@Resource(name = "project2")
	private Pro2 project2;
	private List<java.io.File> upload;
	private List uploadFileName;
	private List uploadContentType;
	private ArrayList list;
	private int id;
	private int qqq;
	private int user_id;
	private String proDemo;
	private String newpwd;
	private String error;
	private List<Pro1s> pr1sList = new ArrayList<Pro1s>();
	private String mubiaoURL;
	private int urlNo;
	private Integer page;
	private String userName;

	public String login() {
		for (String str : LingdaoFactory.lingdao) {
			if(user.getName().equals(str)){
				ActionContext.getContext().getSession().put("loginInfo", 5);
				mubiaoURL = "/project1/project1_zonglan";
				return "indexLd";
			}
		}
		try {
			user = user_Service.getUserByNameAndPwd(user.getName(), user.getPwd());
			if (user.getState() == 0) {
				ActionContext.getContext().getSession().put("loginInfo", "admin");
				ActionContext.getContext().getSession().put("userId", user.getId());
				return "0";
			} else if (user.getState() == 1) {
				ActionContext.getContext().getSession().put("loginInfo", "admin1");
				ActionContext.getContext().getSession().put("userId", user.getId());
				project1 = project2_Service.getPro1ByUser_id(user.getId());
				return "1";
			} else if (user.getState() == 2) {
				ActionContext.getContext().getSession().put("loginInfo", "admin2");
				ActionContext.getContext().getSession().put("userId", user.getId());
				return "2";
			} else if (user.getState() == 3) {
				ActionContext.getContext().getSession().put("loginInfo", "admin3");
				ActionContext.getContext().getSession().put("userId", user.getId());
				return "3";
			} else {
				return this.ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			error = "用户名密码错误,请返回重新登录";
			return "loginerror";
		}
	}

	public String getUsernameFromSchoolWeb() {
		if(userName == "lingdao"){
			
		}else{
			userName = Base64.decode(userName);
		}
		for (String str : LingdaoFactory.lingdao) {
			if(userName.equals(str)){
				ActionContext.getContext().getSession().put("loginInfo", 5);
				mubiaoURL = "/project1/project1_zonglan";
				return "indexLd";
			}
		}
		try {
			user = user_Service.getUserByName(userName);
		} catch (Exception e) {
			error = "您不是本系统的用户，请联系系统管理员。";
			return "errorlogin";
		}
		if (user.getState() == 0) {
			ActionContext.getContext().getSession().put("loginInfo", "admin");
			ActionContext.getContext().getSession().put("userId", user.getId());
			return "0";
		} else if (user.getState() == 1) {
			ActionContext.getContext().getSession().put("loginInfo", "admin1");
			ActionContext.getContext().getSession().put("userId", user.getId());
			project1 = project2_Service.getPro1ByUser_id(user.getId());
			return "1";
		} else if (user.getState() == 2) {
			ActionContext.getContext().getSession().put("loginInfo", "admin2");
			ActionContext.getContext().getSession().put("userId", user.getId());
			return "2";
		} else if (user.getState() == 3) {
			ActionContext.getContext().getSession().put("loginInfo", "admin3");
			ActionContext.getContext().getSession().put("userId", user.getId());
			return "3";
		} else {
			return this.ERROR;
		}
	}

	public String changePassword() {
		User u = user_Service.getUserById(user.getId());
		return "changePassword";
	}

	public String changepwd2() {
		User u = user_Service.getUserById(user.getId());
		System.out.println(u);
		if (u.getPwd().equals(user.getPwd())) {
			u.setPwd(newpwd);
			user_Service.update(u);
			return "success";
		} else {
			error = "原密码错误！";
			return "error";
		}
	}

	public String shouye() {
		try {
			if (ActionContext.getContext().getSession().get("loginInfo") == "admin") {
				return "0";
			} else if (ActionContext.getContext().getSession().get("loginInfo") == "admin1") {
				user = user_Service.getUserById(user.getId());
				project1 = project2_Service.getPro1ByUser_id(user.getId());
				return "1";
			} else if (ActionContext.getContext().getSession().get("loginInfo") == "admin2") {
				return "2";
			} else if (ActionContext.getContext().getSession().get("loginInfo") == "admin3") {
				return "3";
			} else {
				return "exitlogin";
			}
		} catch (Exception e) {
			e.printStackTrace();
			error = "用户名密码错误,请返回重新登录";
			return "loginerror";
		}
	}

	public String exitlogin() {
		ActionContext.getContext().getSession().remove("loginInfo");
		ActionContext.getContext().getSession().remove("logingerror");
		ActionContext.getContext().getSession().remove("userId");
		return "exitlogin";
	}

	public String index0_5() {
		if (urlNo == 1) {
			mubiaoURL = "project1/project1_list";
		} else if (urlNo == 2) {
			mubiaoURL = "project1/project1_zonglan";
		} else if (urlNo == 3) {
			mubiaoURL = "cg/cg_list";
		} else if (urlNo == 4) {
			mubiaoURL = "cg/cg_listlh";
		} else if (urlNo == 5) {
			mubiaoURL = "project1/project1_tongjiByPro1";
		}
		return "indexLd";
	}
	
	public String index0_1() {
		user = user_Service.getUserById(user.getId());
		if (urlNo == 1) {
			mubiaoURL = "project1/project1_list";
		} else if (urlNo == 2) {
			return "0";
		} else if (urlNo == 3) {
			mubiaoURL = "cg/cg_list";
		} else if (urlNo == 4) {
			mubiaoURL = "cg/cg_listlh";
		} else if (urlNo == 5) {
			mubiaoURL = "project1/project1_tongjiByPro1";
		}
		return "index0_1";
	}

	public String index0_2() {
		user = user_Service.getUserById(user.getId());
		project1 = project2_Service.getPro1ByUser_id(user.getId());
		if (urlNo == 2) {
			return "1";
		} else if (urlNo == 3) {
			mubiaoURL = "cg/cg_list";
		} else if (urlNo == 5) {
			mubiaoURL = "project1/project1_tongjiByPro1";
		}
		return "index0_2";
	}

	public String index0_3() {
		user = user_Service.getUserById(user.getId());
		if (urlNo == 2) {
			return "2";
		} else if (urlNo == 3) {
			mubiaoURL = "cg/cg_list";
		} else if (urlNo == 5) {
			mubiaoURL = "project1/project1_tongjiByPro1";
		}
		return "index0_3";
	}

	public String index0_4() {
		user = user_Service.getUserById(user.getId());
		if (urlNo == 2) {
			return "3";
		} else if (urlNo == 3) {
			mubiaoURL = "cg/cg_list";
		} else if (urlNo == 5) {
			mubiaoURL = "project1/project1_tongjiByPro1";
		}
		return "index0_4";
	}

	public String getme() {
		if (user.getId() == 120) {
			user = user_Service.getme(user.getId());
			return "opage1";
		}
		user = user_Service.getme(user.getId());
		return "me";
	}

	public String getme2() {
		user = user_Service.getme(user.getId());
		return "me2";
	}

	// 重点专业
	public String getPros() {
		if (ActionContext.getContext().getSession().get("pr1sList") != null) {
			page = 1;
			return "getPros";
		}
		List<Pro1> p1s = project1_Service.getAllProject1sBy1();
		for (int i = 0; i < p1s.size(); i++) {
			try {
				Pro1s pro1s = new Pro1s();
				pro1s.setPro1(p1s.get(i));
				pro1s.setP1Fenzi(project1_Service.getAllfenziByPro1_id(p1s.get(i).getId()));
				pro1s.setP1Fenmu(project1_Service.getAllfenmuByPro1_id(p1s.get(i).getId()));
				pro1s.setBili(FormatUtil.getBiliByFenziAndFenmu(pro1s.getP1Fenzi(), pro1s.getP1Fenmu()));
				String str = FormatUtil.getjindutiao(pro1s.getBili());
				if (0 <= Integer.parseInt(str) && Integer.parseInt(str) <= 100) {
					pro1s.setJindu(str);
					System.out.println(pro1s.getJindu());
				} else {
					pro1s.setJindu("100");
					System.out.println(pro1s.getJindu());
				}
				System.out.println("bili=" + pro1s.getBili());
				System.out.println("pro1s=" + pro1s.toString());
				List<Pro2> p2s = project2_Service.getPro2sByPro1_id(p1s.get(i).getId());
				List<Pro2s> p2list = new ArrayList<Pro2s>();
				for (int j = 0; j < p2s.size(); j++) {
					try {
						Pro2s pro2s = new Pro2s();
						pro2s.setPro2(p2s.get(j));
						List<Pro3> p3s = project3_Service.getProject3sByPro2_id(p2s.get(j).getId());
						List<Pro3s> pro3List = new ArrayList<Pro3s>();
						for (int k = 0; k < p3s.size(); k++) {
							try {
								int fenzi = project3_Service.getAllfenziByPro3_id(p3s.get(k).getId());
								int fenmu = project3_Service.getAllfenmuByPro3_id(p3s.get(k).getId());
								System.out.println("fenzi;fenmu = " + fenzi + ";" + fenmu);
								Pro3s pro3s = new Pro3s(p3s.get(k), fenzi, fenmu);
								pro3s.setBili(
										FormatUtil.getBiliByFenziAndFenmu(pro3s.getP3Fenzi(), pro3s.getP3Fenmu()));

								String str2 = FormatUtil.getjindutiao(pro3s.getBili());
								if (0 <= Integer.parseInt(str) && Integer.parseInt(str) <= 100) {
									pro3s.setJindu(str);
									System.out.println(pro3s.getJindu());
								} else {
									pro3s.setJindu("100");
									System.out.println(pro3s.getJindu());
								}
								System.out.println("pro3s=" + pro3s.toString());
								pro3List.add(pro3s);
							} catch (Exception e) {

							}
						}
						pro2s.setPro3List(pro3List);
						pro2s.setP2fenzi(project2_Service.getAllfenziByPro2_id(p2s.get(j).getId()));
						pro2s.setP2fenmu(project2_Service.getAllfenmuByPro2_id(p2s.get(j).getId()));
						pro2s.setBili(FormatUtil.getBiliByFenziAndFenmu(pro2s.getP2fenzi(), pro2s.getP2fenmu()));
						System.out.println("比例：" + pro2s.getBili());
						String str3 = FormatUtil.getjindutiao(pro2s.getBili());
						System.out.println(str3);
						if (0 <= Integer.parseInt(str3) && Integer.parseInt(str3) <= 100) {
							pro2s.setJindu(str3);
							System.out.println(pro2s.getJindu());
						} else {
							pro2s.setJindu("100");
							System.out.println(pro2s.getJindu());
						}
						System.out.println("pro2s=" + pro2s);
						System.out.println(pro2s.getPro2().getName() + ";;" + pro2s.getJindu());
						p2list.add(pro2s);
					} catch (Exception e) {

					}
				}
				pro1s.setPro2List(p2list);
				System.out.println("pro1s=" + pro1s);
				try {
					pr1sList.add(pro1s);
				} catch (Exception e) {

				}
				System.out.println("------222----------" + pr1sList);
			} catch (Exception e) {

			}
		}
		ActionContext.getContext().getSession().put("pr1sList", pr1sList);
		page = 1;
		return "getPros";
	}

	// 公共项目
	public String getProsBy2() {
		if (ActionContext.getContext().getSession().get("pr2sList") != null) {
			page = 2;
			return "getPros";
		}
		List<Pro1> p1s = project1_Service.getAllProject1sBy2();
		System.out.println("p1s=" + p1s);
		for (int i = 0; i < p1s.size(); i++) {
			try {
				if (p1s.get(i).getNo().equals("05")) {
					System.out.println("开始05项目=" + p1s.get(i));
				}
				Pro1s pro1s = new Pro1s();
				pro1s.setPro1(p1s.get(i));
				pro1s.setP1Fenzi(project1_Service.getAllfenziByPro1_id(p1s.get(i).getId()));
				pro1s.setP1Fenmu(project1_Service.getAllfenmuByPro1_id(p1s.get(i).getId()));
				pro1s.setBili(FormatUtil.getBiliByFenziAndFenmu(pro1s.getP1Fenzi(), pro1s.getP1Fenmu()));
				System.out.println(p1s.get(i) + "|||" + pro1s.getBili());
				String str = FormatUtil.getjindutiao(pro1s.getBili());
				System.out.println("str=" + str);
				if (0 <= Integer.parseInt(str) && Integer.parseInt(str) <= 100) {
					pro1s.setJindu(str);
				} else {
					pro1s.setJindu("100");
				}
				List<Pro2> p2s = project2_Service.getPro2sByPro1_id(p1s.get(i).getId());
				List<Pro2s> p2list = new ArrayList<Pro2s>();
				for (int j = 0; j < p2s.size(); j++) {
					try {
						Pro2s pro2s = new Pro2s();
						pro2s.setPro2(p2s.get(j));
						List<Pro3> p3s = project3_Service.getProject3sByPro2_id(p2s.get(j).getId());
						List<Pro3s> pro3List = new ArrayList<Pro3s>();
						for (int k = 0; k < p3s.size(); k++) {
							try {
								int fenzi = project3_Service.getAllfenziByPro3_id(p3s.get(k).getId());
								int fenmu = project3_Service.getAllfenmuByPro3_id(p3s.get(k).getId());
								Pro3s pro3s = new Pro3s(p3s.get(k), fenzi, fenmu);
								pro3s.setBili(
										FormatUtil.getBiliByFenziAndFenmu(pro3s.getP3Fenzi(), pro3s.getP3Fenmu()));

								String str2 = FormatUtil.getjindutiao(pro3s.getBili());
								if (0 <= Integer.parseInt(str) && Integer.parseInt(str) <= 100) {
									pro3s.setJindu(str);
								} else {
									pro3s.setJindu("100");
								}
								pro3List.add(pro3s);
							} catch (Exception e) {

							}
						}
						pro2s.setPro3List(pro3List);
						pro2s.setP2fenzi(project2_Service.getAllfenziByPro2_id(p2s.get(j).getId()));
						pro2s.setP2fenmu(project2_Service.getAllfenmuByPro2_id(p2s.get(j).getId()));
						pro2s.setBili(FormatUtil.getBiliByFenziAndFenmu(pro2s.getP2fenzi(), pro2s.getP2fenmu()));
						String str3 = FormatUtil.getjindutiao(pro2s.getBili());
						if (0 <= Integer.parseInt(str3) && Integer.parseInt(str3) <= 100) {
							pro2s.setJindu(str3);
						} else {
							pro2s.setJindu("100");
						}
						p2list.add(pro2s);
					} catch (Exception e) {

					}
				}
				pro1s.setPro2List(p2list);
				try {
					pr1sList.add(pro1s);
				} catch (Exception e) {

				}
				System.out.println("------222----------" + pr1sList);
			} catch (Exception e) {

			}
		}
		ActionContext.getContext().getSession().put("pr2sList", pr1sList);
		page = 2;
		return "getPros";
	}

	// 特色项目
	public String getProsBy3() {
		if (ActionContext.getContext().getSession().get("pr3sList") != null) {
			page = 3;
			return "getPros";
		}
		List<Pro1> p1s = project1_Service.getAllProject1sBy3();
		for (int i = 0; i < p1s.size(); i++) {
			try {
				Pro1s pro1s = new Pro1s();
				pro1s.setPro1(p1s.get(i));
				pro1s.setP1Fenzi(project1_Service.getAllfenziByPro1_id(p1s.get(i).getId()));
				pro1s.setP1Fenmu(project1_Service.getAllfenmuByPro1_id(p1s.get(i).getId()));
				pro1s.setBili(FormatUtil.getBiliByFenziAndFenmu(pro1s.getP1Fenzi(), pro1s.getP1Fenmu()));
				String str = FormatUtil.getjindutiao(pro1s.getBili());
				if (0 <= Integer.parseInt(str) && Integer.parseInt(str) <= 100) {
					pro1s.setJindu(str);
					System.out.println(pro1s.getJindu());
				} else {
					pro1s.setJindu("100");
					System.out.println(pro1s.getJindu());
				}
				System.out.println("bili=" + pro1s.getBili());
				System.out.println("pro1s=" + pro1s.toString());
				List<Pro2> p2s = project2_Service.getPro2sByPro1_id(p1s.get(i).getId());
				List<Pro2s> p2list = new ArrayList<Pro2s>();
				for (int j = 0; j < p2s.size(); j++) {
					try {
						Pro2s pro2s = new Pro2s();
						pro2s.setPro2(p2s.get(j));
						List<Pro3> p3s = project3_Service.getProject3sByPro2_id(p2s.get(j).getId());
						List<Pro3s> pro3List = new ArrayList<Pro3s>();
						for (int k = 0; k < p3s.size(); k++) {
							try {
								int fenzi = project3_Service.getAllfenziByPro3_id(p3s.get(k).getId());
								int fenmu = project3_Service.getAllfenmuByPro3_id(p3s.get(k).getId());
								System.out.println("fenzi;fenmu = " + fenzi + ";" + fenmu);
								Pro3s pro3s = new Pro3s(p3s.get(k), fenzi, fenmu);
								pro3s.setBili(
										FormatUtil.getBiliByFenziAndFenmu(pro3s.getP3Fenzi(), pro3s.getP3Fenmu()));

								String str2 = FormatUtil.getjindutiao(pro3s.getBili());
								if (0 <= Integer.parseInt(str) && Integer.parseInt(str) <= 100) {
									pro3s.setJindu(str);
									System.out.println(pro3s.getJindu());
								} else {
									pro3s.setJindu("100");
									System.out.println(pro3s.getJindu());
								}
								System.out.println("pro3s=" + pro3s.toString());
								pro3List.add(pro3s);
							} catch (Exception e) {

							}
						}
						pro2s.setPro3List(pro3List);
						pro2s.setP2fenzi(project2_Service.getAllfenziByPro2_id(p2s.get(j).getId()));
						pro2s.setP2fenmu(project2_Service.getAllfenmuByPro2_id(p2s.get(j).getId()));
						pro2s.setBili(FormatUtil.getBiliByFenziAndFenmu(pro2s.getP2fenzi(), pro2s.getP2fenmu()));
						System.out.println("比例：" + pro2s.getBili());
						String str3 = FormatUtil.getjindutiao(pro2s.getBili());
						System.out.println(str3);
						if (0 <= Integer.parseInt(str3) && Integer.parseInt(str3) <= 100) {
							pro2s.setJindu(str3);
							System.out.println(pro2s.getJindu());
						} else {
							pro2s.setJindu("100");
							System.out.println(pro2s.getJindu());
						}
						System.out.println("pro2s=" + pro2s);
						System.out.println(pro2s.getPro2().getName() + ";;" + pro2s.getJindu());
						p2list.add(pro2s);
					} catch (Exception e) {

					}
				}
				pro1s.setPro2List(p2list);
				System.out.println("pro1s=" + pro1s);
				try {
					pr1sList.add(pro1s);
				} catch (Exception e) {

				}
				System.out.println("------222----------" + pr1sList);
			} catch (Exception e) {

			}
		}
		ActionContext.getContext().getSession().put("pr3sList", pr1sList);
		page = 3;
		return "getPros";
	}

	public String getPros2() {
		List<Pro1> p1s = project1_Service.getAllProject1s();
		for (int i = 0; i < p1s.size(); i++) {
			try {
				Pro1s pro1s = new Pro1s();
				pro1s.setPro1(p1s.get(i));
				pro1s.setP1Fenzi(project1_Service.getAllfenziByPro1_id(p1s.get(i).getId()));
				pro1s.setP1Fenmu(project1_Service.getAllfenmuByPro1_id(p1s.get(i).getId()));
				pro1s.setBili(FormatUtil.getBiliByFenziAndFenmu(pro1s.getP1Fenzi(), pro1s.getP1Fenmu()));
				String str = FormatUtil.getjindutiao(pro1s.getBili());
				if (0 <= Integer.parseInt(str) && Integer.parseInt(str) <= 100) {
					pro1s.setJindu(str);
					System.out.println(pro1s.getJindu());
				} else {
					pro1s.setJindu("100");
					System.out.println(pro1s.getJindu());
				}
				System.out.println("bili=" + pro1s.getBili());
				System.out.println("pro1s=" + pro1s.toString());
				List<Pro2> p2s = project2_Service.getPro2sByPro1_id(p1s.get(i).getId());
				List<Pro2s> p2list = new ArrayList<Pro2s>();
				for (int j = 0; j < p2s.size(); j++) {
					try {
						Pro2s pro2s = new Pro2s();
						pro2s.setPro2(p2s.get(j));
						List<Pro3> p3s = project3_Service.getProject3sByPro2_id(p2s.get(j).getId());
						List<Pro3s> pro3List = new ArrayList<Pro3s>();
						for (int k = 0; k < p3s.size(); k++) {
							try {
								int fenzi = project3_Service.getAllfenziByPro3_id(p3s.get(k).getId());
								int fenmu = project3_Service.getAllfenmuByPro3_id(p3s.get(k).getId());
								System.out.println("fenzi;fenmu = " + fenzi + ";" + fenmu);
								Pro3s pro3s = new Pro3s(p3s.get(k), fenzi, fenmu);
								pro3s.setBili(
										FormatUtil.getBiliByFenziAndFenmu(pro3s.getP3Fenzi(), pro3s.getP3Fenmu()));

								String str2 = FormatUtil.getjindutiao(pro3s.getBili());
								if (0 <= Integer.parseInt(str) && Integer.parseInt(str) <= 100) {
									pro3s.setJindu(str);
									System.out.println(pro3s.getJindu());
								} else {
									pro3s.setJindu("100");
									System.out.println(pro3s.getJindu());
								}
								System.out.println("pro3s=" + pro3s.toString());
								pro3List.add(pro3s);
							} catch (Exception e) {

							}
						}
						pro2s.setPro3List(pro3List);
						pro2s.setP2fenzi(project2_Service.getAllfenziByPro2_id(p2s.get(j).getId()));
						pro2s.setP2fenmu(project2_Service.getAllfenmuByPro2_id(p2s.get(j).getId()));
						pro2s.setBili(FormatUtil.getBiliByFenziAndFenmu(pro2s.getP2fenzi(), pro2s.getP2fenmu()));
						System.out.println("比例：" + pro2s.getBili());
						String str3 = FormatUtil.getjindutiao(pro2s.getBili());
						System.out.println(str3);
						if (0 <= Integer.parseInt(str3) && Integer.parseInt(str3) <= 100) {
							pro2s.setJindu(str3);
							System.out.println(pro2s.getJindu());
						} else {
							pro2s.setJindu("100");
							System.out.println(pro2s.getJindu());
						}
						System.out.println("pro2s=" + pro2s);
						System.out.println(pro2s.getPro2().getName() + ";;" + pro2s.getJindu());
						p2list.add(pro2s);
					} catch (Exception e) {

					}
				}
				pro1s.setPro2List(p2list);
				System.out.println("pro1s=" + pro1s);
				try {
					pr1sList.add(pro1s);
				} catch (Exception e) {

				}
				System.out.println("------222----------" + pr1sList);
			} catch (Exception e) {

			}
		}
		return "getPros";
	}

	public String getPros3() {
		List<Pro1> p1s = project1_Service.getAllProject1s();
		for (int i = 0; i < p1s.size(); i++) {
			try {
				Pro1s pro1s = new Pro1s();
				pro1s.setPro1(p1s.get(i));
				pro1s.setP1Fenzi(project1_Service.getAllfenziByPro1_id(p1s.get(i).getId()));
				pro1s.setP1Fenmu(project1_Service.getAllfenmuByPro1_id(p1s.get(i).getId()));
				pro1s.setBili(FormatUtil.getBiliByFenziAndFenmu(pro1s.getP1Fenzi(), pro1s.getP1Fenmu()));
				String str = FormatUtil.getjindutiao(pro1s.getBili());
				if (0 <= Integer.parseInt(str) && Integer.parseInt(str) <= 100) {
					pro1s.setJindu(str);
					System.out.println(pro1s.getJindu());
				} else {
					pro1s.setJindu("100");
					System.out.println(pro1s.getJindu());
				}
				System.out.println("bili=" + pro1s.getBili());
				System.out.println("pro1s=" + pro1s.toString());
				List<Pro2> p2s = project2_Service.getPro2sByPro1_id(p1s.get(i).getId());
				List<Pro2s> p2list = new ArrayList<Pro2s>();
				for (int j = 0; j < p2s.size(); j++) {
					try {
						Pro2s pro2s = new Pro2s();
						pro2s.setPro2(p2s.get(j));
						List<Pro3> p3s = project3_Service.getProject3sByPro2_id(p2s.get(j).getId());
						List<Pro3s> pro3List = new ArrayList<Pro3s>();
						for (int k = 0; k < p3s.size(); k++) {
							try {
								int fenzi = project3_Service.getAllfenziByPro3_id(p3s.get(k).getId());
								int fenmu = project3_Service.getAllfenmuByPro3_id(p3s.get(k).getId());
								System.out.println("fenzi;fenmu = " + fenzi + ";" + fenmu);
								Pro3s pro3s = new Pro3s(p3s.get(k), fenzi, fenmu);
								pro3s.setBili(
										FormatUtil.getBiliByFenziAndFenmu(pro3s.getP3Fenzi(), pro3s.getP3Fenmu()));

								String str2 = FormatUtil.getjindutiao(pro3s.getBili());
								if (0 <= Integer.parseInt(str) && Integer.parseInt(str) <= 100) {
									pro3s.setJindu(str);
									System.out.println(pro3s.getJindu());
								} else {
									pro3s.setJindu("100");
									System.out.println(pro3s.getJindu());
								}
								System.out.println("pro3s=" + pro3s.toString());
								pro3List.add(pro3s);
							} catch (Exception e) {

							}
						}
						pro2s.setPro3List(pro3List);
						pro2s.setP2fenzi(project2_Service.getAllfenziByPro2_id(p2s.get(j).getId()));
						pro2s.setP2fenmu(project2_Service.getAllfenmuByPro2_id(p2s.get(j).getId()));
						pro2s.setBili(FormatUtil.getBiliByFenziAndFenmu(pro2s.getP2fenzi(), pro2s.getP2fenmu()));
						System.out.println("比例：" + pro2s.getBili());
						String str3 = FormatUtil.getjindutiao(pro2s.getBili());
						System.out.println(str3);
						if (0 <= Integer.parseInt(str3) && Integer.parseInt(str3) <= 100) {
							pro2s.setJindu(str3);
							System.out.println(pro2s.getJindu());
						} else {
							pro2s.setJindu("100");
							System.out.println(pro2s.getJindu());
						}
						System.out.println("pro2s=" + pro2s);
						System.out.println(pro2s.getPro2().getName() + ";;" + pro2s.getJindu());
						p2list.add(pro2s);
					} catch (Exception e) {

					}
				}
				pro1s.setPro2List(p2list);
				System.out.println("pro1s=" + pro1s);
				try {
					pr1sList.add(pro1s);
				} catch (Exception e) {

				}
				System.out.println("------222----------" + pr1sList);
			} catch (Exception e) {

			}
		}
		return "getPros";
	}

	public String add0() {
		list = user_Service.getDept();
		return "add0";
	}

	public String add() {
		if (user.getState() == 0 || user.getState() == 1) {
			user.setDept_id(null);
		}
		try {
			int i = user_Service.insertUser(user);
			list = user_Service.getDept();
			qqq = 1;
			return "add0";
		} catch (Exception e) {
			error = "用户名已经存在，请重新输入";
			return "error";
		}
	}

	public String list() {
		list = user_Service.getAllUsers();
		for (int i = 0; i < list.size(); i++) {
			User u = (User) list.get(i);
			try {
				Dept dept = deptService.getDept(u.getDept_id());
				u.setDept(dept.getName());
			} catch (Exception e) {
				u.setDept("暂无部门");
			}
		}
		return "list0";
	}

	public String lookup() {
		user.setId(id);
		user = user_Service.getUserById(user.getId());
		list = user_Service.getDept();
		return "lookup";
	}

	public String del() {
		user.setId(id);
		user = user_Service.getUserById(user.getId());
		try {
			user_Service.delUser(user);
			list = user_Service.getAllUsers();
			return "list0";
		} catch (Exception e) {
			return this.ERROR;
		}
	}

	public String update() {
		try {
			user_Service.update(user);
			list = user_Service.getAllUsers();
			return "list0";
		} catch (Exception e) {
			return this.ERROR;
		}
	}

	public String find() {
		list = user_Service.getUsersByState(user.getState());
		for (int i = 0; i < list.size(); i++) {
			User u = (User) list.get(i);
			try {
				Dept dept = deptService.getDept(u.getDept_id());
				u.setDept(dept.getName());
			} catch (Exception e) {
				u.setDept("暂无部门");
			}
		}
		return "list0";
	}

	public String findPro1() {
		user = user_Service.getme(user.getId());
		project1 = project1_Service.getPro1ByUser_id(user.getId());
		return "findPro1";
	}

	public String findPro2() {
		user = user_Service.getme(user.getId());
		proDemo = project2_Service.getPro2ByUser_id(user.getId());
		return "findPro2";
	}

	public String addExcel() {
		try {
			UploadDownUtil util = new UploadDownUtil(upload, uploadFileName, uploadContentType);
			String path = "/excelFiles";
			ArrayList<User> userList = util.readExceluser(path);
			for (User u : userList) {
				System.out.println("uuu=" + u);
				u.setDept_id(deptService.getDeptByName(u.getDept()).getId());
				System.out.println("u.dept_id=" + u.getDept_id());
				u.setDept(null);
				try {
					user_Service.insertUser(u);
				} catch (Exception e) {
					System.out.println("该用户已存在！");
				}
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}

	}

	public Pro2 getProject2() {
		return project2;
	}

	public void setProject2(Pro2 project2) {
		this.project2 = project2;
	}

	public String getProDemo() {
		return proDemo;
	}

	public void setProDemo(String proDemo) {
		this.proDemo = proDemo;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Pro1 getProject1() {
		return project1;
	}

	public void setProject1(Pro1 project1) {
		this.project1 = project1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList getList() {
		return list;
	}

	public void setList(ArrayList list) {
		this.list = list;
	}

	public List<Pro1s> getPr1sList() {
		return pr1sList;
	}

	public void setPr1sList(List<Pro1s> pr1sList) {
		this.pr1sList = pr1sList;
	}

	public List<java.io.File> getUpload() {
		return upload;
	}

	public void setUpload(List<java.io.File> upload) {
		this.upload = upload;
	}

	public List getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(List uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getNewpwd() {
		return newpwd;
	}

	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}

	public List getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(List uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public int getQqq() {
		return qqq;
	}

	public void setQqq(int qqq) {
		this.qqq = qqq;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMubiaoURL() {
		return mubiaoURL;
	}

	public void setMubiaoURL(String mubiaoURL) {
		this.mubiaoURL = mubiaoURL;
	}

	public int getUrlNo() {
		return urlNo;
	}

	public void setUrlNo(int urlNo) {
		this.urlNo = urlNo;
	}

}
