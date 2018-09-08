package com.rzpt1.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.rzpt.entity.File;

public class File_Service {
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public int add(File file) {
		hibernateTemplate.save(file);
		return 1;
	}

	public File getFileByWatch_id(int id) throws IndexOutOfBoundsException {
		System.out.println("getFileByWatch_id watch_id=" + id);
		ArrayList list = (ArrayList) hibernateTemplate.find("from File where watch_id=" + id);
		File file = (File) list.get(list.size() - 1);
		return file;
	}

	public int getFileByWatchIdAndUserId(Integer watchId, Integer userId) {
		try {
			List<File> fileList = (List<File>) hibernateTemplate
					.find("from File where watch_id = " + watchId + "and user_id = " + userId);
			System.out.println("watchId,UserId,size =" + watchId + "," + userId + fileList.size());
			if (fileList.size() != 0) {
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public File getAFileByWatchIdAndUserId(Integer watchId, Integer userId) {
		try {
			List<File> fileList = (List<File>) hibernateTemplate
					.find("from File where watch_id = " + watchId + "and user_id = " + userId);
			System.out.println(fileList.size());
			File f = fileList.get(fileList.size()-1);
			return f;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public ArrayList<File> getFileListByWatchId(int id) {
		return (ArrayList) hibernateTemplate.find("from File where watch_id=" + id);
	}

	public int deleteFileById(File file) {
		try {
			hibernateTemplate.delete(file);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public File getFileById(int id) {
		try {
			File f = (File) hibernateTemplate.find("from File where id =" + id).get(0);
			return f;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
