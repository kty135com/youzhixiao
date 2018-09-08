package com.rzpt.util;

import java.text.DecimalFormat;

import com.rzpt.dto.Files;
import com.rzpt.entity.File;

public class FormatUtil {

	private static DecimalFormat df = new DecimalFormat("0.00%");

	public static String getBiliByFenziAndFenmu(int fenzi, int fenmu) {
		if (fenzi == 0 || fenmu == 0) {
			return "0%";
		} else {
			double fenzi2 = fenzi;
			double fenmu2 = fenmu;
			String str = "" + df.format(fenzi2 / fenmu2);
			return str;
		}
	}

	/**
	 * 获取进度条上倒叙的时间
	 * 
	 * @param bili
	 * @return
	 */
	public static String getjindutiao(String bili) {
		if (bili.equals("0%")) {
			return "100";
		} else if (bili.equals("100")) {
			return "0";
		} else {
			System.out.println("bili.substring(0, 2)=" + bili.substring(0, 2));
			String str = bili.substring(0, 2);
			if (str.indexOf(".") != -1) {
				str = str.substring(0, str.length() - 1);
			}
			return "" + (100 - Integer.parseInt(str));
		}
	}

	/**
	 * 切除File的文件名的uuid，返回真文件名
	 * 
	 * @param file
	 * @return
	 */
	public static File getFilerealNamesToTnames(File file) {
		if (file.getName1() != null && file.getName1() != "") {
			file.setTname1(file.getName1().substring(36, file.getName1().length()));
		}
		if (file.getName2() != null && file.getName2() != "") {
			file.setTname2(file.getName2().substring(36, file.getName2().length()));
		}
		if (file.getName3() != null && file.getName3() != "") {
			file.setTname3(file.getName3().substring(36, file.getName3().length()));
		}
		if (file.getName4() != null && file.getName4() != "") {
			file.setTname4(file.getName4().substring(36, file.getName4().length()));
		}
		if (file.getName5() != null && file.getName5() != "") {
			file.setTname5(file.getName5().substring(36, file.getName5().length()));
		}
		if (file.getName6() != null && file.getName6() != "") {
			file.setTname6(file.getName6().substring(36, file.getName6().length()));
		}
		if (file.getName7() != null && file.getName7() != "") {
			file.setTname7(file.getName7().substring(36, file.getName7().length()));
		}
		return file;
	}

	/**
	 * 切除Files的文件名的uuid，返回真文件名
	 * 
	 * @param file
	 * @return
	 */
	public static Files getFilesrealNamesToTnames(Files file) {
		if (file.getName1() != null && file.getName1() != "") {
			file.setTname1(file.getName1().substring(36, file.getName1().length()));
		}
		if (file.getName2() != null && file.getName2() != "") {
			file.setTname2(file.getName2().substring(36, file.getName2().length()));
		}
		if (file.getName3() != null && file.getName3() != "") {
			file.setTname3(file.getName3().substring(36, file.getName3().length()));
		}
		if (file.getName4() != null && file.getName4() != "") {
			file.setTname4(file.getName4().substring(36, file.getName4().length()));
		}
		if (file.getName5() != null && file.getName5() != "") {
			file.setTname5(file.getName5().substring(36, file.getName5().length()));
		}
		if (file.getName6() != null && file.getName6() != "") {
			file.setTname6(file.getName6().substring(36, file.getName6().length()));
		}
		return file;
	}

	/**
	 * 切除Files的文件名的uuid，返回真文件名
	 * 
	 * @param file
	 * @return
	 */
	public static Files getFilesRNamesFromScheName(Files file) {
		if (file.getScheName1() != null && file.getScheName1() != "") {
			file.setScheRName1(file.getScheName1().substring(36, file.getScheName1().length()));
		}
		if (file.getScheName2() != null && file.getScheName2() != "") {
			file.setScheRName2(file.getScheName2().substring(36, file.getScheName2().length()));
		}
		if (file.getScheName3() != null && file.getScheName3() != "") {
			file.setScheRName3(file.getScheName3().substring(36, file.getScheName3().length()));
		}
		if (file.getScheName4() != null && file.getScheName4() != "") {
			file.setScheRName4(file.getScheName4().substring(36, file.getScheName4().length()));
		}
		if (file.getScheName5() != null && file.getScheName5() != "") {
			file.setScheRName5(file.getScheName5().substring(36, file.getScheName5().length()));
		}
		if (file.getScheName6() != null && file.getScheName6() != "") {
			file.setScheRName6(file.getScheName6().substring(36, file.getScheName6().length()));
		}
		return file;
	}

}
