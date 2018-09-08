package com.rzpt.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletContext;

import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.rzpt.entity.Chengguo;
import com.rzpt.entity.Dept;
import com.rzpt.entity.Lhzb;
import com.rzpt.entity.Pro2;
import com.rzpt.entity.Pro3;
import com.rzpt.entity.Task;
import com.rzpt.entity.User;
import com.rzpt.entity.Watch;
import com.rzpt1.service.Dept_Service;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

public class UploadDownUtil extends ActionSupport {
	// 多文件上传时
	private List<File> uploads;
	private List uploadNames;
	private List uploadContentType;
	// 文件下载时
	private String downContentTypes;
	private long downContentLong;
	private String contentDisposition;
	private InputStream inputStream;

	private Watch watch;
	int rows = 0;
	private ArrayList list; // 该list存放excel表的数据

	public UploadDownUtil() {
		super();
	}

	public UploadDownUtil(List<File> uploads2, List uploadNames2, List uploadContentType2) {
		this.uploads = uploads2;
		this.uploadNames = uploadNames2;
		this.uploadContentType = uploadContentType2;
	}

	public List upload(String path) throws IOException {
		try {
			// 获取servletContext
			ServletContext servletContext = ServletActionContext.getServletContext();
			// String realPath = servletContext.getRealPath(path);
			String separator = System.getProperty("file.separator");
			path.replace("/", separator);
			String realPath = path;
			File file = new File(realPath);
			if (!file.exists()) {
				// 不存在创建
				file.mkdir();
			}
			List fileNames = new ArrayList();
			for (int i = 0; i < uploads.size(); i++) {
				UUID uuid = UUID.randomUUID();
				FileUtils.copyFile(uploads.get(i), new File(realPath + "/" + uuid + uploadNames.get(i)));
				fileNames.add(uuid.toString() + uploadNames.get(i));
			}
			return fileNames;
		} catch (Exception e) {
			List nofile = new ArrayList();
			nofile.add("nofile");
			return nofile;
		}
	}

	public void down(String path, String name) throws IOException {
		System.out.println(path + "/" + name);
		// ServletContext context = ServletActionContext.getServletContext();
		// String realPath = context.getRealPath(path + "/" + name);
		String realPath = path + "/" + name;
		System.out.println(realPath);
		inputStream = new FileInputStream(realPath);
		// downContentTypes = context.getMimeType(realPath);
		downContentLong = new File(realPath).length();
		String fileName = name;
		fileName = new String(fileName.getBytes("gbk"), "utf-8");
		contentDisposition = "attachment;filename=" + fileName;
	}

	/**
	 * 假装有i其实没有
	 * 
	 * @param pathname
	 * @param name
	 * @param i
	 * @throws IOException
	 */
	public void down(String pathname, String name, int i) throws IOException {
		// ServletContext context = ServletActionContext.getServletContext();
		// String realPath = context.getRealPath(path + "/" + name);
		String realPath = pathname;
		System.out.println(realPath);
		inputStream = new FileInputStream(realPath);
		// downContentTypes = context.getMimeType(realPath);
		downContentLong = new File(realPath).length();
		String fileName = name;
		fileName = new String(fileName.getBytes("gbk"), "utf-8");
		contentDisposition = "attachment;filename=" + fileName;
	}

	public String uploadExcel(String path) throws IOException {
		// 获取servletContext
		ServletContext servletContext = ServletActionContext.getServletContext();
		String realPath = servletContext.getRealPath(path);
		File file = new File(realPath);
		if (!file.exists()) {
			// 不存在创建
			file.mkdir();
		}
		List fileNames = new ArrayList();
		for (int i = 0; i < uploads.size(); i++) {
			UUID uuid = UUID.randomUUID();
			/*
			 * FileUtils.copyFile(uploads.get(i), new File(realPath + "/" +
			 * uploadNames.get(i))); fileNames.add(uploadNames.get(i));
			 */
			FileUtils.copyFile(uploads.get(i), new File(realPath + "/" + uuid + uploadNames.get(i)));
			fileNames.add(uuid.toString() + uploadNames.get(i));
		}

		System.out.println(file.getPath() + "\\" + fileNames.get(0));
		return file.getPath() + "\\" + fileNames.get(0);
	}

	public ArrayList<Chengguo> readExcelChengguo(String path) {
		try {
			File file = new File(this.uploadExcel(path));
			Workbook workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(0);// 从0开始
			rows = sheet.getRows(); // 获取行数
			list = new ArrayList<Chengguo>();
			for (int i = 1; i < rows; i++) {
				Chengguo cg = new Chengguo();
				cg.setNo(Integer.parseInt(sheet.getCell(0, i).getContents()));
				cg.setState(sheet.getCell(1, i).getContents());
				cg.setName(sheet.getCell(2, i).getContents());
				cg.setPerson(sheet.getCell(3, i).getContents());
				cg.setJibie(sheet.getCell(4, i).getContents());
				cg.setDept(sheet.getCell(5, i).getContents());
				cg.setFenmu(Integer.parseInt(sheet.getCell(6, i).getContents()));
				try {
					cg.setFenzi(Integer.parseInt(sheet.getCell(7, i).getContents()));
				} catch (Exception e) {
					System.out.println("编号为:" + cg.getNo() + "的成果无分子");
				}
				try {
					cg.setBeizhu(sheet.getCell(8, i).getContents());
				} catch (Exception e) {
					System.out.println("编号为:" + cg.getNo() + "的成果无备注");
				}
				list.add(cg);
			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<Lhzb> readExcelLhzb(String path) {
		try {
			File file = new File(this.uploadExcel(path));
			Workbook workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(0);// 从0开始
			rows = sheet.getRows(); // 获取行数
			list = new ArrayList<Lhzb>();
			for (int i = 1; i < rows; i++) {
				Lhzb lhzb = new Lhzb();
				lhzb.setNum(Integer.parseInt(sheet.getCell(0, i).getContents()));
				lhzb.setContent(sheet.getCell(1, i).getContents());
				lhzb.setDesc(sheet.getCell(2, i).getContents());
				lhzb.setBase(sheet.getCell(3, i).getContents());
				lhzb.setZb(sheet.getCell(4, i).getContents());
				lhzb.setMid(sheet.getCell(5, i).getContents());
				lhzb.setMidFenMu(Integer.parseInt(sheet.getCell(6, i).getContents()));
				try {
					lhzb.setMidFenZi(Integer.parseInt(sheet.getCell(7, i).getContents()));
				} catch (Exception e) {
					System.out.println("编号为:" + lhzb.getNum() + "的量化指标中期无分子");
				}
				lhzb.setLast(sheet.getCell(8, i).getContents());
				lhzb.setLastFenMu(Integer.parseInt(sheet.getCell(9, i).getContents()));
				try {
					lhzb.setLastFenZi(Integer.parseInt(sheet.getCell(10, i).getContents()));
				} catch (Exception e) {
					System.out.println("编号为:" + lhzb.getNum() + "的量化指标末期无分子");
				}
				lhzb.setDept(sheet.getCell(11, i).getContents());
				if (lhzb.getMidFenZi() == null) {
					lhzb.setMidFenZi(0);
				}
				if (lhzb.getLastFenZi() == null) {
					lhzb.setLastFenZi(0);
				}
				list.add(lhzb);
			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<Watch> readExcelwatch(String path) {
		try {
			File file = new File(this.uploadExcel(path));
			Workbook workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(0);// 从0开始
			rows = sheet.getRows(); // 获取行数
			list = new ArrayList<Watch>();
			for (int i = 1; i < rows; i++) {
				watch = new Watch();
				watch.setNo(sheet.getCell(0, i).getContents());
				watch.setName(sheet.getCell(1, i).getContents());
				watch.setContent(sheet.getCell(1, i).getContents());
				watch.setPlan_time(sheet.getCell(3, i).getContents());
				watch.setTask_id(Integer.parseInt(sheet.getCell(4, i).getContents())); // 任务编号
				watch.setFinish_time(sheet.getCell(5, i).getContents()); // 借用字段，此处为所属部门名称
				watch.setColumn(sheet.getCell(6, i).getContents()); // 所属负责人
				try {
					watch.setColumn2(sheet.getCell(7, i).getContents()); // 辅助负责人
				} catch (Exception e) {
					System.out.println("该项暂无数据！");
				}
				try {
					watch.setColumn3(sheet.getCell(8, i).getContents());// 辅助负责人2
				} catch (Exception e) {
					System.out.println("该项暂无数据！");
				}
				try {
					watch.setColumn4(sheet.getCell(9, i).getContents());// 辅助负责人3
				} catch (Exception e) {
					System.out.println("该项暂无数据！");
				}
				try {
					watch.setColumn5(sheet.getCell(10, i).getContents());// 辅助负责人4
				} catch (Exception e) {
					System.out.println("该项暂无数据！");
				}
				try {
					watch.setColumn6(sheet.getCell(11, i).getContents());// 辅助负责人5
				} catch (Exception e) {
					System.out.println("该项暂无数据！");
				}
				list.add(watch);
			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<User> readExceluser(String path) {
		try {
			File file = new File(this.uploadExcel(path));
			Workbook workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(0);// 从0开始
			rows = sheet.getRows(); // 获取行数
			list = new ArrayList<User>();
			for (int i = 1; i < rows; i++) {
				User u = new User();
				u.setName(sheet.getCell(0, i).getContents());
				u.setPwd(sheet.getCell(1, i).getContents());
				u.setRealName(sheet.getCell(2, i).getContents());
				u.setState(Integer.parseInt(sheet.getCell(3, i).getContents()));
				u.setDept(sheet.getCell(4, i).getContents());
				list.add(u);
			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<Dept> readExceldept(String path) {
		try {
			File file = new File(this.uploadExcel(path));
			Workbook workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(0);// 从0开始
			rows = sheet.getRows(); // 获取行数
			// WorkbookSettings wbs= new WorkbookSettings();
			// wbs.setEncoding("UTF-8");
			// Workbook workbook =Workbook.getWorkbook(file, wbs);
			list = new ArrayList<Dept>();
			for (int i = 1; i < rows; i++) {
				Dept d = new Dept();
				d.setName(sheet.getCell(0, i).getContents());
				System.out.println("--------------------------" + sheet.getCell(0, i).getContents());
				System.out.println("d.name=" + d.getName());
				list.add(d);
			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<Pro2> realExcelPro2(String path) {
		try {
			File file = new File(this.uploadExcel(path));
			Workbook workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(0);// 从0开始
			rows = sheet.getRows(); // 获取行数
			list = new ArrayList<Dept>();
			for (int i = 1; i < rows; i++) {
				Pro2 p = new Pro2();
				p.setName(sheet.getCell(0, i).getContents());
				p.setNo(sheet.getCell(1, i).getContents());
				p.setMoney(Double.parseDouble(sheet.getCell(2, i).getContents()));
				p.setPlan_time(sheet.getCell(3, i).getContents());
				p.setPro1_no(Integer.parseInt(sheet.getCell(4, i).getContents()));
				p.setDepter(sheet.getCell(5, i).getContents());
				p.setUser(sheet.getCell(6, i).getContents());
				p.setState(1);
				list.add(p);
			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return list;
		}
	}

	public ArrayList<Pro3> realExcelPro3(String path) {
		try {
			File file = new File(this.uploadExcel(path));
			Workbook workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(0);// 从0开始
			rows = sheet.getRows(); // 获取行数
			list = new ArrayList<Pro3>();
			for (int i = 1; i < rows; i++) {
				Pro3 p = new Pro3();
				p.setName(sheet.getCell(0, i).getContents());
				p.setNo(sheet.getCell(1, i).getContents());
				p.setState(1);
				try {
					p.setMoney(Double.parseDouble(sheet.getCell(2, i).getContents()));
				} catch (Exception e) {
					System.out.println("该条暂无导入");
				}
				p.setPlan_time(sheet.getCell(3, i).getContents());
				p.setPro2_id(Integer.parseInt(sheet.getCell(4, i).getContents())); // 借用一个字段，实际存的为所属二级项目编号
				p.setRate(sheet.getCell(5, i).getContents()); // 借用一个字段，实际意义为所属二级管理员
				try {
					p.setUser(sheet.getCell(6, i).getContents());
				} catch (Exception e) {
					System.out.println("该条暂无导入");
				}
				list.add(p);
			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return list;
		}
	}

	public ArrayList<Task> readExcelTask(String path) {
		try {
			File file = new File(this.uploadExcel(path));
			Workbook workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(0);// 从0开始
			rows = sheet.getRows(); // 获取行数
			list = new ArrayList<Task>();
			for (int i = 1; i < rows; i++) {
				Task t = new Task();
				t.setName(sheet.getCell(0, i).getContents());
				t.setNo(sheet.getCell(1, i).getContents());
				t.setContent(sheet.getCell(2, i).getContents());
				t.setPro3_id(Integer.parseInt(sheet.getCell(3, i).getContents())); // 此处为编号
				t.setMoment(Integer.parseInt(sheet.getCell(4, i).getContents()));
				list.add(t);
			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String toString() {
		return "UploadDownUtil [uploads=" + uploads + ", uploadNames=" + uploadNames + ", uploadContentType="
				+ uploadContentType + ", downContentTypes=" + downContentTypes + ", downContentLong=" + downContentLong
				+ ", contentDisposition=" + contentDisposition + ", inputStream=" + inputStream + ", watch=" + watch
				+ ", rows=" + rows + ", list=" + list + "]";
	}

	public List<File> getUploads() {
		return uploads;
	}

	public void setUploads(List<File> uploads) {
		this.uploads = uploads;
	}

	public List getUploadNames() {
		return uploadNames;
	}

	public void setUploadNames(List uploadNames) {
		this.uploadNames = uploadNames;
	}

	public List getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(List uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getDownContentTypes() {
		return downContentTypes;
	}

	public void setDownContentTypes(String downContentTypes) {
		this.downContentTypes = downContentTypes;
	}

	public long getDownContentLong() {
		return downContentLong;
	}

	public void setDownContentLong(long downContentLong) {
		this.downContentLong = downContentLong;
	}

	public String getContentDisposition() {
		return contentDisposition;
	}

	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public Watch getWatch() {
		return watch;
	}

	public void setWatch(Watch watch) {
		this.watch = watch;
	}

}
