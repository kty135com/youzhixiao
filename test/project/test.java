package project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.rzpt.util.Base64;

public class test {
	public void ioTest() throws IOException {
		File f1 = new File("C:/Users/Administrator/Desktop/logo.png");
		File f2 = new File("C:/Users/Administrator/Desktop/logo2.png");
		InputStream is = null;
		OutputStream os = null;
		try {
			byte[] buffer = new byte[10000];
			is = new FileInputStream(f1);
			os = new FileOutputStream(f2);
			// 输入流从流中文件的二进制位取出byte[](缓存)等量的byte数存入缓存，然后将读取的二进制转换为十进制（0~255）并返回。

			// 一个byte(字节)是八个二进制位（来自国际标准）

			// write(byte[] b, int off, int len)
			// 的意思是：b是本次写的数据，off是从哪里开始写，len是这次写的长度
			while ((is.read(buffer)) != -1) {
				os.write(buffer, 0, buffer.length);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				is.close();
			}
			if (os != null) {
				os.close();
			}
		}
	}

	public void cloneTest() throws CloneNotSupportedException {
		User u = new User("kty", 15);
		User u2 = (User) u.clone();
		System.out.println(u);
		System.out.println(u2);
		System.out.println(u.equals(u2));
		u.setName("qq");
		System.out.println(u.equals(u2));
		System.out.println(u);
		System.out.println(u2);
		System.out.println(new NullPointerException() instanceof Exception);
	}

	public static void main(String[] args) throws InterruptedException {
		// new test().cloneTest();

		try{
			for (int i = 1; i <= 10; i++) {
				System.out.println("这是第" +i+ "次循环");
				if(i==7){
					throw new Exception("我是一个异常");
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			Thread.sleep(500L);
			System.out.println("我会在最后被执行");
		}

	}
}