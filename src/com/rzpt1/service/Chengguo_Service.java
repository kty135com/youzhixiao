package com.rzpt1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.rzpt.entity.CgFile;
import com.rzpt.entity.Chengguo;
import com.rzpt.entity.Lhzb;
import com.rzpt.entity.Wenjian;
import com.rzpt.entity.WenjianFile;

import javassist.bytecode.stackmap.BasicBlock.Catch;

public class Chengguo_Service {

	private HibernateTemplate hibernateTemplate;

	public void insertWenjian(Wenjian w) {
		hibernateTemplate.save(w);
	}

	public void deleteWenjianById(Wenjian w) {
		hibernateTemplate.delete(w);
	}

	public void updateWenjian(Wenjian w) {
		hibernateTemplate.update(w);
	}

	public void deleteWjFileById(WenjianFile w) {
		hibernateTemplate.delete(w);
	}

	public List<Wenjian> querywjFile() {
		return (List<Wenjian>) hibernateTemplate.find("from Wenjian");
	}

	public List<Wenjian> getWenjianList() {
		return (List<Wenjian>) hibernateTemplate.find("from Wenjian order by create_time desc");
	}

	public Wenjian getWenjianById(Integer id) throws DataAccessException, ClassNotFoundException {
		return (Wenjian) hibernateTemplate.get(Class.forName("com.rzpt.entity.Wenjian"), id);
	}

	public void addwnFile(WenjianFile wjFile) {
		hibernateTemplate.save(wjFile);
	}

	public ArrayList<Wenjian> querywnFile() {
		return (ArrayList<Wenjian>) hibernateTemplate.find("from Wenjian where state = 1 order by create_time desc");
	}

	public ArrayList<WenjianFile> querywnFileBywnId(Integer id) {
		return (ArrayList<WenjianFile>) hibernateTemplate.find("from WenjianFile where wenjian_id=" + id + " order by id desc");
	}

	public WenjianFile getwfFileById(Integer id) {
		return (WenjianFile) hibernateTemplate.find("from WenjianFile where id =" + id).get(0);
	}

	public void insertLhzb(Lhzb lhzb) {
		try {
			hibernateTemplate.save(lhzb);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateLhzb(Lhzb lhzb) {
		try {
			hibernateTemplate.update(lhzb);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertChengguo(Chengguo cg) {
		System.out.println("µ½´Ë,ht=" + hibernateTemplate);
		hibernateTemplate.save(cg);
	}

	public Lhzb getLhzb(int id) {
		try {
			return hibernateTemplate.get(Lhzb.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Chengguo> getAllList() {
		try {
			return (List<Chengguo>) hibernateTemplate.find("from Chengguo");
		} catch (Exception e) {
			return null;
		}
	}

	public List<Lhzb> getAllListLh() {
		try {
			return (List<Lhzb>) hibernateTemplate.find("from Lhzb");
		} catch (Exception e) {
			return null;
		}
	}

	public int add(CgFile cf) {
		try {
			System.out.println("cf=" + cf);
			System.out.println(hibernateTemplate);
			hibernateTemplate.save(cf);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public Chengguo getCG(int id) {
		try {
			return (Chengguo) hibernateTemplate.find("from Chengguo where id=" + id).get(0);
		} catch (Exception e) {
			return null;
		}
	}

	public CgFile getcf(int id) {
		try {
			return (CgFile) hibernateTemplate.find("from CgFile where cg_id=" + id).get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
