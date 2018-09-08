package com.rzpt1.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.dao.DataAccessException;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.rzpt.entity.CgFile;
import com.rzpt.entity.Chengguo;
import com.rzpt.entity.Lhzb;
import com.rzpt.entity.Wenjian;
import com.rzpt.entity.WenjianFile;
import com.rzpt.util.UploadDownUtil;
import com.rzpt1.service.Chengguo_Service;

import javassist.bytecode.stackmap.BasicBlock.Catch;

public class Chengguo_Action extends ActionSupport {

	private List<java.io.File> upload;
	private List uploadFileName;
	private List uploadContentType;
	private Chengguo_Service ChengguoService;
	private List<Chengguo> cgs;
	private List<Lhzb> lhs;
	private CgFile cgFile;
	private Lhzb lhzb;
	private int id;
	private Integer idd;
	private String error;
	private Wenjian wenjian;
	private WenjianFile wjFile;
	private String editorValue;

	public String wenjianadd0() {
		return "newpageadd0";
	}

	public String wenjianadd() {
		wenjian.setCreate_time(wenjian.getCreateTime());
		wenjian.setWenjian_desc(editorValue);
		System.out.println("wenjian=" + wenjian);
		ChengguoService.insertWenjian(wenjian);
		return "success";
	}

	public void wenjianlist() throws ServletException, IOException {
		HttpServletRequest req = ServletActionContext.getRequest();
		if (id == 404 || id == 405) {
			req.setAttribute("page", 1);
		}
		List list = new ArrayList<Wenjian>();
		if (id == 405) {
			list = ChengguoService.querywnFile();
		} else {
			list = ChengguoService.getWenjianList();
		}
		req.setAttribute("list", list);
		req.setAttribute("idd", 404);
		req.getRequestDispatcher("/newpage/gonggao_ziliao_list.jsp").forward(req, ServletActionContext.getResponse());
	}

	public String wenjianupload() throws DataAccessException, ClassNotFoundException {
		HttpServletRequest req = ServletActionContext.getRequest();
		List<Wenjian> wjfList = ChengguoService.querywjFile();
		req.setAttribute("wjfList", wjfList);
		return "wenjianupload";
	}

	public void wenjianshow()
			throws DataAccessException, NumberFormatException, ClassNotFoundException, ServletException, IOException {
		System.out.println("iddiddiddiddidd=" + idd);
		HttpServletRequest req = ServletActionContext.getRequest();
		try {
			if (idd == 1) {
				req.setAttribute("idd", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Wenjian wenjian = ChengguoService.getWenjianById(Integer.parseInt("" + req.getAttribute("id")));
		req.setAttribute("wenjian", wenjian);
		req.setAttribute("desc", wenjian.getWenjian_desc());
		req.getRequestDispatcher("/admin/wenjian/wenjian_show.jsp").forward(req, ServletActionContext.getResponse());
	}

	public void wjlist() throws ServletException, IOException {
		HttpServletRequest req = ServletActionContext.getRequest();
		if (req.getAttribute("idd") != null || req.getAttribute("idd") != "") {
			req.setAttribute("idd", req.getAttribute("idd"));
		}
		Integer id = (Integer) req.getAttribute("id");
		System.out.println(id);
		List<WenjianFile> wjFileList = ChengguoService.querywnFileBywnId(id);
		System.out.println(wjFileList);
		req.setAttribute("wjFileList", wjFileList);
		req.getRequestDispatcher("/admin/wenjian/wj_list.jsp").forward(req, ServletActionContext.getResponse());
	}

	public String wjFiledel() throws DataAccessException, ClassNotFoundException {
		wjFile = ChengguoService.getwfFileById(id);
		ChengguoService.deleteWjFileById(wjFile);
		return "success";
	}

	public String wenjiandel() throws DataAccessException, ClassNotFoundException {
		wenjian = ChengguoService.getWenjianById(wenjian.getWenjian_id());
		ChengguoService.deleteWenjianById(wenjian);
		return "success";
	}

	public String add() {
		return "add";
	}

	public String addLh() {
		return "addlh";
	}

	public String update0() {
		lhzb = ChengguoService.getLhzb(id);
		return "update0";
	}

	public String update1() {
		Integer fenzi = lhzb.getMidFenZi();
		Lhzb lh = ChengguoService.getLhzb(lhzb.getId());
		lh.setMidFenZi(fenzi);
		try {
			ChengguoService.updateLhzb(lh);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String update2() {
		Integer fenzi = lhzb.getLastFenZi();
		Lhzb lh = ChengguoService.getLhzb(lhzb.getId());
		lh.setLastFenZi(fenzi);
		try {
			ChengguoService.updateLhzb(lh);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String addExcel() {
		try {
			UploadDownUtil util = new UploadDownUtil(upload, uploadFileName, uploadContentType);
			String path = "/excelFiles";
			ArrayList<Chengguo> cgList = util.readExcelChengguo(path);
			for (Chengguo cg : cgList) {
				try {
					ChengguoService.insertChengguo(cg);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("cg=" + cg.toString());
					System.out.println("序号为----" + cg.getNo() + "----的成果导入失败");
				}
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}

	}

	public String addExcelLhzb() {
		try {
			UploadDownUtil util = new UploadDownUtil(upload, uploadFileName, uploadContentType);
			String path = "/excelFiles";
			ArrayList<Lhzb> lhzbList = util.readExcelLhzb(path);
			for (Lhzb lhzb : lhzbList) {
				try {
					ChengguoService.insertLhzb(lhzb);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("lhzb=" + lhzb.toString());
					System.out.println("序号为----" + lhzb.getNum() + "----的成果导入失败");
				}
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String list() {
		cgs = ChengguoService.getAllList();
		for (Chengguo cg : cgs) {
			double fenzi = 0;
			try {
				fenzi = (double) cg.getFenzi();
			} catch (Exception e) {
				System.out.println("编号为" + cg.getNo() + "的成果无分子");
			}
			double fenmu = (double) cg.getFenmu();
			cg.setFenshu(fenzi / fenmu);
		}
		return "list";
	}

	public String listlh() {
		lhs = ChengguoService.getAllListLh();
		for (Lhzb lhzb : lhs) {
			double midfenzi = 0, lastfenzi = 0;
			try {
				midfenzi = (double) lhzb.getMidFenZi();
			} catch (Exception e) {
				System.out.println("编号为" + lhzb.getNum() + "的量化无中期分子");
			}
			lhzb.setMidfenshu(midfenzi / lhzb.getMidFenMu());

			try {
				lastfenzi = (double) lhzb.getLastFenZi();
			} catch (Exception e) {
				System.out.println("编号为" + lhzb.getNum() + "的量化无末期分子");
			}
			lhzb.setLastfenshu(lastfenzi / lhzb.getLastFenMu());
		}
		return "listlh";
	}

	public String upload() {
		return "upload";
	}

	public String show() {
		Chengguo cg = ChengguoService.getCG(id);
		cgFile = ChengguoService.getcf(cg.getId());
		if (cgFile != null) {
			if (cgFile.getName1() != null && cgFile.getName1() != "") {
				cgFile.setTname1(cgFile.getName1());
				cgFile.setName1(cgFile.getName1().substring(36, cgFile.getName1().length()));
			} else {

			}
			if (cgFile.getName2() != null && cgFile.getName2() != "") {
				cgFile.setTname2(cgFile.getName2());
				cgFile.setName2(cgFile.getName2().substring(36, cgFile.getName2().length()));
			} else {

			}
			if (cgFile.getName3() != null && cgFile.getName3() != "") {
				cgFile.setTname3(cgFile.getName3());
				cgFile.setName3(cgFile.getName3().substring(36, cgFile.getName3().length()));
			} else {

			}
			if (cgFile.getName4() != null && cgFile.getName4() != "") {
				cgFile.setTname4(cgFile.getName4());
				cgFile.setName4(cgFile.getName4().substring(36, cgFile.getName4().length()));
			} else {

			}
			if (cgFile.getName5() != null && cgFile.getName5() != "") {
				cgFile.setTname5(cgFile.getName5());
				cgFile.setName5(cgFile.getName5().substring(36, cgFile.getName5().length()));
			} else {

			}
			if (cgFile.getName6() != null && cgFile.getName6() != "") {
				cgFile.setTname6(cgFile.getName6());
				cgFile.setName6(cgFile.getName6().substring(36, cgFile.getName6().length()));
			} else {

			}
			if (cgFile.getName7() != null && cgFile.getName7() != "") {
				cgFile.setTname7(cgFile.getName7());
				cgFile.setName7(cgFile.getName7().substring(36, cgFile.getName7().length()));
			} else {

			}
			return "show";
		} else if (cgFile == null) {
			error = "该成果尚未上传材料";
			return "error";
		} else {
			error = "出现未知错误，请刷新，如多次出现请联系管理员解决";
			return "error";
		}
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

	public Wenjian getWenjian() {
		return wenjian;
	}

	public void setWenjian(Wenjian wenjian) {
		this.wenjian = wenjian;
	}

	public List getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(List uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public WenjianFile getWjFile() {
		return wjFile;
	}

	public void setWjFile(WenjianFile wjFile) {
		this.wjFile = wjFile;
	}

	public String getEditorValue() {
		return editorValue;
	}

	public void setEditorValue(String editorValue) {
		this.editorValue = editorValue;
	}

	public void setChengguoService(Chengguo_Service chengguoService) {
		ChengguoService = chengguoService;
	}

	public Lhzb getLhzb() {
		return lhzb;
	}

	public void setLhzb(Lhzb lhzb) {
		this.lhzb = lhzb;
	}

	public List<Chengguo> getCgs() {
		return cgs;
	}

	public void setCgs(List<Chengguo> cgs) {
		this.cgs = cgs;
	}

	public List<Lhzb> getLhs() {
		return lhs;
	}

	public void setLhs(List<Lhzb> lhs) {
		this.lhs = lhs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Integer getIdd() {
		return idd;
	}

	public void setIdd(Integer idd) {
		this.idd = idd;
	}

	public CgFile getCgFile() {
		return cgFile;
	}

	public void setCgFile(CgFile cgFile) {
		this.cgFile = cgFile;
	}

}
